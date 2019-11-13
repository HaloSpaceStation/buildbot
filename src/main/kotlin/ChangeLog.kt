import org.antlr.v4.runtime.*

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
            return super.recover(recognizer, e)
        }

        override fun recoverInline(recognizer: Parser?): Token {
            if (recognizer?.currentToken?.text == ":" && recognizer.ruleContext.ruleIndex == recognizer.getRuleIndex("changelog")) {
                recognizer.consume()
                while (recognizer.currentToken.type != ChangeLogParser.STRING && recognizer.currentToken.type != ChangeLogParser.WHITESPACE
                    && recognizer.currentToken.type != ChangeLogParser.EOF
                ) {
                    recognizer.consume()
                }
                reportMatch(recognizer)
                return recognizer.currentToken
            }
            return super.recoverInline(recognizer)
        }

    }

}