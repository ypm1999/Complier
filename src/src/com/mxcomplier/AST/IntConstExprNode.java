package com.mxcomplier.AST;

public class IntConstExprNode extends ExprNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
