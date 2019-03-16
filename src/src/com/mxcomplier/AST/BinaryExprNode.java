package com.mxcomplier.AST;

public class BinaryExprNode extends ExprNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
