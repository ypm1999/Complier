package com.mxcomplier.Scope;

import com.mxcomplier.AST.FuncDefNode;
import com.mxcomplier.Type.FuncType;

public class FuncSymbol extends Symbol{
    private FuncDefNode node;

    public FuncSymbol(String name, FuncDefNode node){
        super(name, new FuncType(name));
        this.node = node;
    }

    public FuncDefNode getNode() {
        return node;
    }

    public Scope getScope(){
        return node.getScope();
    }
}
