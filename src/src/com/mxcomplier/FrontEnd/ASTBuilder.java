package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Error.ComplierError;
import com.mxcomplier.LaxerParser.MxStarBaseVisitor;
import com.mxcomplier.LaxerParser.MxStarParser;
import com.mxcomplier.Type.ArrayType;
import com.mxcomplier.Type.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder  extends MxStarBaseVisitor<Node> {

    @Override
    public Node visitProgram(MxStarParser.ProgramContext ctx) {
        List<ClassDefNode> classDefs = new ArrayList<>();
        List<FuncDefNode> funcDefs = new ArrayList<>();
        List<VarDefNode> varDefs = new ArrayList<>();
        Node tempNode;

        if (ctx.classDefinition() != null){
            for(ParserRuleContext classDef : ctx.classDefinition()){
                tempNode = visit(classDef);
                classDefs.add((ClassDefNode) tempNode);
            }
        }

        if (ctx.functionDefinition() != null){
            for(ParserRuleContext funcDef : ctx.functionDefinition()){
                tempNode = visit(funcDef);
                funcDefs.add((FuncDefNode) tempNode);
            }
        }

        if (ctx.declarationStatement() != null){
            for(ParserRuleContext varDef : ctx.declarationStatement()){
                tempNode = visit(varDef);
                varDefs.add((VarDefNode) tempNode);
            }
        }

        return new ProgramNode(classDefs, funcDefs, varDefs, new Location(ctx.getStart()));
    }

    @Override
    public Node visitFunctionDefinition(MxStarParser.FunctionDefinitionContext ctx) {
        String name = ctx.identifier().getText();
        Node funcbody = visit(ctx.compoundStatement());
        Node returnType = null;
        List<TypeNode> parameters = new ArrayList<>();

        if(ctx.typeOrVoid() != null)
            returnType =  visit(ctx.typeOrVoid());

        for(ParserRuleContext args : ctx.declarationList().declaration()){
            parameters.add((TypeNode) visit(args));
        }

        return new FuncDefNode(name, (TypeNode) returnType, parameters, (CompStmtNode) funcbody, new Location(ctx.getStart()));
    }

    @Override
    public Node visitClassDefinition(MxStarParser.ClassDefinitionContext ctx) {
        String name = ctx.identifier().getText();
        List<VarDefNode> varList = new ArrayList<>();
        List<FuncDefNode> funcList = new ArrayList<>();
        if(ctx.classStatement().declarationStatement() != null)
            for (ParserRuleContext var : ctx.classStatement().declarationStatement()){
                varList.add((VarDefNode) visit(var));
            }
        if (ctx.classStatement().functionDefinition() != null)
            for (ParserRuleContext func : ctx.classStatement().functionDefinition()){
                funcList.add((FuncDefNode) visit(func));
            }
        return new ClassDefNode(name, varList, funcList, new Location(ctx.getStart()));
    }




    @Override
    public Node visitStatement(MxStarParser.StatementContext ctx) {
        if (ctx.compoundStatement() != null)
            return visit(ctx.compoundStatement());
        else if (ctx.expressionStatement() != null)
            return visit(ctx.expressionStatement());
        else if (ctx.selectionStatement() != null)
            return visit(ctx.selectionStatement());
        else if (ctx.iterationStatement() != null)
            return visit(ctx.iterationStatement());
        else if (ctx.jumpStatement() != null)
            return visit(ctx.jumpStatement());
        else throw new ComplierError(new Location(ctx.getStart()), "Unknown statement");
    }

    @Override
    public Node visitCompoundStatement(MxStarParser.CompoundStatementContext ctx) {
        List<StmtNode> stmtlist = new ArrayList<>();
        if (ctx.compoundStatementItem() != null)
            for (ParserRuleContext item : ctx.compoundStatementItem())
                stmtlist.add((StmtNode)visit(item));
        return new CompStmtNode(stmtlist, new Location(ctx.getStart()));
    }

    @Override
    public Node visitCompoundStatementItem(MxStarParser.CompoundStatementItemContext ctx) {
        if (ctx.statement() != null)
            return visit(ctx.statement());
        else if (ctx.declarationStatement() != null)
            return visit(ctx.declarationStatement());
        else throw new ComplierError(new Location(ctx.getStart()), "unKnown compound statement item");
    }

    @Override
    public Node visitWhileStatement(MxStarParser.WhileStatementContext ctx) {
        Node judgeExpr, stmt;
        judgeExpr = visit(ctx.expression());
        stmt = visit(ctx.statement());

        return new WhileStmtNode((ExprNode) judgeExpr, (StmtNode) stmt, new Location(ctx.getStart()));
    }

    @Override
    public Node visitForStatement(MxStarParser.ForStatementContext ctx) {
        ExprNode expr1 = null, expr2 = null, expr3 = null;
        StmtNode stmt = (StmtNode) visit(ctx.statement());
        if (ctx.forCondition().exp1 != null)
            expr1 = (ExprNode) visit(ctx.forCondition().exp1);
        if (ctx.forCondition().exp2 != null)
            expr2 = (ExprNode) visit(ctx.forCondition().exp2);
        if (ctx.forCondition().exp3 != null)
            expr3 = (ExprNode) visit(ctx.forCondition().exp3);
        return new ForStmtNode(expr1, expr2, expr3, stmt, new Location(ctx.getStart()));
    }

    @Override
    public Node visitExpressionStatement(MxStarParser.ExpressionStatementContext ctx) {
        if (ctx.expression() != null)
            return new ExprStmtNode((ExprNode) visit(ctx.expression()), new Location(ctx.getStart()));
        else
            return new BlankStmtNode(new Location(ctx.getStart()));
    }

    @Override
    public Node visitSelectionStatement(MxStarParser.SelectionStatementContext ctx) {
        ExprNode judgeExpr;
        StmtNode thenStmt, elseStmt = null;
        judgeExpr = (ExprNode) visit(ctx.expression());
        thenStmt = (StmtNode) visit(ctx.thenStmt);
        if (ctx.elseStmt != null)
            elseStmt = (StmtNode) visit(ctx.elseStmt);

        return new IfStmtNode(judgeExpr, thenStmt, elseStmt, new Location(ctx.getStart()));
    }

    @Override
    public Node visitBreakStmt(MxStarParser.BreakStmtContext ctx) {
        return new BreakStmtNode(new Location(ctx.getStart()));
    }

    @Override
    public Node visitContinueStmt(MxStarParser.ContinueStmtContext ctx) {
        return  new ContinueStmtNode(new Location(ctx.getStart()));
    }

    @Override
    public Node visitReutrnStmt(MxStarParser.ReutrnStmtContext ctx) {
        return new ReturnStmtNode(new Location(ctx.getStart()));
    }

    @Override
    public Node visitThisExpr(MxStarParser.ThisExprContext ctx) {
        return new ThisExprNode(new Location(ctx.getStart()));
    }

    @Override
    public Node visitIdentifier(MxStarParser.IdentifierContext ctx) {
        return new IdentExprNode(ctx.getText(), new Location(ctx.getStart()));
    }

    @Override
    public Node visitNullConst(MxStarParser.NullConstContext ctx) {
        return new NullExprNode(new Location(ctx.getStart()));
    }

    @Override
    public Node visitIntConst(MxStarParser.IntConstContext ctx) {
        return new IntConstExprNode(Integer.parseInt(ctx.getText()),new Location(ctx.getStart()));
    }

    @Override
    public Node visitBoolConst(MxStarParser.BoolConstContext ctx) {
        BoolConstExprNode.BoolValue value;
        switch (ctx.getText()){
            case "true":    value = BoolConstExprNode.BoolValue.TRUE; break;
            case "false":   value = BoolConstExprNode.BoolValue.FALSE; break;
            default: throw new ComplierError(new Location(ctx.getStart()), "Invalid boolean constant");
        }

        return new BoolConstExprNode(value, new Location(ctx.getStart()));
    }

    @Override
    public Node visitConstantExpr(MxStarParser.ConstantExprContext ctx) {
        return visit(ctx.constant());
    }

    @Override
    public Node visitSubExpr(MxStarParser.SubExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Node visitArrayCallExpr(MxStarParser.ArrayCallExprContext ctx) {
        Node baseExpr, subscriptExpr;
        baseExpr = visit(ctx.primaryExpression());
        subscriptExpr = visit(ctx.expression());

        return new ArrCallExprNode((ExprNode) baseExpr, (ExprNode) subscriptExpr, new Location(ctx.getStart()));
    }

    @Override
    public Node visitFunctionCallExpr(MxStarParser.FunctionCallExprContext ctx) {
        Node baseExpr;
        List<ExprNode> argumentList = new ArrayList<>();
        baseExpr = visit(ctx.primaryExpression());
        if (ctx.argumentExpressionList() != null){
            for (ParserRuleContext arug : ctx.argumentExpressionList().expression())
                argumentList.add((ExprNode) visit(arug));
        }

        return new FuncCallExprNode((ExprNode) baseExpr, argumentList, new Location(ctx.getStart()));
    }

    @Override
    public Node visitMemberCallExpr(MxStarParser.MemberCallExprContext ctx) {
        Node baseExpr, identifier;
        baseExpr = visit(ctx.primaryExpression());
        identifier = visit(ctx.bracketIdentifier());
        if (baseExpr instanceof ConstExprNode)
            throw new ComplierError(new Location(ctx.getStart()), "Invalid member call");

        return new MemberCallExprNode((ExprNode) baseExpr, (IdentExprNode) identifier, new Location(ctx.getStart()));
    }

    @Override
    public Node visitBracketIdentifier(MxStarParser.BracketIdentifierContext ctx) {
        return visit(ctx.identifier());
    }

    @Override
    public Node visitStringConst(MxStarParser.StringConstContext ctx) {
        String str = ctx.getText();
        str = str.substring(1, str.length() - 2);
        return new StringConstExprNode(str,new Location(ctx.getStart()));
    }

    @Override
    public Node visitIdentifierExpr(MxStarParser.IdentifierExprContext ctx) {
        return visit(ctx.identifier());
    }

    @Override
    public Node visitSuffixIncDec(MxStarParser.SuffixIncDecContext ctx) {
        Node subExpr;
        SuffixExprNode.SuffixOp op;
        switch (ctx.op.getText()){
            case "++":  op = SuffixExprNode.SuffixOp.SUFFIX_INC; break;
            case "--":  op = SuffixExprNode.SuffixOp.SUFFIX_DEC; break;
            default:    throw new ComplierError(new Location(ctx.getStart()), "Invalid Suffix Operator");
        }
        subExpr = visit(ctx.expression());

        return new SuffixExprNode((ExprNode) subExpr, op, new Location(ctx.getStart()));
    }

    @Override
    public Node visitPrefixExpr(MxStarParser.PrefixExprContext ctx) {
        Node subExpr;
        PrefixExprNode.PrefixOp op;

        switch (ctx.op.getText()){
            case "++":  op = PrefixExprNode.PrefixOp.PREFIX_INC; break;
            case "--":  op = PrefixExprNode.PrefixOp.PREFIX_DEC; break;
            case "+":   op = PrefixExprNode.PrefixOp.PLUS; break;
            case "-":   op = PrefixExprNode.PrefixOp.MINUS; break;
            case "!":   op = PrefixExprNode.PrefixOp.NOT; break;
            case "~":   op = PrefixExprNode.PrefixOp.INV; break;
            default: throw new ComplierError(new Location(ctx.getStart()), "Invalid prefix operator");
        }
        subExpr = visit(ctx.expression());

        return new PrefixExprNode((ExprNode) subExpr, op, new Location(ctx.getStart()));
    }

    @Override
    public Node visitNewExpr(MxStarParser.NewExprContext ctx) {
        return visit(ctx.newExpression());
    }

    @Override
    public Node visitBinaryExpr(MxStarParser.BinaryExprContext ctx) {
        BinaryExprNode.Op op;
        Node leftExpr = visit(ctx.exp1), rightExpr = visit(ctx.exp2);
        switch (ctx.op.getText()){
            case "*":   op = BinaryExprNode.Op.MUL; break;
            case "/":   op = BinaryExprNode.Op.DIV; break;
            case "%":   op = BinaryExprNode.Op.MOD; break;
            case "+":   op = BinaryExprNode.Op.PLUS; break;
            case "-":   op = BinaryExprNode.Op.MINUS; break;
            case "<<":  op = BinaryExprNode.Op.LSH; break;
            case ">>":  op = BinaryExprNode.Op.RSH; break;
            case ">":   op = BinaryExprNode.Op.LESS; break;
            case "<":   op = BinaryExprNode.Op.LARGE; break;
            case ">=":  op = BinaryExprNode.Op.LESS_EQUAL; break;
            case "<=":  op = BinaryExprNode.Op.LARGE_EQUAL; break;
            case "==":  op = BinaryExprNode.Op.EQUAL; break;
            case "!=":  op = BinaryExprNode.Op.UNEQUAL; break;
            case "&":   op = BinaryExprNode.Op.AND; break;
            case "^":   op = BinaryExprNode.Op.OR; break;
            case "|":   op = BinaryExprNode.Op.XOR; break;
            case "&&":  op = BinaryExprNode.Op.ANDAND; break;
            case "||":  op = BinaryExprNode.Op.OROR; break;
            default: throw new ComplierError(new Location(ctx.getStart()), "Invalid binary operator");
        }
        return new BinaryExprNode((ExprNode) leftExpr, (ExprNode) rightExpr, op, new Location(ctx.getStart()));
    }

    @Override
    public Node visitAssignExpr(MxStarParser.AssignExprContext ctx) {
        Node leftExpr, rightExpr;
        leftExpr = visit(ctx.primaryExpression());
        rightExpr = visit(ctx.expression());
        if (leftExpr instanceof ConstExprNode)
            throw new ComplierError(new Location(ctx.getStart()), "Invalid left value of assign");

        return new AssignExprNode((ExprNode)leftExpr, (ExprNode)rightExpr, new Location(ctx.getStart()));
    }

    @Override
    public Node visitPrimaryExpr(MxStarParser.PrimaryExprContext ctx) {
        return visit(ctx.primaryExpression());
    }

    @Override
    public Node visitNewExpression(MxStarParser.NewExpressionContext ctx) {
        Node newType;
        List<ExprNode> dims = new ArrayList<>();
        int order = 0;
        newType = visit(ctx.baseType());

        if (ctx.expression() != null){
            Type type = ((TypeNode)newType).getType();
            for (ParserRuleContext dim : ctx.expression()){
                type = new ArrayType(type);
                dims.add((ExprNode) visit(dim));
                order++;
            }
            newType = new TypeNode(type, newType.getLocation());
            order = (ctx.getChildCount() - (2 + order)) / 2;
        }

        return new NewExprNode((TypeNode) newType, dims, order, new Location(ctx.getStart()));
    }
}
