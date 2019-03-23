package com.mxcomplier.AST;

import java.util.List;

public class CompStmtNode extends StmtNode {
    private List<StmtNode> stmtlist;

    public CompStmtNode(List<StmtNode> stmtlist, Location location){
        this.stmtlist = stmtlist;
        this.location = location;
    }

    public List<StmtNode> getStmtlist() {
        return stmtlist;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
