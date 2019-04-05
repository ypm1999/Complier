package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.IRVisitor;

public class JumpInstIR extends InstIR {
    private BasicBlockIR target;

    public JumpInstIR(BasicBlockIR target){
        this.target = target;
    }

    public BasicBlockIR getTarget() {
        return target;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
