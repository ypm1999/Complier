package com.mxcomplier.Ir.Operands;

import com.mxcomplier.Ir.IRVisitor;

public class VirtualRegisterIR extends RegisterIR {
    static private int vRegId = 0;

    private int id;
    public VirtualRegisterIR(){
        this.id = ++vRegId;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
