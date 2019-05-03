package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.IRVisitor;
import com.mxcomplier.Ir.Operands.OperandIR;
import com.mxcomplier.Ir.Operands.PhysicalRegisterIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;

import java.util.List;

public class PushInstIR extends InstIR {

    private OperandIR src;
    public PushInstIR(OperandIR reg){
        this.src = reg;
    }

    public OperandIR getSrc() {
        return src;
    }

    public void setSrc(OperandIR src) {
        this.src = src;
    }

    @Override
    public List<VirtualRegisterIR> getUsedVReg() {
        return getVreg(src);
    }

    @Override
    public String toString() {
        return "push " + src;
    }

    public String nasmString(){
        return toString();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
