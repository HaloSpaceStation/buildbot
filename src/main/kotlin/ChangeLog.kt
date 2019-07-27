import org.antlr.v4.runtime.DefaultErrorStrategy
import org.antlr.v4.runtime.NoViableAltException
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException

class ChangeLog : ChangeLogBaseListener() {

    var author: String = ""
    var entries = mutableListOf<Pair<String, String>>()

    override fun enterAuthor(ctx: ChangeLogParser.AuthorContext) {
        this.author = ctx.text
    }

    override fun exitEntry(ctx: ChangeLogParser.EntryContext) {
        val text = ctx.text
        this.entries.add(Pair(text.split(':')[0].trim(), text.split(':')[1].trim()))
    }

    class ChangeLogErrorStrategy : DefaultErrorStrategy() {

        override fun recover(recognizer: Parser?, e: RecognitionException?) {
            if (e is NoViableAltException) {
                throw NoViableAltException(recognizer)
            }
        }

    }

}