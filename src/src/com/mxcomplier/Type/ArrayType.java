package com.mxcomplier.Type;

import com.mxcomplier.Config;

public class ArrayType extends Type{
    private String name;

    private ArrayType(String name){
        this.name = name;
        this.hyperType = HyperType.ARRAY;
        this.varSize = Config.getREGSIZE();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayType)
            return name.equals(((ArrayType) obj).name);
        else
            return false;
    }

    @Override
    public String toString() {
        return String.format("ArrayType(%s)", name.toString());
    }
}
