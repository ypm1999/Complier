package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.IRVisitor;
import com.mxcomplier.Ir.Operands.AddressIR;
import com.mxcomplier.Ir.Operands.OperandIR;
import com.mxcomplier.Ir.Operands.StackSoltIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;

import java.util.ArrayList;
import java.util.List;

public class MoveInstIR extends InstIR {
    public AddressIR dest;
    public OperandIR src;

    public MoveInstIR(AddressIR dest, OperandIR src){
        this.dest = dest;
        this.src = src;
    }

    public AddressIR getDest() {
        return dest;
    }

    public OperandIR getSrc() {
        return src;
    }

    public void setSrc(OperandIR src) {
        this.src = src;
    }

    @Override
    public List<StackSoltIR> getStackSolt() {
        List<StackSoltIR> res = new ArrayList<>();
        if (dest instanceof StackSoltIR)
            res.add((StackSoltIR) dest);
        if (src instanceof StackSoltIR)
            res.add((StackSoltIR) src);
        return res;
    }

    @Override
    public List<VirtualRegisterIR> getUsedVReg() {
        List<VirtualRegisterIR> regs = getVreg(dest);
        regs.addAll(getVreg(src));
        return regs;
    }

    @Override
    public List<VirtualRegisterIR> getDefinedVreg() {
        return getVreg(dest);
    }

    @Override
    public String toString() {
        return String.format("mov %s %s", dest, src);
    }

    public String nasmString() {
        return String.format("mov %s, %s", dest, src);
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
