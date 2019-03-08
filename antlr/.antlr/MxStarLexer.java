// Generated from /home/sjtu-ypm/complier/antlr/MxStar.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Break=2, String=3, Continue=4, Else=5, For=6, If=7, Int=8, Bool=9, 
		Return=10, Void=11, While=12, New=13, LeftParen=14, RightParen=15, LeftBracket=16, 
		RightBracket=17, LeftBrace=18, RightBrace=19, Less=20, LessEqual=21, Greater=22, 
		GreaterEqual=23, LeftShift=24, RightShift=25, Plus=26, PlusPlus=27, Minus=28, 
		MinusMinus=29, Star=30, Div=31, Mod=32, And=33, Or=34, AndAnd=35, OrOr=36, 
		Caret=37, Not=38, Tilde=39, Question=40, Colon=41, Semi=42, Comma=43, 
		Assign=44, Equal=45, NotEqual=46, Dot=47, Identifier=48, Constant=49, 
		DigitSequence=50, Whitespace=51, Newline=52, BlockComment=53, LineComment=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "Break", "String", "Continue", "Else", "For", "If", "Int", "Bool", 
		"Return", "Void", "While", "New", "LeftParen", "RightParen", "LeftBracket", 
		"RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", 
		"GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", 
		"MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", 
		"Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", 
		"NotEqual", "Dot", "Identifier", "Nondigit", "Digit", "Constant", "IntegerConstant", 
		"DecimalConstant", "NonzeroDigit", "DigitSequence", "CharacterConstant", 
		"CCharSequence", "CChar", "EscapeSequence", "Whitespace", "Newline", "BlockComment", 
		"LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'break'", "'string'", "'continue'", "'else'", "'for'", 
		"'if'", "'int'", "'bool'", "'return'", "'void'", "'while'", "'new'", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", 
		"'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", 
		"'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", "'='", 
		"'=='", "'!='", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Break", "String", "Continue", "Else", "For", "If", "Int", 
		"Bool", "Return", "Void", "While", "New", "LeftParen", "RightParen", "LeftBracket", 
		"RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", 
		"GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", 
		"MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", 
		"Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", 
		"NotEqual", "Dot", "Identifier", "Constant", "DigitSequence", "Whitespace", 
		"Newline", "BlockComment", "LineComment"
	};
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


	public MxStarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u0181\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%"+
		"\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\7\61\u011b\n\61\f\61\16\61\u011e\13\61\3"+
		"\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\5\64\u0133\n\64\3\65\3\65\5\65\u0137\n\65\3\66"+
		"\3\66\7\66\u013b\n\66\f\66\16\66\u013e\13\66\3\67\3\67\38\68\u0143\n8"+
		"\r8\168\u0144\39\39\59\u0149\n9\39\39\3:\6:\u014e\n:\r:\16:\u014f\3;\3"+
		";\5;\u0154\n;\3<\3<\3<\3=\6=\u015a\n=\r=\16=\u015b\3=\3=\3>\3>\5>\u0162"+
		"\n>\3>\5>\u0165\n>\3>\3>\3?\3?\3?\3?\7?\u016d\n?\f?\16?\u0170\13?\3?\3"+
		"?\3?\3?\3?\3@\3@\3@\3@\7@\u017b\n@\f@\16@\u017e\13@\3@\3@\3\u016e\2A\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\2e\2g\63i\2k\2m\2o\64q"+
		"\2s\2u\2w\2y\65{\66}\67\1778\3\2\t\4\2C\\c|\3\2\62;\3\2\63;\5\2\f\f\17"+
		"\17^^\7\2$$^^ppttvv\4\2\13\13\"\"\4\2\f\f\17\17\2\u0189\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2g\3\2\2"+
		"\2\2o\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0081\3"+
		"\2\2\2\5\u0087\3\2\2\2\7\u008d\3\2\2\2\t\u0094\3\2\2\2\13\u009d\3\2\2"+
		"\2\r\u00a2\3\2\2\2\17\u00a6\3\2\2\2\21\u00a9\3\2\2\2\23\u00ad\3\2\2\2"+
		"\25\u00b2\3\2\2\2\27\u00b9\3\2\2\2\31\u00be\3\2\2\2\33\u00c4\3\2\2\2\35"+
		"\u00c8\3\2\2\2\37\u00ca\3\2\2\2!\u00cc\3\2\2\2#\u00ce\3\2\2\2%\u00d0\3"+
		"\2\2\2\'\u00d2\3\2\2\2)\u00d4\3\2\2\2+\u00d6\3\2\2\2-\u00d9\3\2\2\2/\u00db"+
		"\3\2\2\2\61\u00de\3\2\2\2\63\u00e1\3\2\2\2\65\u00e4\3\2\2\2\67\u00e6\3"+
		"\2\2\29\u00e9\3\2\2\2;\u00eb\3\2\2\2=\u00ee\3\2\2\2?\u00f0\3\2\2\2A\u00f2"+
		"\3\2\2\2C\u00f4\3\2\2\2E\u00f6\3\2\2\2G\u00f8\3\2\2\2I\u00fb\3\2\2\2K"+
		"\u00fe\3\2\2\2M\u0100\3\2\2\2O\u0102\3\2\2\2Q\u0104\3\2\2\2S\u0106\3\2"+
		"\2\2U\u0108\3\2\2\2W\u010a\3\2\2\2Y\u010c\3\2\2\2[\u010e\3\2\2\2]\u0111"+
		"\3\2\2\2_\u0114\3\2\2\2a\u0116\3\2\2\2c\u011f\3\2\2\2e\u0121\3\2\2\2g"+
		"\u0132\3\2\2\2i\u0136\3\2\2\2k\u0138\3\2\2\2m\u013f\3\2\2\2o\u0142\3\2"+
		"\2\2q\u0146\3\2\2\2s\u014d\3\2\2\2u\u0153\3\2\2\2w\u0155\3\2\2\2y\u0159"+
		"\3\2\2\2{\u0164\3\2\2\2}\u0168\3\2\2\2\177\u0176\3\2\2\2\u0081\u0082\7"+
		"e\2\2\u0082\u0083\7n\2\2\u0083\u0084\7c\2\2\u0084\u0085\7u\2\2\u0085\u0086"+
		"\7u\2\2\u0086\4\3\2\2\2\u0087\u0088\7d\2\2\u0088\u0089\7t\2\2\u0089\u008a"+
		"\7g\2\2\u008a\u008b\7c\2\2\u008b\u008c\7m\2\2\u008c\6\3\2\2\2\u008d\u008e"+
		"\7u\2\2\u008e\u008f\7v\2\2\u008f\u0090\7t\2\2\u0090\u0091\7k\2\2\u0091"+
		"\u0092\7p\2\2\u0092\u0093\7i\2\2\u0093\b\3\2\2\2\u0094\u0095\7e\2\2\u0095"+
		"\u0096\7q\2\2\u0096\u0097\7p\2\2\u0097\u0098\7v\2\2\u0098\u0099\7k\2\2"+
		"\u0099\u009a\7p\2\2\u009a\u009b\7w\2\2\u009b\u009c\7g\2\2\u009c\n\3\2"+
		"\2\2\u009d\u009e\7g\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1"+
		"\7g\2\2\u00a1\f\3\2\2\2\u00a2\u00a3\7h\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5"+
		"\7t\2\2\u00a5\16\3\2\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8\7h\2\2\u00a8\20"+
		"\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7v\2\2\u00ac"+
		"\22\3\2\2\2\u00ad\u00ae\7d\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7q\2\2\u00b0"+
		"\u00b1\7n\2\2\u00b1\24\3\2\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4"+
		"\u00b5\7v\2\2\u00b5\u00b6\7w\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7p\2\2"+
		"\u00b8\26\3\2\2\2\u00b9\u00ba\7x\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7"+
		"k\2\2\u00bc\u00bd\7f\2\2\u00bd\30\3\2\2\2\u00be\u00bf\7y\2\2\u00bf\u00c0"+
		"\7j\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7g\2\2\u00c3"+
		"\32\3\2\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7y\2\2\u00c7"+
		"\34\3\2\2\2\u00c8\u00c9\7*\2\2\u00c9\36\3\2\2\2\u00ca\u00cb\7+\2\2\u00cb"+
		" \3\2\2\2\u00cc\u00cd\7]\2\2\u00cd\"\3\2\2\2\u00ce\u00cf\7_\2\2\u00cf"+
		"$\3\2\2\2\u00d0\u00d1\7}\2\2\u00d1&\3\2\2\2\u00d2\u00d3\7\177\2\2\u00d3"+
		"(\3\2\2\2\u00d4\u00d5\7>\2\2\u00d5*\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7\u00d8"+
		"\7?\2\2\u00d8,\3\2\2\2\u00d9\u00da\7@\2\2\u00da.\3\2\2\2\u00db\u00dc\7"+
		"@\2\2\u00dc\u00dd\7?\2\2\u00dd\60\3\2\2\2\u00de\u00df\7>\2\2\u00df\u00e0"+
		"\7>\2\2\u00e0\62\3\2\2\2\u00e1\u00e2\7@\2\2\u00e2\u00e3\7@\2\2\u00e3\64"+
		"\3\2\2\2\u00e4\u00e5\7-\2\2\u00e5\66\3\2\2\2\u00e6\u00e7\7-\2\2\u00e7"+
		"\u00e8\7-\2\2\u00e88\3\2\2\2\u00e9\u00ea\7/\2\2\u00ea:\3\2\2\2\u00eb\u00ec"+
		"\7/\2\2\u00ec\u00ed\7/\2\2\u00ed<\3\2\2\2\u00ee\u00ef\7,\2\2\u00ef>\3"+
		"\2\2\2\u00f0\u00f1\7\61\2\2\u00f1@\3\2\2\2\u00f2\u00f3\7\'\2\2\u00f3B"+
		"\3\2\2\2\u00f4\u00f5\7(\2\2\u00f5D\3\2\2\2\u00f6\u00f7\7~\2\2\u00f7F\3"+
		"\2\2\2\u00f8\u00f9\7(\2\2\u00f9\u00fa\7(\2\2\u00faH\3\2\2\2\u00fb\u00fc"+
		"\7~\2\2\u00fc\u00fd\7~\2\2\u00fdJ\3\2\2\2\u00fe\u00ff\7`\2\2\u00ffL\3"+
		"\2\2\2\u0100\u0101\7#\2\2\u0101N\3\2\2\2\u0102\u0103\7\u0080\2\2\u0103"+
		"P\3\2\2\2\u0104\u0105\7A\2\2\u0105R\3\2\2\2\u0106\u0107\7<\2\2\u0107T"+
		"\3\2\2\2\u0108\u0109\7=\2\2\u0109V\3\2\2\2\u010a\u010b\7.\2\2\u010bX\3"+
		"\2\2\2\u010c\u010d\7?\2\2\u010dZ\3\2\2\2\u010e\u010f\7?\2\2\u010f\u0110"+
		"\7?\2\2\u0110\\\3\2\2\2\u0111\u0112\7#\2\2\u0112\u0113\7?\2\2\u0113^\3"+
		"\2\2\2\u0114\u0115\7\60\2\2\u0115`\3\2\2\2\u0116\u011c\5c\62\2\u0117\u011b"+
		"\5c\62\2\u0118\u011b\5e\63\2\u0119\u011b\7a\2\2\u011a\u0117\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011db\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120"+
		"\t\2\2\2\u0120d\3\2\2\2\u0121\u0122\t\3\2\2\u0122f\3\2\2\2\u0123\u0124"+
		"\7v\2\2\u0124\u0125\7t\2\2\u0125\u0126\7w\2\2\u0126\u0133\7g\2\2\u0127"+
		"\u0128\7h\2\2\u0128\u0129\7c\2\2\u0129\u012a\7n\2\2\u012a\u012b\7u\2\2"+
		"\u012b\u0133\7g\2\2\u012c\u012d\7p\2\2\u012d\u012e\7w\2\2\u012e\u012f"+
		"\7n\2\2\u012f\u0133\7n\2\2\u0130\u0133\5i\65\2\u0131\u0133\5q9\2\u0132"+
		"\u0123\3\2\2\2\u0132\u0127\3\2\2\2\u0132\u012c\3\2\2\2\u0132\u0130\3\2"+
		"\2\2\u0132\u0131\3\2\2\2\u0133h\3\2\2\2\u0134\u0137\5k\66\2\u0135\u0137"+
		"\7\62\2\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137j\3\2\2\2\u0138"+
		"\u013c\5m\67\2\u0139\u013b\5e\63\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2"+
		"\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013dl\3\2\2\2\u013e\u013c"+
		"\3\2\2\2\u013f\u0140\t\4\2\2\u0140n\3\2\2\2\u0141\u0143\5e\63\2\u0142"+
		"\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145p\3\2\2\2\u0146\u0148\7$\2\2\u0147\u0149\5s:\2\u0148\u0147\3"+
		"\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\7$\2\2\u014b"+
		"r\3\2\2\2\u014c\u014e\5u;\2\u014d\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150t\3\2\2\2\u0151\u0154\n\5\2\2"+
		"\u0152\u0154\5w<\2\u0153\u0151\3\2\2\2\u0153\u0152\3\2\2\2\u0154v\3\2"+
		"\2\2\u0155\u0156\7^\2\2\u0156\u0157\t\6\2\2\u0157x\3\2\2\2\u0158\u015a"+
		"\t\7\2\2\u0159\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\b=\2\2\u015ez\3\2\2\2\u015f"+
		"\u0161\7\17\2\2\u0160\u0162\7\f\2\2\u0161\u0160\3\2\2\2\u0161\u0162\3"+
		"\2\2\2\u0162\u0165\3\2\2\2\u0163\u0165\7\f\2\2\u0164\u015f\3\2\2\2\u0164"+
		"\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\b>\2\2\u0167|\3\2\2\2\u0168"+
		"\u0169\7\61\2\2\u0169\u016a\7,\2\2\u016a\u016e\3\2\2\2\u016b\u016d\13"+
		"\2\2\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016f\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\7,"+
		"\2\2\u0172\u0173\7\61\2\2\u0173\u0174\3\2\2\2\u0174\u0175\b?\2\2\u0175"+
		"~\3\2\2\2\u0176\u0177\7\61\2\2\u0177\u0178\7\61\2\2\u0178\u017c\3\2\2"+
		"\2\u0179\u017b\n\b\2\2\u017a\u0179\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a"+
		"\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2\2\2\u017e\u017c\3\2\2\2\u017f"+
		"\u0180\b@\2\2\u0180\u0080\3\2\2\2\21\2\u011a\u011c\u0132\u0136\u013c\u0144"+
		"\u0148\u014f\u0153\u015b\u0161\u0164\u016e\u017c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}