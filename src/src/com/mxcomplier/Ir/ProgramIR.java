package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Operands.StaticDataIR;

import java.util.List;

public class ProgramIR {
    private List<FuncIR> funcs;
    private FuncIR mainFunc;
    public List<StaticDataIR> staticData;

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
