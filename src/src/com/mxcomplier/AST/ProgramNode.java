package com.mxcomplier.AST;

import java.util.List;

public class ProgramNode extends Node {
    private List<ClassDefNode> classDefs;
    private List<FuncDefNode> funcDefs;
    private List<VarDefNode> varDefs;

    public ProgramNode(List<ClassDefNode> classDefs,
                List<FuncDefNode> funcDefs,
                List<VarDefNode> varDefs,
                Location location){
        this.classDefs = classDefs;
        this.funcDefs = funcDefs;
        this.varDefs = varDefs;
        this.location = location;
    }

    public List<ClassDefNode> getClassDefs() {
        return classDefs;
    }

    public List<FuncDefNode> getFuncDefs() {
        return funcDefs;
    }

    public List<VarDefNode> getVarDefs() {
        return varDefs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
