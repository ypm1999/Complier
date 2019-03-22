// Generated from /home/sjtu-ypm/complier/src/src/com/mxcomplier/LaxerParser/MxStar.g4 by ANTLR 4.7.2
package com.mxcomplier.LaxerParser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_functionDefinition = 1, RULE_classDefinition = 2, 
		RULE_classStatement = 3, RULE_declarationList = 4, RULE_declarationStatement = 5, 
		RULE_declaration = 6, RULE_primaryExpression = 7, RULE_argumentExpressionList = 8, 
		RULE_expression = 9, RULE_newExpression = 10, RULE_statement = 11, RULE_compoundStatement = 12, 
		RULE_compoundStatementItem = 13, RULE_expressionStatement = 14, RULE_selectionStatement = 15, 
		RULE_iterationStatement = 16, RULE_forCondition = 17, RULE_jumpStatement = 18, 
		RULE_baseType = 19, RULE_type = 20, RULE_typeOrVoid = 21, RULE_bracketIdentifier = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDefinition", "classDefinition", "classStatement", 
			"declarationList", "declarationStatement", "declaration", "primaryExpression", 
			"argumentExpressionList", "expression", "newExpression", "statement", 
			"compoundStatement", "compoundStatementItem", "expressionStatement", 
			"selectionStatement", "iterationStatement", "forCondition", "jumpStatement", 
			"baseType", "type", "typeOrVoid", "bracketIdentifier"
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

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxStarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxStarParser.EOF, 0); }
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ClassDefinitionContext> classDefinition() {
			return getRuleContexts(ClassDefinitionContext.class);
		}
		public ClassDefinitionContext classDefinition(int i) {
			return getRuleContext(ClassDefinitionContext.class,i);
		}
		public List<DeclarationStatementContext> declarationStatement() {
			return getRuleContexts(DeclarationStatementContext.class);
		}
		public DeclarationStatementContext declarationStatement(int i) {
			return getRuleContext(DeclarationStatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(46);
					functionDefinition();
					}
					break;
				case 2:
					{
					setState(47);
					classDefinition();
					}
					break;
				case 3:
					{
					setState(48);
					declarationStatement();
					}
					break;
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(EOF);
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TypeOrVoidContext typeOrVoid() {
			return getRuleContext(TypeOrVoidContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(56);
				typeOrVoid();
				}
				break;
			}
			setState(59);
			match(Identifier);
			setState(60);
			match(T__0);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(61);
				declarationList();
				}
			}

			setState(64);
			match(T__1);
			setState(65);
			compoundStatement();
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

	public static class ClassDefinitionContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxStarParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public ClassStatementContext classStatement() {
			return getRuleContext(ClassStatementContext.class,0);
		}
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClassDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitClassDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(Class);
			setState(68);
			match(Identifier);
			setState(69);
			match(T__2);
			setState(70);
			classStatement();
			setState(71);
			match(T__3);
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

	public static class ClassStatementContext extends ParserRuleContext {
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<DeclarationStatementContext> declarationStatement() {
			return getRuleContexts(DeclarationStatementContext.class);
		}
		public DeclarationStatementContext declarationStatement(int i) {
			return getRuleContext(DeclarationStatementContext.class,i);
		}
		public ClassStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClassStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClassStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitClassStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassStatementContext classStatement() throws RecognitionException {
		ClassStatementContext _localctx = new ClassStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(75);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(73);
					functionDefinition();
					}
					break;
				case 2:
					{
					setState(74);
					declarationStatement();
					}
					break;
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DeclarationListContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			declaration();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(81);
				match(T__4);
				setState(82);
				declaration();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DeclarationStatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationStatementContext declarationStatement() throws RecognitionException {
		DeclarationStatementContext _localctx = new DeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			declaration();
			setState(89);
			match(T__5);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			type(0);
			setState(92);
			match(Identifier);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(93);
				match(T__6);
				setState(94);
				expression(0);
				}
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MemberCallExprContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public BracketIdentifierContext bracketIdentifier() {
			return getRuleContext(BracketIdentifierContext.class,0);
		}
		public MemberCallExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMemberCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMemberCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMemberCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayCallExprContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayCallExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterArrayCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitArrayCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitArrayCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExprContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public FunctionCallExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFunctionCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends PrimaryExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SubExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExprContext extends PrimaryExpressionContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public IdentifierExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIdentifierExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIdentifierExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantExprContext extends PrimaryExpressionContext {
		public TerminalNode Constant() { return getToken(MxStarParser.Constant, 0); }
		public ConstantExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterConstantExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitConstantExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitConstantExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		return primaryExpression(0);
	}

	private PrimaryExpressionContext primaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, _parentState);
		PrimaryExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_primaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98);
				match(Identifier);
				}
				break;
			case Constant:
				{
				_localctx = new ConstantExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(Constant);
				}
				break;
			case T__0:
				{
				_localctx = new SubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(T__0);
				setState(101);
				expression(0);
				setState(102);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(120);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayCallExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(106);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(107);
						match(T__7);
						setState(108);
						expression(0);
						setState(109);
						match(T__8);
						}
						break;
					case 2:
						{
						_localctx = new FunctionCallExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(111);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(112);
						match(T__0);
						setState(114);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << Identifier) | (1L << Constant))) != 0)) {
							{
							setState(113);
							argumentExpressionList();
							}
						}

						setState(116);
						match(T__1);
						}
						break;
					case 3:
						{
						_localctx = new MemberCallExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(117);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(118);
						match(T__9);
						setState(119);
						bracketIdentifier();
						}
						break;
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitArgumentExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitArgumentExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			expression(0);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(126);
				match(T__4);
				setState(127);
				expression(0);
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewExprContext extends ExpressionContext {
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryExprContext extends ExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PrimaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPrimaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExpressionContext {
		public ExpressionContext exp1;
		public Token op;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixIncDecContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SuffixIncDecContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSuffixIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSuffixIncDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSuffixIncDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExpressionContext {
		public Token op;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				primaryExpression(0);
				}
				break;
			case 2:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(136);
				expression(14);
				}
				break;
			case 3:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(138);
				expression(13);
				}
				break;
			case 4:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				newExpression();
				}
				break;
			case 5:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				primaryExpression(0);
				setState(141);
				((AssignExprContext)_localctx).op = match(T__6);
				setState(142);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(146);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(147);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(148);
						((BinaryExprContext)_localctx).exp2 = expression(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(150);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(151);
						((BinaryExprContext)_localctx).exp2 = expression(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(153);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(154);
						((BinaryExprContext)_localctx).exp2 = expression(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(156);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(157);
						((BinaryExprContext)_localctx).exp2 = expression(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(159);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(160);
						((BinaryExprContext)_localctx).exp2 = expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(162);
						((BinaryExprContext)_localctx).op = match(T__27);
						setState(163);
						((BinaryExprContext)_localctx).exp2 = expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(165);
						((BinaryExprContext)_localctx).op = match(T__28);
						setState(166);
						((BinaryExprContext)_localctx).exp2 = expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(167);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(168);
						((BinaryExprContext)_localctx).op = match(T__29);
						setState(169);
						((BinaryExprContext)_localctx).exp2 = expression(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(171);
						((BinaryExprContext)_localctx).op = match(T__30);
						setState(172);
						((BinaryExprContext)_localctx).exp2 = expression(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(174);
						((BinaryExprContext)_localctx).op = match(T__31);
						setState(175);
						((BinaryExprContext)_localctx).exp2 = expression(3);
						}
						break;
					case 11:
						{
						_localctx = new SuffixIncDecContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(176);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(177);
						((SuffixIncDecContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((SuffixIncDecContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NewExpressionContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(MxStarParser.New, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_newExpression);
		try {
			int _alt;
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(New);
				setState(184);
				baseType();
				setState(189); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(185);
						match(T__7);
						setState(186);
						expression(0);
						setState(187);
						match(T__8);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(191); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(193);
						match(T__7);
						setState(194);
						match(T__8);
						}
						} 
					}
					setState(199);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(New);
				setState(201);
				baseType();
				setState(204);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(202);
					match(T__0);
					setState(203);
					match(T__1);
					}
					break;
				}
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

	public static class StatementContext extends ParserRuleContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				compoundStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				expressionStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				selectionStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				iterationStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				jumpStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				declarationStatement();
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

	public static class CompoundStatementContext extends ParserRuleContext {
		public List<CompoundStatementItemContext> compoundStatementItem() {
			return getRuleContexts(CompoundStatementItemContext.class);
		}
		public CompoundStatementItemContext compoundStatementItem(int i) {
			return getRuleContext(CompoundStatementItemContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__2);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << Identifier) | (1L << Constant))) != 0)) {
				{
				{
				setState(217);
				compoundStatementItem();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
			match(T__3);
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

	public static class CompoundStatementItemContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public CompoundStatementItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatementItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCompoundStatementItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCompoundStatementItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCompoundStatementItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementItemContext compoundStatementItem() throws RecognitionException {
		CompoundStatementItemContext _localctx = new CompoundStatementItemContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_compoundStatementItem);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				declarationStatement();
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

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << Identifier) | (1L << Constant))) != 0)) {
				{
				setState(229);
				expression(0);
				}
			}

			setState(232);
			match(T__5);
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

	public static class SelectionStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(MxStarParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxStarParser.Else, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(If);
			setState(235);
			match(T__0);
			setState(236);
			expression(0);
			setState(237);
			match(T__1);
			setState(238);
			statement();
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(239);
				match(Else);
				setState(240);
				statement();
				}
				break;
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

	public static class IterationStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(MxStarParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode For() { return getToken(MxStarParser.For, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_iterationStatement);
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				match(While);
				setState(244);
				match(T__0);
				setState(245);
				expression(0);
				setState(246);
				match(T__1);
				setState(247);
				statement();
				}
				break;
			case For:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				match(For);
				setState(250);
				match(T__0);
				setState(251);
				forCondition();
				setState(252);
				match(T__1);
				setState(253);
				statement();
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

	public static class ForConditionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitForCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitForCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << Identifier) | (1L << Constant))) != 0)) {
				{
				setState(257);
				expression(0);
				}
			}

			setState(260);
			match(T__5);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << Identifier) | (1L << Constant))) != 0)) {
				{
				setState(261);
				expression(0);
				}
			}

			setState(264);
			match(T__5);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << Identifier) | (1L << Constant))) != 0)) {
				{
				setState(265);
				expression(0);
				}
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

	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(MxStarParser.Continue, 0); }
		public TerminalNode Break() { return getToken(MxStarParser.Break, 0); }
		public TerminalNode Return() { return getToken(MxStarParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_jumpStatement);
		int _la;
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(Continue);
				setState(269);
				match(T__5);
				}
				break;
			case Break:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				match(Break);
				setState(271);
				match(T__5);
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				match(Return);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << Identifier) | (1L << Constant))) != 0)) {
					{
					setState(273);
					expression(0);
					}
				}

				setState(276);
				match(T__5);
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

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(MxStarParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxStarParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxStarParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class TypeContext extends ParserRuleContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(282);
			baseType();
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(284);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(285);
					match(T__7);
					setState(286);
					match(T__8);
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeOrVoidContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(MxStarParser.Void, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeOrVoidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeOrVoid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterTypeOrVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitTypeOrVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitTypeOrVoid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeOrVoidContext typeOrVoid() throws RecognitionException {
		TypeOrVoidContext _localctx = new TypeOrVoidContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeOrVoid);
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(Void);
				}
				break;
			case Bool:
			case Int:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				type(0);
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

	public static class BracketIdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public BracketIdentifierContext bracketIdentifier() {
			return getRuleContext(BracketIdentifierContext.class,0);
		}
		public BracketIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBracketIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBracketIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBracketIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracketIdentifierContext bracketIdentifier() throws RecognitionException {
		BracketIdentifierContext _localctx = new BracketIdentifierContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bracketIdentifier);
		try {
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(Identifier);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(T__0);
				setState(298);
				bracketIdentifier();
				setState(299);
				match(T__1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return primaryExpression_sempred((PrimaryExpressionContext)_localctx, predIndex);
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 20:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean primaryExpression_sempred(PrimaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 15);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u0132\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\5\3<\n\3\3\3\3\3\3\3\5\3A\n"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5"+
		"\3\6\3\6\3\6\7\6V\n\6\f\6\16\6Y\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\bb"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tk\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\tu\n\t\3\t\3\t\3\t\3\t\7\t{\n\t\f\t\16\t~\13\t\3\n\3\n\3\n\7\n"+
		"\u0083\n\n\f\n\16\n\u0086\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0093\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00b5\n\13\f\13"+
		"\16\13\u00b8\13\13\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00c0\n\f\r\f\16\f\u00c1"+
		"\3\f\3\f\7\f\u00c6\n\f\f\f\16\f\u00c9\13\f\3\f\3\f\3\f\3\f\5\f\u00cf\n"+
		"\f\5\f\u00d1\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d9\n\r\3\16\3\16\7\16"+
		"\u00dd\n\16\f\16\16\16\u00e0\13\16\3\16\3\16\3\17\3\17\5\17\u00e6\n\17"+
		"\3\20\5\20\u00e9\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00f4\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u0102\n\22\3\23\5\23\u0105\n\23\3\23\3\23\5\23\u0109\n\23\3\23\3"+
		"\23\5\23\u010d\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0115\n\24\3\24"+
		"\5\24\u0118\n\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0122\n"+
		"\26\f\26\16\26\u0125\13\26\3\27\3\27\5\27\u0129\n\27\3\30\3\30\3\30\3"+
		"\30\3\30\5\30\u0130\n\30\3\30\2\5\20\24*\31\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\2\n\3\2\r\16\3\2\17\22\3\2\23\25\3\2\17\20\3\2\26"+
		"\27\3\2\30\33\3\2\34\35\4\2#%\64\64\2\u0150\2\65\3\2\2\2\4;\3\2\2\2\6"+
		"E\3\2\2\2\bO\3\2\2\2\nR\3\2\2\2\fZ\3\2\2\2\16]\3\2\2\2\20j\3\2\2\2\22"+
		"\177\3\2\2\2\24\u0092\3\2\2\2\26\u00d0\3\2\2\2\30\u00d8\3\2\2\2\32\u00da"+
		"\3\2\2\2\34\u00e5\3\2\2\2\36\u00e8\3\2\2\2 \u00ec\3\2\2\2\"\u0101\3\2"+
		"\2\2$\u0104\3\2\2\2&\u0117\3\2\2\2(\u0119\3\2\2\2*\u011b\3\2\2\2,\u0128"+
		"\3\2\2\2.\u012f\3\2\2\2\60\64\5\4\3\2\61\64\5\6\4\2\62\64\5\f\7\2\63\60"+
		"\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7\2\2\39\3\3\2\2\2:<\5,\27\2;:\3"+
		"\2\2\2;<\3\2\2\2<=\3\2\2\2=>\7\64\2\2>@\7\3\2\2?A\5\n\6\2@?\3\2\2\2@A"+
		"\3\2\2\2AB\3\2\2\2BC\7\4\2\2CD\5\32\16\2D\5\3\2\2\2EF\7\62\2\2FG\7\64"+
		"\2\2GH\7\5\2\2HI\5\b\5\2IJ\7\6\2\2J\7\3\2\2\2KN\5\4\3\2LN\5\f\7\2MK\3"+
		"\2\2\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\t\3\2\2\2QO\3\2\2\2RW"+
		"\5\16\b\2ST\7\7\2\2TV\5\16\b\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"X\13\3\2\2\2YW\3\2\2\2Z[\5\16\b\2[\\\7\b\2\2\\\r\3\2\2\2]^\5*\26\2^a\7"+
		"\64\2\2_`\7\t\2\2`b\5\24\13\2a_\3\2\2\2ab\3\2\2\2b\17\3\2\2\2cd\b\t\1"+
		"\2dk\7\64\2\2ek\7\65\2\2fg\7\3\2\2gh\5\24\13\2hi\7\4\2\2ik\3\2\2\2jc\3"+
		"\2\2\2je\3\2\2\2jf\3\2\2\2k|\3\2\2\2lm\f\5\2\2mn\7\n\2\2no\5\24\13\2o"+
		"p\7\13\2\2p{\3\2\2\2qr\f\4\2\2rt\7\3\2\2su\5\22\n\2ts\3\2\2\2tu\3\2\2"+
		"\2uv\3\2\2\2v{\7\4\2\2wx\f\3\2\2xy\7\f\2\2y{\5.\30\2zl\3\2\2\2zq\3\2\2"+
		"\2zw\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\21\3\2\2\2~|\3\2\2\2\177\u0084"+
		"\5\24\13\2\u0080\u0081\7\7\2\2\u0081\u0083\5\24\13\2\u0082\u0080\3\2\2"+
		"\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\23"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\b\13\1\2\u0088\u0093\5\20\t\2"+
		"\u0089\u008a\t\2\2\2\u008a\u0093\5\24\13\20\u008b\u008c\t\3\2\2\u008c"+
		"\u0093\5\24\13\17\u008d\u0093\5\26\f\2\u008e\u008f\5\20\t\2\u008f\u0090"+
		"\7\t\2\2\u0090\u0091\5\24\13\3\u0091\u0093\3\2\2\2\u0092\u0087\3\2\2\2"+
		"\u0092\u0089\3\2\2\2\u0092\u008b\3\2\2\2\u0092\u008d\3\2\2\2\u0092\u008e"+
		"\3\2\2\2\u0093\u00b6\3\2\2\2\u0094\u0095\f\r\2\2\u0095\u0096\t\4\2\2\u0096"+
		"\u00b5\5\24\13\16\u0097\u0098\f\f\2\2\u0098\u0099\t\5\2\2\u0099\u00b5"+
		"\5\24\13\r\u009a\u009b\f\13\2\2\u009b\u009c\t\6\2\2\u009c\u00b5\5\24\13"+
		"\f\u009d\u009e\f\n\2\2\u009e\u009f\t\7\2\2\u009f\u00b5\5\24\13\13\u00a0"+
		"\u00a1\f\t\2\2\u00a1\u00a2\t\b\2\2\u00a2\u00b5\5\24\13\n\u00a3\u00a4\f"+
		"\b\2\2\u00a4\u00a5\7\36\2\2\u00a5\u00b5\5\24\13\t\u00a6\u00a7\f\7\2\2"+
		"\u00a7\u00a8\7\37\2\2\u00a8\u00b5\5\24\13\b\u00a9\u00aa\f\6\2\2\u00aa"+
		"\u00ab\7 \2\2\u00ab\u00b5\5\24\13\7\u00ac\u00ad\f\5\2\2\u00ad\u00ae\7"+
		"!\2\2\u00ae\u00b5\5\24\13\6\u00af\u00b0\f\4\2\2\u00b0\u00b1\7\"\2\2\u00b1"+
		"\u00b5\5\24\13\5\u00b2\u00b3\f\21\2\2\u00b3\u00b5\t\2\2\2\u00b4\u0094"+
		"\3\2\2\2\u00b4\u0097\3\2\2\2\u00b4\u009a\3\2\2\2\u00b4\u009d\3\2\2\2\u00b4"+
		"\u00a0\3\2\2\2\u00b4\u00a3\3\2\2\2\u00b4\u00a6\3\2\2\2\u00b4\u00a9\3\2"+
		"\2\2\u00b4\u00ac\3\2\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\25\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00bf\5(\25\2\u00bb"+
		"\u00bc\7\n\2\2\u00bc\u00bd\5\24\13\2\u00bd\u00be\7\13\2\2\u00be\u00c0"+
		"\3\2\2\2\u00bf\u00bb\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c7\3\2\2\2\u00c3\u00c4\7\n\2\2\u00c4\u00c6\7\13"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00d1\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\61"+
		"\2\2\u00cb\u00ce\5(\25\2\u00cc\u00cd\7\3\2\2\u00cd\u00cf\7\4\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00b9\3\2"+
		"\2\2\u00d0\u00ca\3\2\2\2\u00d1\27\3\2\2\2\u00d2\u00d9\5\32\16\2\u00d3"+
		"\u00d9\5\36\20\2\u00d4\u00d9\5 \21\2\u00d5\u00d9\5\"\22\2\u00d6\u00d9"+
		"\5&\24\2\u00d7\u00d9\5\f\7\2\u00d8\u00d2\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d8"+
		"\u00d4\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2"+
		"\2\2\u00d9\31\3\2\2\2\u00da\u00de\7\5\2\2\u00db\u00dd\5\34\17\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\6\2\2\u00e2"+
		"\33\3\2\2\2\u00e3\u00e6\5\30\r\2\u00e4\u00e6\5\f\7\2\u00e5\u00e3\3\2\2"+
		"\2\u00e5\u00e4\3\2\2\2\u00e6\35\3\2\2\2\u00e7\u00e9\5\24\13\2\u00e8\u00e7"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7\b\2\2\u00eb"+
		"\37\3\2\2\2\u00ec\u00ed\7*\2\2\u00ed\u00ee\7\3\2\2\u00ee\u00ef\5\24\13"+
		"\2\u00ef\u00f0\7\4\2\2\u00f0\u00f3\5\30\r\2\u00f1\u00f2\7+\2\2\u00f2\u00f4"+
		"\5\30\r\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4!\3\2\2\2\u00f5"+
		"\u00f6\7-\2\2\u00f6\u00f7\7\3\2\2\u00f7\u00f8\5\24\13\2\u00f8\u00f9\7"+
		"\4\2\2\u00f9\u00fa\5\30\r\2\u00fa\u0102\3\2\2\2\u00fb\u00fc\7,\2\2\u00fc"+
		"\u00fd\7\3\2\2\u00fd\u00fe\5$\23\2\u00fe\u00ff\7\4\2\2\u00ff\u0100\5\30"+
		"\r\2\u0100\u0102\3\2\2\2\u0101\u00f5\3\2\2\2\u0101\u00fb\3\2\2\2\u0102"+
		"#\3\2\2\2\u0103\u0105\5\24\13\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2"+
		"\2\u0105\u0106\3\2\2\2\u0106\u0108\7\b\2\2\u0107\u0109\5\24\13\2\u0108"+
		"\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\7\b"+
		"\2\2\u010b\u010d\5\24\13\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"%\3\2\2\2\u010e\u010f\7/\2\2\u010f\u0118\7\b\2\2\u0110\u0111\7.\2\2\u0111"+
		"\u0118\7\b\2\2\u0112\u0114\7\60\2\2\u0113\u0115\5\24\13\2\u0114\u0113"+
		"\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\7\b\2\2\u0117"+
		"\u010e\3\2\2\2\u0117\u0110\3\2\2\2\u0117\u0112\3\2\2\2\u0118\'\3\2\2\2"+
		"\u0119\u011a\t\t\2\2\u011a)\3\2\2\2\u011b\u011c\b\26\1\2\u011c\u011d\5"+
		"(\25\2\u011d\u0123\3\2\2\2\u011e\u011f\f\3\2\2\u011f\u0120\7\n\2\2\u0120"+
		"\u0122\7\13\2\2\u0121\u011e\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3"+
		"\2\2\2\u0123\u0124\3\2\2\2\u0124+\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0129"+
		"\7\'\2\2\u0127\u0129\5*\26\2\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129"+
		"-\3\2\2\2\u012a\u0130\7\64\2\2\u012b\u012c\7\3\2\2\u012c\u012d\5.\30\2"+
		"\u012d\u012e\7\4\2\2\u012e\u0130\3\2\2\2\u012f\u012a\3\2\2\2\u012f\u012b"+
		"\3\2\2\2\u0130/\3\2\2\2$\63\65;@MOWajtz|\u0084\u0092\u00b4\u00b6\u00c1"+
		"\u00c7\u00ce\u00d0\u00d8\u00de\u00e5\u00e8\u00f3\u0101\u0104\u0108\u010c"+
		"\u0114\u0117\u0123\u0128\u012f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}