import org.antlr.v4.runtime.*

class ChangeLog : ChangeLogBaseListener() {

    var author: String = ""
    var entries = mutableListOf<Pair<String, String>>()

    override fun enterAuthor(ctx: ChangeLogParser.AuthorContext) {
        this.author = ctx.text
    }

    override fun exitEntry(ctx: ChangeLogParser.EntryContext) {
        val text = ctx.text.split(':')
        this.entries.add(Pair(text[0].trim(), text.takeLast(text.size - 1).joinToString(":").trim()))
    }

    class ChangeLogErrorStrategy : DefaultErrorStrategy() {

        override fun recover(recognizer: Parser?, e: RecognitionException?) {
            if (e is NoViableAltException) {
                throw NoViableAltException(recognizer)
            }
            return super.recover(recognizer, e)
        }

        override fun recoverInline(recognizer: Parser): Token {
            if (recognizer.ruleContext.ruleIndex == recognizer.getRuleIndex("changelog")) {
                recognizer.consume() //Gobble the bad token
                while (recognizer.tokenStream.LA(1) != ChangeLogParser.BEGINCL && recognizer.tokenStream.LA(1) != ChangeLogParser.EOF
                ) {
                    // Since we're still in the start rule, continue to gobble tokens until we find something
                    // or run out of input
                    recognizer.consume()
                }
                if (recognizer.tokenStream.LA(1) == ChangeLogParser.BEGINCL) {
                    //We've found the start of a changelog
                    recognizer.consume()
                    reportMatch(recognizer)
                    return recognizer.currentToken
                }
            } else if (recognizer.ruleContext.ruleIndex == recognizer.getRuleIndex("entries")) {
                recognizer.consume()
                while (recognizer.tokenStream.LA(1) != ChangeLogParser.NEWLINE && recognizer.tokenStream.LA(1) != ChangeLogParser.EOF) {
                    recognizer.ruleContext.addChild(recognizer.consume())
                }
                return recognizer.consume()
            }
            return super.recoverInline(recognizer)
        }

    }

}