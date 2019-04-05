package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.Operands.AddressIR;

public class UnaryInstIR extends InstIR {
    public enum Op{
        NEG, INV, INC, DEC, NULL, ERROR
    }

    private Op op;
    private AddressIR dest;

    public UnaryInstIR(Op op, AddressIR dest){
        this.op = op;
        this.dest = dest;
    }

    public Op getOp() {
        return op;
    }

    public AddressIR getDest() {
        return dest;
    }

}

