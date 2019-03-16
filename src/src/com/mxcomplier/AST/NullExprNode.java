package com.mxcomplier.AST;

public class NullExprNode extends ExprNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
