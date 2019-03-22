// Generated from /home/sjtu-ypm/complier/src/src/com/mxcomplier/LaxerParser/MxStar.g4 by ANTLR 4.7.2
package com.mxcomplier.LaxerParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxStarParser}.
 */
public interface MxStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxStarParser.ProgramContext ctx);
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
	 * Enter a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MxStarParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MxStarParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constant}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MxStarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MxStarParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MxStarParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MxStarParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExperssion}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubExperssion(MxStarParser.SubExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExperssion}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubExperssion(MxStarParser.SubExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayCall}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCall(MxStarParser.ArrayCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayCall}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCall(MxStarParser.ArrayCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberCall}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberCall(MxStarParser.MemberCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberCall}
	 * labeled alternative in {@link MxStarParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberCall(MxStarParser.MemberCallContext ctx);
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
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(MxStarParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(MxStarParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(MxStarParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(MxStarParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(MxStarParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(MxStarParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxStarParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxStarParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixIncDec}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixIncDec(MxStarParser.SuffixIncDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixIncDec}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixIncDec(MxStarParser.SuffixIncDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MxStarParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MxStarParser.AssignExprContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#compoundStatementItem}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatementItem(MxStarParser.CompoundStatementItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#compoundStatementItem}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatementItem(MxStarParser.CompoundStatementItemContext ctx);
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
	 * Enter a parse tree produced by {@link MxStarParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(MxStarParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(MxStarParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxStarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxStarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#typeOrVoid}.
	 * @param ctx the parse tree
	 */
	void enterTypeOrVoid(MxStarParser.TypeOrVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#typeOrVoid}.
	 * @param ctx the parse tree
	 */
	void exitTypeOrVoid(MxStarParser.TypeOrVoidContext ctx);
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