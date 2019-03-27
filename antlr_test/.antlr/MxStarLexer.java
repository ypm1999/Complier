// Generated from /home/sjtu-ypm/complier/antlr_test/MxStar.g4 by ANTLR 4.7.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, Null=34, True=35, False=36, This=37, Void=38, Int=39, 
		String=40, Bool=41, New=42, Class=43, Return=44, Continue=45, Break=46, 
		Else=47, For=48, While=49, If=50, IntegerConstant=51, Nondigit=52, Digit=53, 
		NonzeroDigit=54, CharacterConstant=55, Whitespace=56, Newline=57, BlockComment=58, 
		LineComment=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"Null", "True", "False", "This", "Void", "Int", "String", "Bool", "New", 
		"Class", "Return", "Continue", "Break", "Else", "For", "While", "If", 
		"IntegerConstant", "Nondigit", "Digit", "NonzeroDigit", "CharacterConstant", 
		"CCharSequence", "CChar", "EscapeSequence", "Whitespace", "Newline", "BlockComment", 
		"LineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "','", "'='", "'['", "']'", "'.'", "'++'", 
		"'--'", "'+'", "'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'<<'", "'>>'", 
		"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&'", "'^'", "'|'", "'&&'", 
		"'||'", "';'", "'_'", "'null'", "'true'", "'false'", "'this'", "'void'", 
		"'int'", "'string'", "'bool'", "'new'", "'class'", "'return'", "'continue'", 
		"'break'", "'else'", "'for'", "'while'", "'if'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "Null", "True", 
		"False", "This", "Void", "Int", "String", "Bool", "New", "Class", "Return", 
		"Continue", "Break", "Else", "For", "While", "If", "IntegerConstant", 
		"Nondigit", "Digit", "NonzeroDigit", "CharacterConstant", "Whitespace", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u0172\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&"+
		"\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3"+
		"*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\7\64\u012b"+
		"\n\64\f\64\16\64\u012e\13\64\5\64\u0130\n\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\58\u013a\n8\38\38\39\69\u013f\n9\r9\169\u0140\3:\3:\5:\u0145"+
		"\n:\3;\3;\3;\3<\6<\u014b\n<\r<\16<\u014c\3<\3<\3=\3=\5=\u0153\n=\3=\5"+
		"=\u0156\n=\3=\3=\3>\3>\3>\3>\7>\u015e\n>\f>\16>\u0161\13>\3>\3>\3>\3>"+
		"\3>\3?\3?\3?\3?\7?\u016c\n?\f?\16?\u016f\13?\3?\3?\3\u015f\2@\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q\2s\2u"+
		"\2w:y;{<}=\3\2\t\4\2C\\c|\3\2\62;\3\2\63;\5\2\f\f\17\17^^\7\2$$^^pptt"+
		"vv\4\2\13\13\"\"\4\2\f\f\17\17\2\u0178\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2w\3\2\2\2\2y\3\2\2"+
		"\2\2{\3\2\2\2\2}\3\2\2\2\3\177\3\2\2\2\5\u0081\3\2\2\2\7\u0083\3\2\2\2"+
		"\t\u0085\3\2\2\2\13\u0087\3\2\2\2\r\u0089\3\2\2\2\17\u008b\3\2\2\2\21"+
		"\u008d\3\2\2\2\23\u008f\3\2\2\2\25\u0091\3\2\2\2\27\u0094\3\2\2\2\31\u0097"+
		"\3\2\2\2\33\u0099\3\2\2\2\35\u009b\3\2\2\2\37\u009d\3\2\2\2!\u009f\3\2"+
		"\2\2#\u00a1\3\2\2\2%\u00a3\3\2\2\2\'\u00a5\3\2\2\2)\u00a8\3\2\2\2+\u00ab"+
		"\3\2\2\2-\u00ad\3\2\2\2/\u00af\3\2\2\2\61\u00b2\3\2\2\2\63\u00b5\3\2\2"+
		"\2\65\u00b8\3\2\2\2\67\u00bb\3\2\2\29\u00bd\3\2\2\2;\u00bf\3\2\2\2=\u00c1"+
		"\3\2\2\2?\u00c4\3\2\2\2A\u00c7\3\2\2\2C\u00c9\3\2\2\2E\u00cb\3\2\2\2G"+
		"\u00d0\3\2\2\2I\u00d5\3\2\2\2K\u00db\3\2\2\2M\u00e0\3\2\2\2O\u00e5\3\2"+
		"\2\2Q\u00e9\3\2\2\2S\u00f0\3\2\2\2U\u00f5\3\2\2\2W\u00f9\3\2\2\2Y\u00ff"+
		"\3\2\2\2[\u0106\3\2\2\2]\u010f\3\2\2\2_\u0115\3\2\2\2a\u011a\3\2\2\2c"+
		"\u011e\3\2\2\2e\u0124\3\2\2\2g\u012f\3\2\2\2i\u0131\3\2\2\2k\u0133\3\2"+
		"\2\2m\u0135\3\2\2\2o\u0137\3\2\2\2q\u013e\3\2\2\2s\u0144\3\2\2\2u\u0146"+
		"\3\2\2\2w\u014a\3\2\2\2y\u0155\3\2\2\2{\u0159\3\2\2\2}\u0167\3\2\2\2\177"+
		"\u0080\7*\2\2\u0080\4\3\2\2\2\u0081\u0082\7+\2\2\u0082\6\3\2\2\2\u0083"+
		"\u0084\7}\2\2\u0084\b\3\2\2\2\u0085\u0086\7\177\2\2\u0086\n\3\2\2\2\u0087"+
		"\u0088\7.\2\2\u0088\f\3\2\2\2\u0089\u008a\7?\2\2\u008a\16\3\2\2\2\u008b"+
		"\u008c\7]\2\2\u008c\20\3\2\2\2\u008d\u008e\7_\2\2\u008e\22\3\2\2\2\u008f"+
		"\u0090\7\60\2\2\u0090\24\3\2\2\2\u0091\u0092\7-\2\2\u0092\u0093\7-\2\2"+
		"\u0093\26\3\2\2\2\u0094\u0095\7/\2\2\u0095\u0096\7/\2\2\u0096\30\3\2\2"+
		"\2\u0097\u0098\7-\2\2\u0098\32\3\2\2\2\u0099\u009a\7/\2\2\u009a\34\3\2"+
		"\2\2\u009b\u009c\7#\2\2\u009c\36\3\2\2\2\u009d\u009e\7\u0080\2\2\u009e"+
		" \3\2\2\2\u009f\u00a0\7,\2\2\u00a0\"\3\2\2\2\u00a1\u00a2\7\61\2\2\u00a2"+
		"$\3\2\2\2\u00a3\u00a4\7\'\2\2\u00a4&\3\2\2\2\u00a5\u00a6\7>\2\2\u00a6"+
		"\u00a7\7>\2\2\u00a7(\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9\u00aa\7@\2\2\u00aa"+
		"*\3\2\2\2\u00ab\u00ac\7>\2\2\u00ac,\3\2\2\2\u00ad\u00ae\7@\2\2\u00ae."+
		"\3\2\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1\7?\2\2\u00b1\60\3\2\2\2\u00b2"+
		"\u00b3\7@\2\2\u00b3\u00b4\7?\2\2\u00b4\62\3\2\2\2\u00b5\u00b6\7?\2\2\u00b6"+
		"\u00b7\7?\2\2\u00b7\64\3\2\2\2\u00b8\u00b9\7#\2\2\u00b9\u00ba\7?\2\2\u00ba"+
		"\66\3\2\2\2\u00bb\u00bc\7(\2\2\u00bc8\3\2\2\2\u00bd\u00be\7`\2\2\u00be"+
		":\3\2\2\2\u00bf\u00c0\7~\2\2\u00c0<\3\2\2\2\u00c1\u00c2\7(\2\2\u00c2\u00c3"+
		"\7(\2\2\u00c3>\3\2\2\2\u00c4\u00c5\7~\2\2\u00c5\u00c6\7~\2\2\u00c6@\3"+
		"\2\2\2\u00c7\u00c8\7=\2\2\u00c8B\3\2\2\2\u00c9\u00ca\7a\2\2\u00caD\3\2"+
		"\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7n\2\2\u00ce\u00cf"+
		"\7n\2\2\u00cfF\3\2\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3"+
		"\7w\2\2\u00d3\u00d4\7g\2\2\u00d4H\3\2\2\2\u00d5\u00d6\7h\2\2\u00d6\u00d7"+
		"\7c\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da\7g\2\2\u00da"+
		"J\3\2\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7j\2\2\u00dd\u00de\7k\2\2\u00de"+
		"\u00df\7u\2\2\u00dfL\3\2\2\2\u00e0\u00e1\7x\2\2\u00e1\u00e2\7q\2\2\u00e2"+
		"\u00e3\7k\2\2\u00e3\u00e4\7f\2\2\u00e4N\3\2\2\2\u00e5\u00e6\7k\2\2\u00e6"+
		"\u00e7\7p\2\2\u00e7\u00e8\7v\2\2\u00e8P\3\2\2\2\u00e9\u00ea\7u\2\2\u00ea"+
		"\u00eb\7v\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7p\2\2"+
		"\u00ee\u00ef\7i\2\2\u00efR\3\2\2\2\u00f0\u00f1\7d\2\2\u00f1\u00f2\7q\2"+
		"\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7n\2\2\u00f4T\3\2\2\2\u00f5\u00f6\7"+
		"p\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7y\2\2\u00f8V\3\2\2\2\u00f9\u00fa"+
		"\7e\2\2\u00fa\u00fb\7n\2\2\u00fb\u00fc\7c\2\2\u00fc\u00fd\7u\2\2\u00fd"+
		"\u00fe\7u\2\2\u00feX\3\2\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7g\2\2\u0101"+
		"\u0102\7v\2\2\u0102\u0103\7w\2\2\u0103\u0104\7t\2\2\u0104\u0105\7p\2\2"+
		"\u0105Z\3\2\2\2\u0106\u0107\7e\2\2\u0107\u0108\7q\2\2\u0108\u0109\7p\2"+
		"\2\u0109\u010a\7v\2\2\u010a\u010b\7k\2\2\u010b\u010c\7p\2\2\u010c\u010d"+
		"\7w\2\2\u010d\u010e\7g\2\2\u010e\\\3\2\2\2\u010f\u0110\7d\2\2\u0110\u0111"+
		"\7t\2\2\u0111\u0112\7g\2\2\u0112\u0113\7c\2\2\u0113\u0114\7m\2\2\u0114"+
		"^\3\2\2\2\u0115\u0116\7g\2\2\u0116\u0117\7n\2\2\u0117\u0118\7u\2\2\u0118"+
		"\u0119\7g\2\2\u0119`\3\2\2\2\u011a\u011b\7h\2\2\u011b\u011c\7q\2\2\u011c"+
		"\u011d\7t\2\2\u011db\3\2\2\2\u011e\u011f\7y\2\2\u011f\u0120\7j\2\2\u0120"+
		"\u0121\7k\2\2\u0121\u0122\7n\2\2\u0122\u0123\7g\2\2\u0123d\3\2\2\2\u0124"+
		"\u0125\7k\2\2\u0125\u0126\7h\2\2\u0126f\3\2\2\2\u0127\u0130\7\62\2\2\u0128"+
		"\u012c\5m\67\2\u0129\u012b\5k\66\2\u012a\u0129\3\2\2\2\u012b\u012e\3\2"+
		"\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u0130\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012f\u0127\3\2\2\2\u012f\u0128\3\2\2\2\u0130h\3\2\2\2"+
		"\u0131\u0132\t\2\2\2\u0132j\3\2\2\2\u0133\u0134\t\3\2\2\u0134l\3\2\2\2"+
		"\u0135\u0136\t\4\2\2\u0136n\3\2\2\2\u0137\u0139\7$\2\2\u0138\u013a\5q"+
		"9\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\7$\2\2\u013cp\3\2\2\2\u013d\u013f\5s:\2\u013e\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141r\3\2\2\2"+
		"\u0142\u0145\n\5\2\2\u0143\u0145\5u;\2\u0144\u0142\3\2\2\2\u0144\u0143"+
		"\3\2\2\2\u0145t\3\2\2\2\u0146\u0147\7^\2\2\u0147\u0148\t\6\2\2\u0148v"+
		"\3\2\2\2\u0149\u014b\t\7\2\2\u014a\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\b<"+
		"\2\2\u014fx\3\2\2\2\u0150\u0152\7\17\2\2\u0151\u0153\7\f\2\2\u0152\u0151"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0156\7\f\2\2\u0155"+
		"\u0150\3\2\2\2\u0155\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\b="+
		"\2\2\u0158z\3\2\2\2\u0159\u015a\7\61\2\2\u015a\u015b\7,\2\2\u015b\u015f"+
		"\3\2\2\2\u015c\u015e\13\2\2\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2\2"+
		"\u015f\u0160\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u015f"+
		"\3\2\2\2\u0162\u0163\7,\2\2\u0163\u0164\7\61\2\2\u0164\u0165\3\2\2\2\u0165"+
		"\u0166\b>\2\2\u0166|\3\2\2\2\u0167\u0168\7\61\2\2\u0168\u0169\7\61\2\2"+
		"\u0169\u016d\3\2\2\2\u016a\u016c\n\b\2\2\u016b\u016a\3\2\2\2\u016c\u016f"+
		"\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u0170\u0171\b?\2\2\u0171~\3\2\2\2\r\2\u012c\u012f\u0139"+
		"\u0140\u0144\u014c\u0152\u0155\u015f\u016d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}