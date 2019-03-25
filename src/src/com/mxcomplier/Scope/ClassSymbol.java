package com.mxcomplier.Scope;

import com.mxcomplier.AST.ClassDefNode;
import com.mxcomplier.Type.ClassType;
import com.mxcomplier.Type.Type;

public class ClassSymbol extends Symbol{
    private ClassDefNode node;
    public ClassSymbol(String name, ClassDefNode node){
        super(name, new ClassType(name));
        this.node = node;
    }

    public ClassSymbol(String name){
        super(name, new ClassType(name));
        this.node = null;
    }

    public ClassDefNode getNode() {
        return node;
    }

    public Scope getScope(){
        return node.getScope();
    }
}
