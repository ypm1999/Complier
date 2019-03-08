// Generated from MxStar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxStarParser}.
 */
public interface MxStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxStarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(MxStarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(MxStarParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MxStarParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MxStarParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#functionDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclarator(MxStarParser.FunctionDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclarator(MxStarParser.FunctionDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(MxStarParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(MxStarParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classStatement}.
	 * @param ctx the parse tree
	 */
	void enterClassStatement(MxStarParser.ClassStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classStatement}.
	 * @param ctx the parse tree
	 */
	void exitClassStatement(MxStarParser.ClassStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classBlockItem}.
	 * @param ctx the parse tree
	 */
	void enterClassBlockItem(MxStarParser.ClassBlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classBlockItem}.
	 * @param ctx the parse tree
	 */
	void exitClassBlockItem(MxStarParser.ClassBlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#constructFunctionDefine}.
	 * @param ctx the parse tree
	 */
	void enterConstructFunctionDefine(MxStarParser.ConstructFunctionDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#constructFunctionDefine}.
	 * @param ctx the parse tree
	 */
	void exitConstructFunctionDefine(MxStarParser.ConstructFunctionDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationList(MxStarParser.DeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationList(MxStarParser.DeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatement(MxStarParser.DeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatement(MxStarParser.DeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MxStarParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MxStarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(MxStarParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(MxStarParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MxStarParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MxStarParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(MxStarParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(MxStarParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpressionList(MxStarParser.ArgumentExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpressionList(MxStarParser.ArgumentExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(MxStarParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(MxStarParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(MxStarParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(MxStarParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(MxStarParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(MxStarParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(MxStarParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(MxStarParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxStarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxStarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxStarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxStarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MxStarParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MxStarParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(MxStarParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(MxStarParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(MxStarParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(MxStarParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(MxStarParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(MxStarParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(MxStarParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(MxStarParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(MxStarParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(MxStarParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#bracketIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterBracketIdentifier(MxStarParser.BracketIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#bracketIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitBracketIdentifier(MxStarParser.BracketIdentifierContext ctx);
}