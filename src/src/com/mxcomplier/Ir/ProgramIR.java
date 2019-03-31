package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Operands.StaticDataIR;

import java.util.List;

public class ProgramIR {
    private List<BasicBlockIR> BBList;
    private List<FuncIR> funcs;
    private FuncIR mainFunc;
    private List<StaticDataIR> staticData;

}
