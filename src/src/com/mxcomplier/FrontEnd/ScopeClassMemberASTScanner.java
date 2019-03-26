package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Scope.FuncSymbol;
import com.mxcomplier.Scope.Symbol;
import com.mxcomplier.Scope.VarSymbol;
import com.mxcomplier.Type.ClassType;
import com.mxcomplier.Type.Type;

import java.util.ArrayList;
import java.util.List;

//add class members ans all functions
public class ScopeClassMemberASTScanner extends ASTScanner{

    @Override
    public void visit(ProgramNode node) {
        globalScope = currentScope = node.getScope();

        for (ClassDefNode classes: node.getClassDefs())
            classes.accept(this);
        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);

        globalScope = currentScope = null;
    }

    @Override
    public void visit(ClassDefNode node) {
        currentScope = node.getScope();

        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);
        for (VarDefNode vars : node.getMemberDefs())
            vars.accept(this);

        currentScope = currentScope.getParent();
    }

    @Override
    public void visit(FuncDefNode node) {
        List<Type> args = new ArrayList<>();
        for (VarDefNode arg : node.getParameters()){
            Type type = arg.getType().getType();
            if (type instanceof ClassType)
                type = globalScope.getClass(((ClassType) type).getName(), node.getLocation()).getType();
            args.add(type);
        }
        FuncSymbol symbol = new FuncSymbol(node.getName(), node.getReturnType().getType(), node.getScope(), args);
        currentScope.put(symbol, node.getLocation());
        node.getScope().setParent(currentScope);
    }

    @Override
    public void visit(VarDefNode node) {
        putVar(node);
    }

}
