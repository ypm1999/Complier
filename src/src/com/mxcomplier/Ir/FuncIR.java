package com.mxcomplier.Ir;

import java.util.List;

public class FuncIR {
    private String msg; //for Debug
    private String name;
    private List<BasicBlockIR> BBList;
    private List<FuncIR> callee;

    public FuncIR(String name, List<BasicBlockIR> BBList, List<FuncIR> callee){
        this.msg = "";
        this.name = name;
        this.BBList = BBList;
        this.callee = callee;
    }

    public FuncIR(String name, List<BasicBlockIR> BBList, List<FuncIR> callee, String msg){
        this.msg = msg;
        this.name = name;
        this.BBList = BBList;
        this.callee = callee;
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

    public String getMsg() {
        return msg;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
