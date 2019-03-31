package com.mxcomplier.Ir.Operands;

import com.mxcomplier.Ir.IRVisitor;

public class MemoryIR extends AddressIR {
    private RegisterIR size = null;
    private RegisterIR offset = null;
    private ConstantIR constant = null;


    public MemoryIR(){}

    public MemoryIR(RegisterIR size){
        this.size = size;
    }

    public MemoryIR(RegisterIR size, RegisterIR offset){
        this.size = size;
        this.offset = offset;
    }

    public MemoryIR(ConstantIR constant){
        this.constant = constant;
    }


    public RegisterIR getSize() {
        return size;
    }

    public RegisterIR getOffset() {
        return offset;
    }

    public ConstantIR getConstant() {
        return constant;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
