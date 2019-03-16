package com.mxcomplier.AST;

public class ClassDefNode extends Node {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
