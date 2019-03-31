package com.mxcomplier.Ir.Operands;

import com.mxcomplier.Ir.IRVisitor;

public class ImmediateIR extends ConstantIR {
    private int value;

    public ImmediateIR(int value){
        this.value = value;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
