package com.mxcomplier.AST;

public class MemberCallExprNode extends ExprNode {

    private ExprNode baseExpr;
    private IdentExprNode identifier;

    public MemberCallExprNode(ExprNode baseExpr, IdentExprNode identifier, Location location) {
        this.baseExpr = baseExpr;
        this.identifier = identifier;
        this.location = location;
    }

    public ExprNode getBaseExpr() {
        return baseExpr;
    }

    public IdentExprNode getIdentifier() {
        return identifier;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
