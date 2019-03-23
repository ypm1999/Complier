package com.mxcomplier.AST;

public class WhileStmtNode extends StmtNode {
    private ExprNode judgeExpr;
    private StmtNode stmt;

    public WhileStmtNode(ExprNode judgeExpr, StmtNode stmt, Location location){
        this.judgeExpr = judgeExpr;
        this.stmt = stmt;
        this.location = location;
    }

    public StmtNode getStmt() {
        return stmt;
    }

    public ExprNode getJudgeExpr() {
        return judgeExpr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
