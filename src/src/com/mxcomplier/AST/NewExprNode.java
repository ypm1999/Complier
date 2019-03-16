package com.mxcomplier.AST;

public class NewExprNode extends ExprNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
