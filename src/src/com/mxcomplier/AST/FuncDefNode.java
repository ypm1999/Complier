package com.mxcomplier.AST;

import java.util.List;

final public class FuncDefNode extends Node {
    private String name;
    private TypeNode returnType;
    private boolean isConstructor;
    private List<TypeNode> parameters;
    private BlockStmtNode funcBody;

    FuncDefNode(String name, TypeNode returnType, List<TypeNode> parameters, BlockStmtNode funcBody){
        this.name = name;
        this.returnType = returnType;
        this.isConstructor = returnType == null;
        this.parameters = parameters;
        this.funcBody = funcBody;
    }

    public String getName() {
        return name;
    }

    public TypeNode getReturnType() {
        return returnType;
    }

    public boolean getIsConstructor(){
        return isConstructor;
    }

    public List<TypeNode> getParameters() {
        return parameters;
    }

    public BlockStmtNode getFuncBody() {
        return funcBody;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
