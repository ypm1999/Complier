package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Scope.Scope;
import com.mxcomplier.Scope.VarSymbol;

public class ScopeClassMemberASTScanner extends ASTScanner{

    @Override
    public void visit(ProgramNode node) {
        currentScope = node.getScope();

        for (ClassDefNode classes: node.getClassDefs())
            classes.accept(this);

        currentScope = currentScope.getParent();
    }

    @Override
    public void visit(FuncDefNode node) {

    }

    @Override
    public void visit(ClassDefNode node) {
        currentScope = node.getScope();

        for (VarDefNode vars : node.getMemberDefs())
            vars.accept(this);

        currentScope = currentScope.getParent();
    }

    @Override
    public void visit(VarDefNode node) {
        currentScope.put(new VarSymbol(node.getName(), node.getType().getType()));
    }

}
