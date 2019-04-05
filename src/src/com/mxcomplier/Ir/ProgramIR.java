package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Operands.StaticDataIR;

import java.util.List;

public class ProgramIR {
    private List<FuncIR> funcs;
    private List<StaticDataIR> staticData;

    public ProgramIR(List<FuncIR> func, List<StaticDataIR> staticData){
        this.funcs = func;
        this.staticData = staticData;
    }

    public List<FuncIR> getFuncs() {
        return funcs;
    }

    public List<StaticDataIR> getStaticData() {
        return staticData;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
