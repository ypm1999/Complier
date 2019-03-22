package com.mxcomplier.AST;

public class AssignExprNode extends ExprNode {
    private ExprNode leftExpr, rightExpr;

    public AssignExprNode(ExprNode leftExpr, ExprNode rightExpr, Location location){
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
        this.location = location;
    }

    public Node getLeftExpr() {
        return leftExpr;
    }

    public Node getRightExpr() {
        return rightExpr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
