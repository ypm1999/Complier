package com.mxcomplier.AST;

public class TypeNode extends Node {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
