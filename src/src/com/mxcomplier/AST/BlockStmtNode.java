package com.mxcomplier.AST;

public class BlockStmtNode extends StmtNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
