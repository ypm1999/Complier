package com.mxcomplier.AST;

public class BlankStmtNode extends StmtNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
