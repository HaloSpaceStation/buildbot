import com.beust.klaxon.Klaxon
import com.jcraft.jsch.JSch
import com.jcraft.jsch.Session
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.request.header
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.apache.commons.codec.digest.HmacAlgorithms
import org.apache.commons.codec.digest.HmacUtils
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.lib.PersonIdent
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.transport.*
import org.eclipse.jgit.util.FS
import java.io.File
import java.security.MessageDigest

val WEBHOOK_KEY: String = System.getProperty("bot.webhook")

val SshSessionFactory = object : JschConfigSessionFactory() {

    override fun createDefaultJSch(fs: FS?): JSch {
        val default = super.createDefaultJSch(fs)

        default.removeAllIdentity()
        default.addIdentity(File(System.getProperty("bot.keypath")).absolutePath, System.getProperty("bot.keypass"))
        return default
    }

    override fun configure(hc: OpenSshConfig.Host?, session: Session?) {
        session?.setConfig("StrictHostKeyChecking", "no")
    }

}

data class PullBase(val ref: String)
data class PullRequest(val state: String, val body: String, val base: PullBase, val merged: Boolean)
data class PullRequestEvent(val action: String, val pull_request: PullRequest, val number: Int)

fun generateChangelog(repoPath: String) {
    val command = ProcessBuilder().command("python", "$repoPath/tools/GenerateChangelog/ss13_genchangelog.py", "$repoPath/html/changelog.html", "$repoPath/html/changelogs")
    command.start().waitFor()
}

fun hmacMessage(body: String): String {
    return "sha1=${HmacUtils(HmacAlgorithms.HMAC_SHA_1, WEBHOOK_KEY).hmacHex(body.toByteArray(Charsets.ISO_8859_1))}"
}

fun main(args: Array<String>) {
    val hsRepo = FileRepositoryBuilder.create(File("repo/.git"))
    var hsGit: Git

    if(hsRepo.refDatabase.findRef("HEAD") == null) {
        hsGit = Git.cloneRepository()
            .setURI("git@github.com:HaloSpaceStation/HaloSpaceStation13.git")
            .setDirectory(File("repo/"))
            .setGitDir(File("repo/.git"))
            .setTransportConfigCallback {
                (it as SshTransport).sshSessionFactory = SshSessionFactory
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
    embeddedServer(Netty,2703) {
        routing {
            get("/health") {
                call.respondText("OK", ContentType.Text.Plain)
            }

            post("/pull") {
                val hubSignature = call.request.header("X-Hub-Signature") ?: ""
                val data = call.receive<String>()

                val dataSignature = hmacMessage(data)
                if(MessageDigest.isEqual(dataSignature.toByteArray(), hubSignature.toByteArray()))
                {
                    println("Valid request!")
                    call.respond(HttpStatusCode.OK, "")
                } else {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid Hub Signature $dataSignature")
                    return@post
                }

                println("Parsing JSON...")
                val jsonData = Klaxon().parse<PullRequestEvent>(data)
                println("Parsed!")
                if(jsonData == null)
                {
                    call.respond(HttpStatusCode.BadRequest, "Bad Request!")
                    return@post
                }

                if(jsonData.action == "closed" && jsonData.pull_request.merged && jsonData.pull_request.base.ref == "alpha")
                {
                    println("Parsing PR")
                    val body = jsonData.pull_request.body
                    var clText = body.substring(body.indexOf("\uD83C\uDD91 ") + 3)
                    clText = clText.substring(0, body.indexOf("/\uD83C\uDD91"))
                    val clList = clText.split('\n')
                    if(clList.size >= 2)
                    {
                        val author = clList[0]
                        val logEntries = mutableListOf<String>()
                        for (i in 1 until clList.size - 1)
                        {
                            logEntries += clList[i]
                        }

                        var clYaml = """
                            author: $author
                            delete-after: True
                            changes:
                        """.trimIndent()
                        logEntries.forEach {
                            clYaml += "\n  - ${it.split(':')[0]}: \"${it.split(": ")[1]}\""
                        }
                        val clFile = File("repo/html/changelogs/pr-${jsonData.number}-changes.yml")
                        clFile.writeText(clYaml)

                        withContext(Dispatchers.IO) {
                            println("Pulling...")
                            hsGit.pull()
                                .setRemote("origin")
                                .setTransportConfigCallback {
                                    (it as SshTransport).sshSessionFactory = SshSessionFactory
                                }
                                .call()

                            runBlocking {
                                println("Running scripts...")
                                val repoPath = File("repo/").absolutePath
                                generateChangelog(repoPath)
                            }

                            //hsGit.add().addFilepattern("html").setUpdate(true).call()
                            //val commit = hsGit.commit()
                            //commit.author = PersonIdent("HaloStation Build Bot", "<hs13@ss13.projectunsc.org>")
                            //commit.message = "[ci skip] Autogenerated Changelog for PR #${jsonData.number}"
                            //commit.call()

                            println("Changes committed... Attempting to push...")

                            val push = hsGit.push()
                            push.refSpecs = listOf(RefSpec("refs/heads/alpha:refs/heads/alpha"))
                            push.setTransportConfigCallback {
                                    (it as SshTransport).sshSessionFactory = SshSessionFactory
                            }
                            try {
                                //push.call()
                            } catch (ex: Exception) {
                                println(ex.message)
                            }

                            println("Push complete!")
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}
