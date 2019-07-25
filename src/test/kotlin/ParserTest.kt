import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.junit.Assert
import org.junit.Test

class ParserTest {

    @Test
    fun testParserRegular() {
        val body = """
            blah blah blah
            :cl: AuthorName
            rscadd: Test Entry 1
            rscdel: Test Entry 2
            /:cl:
            blah blah blah
        """.trimIndent()

        val expectedAuthor = "AuthorName"
        val expectedEntries = mapOf("rscadd" to "Test Entry 1", "rscdel" to "Test Entry 2")

        var clText = body.substring(body.indexOf(":cl:"))
        clText = clText.substring(0, clText.indexOf("/:cl:") + 5)

        val clLexer = ChangeLogLexer(CharStreams.fromString(clText))
        val clTokens = CommonTokenStream(clLexer)
        val clParser = ChangeLogParser(clTokens)
        val clWalker = ParseTreeWalker()
        val clListener = ChangeLog()
        clWalker.walk(clListener, clParser.changelog())

        val author = clListener.author
        val logEntries = clListener.entries

        Assert.assertEquals(expectedAuthor, author)
        Assert.assertEquals(expectedEntries, logEntries)
    }

    @Test
    fun testParserNoSpaceOnAuthor() {
        val body = """
            :cl:AuthorName
            rscadd: Entry 1
            /:cl:
        """.trimIndent()

        val clLexer = ChangeLogLexer(CharStreams.fromString(body))
        val clTokens = CommonTokenStream(clLexer)
        val clParser = ChangeLogParser(clTokens)
        val clWalker = ParseTreeWalker()
        val clListener = ChangeLog()
        clWalker.walk(clListener, clParser.changelog())

        val author = clListener.author

        Assert.assertEquals("AuthorName", author)
    }

    @Test
    fun testTransposedSpaceOnEntry() {
        val body = """
            :cl: AuthorName
            rscadd :Entry 1
            /:cl:
        """.trimIndent()
        val expected = mapOf("rscadd" to "Entry 1")

        val clLexer = ChangeLogLexer(CharStreams.fromString(body))
        val clTokens = CommonTokenStream(clLexer)
        val clParser = ChangeLogParser(clTokens)
        val clWalker = ParseTreeWalker()
        val clListener = ChangeLog()
        clWalker.walk(clListener, clParser.changelog())

        Assert.assertEquals(expected, clListener.entries)
    }

    @Test
    fun testExtraSpaceOnEntry() {
        val body = """
            :cl: AuthorName
            rscadd : Entry 1
            /:cl:
        """.trimIndent()
        val expected = mapOf("rscadd" to "Entry 1")

        val clLexer = ChangeLogLexer(CharStreams.fromString(body))
        val clTokens = CommonTokenStream(clLexer)
        val clParser = ChangeLogParser(clTokens)
        val clWalker = ParseTreeWalker()
        val clListener = ChangeLog()
        clWalker.walk(clListener, clParser.changelog())

        Assert.assertEquals(expected, clListener.entries)
    }

    @Test
    fun recognizesCLEmoji() {
        val body ="""
            🆑 AuthorName
            rscadd: Entry
            /🆑
        """.trimIndent()

        val clLexer = ChangeLogLexer(CharStreams.fromString(body))
        val clTokens = CommonTokenStream(clLexer)
        val clParser = ChangeLogParser(clTokens)
        val clWalker = ParseTreeWalker()
        val clListener = ChangeLog()
        clWalker.walk(clListener, clParser.changelog())

        Assert.assertEquals("AuthorName", clListener.author)
    }
}