// Generated from /home/sjtu-ypm/complier/src/src/com/mxcomplier/LaxerParser/MxStar.g4 by ANTLR 4.7.2
package com.mxcomplier.LaxerParser;
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, Bool=33, Int=34, String=35, Null=36, Void=37, True=38, False=39, 
		If=40, Else=41, For=42, While=43, Break=44, Continue=45, Return=46, New=47, 
		Class=48, This=49, Identifier=50, Constant=51, DigitSequence=52, Whitespace=53, 
		Newline=54, BlockComment=55, LineComment=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "Bool", 
			"Int", "String", "Null", "Void", "True", "False", "If", "Else", "For", 
			"While", "Break", "Continue", "Return", "New", "Class", "This", "Identifier", 
			"Nondigit", "Digit", "Constant", "IntegerConstant", "DecimalConstant", 
			"NonzeroDigit", "DigitSequence", "CharacterConstant", "CCharSequence", 
			"CChar", "EscapeSequence", "Whitespace", "Newline", "BlockComment", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "','", "';'", "'='", "'['", "']'", 
			"'.'", "'++'", "'--'", "'+'", "'-'", "'!'", "'~'", "'*'", "'/'", "'%'", 
			"'<<'", "'>>'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&'", 
			"'^'", "'|'", "'&&'", "'||'", "'bool'", "'int'", "'string'", "'null'", 
			"'void'", "'true'", "'false'", "'if'", "'else'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", "'new'", "'class'", "'this'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Bool", "Int", 
			"String", "Null", "Void", "True", "False", "If", "Else", "For", "While", 
			"Break", "Continue", "Return", "New", "Class", "This", "Identifier", 
			"Constant", "DigitSequence", "Whitespace", "Newline", "BlockComment", 
			"LineComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u018c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%"+
		"\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63"+
		"\7\63\u0130\n\63\f\63\16\63\u0133\13\63\3\64\3\64\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\5\66\u013e\n\66\3\67\3\67\5\67\u0142\n\67\38\38\78\u0146"+
		"\n8\f8\168\u0149\138\39\39\3:\6:\u014e\n:\r:\16:\u014f\3;\3;\5;\u0154"+
		"\n;\3;\3;\3<\6<\u0159\n<\r<\16<\u015a\3=\3=\5=\u015f\n=\3>\3>\3>\3?\6"+
		"?\u0165\n?\r?\16?\u0166\3?\3?\3@\3@\5@\u016d\n@\3@\5@\u0170\n@\3@\3@\3"+
		"A\3A\3A\3A\7A\u0178\nA\fA\16A\u017b\13A\3A\3A\3A\3A\3A\3B\3B\3B\3B\7B"+
		"\u0186\nB\fB\16B\u0189\13B\3B\3B\3\u0179\2C\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\2i\2k\65m\2o\2q\2s\66u\2w\2y\2{\2}\67\177"+
		"8\u00819\u0083:\3\2\t\4\2C\\c|\3\2\62;\3\2\63;\5\2\f\f\17\17^^\7\2$$^"+
		"^ppttvv\4\2\13\13\"\"\4\2\f\f\17\17\2\u0194\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2k\3\2\2\2\2s\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\3\u0085\3\2\2\2\5\u0087\3\2\2\2\7\u0089\3\2\2\2\t\u008b\3\2\2"+
		"\2\13\u008d\3\2\2\2\r\u008f\3\2\2\2\17\u0091\3\2\2\2\21\u0093\3\2\2\2"+
		"\23\u0095\3\2\2\2\25\u0097\3\2\2\2\27\u0099\3\2\2\2\31\u009c\3\2\2\2\33"+
		"\u009f\3\2\2\2\35\u00a1\3\2\2\2\37\u00a3\3\2\2\2!\u00a5\3\2\2\2#\u00a7"+
		"\3\2\2\2%\u00a9\3\2\2\2\'\u00ab\3\2\2\2)\u00ad\3\2\2\2+\u00b0\3\2\2\2"+
		"-\u00b3\3\2\2\2/\u00b5\3\2\2\2\61\u00b7\3\2\2\2\63\u00ba\3\2\2\2\65\u00bd"+
		"\3\2\2\2\67\u00c0\3\2\2\29\u00c3\3\2\2\2;\u00c5\3\2\2\2=\u00c7\3\2\2\2"+
		"?\u00c9\3\2\2\2A\u00cc\3\2\2\2C\u00cf\3\2\2\2E\u00d4\3\2\2\2G\u00d8\3"+
		"\2\2\2I\u00df\3\2\2\2K\u00e4\3\2\2\2M\u00e9\3\2\2\2O\u00ee\3\2\2\2Q\u00f4"+
		"\3\2\2\2S\u00f7\3\2\2\2U\u00fc\3\2\2\2W\u0100\3\2\2\2Y\u0106\3\2\2\2["+
		"\u010c\3\2\2\2]\u0115\3\2\2\2_\u011c\3\2\2\2a\u0120\3\2\2\2c\u0126\3\2"+
		"\2\2e\u012b\3\2\2\2g\u0134\3\2\2\2i\u0136\3\2\2\2k\u013d\3\2\2\2m\u0141"+
		"\3\2\2\2o\u0143\3\2\2\2q\u014a\3\2\2\2s\u014d\3\2\2\2u\u0151\3\2\2\2w"+
		"\u0158\3\2\2\2y\u015e\3\2\2\2{\u0160\3\2\2\2}\u0164\3\2\2\2\177\u016f"+
		"\3\2\2\2\u0081\u0173\3\2\2\2\u0083\u0181\3\2\2\2\u0085\u0086\7*\2\2\u0086"+
		"\4\3\2\2\2\u0087\u0088\7+\2\2\u0088\6\3\2\2\2\u0089\u008a\7}\2\2\u008a"+
		"\b\3\2\2\2\u008b\u008c\7\177\2\2\u008c\n\3\2\2\2\u008d\u008e\7.\2\2\u008e"+
		"\f\3\2\2\2\u008f\u0090\7=\2\2\u0090\16\3\2\2\2\u0091\u0092\7?\2\2\u0092"+
		"\20\3\2\2\2\u0093\u0094\7]\2\2\u0094\22\3\2\2\2\u0095\u0096\7_\2\2\u0096"+
		"\24\3\2\2\2\u0097\u0098\7\60\2\2\u0098\26\3\2\2\2\u0099\u009a\7-\2\2\u009a"+
		"\u009b\7-\2\2\u009b\30\3\2\2\2\u009c\u009d\7/\2\2\u009d\u009e\7/\2\2\u009e"+
		"\32\3\2\2\2\u009f\u00a0\7-\2\2\u00a0\34\3\2\2\2\u00a1\u00a2\7/\2\2\u00a2"+
		"\36\3\2\2\2\u00a3\u00a4\7#\2\2\u00a4 \3\2\2\2\u00a5\u00a6\7\u0080\2\2"+
		"\u00a6\"\3\2\2\2\u00a7\u00a8\7,\2\2\u00a8$\3\2\2\2\u00a9\u00aa\7\61\2"+
		"\2\u00aa&\3\2\2\2\u00ab\u00ac\7\'\2\2\u00ac(\3\2\2\2\u00ad\u00ae\7>\2"+
		"\2\u00ae\u00af\7>\2\2\u00af*\3\2\2\2\u00b0\u00b1\7@\2\2\u00b1\u00b2\7"+
		"@\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4.\3\2\2\2\u00b5\u00b6\7@"+
		"\2\2\u00b6\60\3\2\2\2\u00b7\u00b8\7>\2\2\u00b8\u00b9\7?\2\2\u00b9\62\3"+
		"\2\2\2\u00ba\u00bb\7@\2\2\u00bb\u00bc\7?\2\2\u00bc\64\3\2\2\2\u00bd\u00be"+
		"\7?\2\2\u00be\u00bf\7?\2\2\u00bf\66\3\2\2\2\u00c0\u00c1\7#\2\2\u00c1\u00c2"+
		"\7?\2\2\u00c28\3\2\2\2\u00c3\u00c4\7(\2\2\u00c4:\3\2\2\2\u00c5\u00c6\7"+
		"`\2\2\u00c6<\3\2\2\2\u00c7\u00c8\7~\2\2\u00c8>\3\2\2\2\u00c9\u00ca\7("+
		"\2\2\u00ca\u00cb\7(\2\2\u00cb@\3\2\2\2\u00cc\u00cd\7~\2\2\u00cd\u00ce"+
		"\7~\2\2\u00ceB\3\2\2\2\u00cf\u00d0\7d\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2"+
		"\7q\2\2\u00d2\u00d3\7n\2\2\u00d3D\3\2\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6"+
		"\7p\2\2\u00d6\u00d7\7v\2\2\u00d7F\3\2\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da"+
		"\7v\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7p\2\2\u00dd"+
		"\u00de\7i\2\2\u00deH\3\2\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7w\2\2\u00e1"+
		"\u00e2\7n\2\2\u00e2\u00e3\7n\2\2\u00e3J\3\2\2\2\u00e4\u00e5\7x\2\2\u00e5"+
		"\u00e6\7q\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7f\2\2\u00e8L\3\2\2\2\u00e9"+
		"\u00ea\7v\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7g\2\2"+
		"\u00edN\3\2\2\2\u00ee\u00ef\7h\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7n\2"+
		"\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7g\2\2\u00f3P\3\2\2\2\u00f4\u00f5\7"+
		"k\2\2\u00f5\u00f6\7h\2\2\u00f6R\3\2\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9"+
		"\7n\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7g\2\2\u00fbT\3\2\2\2\u00fc\u00fd"+
		"\7h\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7t\2\2\u00ffV\3\2\2\2\u0100\u0101"+
		"\7y\2\2\u0101\u0102\7j\2\2\u0102\u0103\7k\2\2\u0103\u0104\7n\2\2\u0104"+
		"\u0105\7g\2\2\u0105X\3\2\2\2\u0106\u0107\7d\2\2\u0107\u0108\7t\2\2\u0108"+
		"\u0109\7g\2\2\u0109\u010a\7c\2\2\u010a\u010b\7m\2\2\u010bZ\3\2\2\2\u010c"+
		"\u010d\7e\2\2\u010d\u010e\7q\2\2\u010e\u010f\7p\2\2\u010f\u0110\7v\2\2"+
		"\u0110\u0111\7k\2\2\u0111\u0112\7p\2\2\u0112\u0113\7w\2\2\u0113\u0114"+
		"\7g\2\2\u0114\\\3\2\2\2\u0115\u0116\7t\2\2\u0116\u0117\7g\2\2\u0117\u0118"+
		"\7v\2\2\u0118\u0119\7w\2\2\u0119\u011a\7t\2\2\u011a\u011b\7p\2\2\u011b"+
		"^\3\2\2\2\u011c\u011d\7p\2\2\u011d\u011e\7g\2\2\u011e\u011f\7y\2\2\u011f"+
		"`\3\2\2\2\u0120\u0121\7e\2\2\u0121\u0122\7n\2\2\u0122\u0123\7c\2\2\u0123"+
		"\u0124\7u\2\2\u0124\u0125\7u\2\2\u0125b\3\2\2\2\u0126\u0127\7v\2\2\u0127"+
		"\u0128\7j\2\2\u0128\u0129\7k\2\2\u0129\u012a\7u\2\2\u012ad\3\2\2\2\u012b"+
		"\u0131\5g\64\2\u012c\u0130\5g\64\2\u012d\u0130\5i\65\2\u012e\u0130\7a"+
		"\2\2\u012f\u012c\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u012e\3\2\2\2\u0130"+
		"\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132f\3\2\2\2"+
		"\u0133\u0131\3\2\2\2\u0134\u0135\t\2\2\2\u0135h\3\2\2\2\u0136\u0137\t"+
		"\3\2\2\u0137j\3\2\2\2\u0138\u013e\5M\'\2\u0139\u013e\5O(\2\u013a\u013e"+
		"\5I%\2\u013b\u013e\5m\67\2\u013c\u013e\5u;\2\u013d\u0138\3\2\2\2\u013d"+
		"\u0139\3\2\2\2\u013d\u013a\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013c\3\2"+
		"\2\2\u013el\3\2\2\2\u013f\u0142\5o8\2\u0140\u0142\7\62\2\2\u0141\u013f"+
		"\3\2\2\2\u0141\u0140\3\2\2\2\u0142n\3\2\2\2\u0143\u0147\5q9\2\u0144\u0146"+
		"\5i\65\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148p\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\t\4\2\2"+
		"\u014br\3\2\2\2\u014c\u014e\5i\65\2\u014d\u014c\3\2\2\2\u014e\u014f\3"+
		"\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150t\3\2\2\2\u0151\u0153"+
		"\7$\2\2\u0152\u0154\5w<\2\u0153\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0156\7$\2\2\u0156v\3\2\2\2\u0157\u0159\5y=\2\u0158"+
		"\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015bx\3\2\2\2\u015c\u015f\n\5\2\2\u015d\u015f\5{>\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015d\3\2\2\2\u015fz\3\2\2\2\u0160\u0161\7^\2\2\u0161\u0162"+
		"\t\6\2\2\u0162|\3\2\2\2\u0163\u0165\t\7\2\2\u0164\u0163\3\2\2\2\u0165"+
		"\u0166\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\u0169\b?\2\2\u0169~\3\2\2\2\u016a\u016c\7\17\2\2\u016b\u016d"+
		"\7\f\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u0170\7\f\2\2\u016f\u016a\3\2\2\2\u016f\u016e\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0172\b@\2\2\u0172\u0080\3\2\2\2\u0173\u0174\7\61\2\2\u0174"+
		"\u0175\7,\2\2\u0175\u0179\3\2\2\2\u0176\u0178\13\2\2\2\u0177\u0176\3\2"+
		"\2\2\u0178\u017b\3\2\2\2\u0179\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a"+
		"\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\7,\2\2\u017d\u017e\7\61"+
		"\2\2\u017e\u017f\3\2\2\2\u017f\u0180\bA\2\2\u0180\u0082\3\2\2\2\u0181"+
		"\u0182\7\61\2\2\u0182\u0183\7\61\2\2\u0183\u0187\3\2\2\2\u0184\u0186\n"+
		"\b\2\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\bB"+
		"\2\2\u018b\u0084\3\2\2\2\21\2\u012f\u0131\u013d\u0141\u0147\u014f\u0153"+
		"\u015a\u015e\u0166\u016c\u016f\u0179\u0187\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}