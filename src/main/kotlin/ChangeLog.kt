class ChangeLog : ChangeLogBaseListener() {

    var author: String = ""
    var entries = mutableMapOf<String, String>()

    override fun enterAuthor(ctx: ChangeLogParser.AuthorContext) {
        this.author = ctx.text
    }

    override fun exitEntry(ctx: ChangeLogParser.EntryContext) {
        val text = ctx.text
        this.entries.put(text.split(':')[0].trim(), text.split(':')[1].trim())
    }

}