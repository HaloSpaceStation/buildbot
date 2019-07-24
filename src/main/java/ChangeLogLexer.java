// Generated from D:/GitHub/HaloStation Build Bot/src/main/antlr\ChangeLog.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ChangeLogLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, NEWLINE = 2, BEGINCL = 3, ENDCL = 4, DIGITS = 5, PUNCTUATION = 6, TAG = 7,
            TEXT = 8, WHITESPACE = 9;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "NEWLINE", "BEGINCL", "ENDCL", "DIGITS", "PUNCTUATION", "TAG",
                "TEXT", "WHITESPACE"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "':'", null, "':cl:'", null, null, null, null, null, "' '"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
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
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "ChangeLog.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\u008a\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3" +
                    "\2\3\2\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\6\6" +
                    "&\n\6\r\6\16\6\'\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3" +
                    "\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b" +
                    "\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3" +
                    "\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b" +
                    "\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3" +
                    "\b\3\b\3\b\3\b\3\b\5\b\u0082\n\b\3\t\6\t\u0085\n\t\r\t\16\t\u0086\3\n" +
                    "\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\6\4\2\f\f\17" +
                    "\17\3\2\62;\3\2.\60\4\2C\\c|\2\u0097\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2" +
                    "\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23" +
                    "\3\2\2\2\3\25\3\2\2\2\5\32\3\2\2\2\7\34\3\2\2\2\t!\3\2\2\2\13%\3\2\2\2" +
                    "\r)\3\2\2\2\17\u0081\3\2\2\2\21\u0084\3\2\2\2\23\u0088\3\2\2\2\25\26\7" +
                    "<\2\2\26\4\3\2\2\2\27\30\7\17\2\2\30\33\7\f\2\2\31\33\t\2\2\2\32\27\3" +
                    "\2\2\2\32\31\3\2\2\2\33\6\3\2\2\2\34\35\7<\2\2\35\36\7e\2\2\36\37\7n\2" +
                    "\2\37 \7<\2\2 \b\3\2\2\2!\"\7\61\2\2\"#\5\7\4\2#\n\3\2\2\2$&\t\3\2\2%" +
                    "$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\f\3\2\2\2)*\t\4\2\2*\16\3" +
                    "\2\2\2+,\7d\2\2,-\7w\2\2-.\7i\2\2./\7h\2\2/\60\7k\2\2\60\u0082\7z\2\2" +
                    "\61\62\7y\2\2\62\63\7k\2\2\63\u0082\7r\2\2\64\65\7v\2\2\65\66\7y\2\2\66" +
                    "\67\7g\2\2\678\7c\2\28\u0082\7m\2\29:\7u\2\2:;\7q\2\2;<\7w\2\2<=\7p\2" +
                    "\2=>\7f\2\2>?\7c\2\2?@\7f\2\2@\u0082\7f\2\2AB\7u\2\2BC\7q\2\2CD\7w\2\2" +
                    "DE\7p\2\2EF\7f\2\2FG\7f\2\2GH\7g\2\2H\u0082\7n\2\2IJ\7t\2\2JK\7u\2\2K" +
                    "L\7e\2\2LM\7c\2\2MN\7f\2\2N\u0082\7f\2\2OP\7t\2\2PQ\7u\2\2QR\7e\2\2RS" +
                    "\7f\2\2ST\7g\2\2T\u0082\7n\2\2UV\7k\2\2VW\7o\2\2WX\7c\2\2XY\7i\2\2YZ\7" +
                    "g\2\2Z[\7c\2\2[\\\7f\2\2\\\u0082\7f\2\2]^\7k\2\2^_\7o\2\2_`\7c\2\2`a\7" +
                    "i\2\2ab\7g\2\2bc\7f\2\2cd\7g\2\2d\u0082\7n\2\2ef\7o\2\2fg\7c\2\2gh\7r" +
                    "\2\2hi\7v\2\2ij\7y\2\2jk\7g\2\2kl\7c\2\2l\u0082\7m\2\2mn\7u\2\2no\7r\2" +
                    "\2op\7g\2\2pq\7n\2\2qr\7n\2\2rs\7e\2\2st\7j\2\2tu\7g\2\2uv\7e\2\2v\u0082" +
                    "\7m\2\2wx\7g\2\2xy\7z\2\2yz\7r\2\2z{\7g\2\2{|\7t\2\2|}\7k\2\2}~\7o\2\2" +
                    "~\177\7g\2\2\177\u0080\7p\2\2\u0080\u0082\7v\2\2\u0081+\3\2\2\2\u0081" +
                    "\61\3\2\2\2\u0081\64\3\2\2\2\u00819\3\2\2\2\u0081A\3\2\2\2\u0081I\3\2" +
                    "\2\2\u0081O\3\2\2\2\u0081U\3\2\2\2\u0081]\3\2\2\2\u0081e\3\2\2\2\u0081" +
                    "m\3\2\2\2\u0081w\3\2\2\2\u0082\20\3\2\2\2\u0083\u0085\t\5\2\2\u0084\u0083" +
                    "\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087" +
                    "\22\3\2\2\2\u0088\u0089\7\"\2\2\u0089\24\3\2\2\2\7\2\32\'\u0081\u0086" +
                    "\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}