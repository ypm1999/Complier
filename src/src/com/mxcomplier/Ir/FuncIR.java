package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Instructions.CJumpInstIR;
import com.mxcomplier.Ir.Instructions.CallInstIR;
import com.mxcomplier.Ir.Instructions.InstIR;
import com.mxcomplier.Ir.Instructions.JumpInstIR;
import com.mxcomplier.Ir.Operands.AddressIR;
import com.mxcomplier.Ir.Operands.OperandIR;
import com.mxcomplier.Ir.Operands.PhysicalRegisterIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FuncIR {
    public enum Type{
        EXTRA, LIBRARY, USER
    }
    private String name;
    private Type type;
    public VirtualRegisterIR returnValue = null;
    public BasicBlockIR entryBB, leaveBB;
    public HashSet<FuncIR> callee = new HashSet<>(), caller = new HashSet<>();
    public HashSet<VirtualRegisterIR> usedGlobalVar = new HashSet<>(), selfUsedGlobalVar;
    public HashSet<VirtualRegisterIR> definedGlobalVar, selfDefinedGlobalVar;
    private HashSet<PhysicalRegisterIR> definedPhyRegs = null, usedPhyRegs = null;

    private List<BasicBlockIR> BBList = new ArrayList<>();
    private List<BasicBlockIR> orderedBBList, reversedOrderedBBList;
    private List<VirtualRegisterIR> parameters = new ArrayList<>();

    public FuncIR(String name){
        this.name = name;
        this.type = Type.USER;
    }

    public FuncIR(String name, Type type){
        this.name = name;
        this.type = type;
    }

    public void initGlobalDefined(){
        HashSet<VirtualRegisterIR> usedVreg = new HashSet<>(), definedVreg = new HashSet<>();
        for (BasicBlockIR bb : BBList){
            for(InstIR inst = bb.getHead().next; inst != bb.getTail(); inst = inst.next){
                if (inst instanceof CallInstIR){
                    for (OperandIR arg : ((CallInstIR) inst).getArgs())
                        usedVreg.addAll(inst.getVreg(arg));
                    if (((CallInstIR) inst).getReturnValue() != null) {
                        AddressIR ret = ((CallInstIR) inst).getReturnValue();
                        if (ret instanceof VirtualRegisterIR)
                            definedVreg.add((VirtualRegisterIR) ret);
                        else
                            usedVreg.addAll(inst.getVreg(ret));
                    }
                    continue;
                }
                usedVreg.addAll(inst.getUsedVReg());
                definedVreg.addAll(inst.getDefinedVreg());
            }
        }

        definedGlobalVar = new HashSet<>(usedGlobalVar);
        usedGlobalVar.retainAll(usedVreg);
        definedGlobalVar.retainAll(definedVreg);

        selfUsedGlobalVar = new HashSet<>(usedGlobalVar);
        selfDefinedGlobalVar = new HashSet<>(definedGlobalVar);
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
        for(InstIR inst = now.getTail().prev; inst != now.getHead(); inst = inst.prev) {
            if (inst instanceof JumpInstIR)
                dfsBB(((JumpInstIR) inst).getTarget(), now);
            if (inst instanceof CJumpInstIR) {
                dfsBB(((CJumpInstIR) inst).getTrueBB(), now);
//                dfsBB(((CJumpInstIR) inst).getFalseBB(), now);
            }
        }
        reversedOrderedBBList.add(now);
    }

    public void initOrderBBList(){
        for (BasicBlockIR bb:BBList)
            bb.initFrontAndSucc();
        accessed.clear();
        reversedOrderedBBList = new ArrayList<>();
        dfsBB(entryBB, null);
        List<BasicBlockIR> tempBBList = new ArrayList<>(BBList);
        for (BasicBlockIR bb:tempBBList){
            if (!accessed.contains(bb))
                BBList.remove(bb);
        }
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

    public Type getType() {
        return type;
    }

    public List<VirtualRegisterIR> getParameters() {
        return parameters;
    }

    public HashSet<PhysicalRegisterIR> getDefinedPhyRegs(){
        if (definedPhyRegs == null){
            definedPhyRegs = new HashSet<>();
            if (type == Type.LIBRARY)
                definedPhyRegs.addAll(RegisterSet.allocatePhyRegisterSet);
            else {
                for (BasicBlockIR bb : BBList) {
                    for (InstIR inst = bb.getHead().next; inst != bb.getTail(); inst = inst.next) {
                        for (VirtualRegisterIR vreg : inst.getDefinedVreg())
                            definedPhyRegs.add(vreg.getPhyReg());
                    }
                }
            }
        }
        return definedPhyRegs;
    }

    public HashSet<PhysicalRegisterIR> getUsedPhyRegs() {
        if (usedPhyRegs == null){
            usedPhyRegs = new HashSet<>();
            if (type == Type.LIBRARY)
                usedPhyRegs.addAll(RegisterSet.allocatePhyRegisterSet);
            else
                for (BasicBlockIR bb:BBList){
                    for(InstIR inst = bb.getHead().next; inst != bb.getTail(); inst = inst.next){
                        for (VirtualRegisterIR vreg: inst.getUsedVReg())
                            usedPhyRegs.add(vreg.getPhyReg());
                    }
                }
        }
        return usedPhyRegs;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
