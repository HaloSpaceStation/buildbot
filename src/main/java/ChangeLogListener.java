// Generated from D:/GitHub/HaloStation Build Bot/src/main/antlr\ChangeLog.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ChangeLogParser}.
 */
public interface ChangeLogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ChangeLogParser#changelog}.
	 * @param ctx the parse tree
	 */
	void enterChangelog(ChangeLogParser.ChangelogContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChangeLogParser#changelog}.
	 * @param ctx the parse tree
	 */
	void exitChangelog(ChangeLogParser.ChangelogContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChangeLogParser#author}.
	 * @param ctx the parse tree
	 */
	void enterAuthor(ChangeLogParser.AuthorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChangeLogParser#author}.
	 * @param ctx the parse tree
	 */
	void exitAuthor(ChangeLogParser.AuthorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChangeLogParser#entries}.
	 * @param ctx the parse tree
	 */
	void enterEntries(ChangeLogParser.EntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChangeLogParser#entries}.
	 * @param ctx the parse tree
	 */
	void exitEntries(ChangeLogParser.EntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChangeLogParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(ChangeLogParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChangeLogParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(ChangeLogParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChangeLogParser#entry_tail}.
	 * @param ctx the parse tree
	 */
	void enterEntry_tail(ChangeLogParser.Entry_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChangeLogParser#entry_tail}.
	 * @param ctx the parse tree
	 */
	void exitEntry_tail(ChangeLogParser.Entry_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChangeLogParser#whitespace}.
	 * @param ctx the parse tree
	 */
	void enterWhitespace(ChangeLogParser.WhitespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChangeLogParser#whitespace}.
	 * @param ctx the parse tree
	 */
	void exitWhitespace(ChangeLogParser.WhitespaceContext ctx);
}