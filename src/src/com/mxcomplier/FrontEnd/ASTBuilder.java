package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Error.ComplierError;
import com.mxcomplier.LaxerParser.MxStarBaseVisitor;
import com.mxcomplier.LaxerParser.MxStarParser;
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
        String name = ctx.Identifier().getText();
        Node funcbody = visit(ctx.compoundStatement());
        Node returnType = null;
        List<TypeNode> parameters = new ArrayList<>();

        if(ctx.typeOrVoid() != null)
            returnType =  visit(ctx.typeOrVoid());

        for(ParserRuleContext args : ctx.declarationList().declaration()){
            parameters.add((TypeNode) visit(args));
        }

        return new FuncDefNode(name, (TypeNode) returnType, parameters, (BlockStmtNode) funcbody, new Location(ctx.getStart()));
    }

    @Override
    public Node visitClassDefinition(MxStarParser.ClassDefinitionContext ctx) {
        String name = ctx.Identifier().getText();
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
    public Node visitSuffixIncDec(MxStarParser.SuffixIncDecContext ctx) {
        Node subExpr = NullExprNode.getInstance();
        SuffixExprNode.SuffixOp op;
        switch (ctx.op.getText()){
            case "++": op = SuffixExprNode.SuffixOp.SUFFIX_INC; break;
            case "--": op = SuffixExprNode.SuffixOp.SUFFIX_DEC; break;
            default: op = SuffixExprNode.SuffixOp.NULL; break;
        }

        if(ctx.expression() != null)
            subExpr = visit(ctx.expression());

        return new SuffixExprNode((ExprNode) subExpr, op, new Location(ctx.getStart()));
    }

    @Override
    public Node visitPrefixExpr(MxStarParser.PrefixExprContext ctx) {
        Node subExpr = NullExprNode.getInstance();
        PrefixExprNode.PrefixOp op;

        switch (ctx.op.getText()){
            case "++": op = PrefixExprNode.PrefixOp.PREFIX_INC; break;
            case "--": op = PrefixExprNode.PrefixOp.PREFIX_DEC; break;
            case "+": op = PrefixExprNode.PrefixOp.PLUS; break;
            case "-": op = PrefixExprNode.PrefixOp.MINUS; break;
            case "!": op = PrefixExprNode.PrefixOp.NOT; break;
            case "~": op = PrefixExprNode.PrefixOp.INV; break;
            default: op = PrefixExprNode.PrefixOp.NULL; break;
        }

        if(ctx.expression() != null)
            subExpr = visit(ctx.expression());

        return new PrefixExprNode((ExprNode) subExpr, op, new Location(ctx.getStart()));
    }

    @Override
    public Node visitNewExpr(MxStarParser.NewExprContext ctx) {
        return visit(ctx.newExpression());
    }

    @Override
    public Node visitAssignExpr(MxStarParser.AssignExprContext ctx) {
        Node leftExpr = NullExprNode.getInstance(), rightExpr = NullExprNode.getInstance();

        if(ctx.primaryExpression() != null)
            leftExpr = visit(ctx.primaryExpression());
        if(ctx.expression() != null)
            rightExpr = visit(ctx.expression());

        return new AssignExprNode((ExprNode)leftExpr, (ExprNode)rightExpr, new Location(ctx.getStart()));
    }

    @Override
    public Node visitPrimaryExpr(MxStarParser.PrimaryExprContext ctx) {
        return visit(ctx.primaryExpression());
    }

    @Override
    public Node visitNewExpression(MxStarParser.NewExpressionContext ctx) {

    }
}
