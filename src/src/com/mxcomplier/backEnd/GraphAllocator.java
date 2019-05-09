package com.mxcomplier.backEnd;

import com.mxcomplier.Config;
import com.mxcomplier.Error.IRError;
import com.mxcomplier.FrontEnd.IRBuilder;
import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.InstIR;
import com.mxcomplier.Ir.Instructions.MoveInstIR;
import com.mxcomplier.Ir.Operands.*;

import java.util.*;

import static com.mxcomplier.Ir.RegisterSet.*;
import static java.lang.Math.min;

public class GraphAllocator{
    private static final int REGNUM = 14;

    private FuncIR curFunc = null;
    private Graph graph, originGraph;
    private List<VirtualRegisterIR> spilledVregs, coalescedNodes;
    private LinkedList<VirtualRegisterIR> finishedStack;
    private HashSet<VirtualRegisterIR> simplifyTODOList, spillTODOList, freezeTODOList;
    private HashSet<MoveInstIR> moveTODOList,  activeMoves;
    private HashMap<VirtualRegisterIR, PhysicalRegisterIR> colorMap;

    private void init(){
        simplifyTODOList = new HashSet<>();
        spillTODOList = new HashSet<>();
        moveTODOList = new HashSet<>();
        freezeTODOList = new HashSet<>();
        activeMoves = new HashSet<>();
        colorMap = new HashMap<>();
        spilledVregs = new ArrayList<>();
        coalescedNodes = new ArrayList<>();
        finishedStack = new LinkedList<>();
    }

    private void makeWorkList(){
        for (VirtualRegisterIR node:graph.getnodes()){
            if (graph.getDegree(node) >= REGNUM)
                spillTODOList.add(node);
            else if (isMoveRelated(node))
                freezeTODOList.add(node);
            else
                simplifyTODOList.add(node);
        }
    }

    private boolean isMoveRelated(VirtualRegisterIR vreg){
        for (MoveInstIR move:vreg.moveList) {
            if (activeMoves.contains(move) || moveTODOList.contains(move))
                return true;
        }
        return false;
    }

    private void enableMove(VirtualRegisterIR vreg){
        for (MoveInstIR move:vreg.moveList) {
            if (activeMoves.contains(move)){
                activeMoves.remove(move);
                moveTODOList.add(move);
            }
        }
    }

    private VirtualRegisterIR getAlias(VirtualRegisterIR vreg){
        if (vreg.alias == vreg)
            return vreg;
        return vreg.alias = getAlias(vreg.alias);
    }

    private void doSimplify(){
        VirtualRegisterIR node = simplifyTODOList.iterator().next();
        simplifyTODOList.remove(node);
        removeNode(node);
        finishedStack.addFirst(node);
    }

    private void doSpill(){
        if (spillTODOList.isEmpty())
            return;
        VirtualRegisterIR spillCandidate = null;
        int maxDegree = -2;
        for (VirtualRegisterIR vreg:spillTODOList){
            if (vreg.getPhyReg() != null)
                continue;

            int curDeegree = graph.getDegree(vreg);
            if (curDeegree > maxDegree){
                maxDegree = curDeegree;
                spillCandidate = vreg;
            }
        }
        if (spillCandidate == null)
            throw new IRError("can't spill");

        spillTODOList.remove(spillCandidate);
        removeNode(spillCandidate);
        finishedStack.addFirst(spillCandidate);
    }

    private boolean OK(VirtualRegisterIR u, VirtualRegisterIR v){
        for (VirtualRegisterIR t : graph.getNeighbor(v)){
            if (!(graph.getDegree(t) < REGNUM || t.getPhyReg() != null || graph.getNeighbor(t).contains(u)))
                return false;
        }
        return  true;
    }

    private boolean conservative(VirtualRegisterIR u, VirtualRegisterIR v){
        HashSet<VirtualRegisterIR> nodes = new HashSet<>(graph.getNeighbor(u));
        nodes.addAll(graph.getNeighbor(v));
        int cnt = 0;
        for (VirtualRegisterIR node : nodes)
            if (graph.getDegree(node) >= REGNUM)
                cnt++;
        return cnt < REGNUM;
    }

    private void addTODOList(VirtualRegisterIR node){
        if (!isMoveRelated(node) && graph.getDegree(node) < REGNUM){
            freezeTODOList.remove(node);
            simplifyTODOList.add(node);
        }
    }

    private void combine(VirtualRegisterIR u, VirtualRegisterIR v){
        coalescedNodes.add(v);
        freezeTODOList.remove(v);
        spillTODOList.remove(v);

        v.alias = u;
        u.moveList.addAll(v.moveList);
        enableMove(v);

        HashSet<VirtualRegisterIR> adjNodes = new HashSet<>(graph.getNeighbor(v));
        for (VirtualRegisterIR node : adjNodes){
            graph.removeEdge(v, node);
            graph.addEdge(u, node);
            originGraph.removeEdge(v, node);
            originGraph.addEdge(u, node);
            if (graph.getDegree(node) >= REGNUM && freezeTODOList.contains(node)){
                freezeTODOList.remove(node);
                spillTODOList.add(node);
            }
        }

        if (graph.getDegree(u) >= REGNUM && freezeTODOList.contains(u)){
            freezeTODOList.remove(u);
            spillTODOList.add(u);
        }
    }

    private void doCoalesce(){
        MoveInstIR move = moveTODOList.iterator().next();
        moveTODOList.remove(move);
        VirtualRegisterIR dest = getAlias((VirtualRegisterIR) move.dest);
        VirtualRegisterIR src = getAlias((VirtualRegisterIR) move.src);
        VirtualRegisterIR u, v;
        if (dest.getPhyReg() != null){
            u = dest;
            v = src;
        }
        else{
            u = src;
            v = dest;
        }

        if (u == v){
            addTODOList(u);
        }
        else if (v.getPhyReg() != null || graph.getNeighbor(u).contains(v)){
            addTODOList(u);
            addTODOList(v);
        }
        else if ((u.getPhyReg() == null && conservative(u, v)) || (u.getPhyReg() != null && OK(u, v))){
            System.err.println(u + "  " + v);
            combine(u, v);
            addTODOList(u);
        }
        else
            activeMoves.add(move);
    }

    private void doFreeze(){
        VirtualRegisterIR node = freezeTODOList.iterator().next();
        freezeTODOList.remove(node);
        simplifyTODOList.add(node);

        for (MoveInstIR move : node.moveList){
            if (activeMoves.contains(move) || moveTODOList.contains(move)) {
                VirtualRegisterIR v;
                if (getAlias((VirtualRegisterIR) move.dest) == getAlias(node))
                    v = getAlias((VirtualRegisterIR) move.src);
                else
                    v = getAlias((VirtualRegisterIR) move.dest);

                activeMoves.remove(move);

                boolean isEmpty = true;
                for (MoveInstIR tempMove : v.moveList) {
                    if (activeMoves.contains(tempMove) || moveTODOList.contains(tempMove)) {
                        isEmpty = false;
                        break;
                    }
                }
                if (isEmpty && freezeTODOList.contains(v)) {
                    freezeTODOList.remove(v);
                    simplifyTODOList.add(v);
                }
            }
        }
    }

    private void removeNode(VirtualRegisterIR node){
        HashSet<VirtualRegisterIR> neighbor = graph.getNeighbor(node);
        graph.removeNode(node);
        for (VirtualRegisterIR vreg : neighbor)
            if (graph.getDegree(vreg) == REGNUM - 1){
                //TODO
                enableMove(vreg);
                graph.getNeighbor(vreg).forEach(this::enableMove);
                if (spillTODOList.contains(vreg)){
                    spillTODOList.remove(vreg);
                    if (isMoveRelated(vreg))
                        freezeTODOList.add(vreg);
                    else
                        simplifyTODOList.add(vreg);
                }
            }
    }


    private void assignColor(){
        colorMap = new HashMap<>();
        for (VirtualRegisterIR vreg : finishedStack){
            if (vreg.getPhyReg() != null) {
                colorMap.put(vreg, vreg.getPhyReg());
            }
        }
        for (VirtualRegisterIR vreg : finishedStack){
            if (vreg.getPhyReg() != null)
                continue;
            List<PhysicalRegisterIR> colorCanUse = new LinkedList<>(allocatePhyRegisterSet);
            for (VirtualRegisterIR neighbor : originGraph.getNeighbor(vreg))
                if (colorMap.containsKey(neighbor))
                    colorCanUse.remove(colorMap.get(neighbor));
            if (colorCanUse.isEmpty()){
                spilledVregs.add(vreg);
            }
            else{
                PhysicalRegisterIR preg = null;
                for (int i = 0; i < min(6, curFunc.getParameters().size()); i++)
                    if (colorCanUse.contains(paratReg[i].getPhyReg())){
                        preg =  paratReg[i].getPhyReg();
                        break;
                    }
                if (preg == null) {
                    preg = colorCanUse.iterator().next();
                    colorCanUse.retainAll(calleeSaveRegisterSet);
                    if (!colorCanUse.isEmpty())
                        preg = colorCanUse.iterator().next();
                }
                colorMap.put(vreg, preg);
            }
        }
    }

    private void aliasRename(FuncIR func){
        //rename alias
        HashMap<VirtualRegisterIR, VirtualRegisterIR> aliasRenameMap = new HashMap<>();
        for (VirtualRegisterIR vreg : coalescedNodes)
            aliasRenameMap.put(vreg, getAlias(vreg));
        for (BasicBlockIR bb : func.getBBList()) {
            for (InstIR inst = bb.getHead().next; inst != bb.getTail(); inst = inst.next)
                inst.replaceVreg(aliasRenameMap);
        }
    }

    private IRBuilder irBuilder;
    private void rewriteFunc(FuncIR func){
        for (VirtualRegisterIR vreg :spilledVregs) {
            if (vreg.memory == null)
                vreg.memory = new StackSoltIR(vreg.lable + "_spillPlace");
        }

        //spill
        for (BasicBlockIR bb : func.getBBList()) {
            for(InstIR inst = bb.getHead().next; inst != bb.getTail(); inst = inst.next) {
//                if (inst instanceof MoveInstIR){
//                    AddressIR dest = ((MoveInstIR) inst).getDest();
//                    OperandIR src = ((MoveInstIR) inst).getSrc();
//                    if (dest instanceof VirtualRegisterIR && src instanceof MemoryIR
//                            && !dest.lable.equals("spill_reg") && src == ((VirtualRegisterIR) dest).memory) {
//                        inst = inst.prev;
//                        inst.next.remove();
//                        continue;
//                    }
//                }
                List<VirtualRegisterIR> used = inst.getUsedVReg(), defined = inst.getDefinedVreg();
                used.retainAll(spilledVregs);
                defined.retainAll(spilledVregs);
                HashMap<VirtualRegisterIR, VirtualRegisterIR> renameMap = new HashMap<>();
                for (VirtualRegisterIR vreg: used) {
                    VirtualRegisterIR tmp = new VirtualRegisterIR("spill_reg");
                    renameMap.put(vreg, tmp);
                    inst.prepend(new MoveInstIR(tmp, vreg.memory));
                }
                InstIR curInst = inst;
                for (VirtualRegisterIR vreg: defined) {
                    VirtualRegisterIR tmp;
                    if (!renameMap.containsKey(vreg)) {
                        tmp = new VirtualRegisterIR("spill_reg");
                        renameMap.put(vreg, tmp);
                    }
                    else
                        tmp = renameMap.get(vreg);
                    inst.append(new MoveInstIR(vreg.memory,tmp));
                    inst = inst.next;
                }
                curInst.replaceVreg(renameMap);
            }
        }
    }

    private void runFunc(FuncIR func){
//        for (VirtualRegisterIR vreg : func.usedGlobalVar)
//            vreg.setPhyReg(null);
        while (true){
            init();
            originGraph = new LivenessAnalyzer().buildGraph(func, moveTODOList);
            graph = new Graph(originGraph);
            makeWorkList();
            do{
                if (!simplifyTODOList.isEmpty()) doSimplify();
                else if (!moveTODOList.isEmpty()) doCoalesce();
                else if (!freezeTODOList.isEmpty()) doFreeze();
                else doSpill();
            }while(!spillTODOList.isEmpty() || !simplifyTODOList.isEmpty()
                    || !moveTODOList.isEmpty() || !freezeTODOList.isEmpty());

            assignColor();
            aliasRename(func);

            if (spilledVregs.isEmpty()){
                //set phyReg
                for (VirtualRegisterIR vreg: originGraph.getnodes())
                    if (vreg.getPhyReg() == null) {
                        vreg.setPhyReg(colorMap.get(vreg));
                    }
                break;
            }
            else
                rewriteFunc(func);

        }

        for (BasicBlockIR bb:func.getBBList()){
            for(InstIR inst = bb.getHead().next; inst != bb.getTail(); inst = inst.next) {
                if (inst instanceof MoveInstIR && ((MoveInstIR) inst).src instanceof VirtualRegisterIR
                        && ((MoveInstIR) inst).dest instanceof  VirtualRegisterIR){
                    VirtualRegisterIR dest = (VirtualRegisterIR) ((MoveInstIR) inst).dest;
                    VirtualRegisterIR src = (VirtualRegisterIR) ((MoveInstIR) inst).src;
                    if (dest.getPhyReg() == src.getPhyReg()){
                        inst = inst.prev;
                        inst.next.remove();
                    }
                }
            }
        }
    }

    public void run(IRBuilder ir){
        irBuilder = ir;
        int cnt = 0;
        for (StaticDataIR mem : ir.root.getStaticData()){
            mem.lable = "__Static" + cnt + "_" + mem.lable;
            cnt++;
        }
        for (FuncIR func: ir.root.getFuncs()){
            curFunc = func;
            runFunc(func);
            curFunc = null;
        }
        if (Config.DEBUG) {
            new IRPrinter(irBuilder).visit(irBuilder.root);
            System.out.flush();
        }
        for (FuncIR func: ir.root.getFuncs())
            dfsFuncPhyRegs(func);
    }

    static private HashSet<FuncIR> accessedFunc = new HashSet<>();
    private void dfsFuncPhyRegs(FuncIR func){
        if (accessedFunc.contains(func))
            return;
        accessedFunc.add(func);
        func.initPhyRegs();
        for (FuncIR nextFunc: func.callee) {
            dfsFuncPhyRegs(nextFunc);
            func.usedPhyRegs.addAll(nextFunc.usedPhyRegs);
            func.definedPhyRegs.addAll(nextFunc.definedPhyRegs);
        }
    }

}
