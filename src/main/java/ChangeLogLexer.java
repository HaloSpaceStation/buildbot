// Generated from D:/GitHub/HaloStation Build Bot/src/main/antlr\ChangeLog.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ChangeLogLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NEWLINE=2, BEGINCL=3, ENDCL=4, DIGITS=5, PUNCTUATION=6, TAG=7, 
		TEXT=8, WHITESPACE=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "NEWLINE", "BEGINCL", "ENDCL", "DIGITS", "PUNCTUATION", "TAG", 
			"TEXT", "WHITESPACE"
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


	public ChangeLogLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ChangeLog.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\u008e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3"+
		"\2\3\2\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4$\n\4\3\5"+
		"\3\5\3\5\3\6\6\6*\n\6\r\6\16\6+\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0086\n\b\3\t\6\t\u0089\n\t\r\t"+
		"\16\t\u008a\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3"+
		"\2\6\4\2\f\f\17\17\3\2\62;\3\2.\60\4\2C\\c|\3\3\2\uf193\3\uf193\3\u009d"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\32\3\2\2\2"+
		"\7#\3\2\2\2\t%\3\2\2\2\13)\3\2\2\2\r-\3\2\2\2\17\u0085\3\2\2\2\21\u0088"+
		"\3\2\2\2\23\u008c\3\2\2\2\25\26\7<\2\2\26\4\3\2\2\2\27\30\7\17\2\2\30"+
		"\33\7\f\2\2\31\33\t\2\2\2\32\27\3\2\2\2\32\31\3\2\2\2\33\6\3\2\2\2\34"+
		"\35\7<\2\2\35\36\7e\2\2\36\37\7n\2\2\37$\7<\2\2 $\t\6\2\2!\"\7\u1f1b\2"+
		"\2\"$\7\63\2\2#\34\3\2\2\2# \3\2\2\2#!\3\2\2\2$\b\3\2\2\2%&\7\61\2\2&"+
		"\'\5\7\4\2\'\n\3\2\2\2(*\t\3\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2"+
		"\2,\f\3\2\2\2-.\t\4\2\2.\16\3\2\2\2/\60\7d\2\2\60\61\7w\2\2\61\62\7i\2"+
		"\2\62\63\7h\2\2\63\64\7k\2\2\64\u0086\7z\2\2\65\66\7y\2\2\66\67\7k\2\2"+
		"\67\u0086\7r\2\289\7v\2\29:\7y\2\2:;\7g\2\2;<\7c\2\2<\u0086\7m\2\2=>\7"+
		"u\2\2>?\7q\2\2?@\7w\2\2@A\7p\2\2AB\7f\2\2BC\7c\2\2CD\7f\2\2D\u0086\7f"+
		"\2\2EF\7u\2\2FG\7q\2\2GH\7w\2\2HI\7p\2\2IJ\7f\2\2JK\7f\2\2KL\7g\2\2L\u0086"+
		"\7n\2\2MN\7t\2\2NO\7u\2\2OP\7e\2\2PQ\7c\2\2QR\7f\2\2R\u0086\7f\2\2ST\7"+
		"t\2\2TU\7u\2\2UV\7e\2\2VW\7f\2\2WX\7g\2\2X\u0086\7n\2\2YZ\7k\2\2Z[\7o"+
		"\2\2[\\\7c\2\2\\]\7i\2\2]^\7g\2\2^_\7c\2\2_`\7f\2\2`\u0086\7f\2\2ab\7"+
		"k\2\2bc\7o\2\2cd\7c\2\2de\7i\2\2ef\7g\2\2fg\7f\2\2gh\7g\2\2h\u0086\7n"+
		"\2\2ij\7o\2\2jk\7c\2\2kl\7r\2\2lm\7v\2\2mn\7y\2\2no\7g\2\2op\7c\2\2p\u0086"+
		"\7m\2\2qr\7u\2\2rs\7r\2\2st\7g\2\2tu\7n\2\2uv\7n\2\2vw\7e\2\2wx\7j\2\2"+
		"xy\7g\2\2yz\7e\2\2z\u0086\7m\2\2{|\7g\2\2|}\7z\2\2}~\7r\2\2~\177\7g\2"+
		"\2\177\u0080\7t\2\2\u0080\u0081\7k\2\2\u0081\u0082\7o\2\2\u0082\u0083"+
		"\7g\2\2\u0083\u0084\7p\2\2\u0084\u0086\7v\2\2\u0085/\3\2\2\2\u0085\65"+
		"\3\2\2\2\u00858\3\2\2\2\u0085=\3\2\2\2\u0085E\3\2\2\2\u0085M\3\2\2\2\u0085"+
		"S\3\2\2\2\u0085Y\3\2\2\2\u0085a\3\2\2\2\u0085i\3\2\2\2\u0085q\3\2\2\2"+
		"\u0085{\3\2\2\2\u0086\20\3\2\2\2\u0087\u0089\t\5\2\2\u0088\u0087\3\2\2"+
		"\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\22"+
		"\3\2\2\2\u008c\u008d\7\"\2\2\u008d\24\3\2\2\2\b\2\32#+\u0085\u008a\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}