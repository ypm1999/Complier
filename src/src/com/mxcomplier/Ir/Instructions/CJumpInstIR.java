package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.IRVisitor;
import com.mxcomplier.Ir.Operands.AddressIR;
import com.mxcomplier.Ir.Operands.OperandIR;

public class CJumpInstIR extends InstIR {
    public enum Op{
        L, G, LE, GE, EQ, NEQ, ERROR
    }

    private Op op;
    private OperandIR lhs, rhs;
    private BasicBlockIR trueBB, falseBB;

    public CJumpInstIR(Op op, OperandIR lhs, OperandIR rhs, BasicBlockIR trueBB, BasicBlockIR falseBB){
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
        this.trueBB = trueBB;
        this.falseBB = falseBB;
    }

    public Op getOp() {
        return op;
    }

    public OperandIR getLhs() {
        return lhs;
    }

    public OperandIR getRhs() {
        return rhs;
    }

    public BasicBlockIR getTrueBB() {
        return trueBB;
    }

    public BasicBlockIR getFalseBB() {
        return falseBB;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
