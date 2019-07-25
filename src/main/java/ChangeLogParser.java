// Generated from D:/GitHub/HaloStation Build Bot/src/main/antlr\ChangeLog.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ChangeLogParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NEWLINE=2, BEGINCL=3, ENDCL=4, DIGITS=5, PUNCTUATION=6, TAG=7, 
		TEXT=8, WHITESPACE=9;
	public static final int
		RULE_changelog = 0, RULE_author = 1, RULE_entries = 2, RULE_entry = 3, 
		RULE_entry_tail = 4, RULE_whitespace = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"changelog", "author", "entries", "entry", "entry_tail", "whitespace"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, null, null, null, null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NEWLINE", "BEGINCL", "ENDCL", "DIGITS", "PUNCTUATION", "TAG", 
			"TEXT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ChangeLog.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ChangeLogParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ChangelogContext extends ParserRuleContext {
		public TerminalNode BEGINCL() { return getToken(ChangeLogParser.BEGINCL, 0); }

        public List<WhitespaceContext> whitespace() {
            return getRuleContexts(WhitespaceContext.class);
        }

        public WhitespaceContext whitespace(int i) {
            return getRuleContext(WhitespaceContext.class, i);
		}
		public AuthorContext author() {
			return getRuleContext(AuthorContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ChangeLogParser.NEWLINE, 0); }
		public EntriesContext entries() {
			return getRuleContext(EntriesContext.class,0);
		}
		public TerminalNode ENDCL() { return getToken(ChangeLogParser.ENDCL, 0); }
		public ChangelogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changelog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).enterChangelog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).exitChangelog(this);
		}
	}

	public final ChangelogContext changelog() throws RecognitionException {
		ChangelogContext _localctx = new ChangelogContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_changelog);
		try {
            int _alt;
			enterOuterAlt(_localctx, 1);
			{
                setState(15);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 0, _ctx);
                while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1 + 1) {
                        {
                            {
                                setState(12);
                                matchWildcard();
                            }
                        }
                    }
                    setState(17);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 0, _ctx);
                }
                setState(18);
			match(BEGINCL);
                setState(19);
			whitespace();
                setState(20);
			author();
                setState(21);
			match(NEWLINE);
                setState(22);
			entries();
                setState(23);
			match(ENDCL);
                setState(24);
                whitespace();
                setState(28);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
                while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1 + 1) {
                        {
                            {
                                setState(25);
                                matchWildcard();
                            }
                        }
                    }
                    setState(30);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
                }
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AuthorContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(ChangeLogParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(ChangeLogParser.TEXT, i);
		}
		public List<TerminalNode> DIGITS() { return getTokens(ChangeLogParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(ChangeLogParser.DIGITS, i);
		}
		public List<TerminalNode> PUNCTUATION() { return getTokens(ChangeLogParser.PUNCTUATION); }
		public TerminalNode PUNCTUATION(int i) {
			return getToken(ChangeLogParser.PUNCTUATION, i);
		}
		public AuthorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_author; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).enterAuthor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).exitAuthor(this);
		}
	}

	public final AuthorContext author() throws RecognitionException {
		AuthorContext _localctx = new AuthorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_author);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
                    setState(31);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGITS) | (1L << PUNCTUATION) | (1L << TEXT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
                setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGITS) | (1L << PUNCTUATION) | (1L << TEXT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntriesContext extends ParserRuleContext {
		public EntryContext entry() {
			return getRuleContext(EntryContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ChangeLogParser.NEWLINE, 0); }
		public Entry_tailContext entry_tail() {
			return getRuleContext(Entry_tailContext.class,0);
		}
		public EntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).enterEntries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).exitEntries(this);
		}
	}

	public final EntriesContext entries() throws RecognitionException {
		EntriesContext _localctx = new EntriesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_entries);
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(36);
			entry();
                setState(37);
			match(NEWLINE);
                setState(38);
			entry_tail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntryContext extends ParserRuleContext {
		public TerminalNode TAG() { return getToken(ChangeLogParser.TAG, 0); }
		public List<WhitespaceContext> whitespace() {
			return getRuleContexts(WhitespaceContext.class);
		}
		public WhitespaceContext whitespace(int i) {
			return getRuleContext(WhitespaceContext.class,i);
		}
		public List<TerminalNode> TEXT() { return getTokens(ChangeLogParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(ChangeLogParser.TEXT, i);
		}
		public List<TerminalNode> DIGITS() { return getTokens(ChangeLogParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(ChangeLogParser.DIGITS, i);
		}
		public List<TerminalNode> PUNCTUATION() { return getTokens(ChangeLogParser.PUNCTUATION); }
		public TerminalNode PUNCTUATION(int i) {
			return getToken(ChangeLogParser.PUNCTUATION, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(ChangeLogParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(ChangeLogParser.WHITESPACE, i);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(40);
			match(TAG);
                setState(41);
			whitespace();
                setState(42);
			match(T__0);
                setState(43);
			whitespace();
                setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
                    setState(44);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGITS) | (1L << PUNCTUATION) | (1L << TEXT) | (1L << WHITESPACE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
                setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGITS) | (1L << PUNCTUATION) | (1L << TEXT) | (1L << WHITESPACE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Entry_tailContext extends ParserRuleContext {
		public EntriesContext entries() {
			return getRuleContext(EntriesContext.class,0);
		}
		public Entry_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).enterEntry_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).exitEntry_tail(this);
		}
	}

	public final Entry_tailContext entry_tail() throws RecognitionException {
		Entry_tailContext _localctx = new Entry_tailContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_entry_tail);
		try {
            setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG:
				enterOuterAlt(_localctx, 1);
				{
                    setState(49);
				entries();
				}
				break;
			case ENDCL:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhitespaceContext extends ParserRuleContext {
		public TerminalNode WHITESPACE() { return getToken(ChangeLogParser.WHITESPACE, 0); }
		public WhitespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whitespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).enterWhitespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChangeLogListener ) ((ChangeLogListener)listener).exitWhitespace(this);
		}
	}

	public final WhitespaceContext whitespace() throws RecognitionException {
		WhitespaceContext _localctx = new WhitespaceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whitespace);
		try {
            setState(55);
			_errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
                    setState(53);
				match(WHITESPACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13<\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\7\2\20\n\2\f\2\16\2\23\13\2\3\2" +
                    "\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\3\6\3#\n\3\r" +
                    "\3\16\3$\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\6\5\60\n\5\r\5\16\5\61\3" +
                    "\6\3\6\5\6\66\n\6\3\7\3\7\5\7:\n\7\3\7\4\21\36\2\b\2\4\6\b\n\f\2\4\4\2" +
                    "\7\b\n\n\4\2\7\b\n\13\2;\2\21\3\2\2\2\4\"\3\2\2\2\6&\3\2\2\2\b*\3\2\2" +
                    "\2\n\65\3\2\2\2\f9\3\2\2\2\16\20\13\2\2\2\17\16\3\2\2\2\20\23\3\2\2\2" +
                    "\21\22\3\2\2\2\21\17\3\2\2\2\22\24\3\2\2\2\23\21\3\2\2\2\24\25\7\5\2\2" +
                    "\25\26\5\f\7\2\26\27\5\4\3\2\27\30\7\4\2\2\30\31\5\6\4\2\31\32\7\6\2\2" +
                    "\32\36\5\f\7\2\33\35\13\2\2\2\34\33\3\2\2\2\35 \3\2\2\2\36\37\3\2\2\2" +
                    "\36\34\3\2\2\2\37\3\3\2\2\2 \36\3\2\2\2!#\t\2\2\2\"!\3\2\2\2#$\3\2\2\2" +
                    "$\"\3\2\2\2$%\3\2\2\2%\5\3\2\2\2&\'\5\b\5\2\'(\7\4\2\2()\5\n\6\2)\7\3" +
                    "\2\2\2*+\7\t\2\2+,\5\f\7\2,-\7\3\2\2-/\5\f\7\2.\60\t\3\2\2/.\3\2\2\2\60" +
                    "\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\t\3\2\2\2\63\66\5\6\4\2\64\66" +
                    "\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2\66\13\3\2\2\2\67:\7\13\2\28:\3\2" +
                    "\2\29\67\3\2\2\298\3\2\2\2:\r\3\2\2\2\b\21\36$\61\659";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}