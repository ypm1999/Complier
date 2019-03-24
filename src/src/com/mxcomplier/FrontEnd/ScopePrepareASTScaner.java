package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Scope.ClassSymbol;
import com.mxcomplier.Scope.FuncSymbol;
import com.mxcomplier.Scope.Scope;
import com.mxcomplier.Scope.Symbol;

public class ScopePrepareASTScaner extends ASTScaner{


    private void addBuildInFunc(){

    }

    private void prepareGlobalScope(){
    }

    @Override
    public void visit(ProgramNode node) {
        currentScope = new Scope(null);
        prepareGlobalScope();
        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);
        for (ClassDefNode clas: node.getClassDefs())
            clas.accept(this);
        node.setScope(currentScope);
    }

    @Override
    public void visit(FuncDefNode node) {
        Symbol symbol = new FuncSymbol(node.getName(), node);
        currentScope.put(node.getName(), symbol, node.getLocation());

        node.setScope(new Scope(currentScope));
    }

    @Override
    public void visit(ClassDefNode node) {
        Symbol symbol = new ClassSymbol(node.getName(), node);
        currentScope.put(node.getName(), symbol, node.getLocation());
        Scope lastScope = currentScope;
        currentScope = new Scope(currentScope);

        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);

        node.setScope(currentScope);
        currentScope = lastScope;
    }
}
