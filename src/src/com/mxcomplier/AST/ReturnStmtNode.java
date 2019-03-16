package com.mxcomplier.AST;

public class ReturnStmtNode extends StmtNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
