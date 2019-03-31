package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Instructions.InstIR;

import java.util.List;

public class BasicBlockIR {
    private String msg; //for Debug
    private FuncIR func;
    private InstIR head, tail;
//    public List<BasicBlockIR> fronters;
//    public List<BasicBlockIR> successors;

    public BasicBlockIR(FuncIR func){
        this.msg = "";
        this.func = func;
        this.head = this.tail = null;
    }

    public BasicBlockIR(FuncIR func, String msg){
        this.msg = msg;
        this.func = func;
        this.head = this.tail = null;
    }

    public void append(InstIR inst){
        if (head == null){
            inst.prev = inst.next = null;
            head = tail = inst;
        }
        else
            tail.append(inst);
    }

    public FuncIR getFunc() {
        return func;
    }

    public InstIR getHead() {
        return head;
    }

    public InstIR getTail() {
        return tail;
    }

    public String getMsg() {
        return msg;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
