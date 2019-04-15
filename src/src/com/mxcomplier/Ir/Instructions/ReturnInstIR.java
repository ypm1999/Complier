package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.IRVisitor;
public class ReturnInstIR extends BranchInstIR {

    @Override
    public String toString() {
        return "leave\nret";
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
