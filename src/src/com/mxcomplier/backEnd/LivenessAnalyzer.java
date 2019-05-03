package com.mxcomplier.backEnd;

import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.InstIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LivenessAnalyzer {

    private HashMap<BasicBlockIR, HashSet<VirtualRegisterIR>> liveOut = new HashMap<>();
    private HashMap<BasicBlockIR, HashSet<VirtualRegisterIR>> usedVregs = new HashMap<>();
    private HashMap<BasicBlockIR, HashSet<VirtualRegisterIR>> definedVregs = new HashMap<>();

    LivenessAnalyzer(){

    }


    void buildGraph(FuncIR func, Graph graph){
        graph.clear();
        liveOut.clear();
        usedVregs.clear();
        definedVregs.clear();
        //get usedVregs & definedVregs
        for (BasicBlockIR bb : func.getBBList()){
            HashSet<VirtualRegisterIR> bbUsed = new HashSet<>();
            HashSet<VirtualRegisterIR> bbDefined = new HashSet<>();
            liveOut.put(bb, new HashSet<>());
            usedVregs.put(bb, bbUsed);
            definedVregs.put(bb, bbDefined);
            for(InstIR inst = bb.getHead().next; inst != bb.getTail(); inst = inst.next){
                List<VirtualRegisterIR> used = inst.getUsedVReg(), defined = inst.getDefinedVreg();
                for (VirtualRegisterIR vreg : used)
                    if (!bbDefined.contains(vreg))
                        bbUsed.add(vreg);
                bbDefined.addAll(defined);
                for (VirtualRegisterIR vreg: used)
                    graph.addPoint(vreg);
                for (VirtualRegisterIR vreg: defined)
                    graph.addPoint(vreg);
            }
        }
        //get liveOut
        boolean changed = true;
        while(changed){
            changed = false;
            for (BasicBlockIR bb : func.getBBList()){
                int oldSize = liveOut.get(bb).size();
                HashSet<VirtualRegisterIR> curLiveOut = new HashSet<>();
                for (BasicBlockIR nextBB: bb.successors){
                    HashSet<VirtualRegisterIR> tempVregs = new HashSet<>(liveOut.get(nextBB));
                    tempVregs.removeAll(definedVregs.get(nextBB));
                    tempVregs.addAll(usedVregs.get(nextBB));
                    curLiveOut.addAll(tempVregs);
                }
                liveOut.put(bb, curLiveOut);
                changed = changed || oldSize != curLiveOut.size();
            }
        }

        for (BasicBlockIR bb : func.getBBList()) {
            HashSet<VirtualRegisterIR> liveNow = liveOut.get(bb);
            for(InstIR inst = bb.getHead().next; inst != bb.getTail(); inst = inst.next) {
                List<VirtualRegisterIR> used = inst.getUsedVReg(), defined = inst.getDefinedVreg();
                graph.addEdges(new HashSet<>(defined), liveNow);
                liveNow.removeAll(defined);
                liveNow.addAll(used);
            }
        }

    }


    void run(FuncIR func, Graph interferenceGraph){
        buildGraph(func, interferenceGraph);
    }


}
