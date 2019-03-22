package com.mxcomplier.AST;

public class NullExprNode extends ExprNode {
    static private NullExprNode instance = new NullExprNode();

    private NullExprNode(){}

    public static NullExprNode getInstance() {
        return instance;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
