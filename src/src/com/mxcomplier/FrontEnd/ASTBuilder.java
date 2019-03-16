package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.LaxerParser.MxStarBaseVisitor;
import com.mxcomplier.LaxerParser.MxStarParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

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


        return new FuncDefNode();
    }

    @Override
    public Node visitClassDefinition(MxStarParser.ClassDefinitionContext ctx) {

        return new ClassDefNode();
    }


    @Override
    public Node visitDeclarationStatement(MxStarParser.DeclarationStatementContext ctx) {

        return Node
    }
}
