package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.IRVisitor;
import com.mxcomplier.Ir.Operands.RegisterIR;

public class ReturnInstIR extends InstIR {
    private RegisterIR dest;

    public ReturnInstIR(RegisterIR dest){
        this.dest = dest;
    }

    public RegisterIR getDest() {
        return dest;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
