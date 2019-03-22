package com.mxcomplier.Type;

public class BoolType extends Type{
    static private BoolType instance = new BoolType();

    private BoolType(){
        this.hyperType = HyperType.BOOL;
    }

    public BoolType getInstance(){
        return instance;
    }
}
