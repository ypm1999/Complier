package com.mxcomplier.Ir.Operands;

import com.mxcomplier.Ir.IRVisitor;

public class ImmediateIR extends ConstantIR {
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
