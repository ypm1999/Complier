package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.IRVisitor;
import com.mxcomplier.Ir.Operands.RegisterIR;

public class BinaryInstIR extends InstIR {
    public enum Op{
        ADD, SUB, MUL, DIV, SHL, SHR, AND, OR, XOR
    }

    private Op op;
    private RegisterIR dest;
    private RegisterIR lhs, rhs;

    public BinaryInstIR(Op op, RegisterIR dest, RegisterIR lhs, RegisterIR rhs){
        this.op = op;
        this.dest = dest;
        this.lhs = lhs;
        this.rhs = rhs;
    }


    public Op getOp() {
        return op;
    }

    public RegisterIR getLhs() {
        return lhs;
    }

    public RegisterIR getRhs() {
        return rhs;
    }

    public RegisterIR getDest() {
        return dest;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
