package com.mxcomplier.AST;

public class ContinueStmtNode extends StmtNode {

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
