package com.mxcomplier.AST;

import java.util.List;

public class ClassDefNode extends Node {
    private String name;
    private List<VarDefNode> memberdefs;
    private List<FuncDefNode> funcdefs;

    public ClassDefNode(String name,
                        List<VarDefNode> memberdefs,
                        List<FuncDefNode> funcdefs,
                        Location location)
    {
        this.name = name;
        this.memberdefs = memberdefs;
        this.funcdefs = funcdefs;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public List<VarDefNode> getMemberdefs() {
        return memberdefs;
    }

    public List<FuncDefNode> getFuncdefs() {
        return funcdefs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
