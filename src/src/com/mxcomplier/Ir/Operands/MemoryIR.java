package com.mxcomplier.Ir.Operands;

import com.mxcomplier.Ir.IRVisitor;

public class MemoryIR extends AddressIR {
    private RegisterIR base = null;
    private RegisterIR offset = null;
    private int indexLeftShift = 0;
    private ConstantIR constant = null;


    public MemoryIR(){}

    public MemoryIR(RegisterIR base){
        this.base = base;
    }

    public MemoryIR(RegisterIR base, RegisterIR offset){
        this.base = base;
        this.offset = offset;
    }

    public MemoryIR(ConstantIR constant){
        this.constant = constant;
    }


    public OperandIR getBase() {
        return base;
    }

    public OperandIR getOffset() {
        return offset;
    }

    public ConstantIR getConstant() {
        return constant;
    }

    public int getIndexLeftShift() {
        return indexLeftShift;
    }

    public void setIndexLeftShift(int indexLeftShift) {
        this.indexLeftShift = indexLeftShift;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
