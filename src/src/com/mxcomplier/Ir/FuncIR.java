package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Operands.RegisterIR;

import java.util.ArrayList;
import java.util.List;

public class FuncIR {
    private String name;
    public BasicBlockIR entryBB, leaveBB;
    private List<BasicBlockIR> BBList = new ArrayList<>();
    private List<FuncIR> callee = new ArrayList<>();
    private List<RegisterIR> parameters = new ArrayList<>();

    public FuncIR(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public List<BasicBlockIR> getBBList() {
        return BBList;
    }

    public List<FuncIR> getCallee() {
        return callee;
    }

    public void addPara(RegisterIR reg){
        parameters.add(reg);
    }

    public List<RegisterIR> getParameters() {
        return parameters;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
