import com.beust.klaxon.Klaxon
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.apache.commons.codec.digest.HmacAlgorithms
import org.apache.commons.codec.digest.HmacUtils
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.lib.PersonIdent
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.transport.*
import org.eclipse.jgit.transport.sshd.SshdSessionFactory
import java.io.File
import java.nio.file.Path
import java.security.MessageDigest
import java.util.concurrent.locks.ReentrantLock

val WEBHOOK_KEY: String = System.getProperty("bot.webhook")

val SshSessionFactory = object : SshdSessionFactory() {

    override fun getDefaultIdentities(sshDir: File?): MutableList<Path> {
        return mutableListOf(File(System.getProperty("bot.keypath")).toPath())
    }
}

val OurCredentialsProvider = object : CredentialsProvider() {
    override fun isInteractive(): Boolean {
        return false
    }

    override fun supports(vararg items: CredentialItem?): Boolean {
        return items.all { it is CredentialItem.Password || it is CredentialItem.InformationalMessage }
    }

    override fun get(uri: URIish, vararg items: CredentialItem?): Boolean {
        if (uri.equals(File(System.getProperty("bot.keypath")).toURI())) {
            (items.find { it is CredentialItem.Password } as? CredentialItem.Password)?.setValueNoCopy(
                System.getProperty(
                    "bot.keypass"
                ).toCharArray()
            )

            return true
        }

        return false
    }

}

// Only let 1 CL be written at a time
val changelogLock = ReentrantLock()

data class PullBase(val ref: String)
data class PullAuthor(val login: String)
data class PullRequest(
    val state: String,
    val user: PullAuthor,
    val body: String,
    val base: PullBase,
    val merged: Boolean
)

data class PullRequestEvent(val action: String, val pull_request: PullRequest, val number: Int)

fun generateChangelog(repoPath: String) {
    val command = ProcessBuilder().command(
        "python",
        "$repoPath/tools/GenerateChangelog/ss13_genchangelog.py",
        "$repoPath/html/changelog.html",
        "$repoPath/html/changelogs"
    )
    command.start().waitFor()
}

fun hmacMessage(body: String): String {
    return "sha1=${HmacUtils(HmacAlgorithms.HMAC_SHA_1, WEBHOOK_KEY).hmacHex(body.toByteArray())}"
}

fun walkChangelog(body: String): ChangeLog {
    val clLexer = ChangeLogLexer(CharStreams.fromString(body))
    val clTokens = CommonTokenStream(clLexer)
    val clParser = ChangeLogParser(clTokens)
    val clWalker = ParseTreeWalker()
    val clListener = ChangeLog()
    clParser.errorHandler = ChangeLog.ChangeLogErrorStrategy()
    clWalker.walk(clListener, clParser.changelog())

    return clListener
}

fun main(args: Array<String>) {
    val hsRepo = FileRepositoryBuilder.create(File("repo/.git"))
    var hsGit: Git

    if (hsRepo.refDatabase.findRef("HEAD") == null) {
        hsGit = Git.cloneRepository()
            .setURI("git@github.com:HaloSpaceStation/HaloSpaceStation13.git")
            .setDirectory(File("repo/"))
            .setGitDir(File("repo/.git"))
            .setTransportConfigCallback {
                (it as SshTransport).sshSessionFactory = SshSessionFactory
                it.credentialsProvider = OurCredentialsProvider
            }
            .setBranchesToClone(listOf("refs/heads/alpha"))
            .setBranch("refs/heads/alpha").call()
    }
    hsGit = Git(hsRepo)
    hsGit.remoteAdd().setName("origin").setUri(URIish("git@github.com:HaloSpaceStation/HaloSpaceStation13.git")).call()

    val hsConfig = hsRepo.config
    hsConfig.setString("core", null, "autocrlf", "true")
    hsConfig.save()

    println("Git started... starting webserver...")
    embeddedServer(Netty, 2703) {
        routing {
            get("/health") {
                call.respondText("OK", ContentType.Text.Plain)
            }

            post("/pull") {
                val hubSignature = call.request.header("X-Hub-Signature") ?: ""
                val data = call.receive<ByteArray>().toString(Charsets.UTF_8)

                val dataSignature = hmacMessage(data)
                if (MessageDigest.isEqual(dataSignature.toByteArray(), hubSignature.toByteArray())) {
                    println("Valid request!")
                    call.respond(HttpStatusCode.OK, "")
                } else {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid Hub Signature")
                    return@post
                }

                println("Parsing JSON...")
                val jsonData = Klaxon().parse<PullRequestEvent>(data)
                println("Parsed!")
                if (jsonData == null) {
                    call.respond(HttpStatusCode.BadRequest, "Bad Request!")
                    return@post
                }

                if (jsonData.action == "closed" && jsonData.pull_request.merged && jsonData.pull_request.base.ref == "alpha") {
                    println("Parsing PR ${jsonData.number}")
                    val body = jsonData.pull_request.body

                    val clListener = walkChangelog(body)

                    var author = clListener.author
                    val logEntries = clListener.entries

                    if (author == "") {
                        author = jsonData.pull_request.user.login
                    }

                    if (logEntries.isNotEmpty() && author != "") {
                        println("PR ${jsonData.number} was parsed")
                        var clYaml = """
                            author: $author
                            delete-after: True
                            changes:
                        """.trimIndent()
                        logEntries.forEach { (key, value) ->
                            clYaml += "\n  - $key: \"${value.replace(Regex("[^\\p{L}\\p{Z}\\p{N},.]"), "")}\""
                        }
                        changelogLock.lock()
                        val clFile = File("repo/html/changelogs/pr-${jsonData.number}-changes.yml")
                        try {
                            clFile.writeText(clYaml)

                            withContext(Dispatchers.IO) {
                                println("Pulling...")
                                hsGit.pull()
                                    .setRemote("origin")
                                    .setTransportConfigCallback {
                                        (it as SshTransport).sshSessionFactory = SshSessionFactory
                                        it.credentialsProvider = OurCredentialsProvider
                                    }
                                    .call()

                                runBlocking {
                                    println("Running scripts...")
                                    val repoPath = File("repo/").absolutePath
                                    generateChangelog(repoPath)
                                }

                                hsGit.add().addFilepattern("html").setUpdate(true).call()
                                val commit = hsGit.commit()
                                commit.author = PersonIdent("HaloStation Build Bot", "<hs13@ss13.projectunsc.org>")
                                commit.message = "[ci skip] Autogenerated Changelog for PR #${jsonData.number}"
                                commit.call()

                                println("Changes committed... Attempting to push...")

                                val push = hsGit.push()
                                push.refSpecs = listOf(RefSpec("refs/heads/alpha:refs/heads/alpha"))
                                push.setTransportConfigCallback {
                                    (it as SshTransport).sshSessionFactory = SshSessionFactory
                                    it.credentialsProvider = OurCredentialsProvider
                                }
                                try {
                                    push.call()
                                } catch (ex: Exception) {
                                    println(ex.message)
                                }

                                println("Push complete!")
                            }
                        } finally {
                            changelogLock.unlock()
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}
