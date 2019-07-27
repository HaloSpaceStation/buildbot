import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.NoViableAltException
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
        val expectedEntries = listOf(Pair("rscadd", "Test Entry 1"), Pair("rscdel", "Test Entry 2"))

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
        val expected = listOf(Pair("rscadd", "Entry 1"))

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
        val expected = listOf(Pair("rscadd", "Entry 1"))

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
        val entries = listOf(Pair("rscadd", "Entry"))

        val clLexer = ChangeLogLexer(CharStreams.fromString(body))
        val clTokens = CommonTokenStream(clLexer)
        val clParser = ChangeLogParser(clTokens)
        val clWalker = ParseTreeWalker()
        val clListener = ChangeLog()
        clWalker.walk(clListener, clParser.changelog())

        Assert.assertEquals("AuthorName", clListener.author)
        Assert.assertEquals(entries, clListener.entries)
    }

    @Test
    fun readInPlace() {
        val body = """
            This is a bunch of text.
            :cl: Author
            rscadd: An entry
            /:cl:
            It has a change log embedded in it!
        """.trimIndent()
        val author = "Author"
        val entries = mutableListOf(Pair("rscadd", "An entry"))

        val clLexer = ChangeLogLexer(CharStreams.fromString(body))
        val clTokens = CommonTokenStream(clLexer)
        val clParser = ChangeLogParser(clTokens)
        val clWalker = ParseTreeWalker()
        val clListener = ChangeLog()
        clWalker.walk(clListener, clParser.changelog())

        Assert.assertEquals(author, clListener.author)
        Assert.assertEquals(entries, clListener.entries)
    }

    @Test(expected = NoViableAltException::class)
    fun failOnBadTag() {
        val body = """
            :cl: Author
            rscadd: A usable entry
            bad: This is an unusable entry
            anotherBad: This one is also unusable
            /:cl:
        """.trimIndent()

        val clLexer = ChangeLogLexer(CharStreams.fromString(body))
        val clTokens = CommonTokenStream(clLexer)
        val clParser = ChangeLogParser(clTokens)
        val clWalker = ParseTreeWalker()
        val clListener = ChangeLog()
        clParser.errorHandler = ChangeLog.ChangeLogErrorStrategy()
        clWalker.walk(clListener, clParser.changelog())
    }
}