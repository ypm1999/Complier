package com.mxcomplier.AST;

public class VarDefNode extends Node {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
