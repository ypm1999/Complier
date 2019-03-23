package com.mxcomplier.AST;

public class VarDefNode extends Node {

    private TypeNode type;
    private String name;
    private ExprNode initExpr;

    public VarDefNode(TypeNode type, String name, ExprNode initExpr, Location location) {
        this.type = type;
        this.name = name;
        this.initExpr = initExpr;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public ExprNode getInitExpr() {
        return initExpr;
    }

    public TypeNode getType() {
        return type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}