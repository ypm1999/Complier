package com.mxcomplier.AST;

import java.util.List;

public class BlockStmtNode extends StmtNode {
    private List<Node> stmtlist;



    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
