package com.mxcomplier.AST;

public class IdentExprNode extends ExprNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
