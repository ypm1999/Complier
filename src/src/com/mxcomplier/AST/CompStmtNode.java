package com.mxcomplier.AST;

import com.mxcomplier.Scope.Scope;

import java.util.List;

public class CompStmtNode extends StmtNode {
    private List<StmtNode> stmtlist;
    private Scope scope = new Scope();

    public CompStmtNode(List<StmtNode> stmtlist, Location location){
        this.stmtlist = stmtlist;
        this.location = location;
    }

    public List<StmtNode> getStmtlist() {
        return stmtlist;
    }

    public Scope getScope() {
        return scope;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
