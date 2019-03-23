package com.mxcomplier.AST;

public class ReturnStmtNode extends StmtNode {

    public ReturnStmtNode(Location location){
        this.location = location;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
