// Generated from D:/GitHub/HaloStation Build Bot/src/main/antlr\ChangeLog.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ChangeLogParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface ChangeLogVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link ChangeLogParser#changelog}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitChangelog(ChangeLogParser.ChangelogContext ctx);

    /**
     * Visit a parse tree produced by {@link ChangeLogParser#author}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAuthor(ChangeLogParser.AuthorContext ctx);

    /**
     * Visit a parse tree produced by {@link ChangeLogParser#entries}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEntries(ChangeLogParser.EntriesContext ctx);

    /**
     * Visit a parse tree produced by {@link ChangeLogParser#entry}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEntry(ChangeLogParser.EntryContext ctx);

    /**
     * Visit a parse tree produced by {@link ChangeLogParser#entry_tail}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEntry_tail(ChangeLogParser.Entry_tailContext ctx);
}