package com.mxcomplier.AST;

import com.mxcomplier.Scope.Scope;

import java.util.List;

public class ClassDefNode extends Node {
    private String name;
    private List<VarDefNode> memberDefs;
    private List<FuncDefNode> funcDefs;
    private Scope scope;

    public ClassDefNode(String name,
                        List<VarDefNode> memberDefs,
                        List<FuncDefNode> funcDefs,
                        Location location) {
        this.name = name;
        this.memberDefs = memberDefs;
        this.funcDefs = funcDefs;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public List<VarDefNode> getMemberDefs() {
        return memberDefs;
    }

    public List<FuncDefNode> getFuncDefs() {
        return funcDefs;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
