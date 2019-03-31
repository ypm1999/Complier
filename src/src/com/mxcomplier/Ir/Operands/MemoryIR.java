package com.mxcomplier.Ir.Operands;

import com.mxcomplier.Ir.IRVisitor;

public class MemoryIR extends AddressIR {
    private int size;
    private int offset;


    public MemoryIR(int size){
        this.size = size;
        this.offset = 0;
    }

    public MemoryIR(int size, int offset){
        this.size = size;
        this.offset = offset;
    }


    public int getSize() {
        return size;
    }

    public int getOffset() {
        return offset;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
