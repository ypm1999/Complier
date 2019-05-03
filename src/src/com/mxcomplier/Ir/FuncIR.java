package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Instructions.CJumpInstIR;
import com.mxcomplier.Ir.Instructions.InstIR;
import com.mxcomplier.Ir.Instructions.JumpInstIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FuncIR {
    public enum Type{
        EXTRA, LIBRARY, USER
    }
    private String name;
    private Type type;
    public BasicBlockIR entryBB, leaveBB;
    public HashSet<VirtualRegisterIR> usedGlobalVar = new HashSet<>();
    private List<BasicBlockIR> BBList = new ArrayList<>();
    private List<BasicBlockIR> orderedBBList, reversedOrderedBBList;
    private List<FuncIR> callee = new ArrayList<>();
    private List<VirtualRegisterIR> parameters = new ArrayList<>();

    public FuncIR(String name){
        this.name = name;
        this.type = Type.USER;
    }

    public FuncIR(String name, Type type){
        this.name = name;
        this.type = type;
    }

    static private HashSet<BasicBlockIR> accessed = new HashSet<>();
    private void dfsBB(BasicBlockIR now, BasicBlockIR fa){
        if (fa != null) {
            now.addFronter(fa);
            fa.addSuccessor(now);
        }
        if (accessed.contains(now))
            return;
        accessed.add(now);
        InstIR inst = now.getTail().prev;
        if (inst instanceof JumpInstIR)
            dfsBB(((JumpInstIR) inst).getTarget(), now);
        if (inst instanceof CJumpInstIR){
            dfsBB(((CJumpInstIR) inst).getTrueBB(), now);
            dfsBB(((CJumpInstIR) inst).getFalseBB(), now);
        }
    }

    public void initOrderBBList(){
        accessed.clear();
        dfsBB(entryBB, null);

        orderedBBList = new ArrayList<>();
        orderedBBList.add(entryBB);
        for(BasicBlockIR bb:orderedBBList)
            orderedBBList.addAll(bb.successors);
        reversedOrderedBBList = new ArrayList<>(orderedBBList);
        Collections.reverse(reversedOrderedBBList);
    }

    public List<BasicBlockIR> getReversedOrderedBBList() {
        return reversedOrderedBBList;
    }

    public List<BasicBlockIR> getOrderedBBList() {
        return orderedBBList;
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

    public Type getType() {
        return type;
    }

    public List<VirtualRegisterIR> getParameters() {
        return parameters;
    }


    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
