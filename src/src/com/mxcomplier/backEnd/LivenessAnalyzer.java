package com.mxcomplier.backEnd;

import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.InstIR;
import com.mxcomplier.Ir.Instructions.MoveInstIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LivenessAnalyzer {

    private HashMap<BasicBlockIR, HashSet<VirtualRegisterIR>> liveOut = new HashMap<>();
    private HashMap<BasicBlockIR, HashSet<VirtualRegisterIR>> usedVregs = new HashMap<>();
    private HashMap<BasicBlockIR, HashSet<VirtualRegisterIR>> definedVregs = new HashMap<>();

    LivenessAnalyzer(){

    }

    Graph buildGraph(FuncIR func, HashSet<MoveInstIR> moveList){
        Graph graph = new Graph();
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
                    graph.addNode(vreg);
                for (VirtualRegisterIR vreg: defined)
                    graph.addNode(vreg);
            }
        }
        //get liveOut
        boolean changed = true;
        while(changed){
            changed = false;
            for (BasicBlockIR bb : func.getReversedOrderedBBList()){
                int oldSize = liveOut.get(bb).size();
                HashSet<VirtualRegisterIR> curLiveOut = new HashSet<>();
                for (BasicBlockIR nextBB: bb.successors){
                    HashSet<VirtualRegisterIR> tempVregs = new HashSet<>(liveOut.get(nextBB));
                    tempVregs.removeAll(definedVregs.get(nextBB));
                    tempVregs.addAll(usedVregs.get(nextBB));
                    curLiveOut.addAll(tempVregs);
                }
                liveOut.remove(bb);
                liveOut.put(bb, curLiveOut);
                changed = changed || oldSize != curLiveOut.size();
            }
        }

        for (BasicBlockIR bb : func.getBBList()) {
            HashSet<VirtualRegisterIR> liveNow = liveOut.get(bb);
            for(InstIR inst = bb.getTail().prev; inst != bb.getHead(); inst = inst.prev) {
                List<VirtualRegisterIR> used = inst.getUsedVReg(), defined = inst.getDefinedVreg();
                if (inst instanceof MoveInstIR){
                    MoveInstIR moveInst = (MoveInstIR) inst;
                    if (moveInst.dest instanceof VirtualRegisterIR && moveInst.src instanceof VirtualRegisterIR) {
                        VirtualRegisterIR dest = (VirtualRegisterIR) moveInst.dest;
                        VirtualRegisterIR src = (VirtualRegisterIR) moveInst.src;
                        if (dest.getPhyReg() == null || src.getPhyReg() == null) {
                            liveNow.removeAll(used);
                            addMoveList(dest, moveInst);
                            addMoveList(src, moveInst);
                            moveList.add(moveInst);
                        }
                    }
                }
                graph.addEdges(new HashSet<>(defined), liveNow);
                liveNow.removeAll(defined);
                liveNow.addAll(used);

            }
        }
        return graph;
    }

    private void addMoveList(VirtualRegisterIR vreg, MoveInstIR inst){
        vreg.moveList.add(inst);
    }

//
//    void run(FuncIR func){
//        Graph interferenceGraph = new Graph();
//        buildGraph(func, interferenceGraph);
//    }


}
