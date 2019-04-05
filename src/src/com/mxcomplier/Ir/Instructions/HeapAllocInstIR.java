package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.IRVisitor;
import com.mxcomplier.Ir.Operands.RegisterIR;

public class HeapAllocInstIR extends InstIR {
    private RegisterIR dest;


    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
