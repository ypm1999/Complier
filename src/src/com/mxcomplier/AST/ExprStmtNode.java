package com.mxcomplier.AST;

public class ExprStmtNode extends StmtNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
