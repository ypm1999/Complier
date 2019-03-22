package com.mxcomplier.Type;

import com.sun.management.VMOption;

public class VoidType extends Type{
    static private VoidType instance = new VoidType();

    private VoidType(){
        this.hyperType = HyperType.VOID;
    }

    public VoidType getInstance(){
        return instance;
    }
}
