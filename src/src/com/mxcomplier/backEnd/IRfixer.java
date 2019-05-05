package com.mxcomplier.backEnd;

import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.*;
import com.mxcomplier.Ir.Operands.ImmediateIR;
import com.mxcomplier.Ir.Operands.MemoryIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;
import com.mxcomplier.Ir.ProgramIR;
import com.mxcomplier.Ir.RegisterSet;

import java.util.ArrayList;
import java.util.HashSet;

import static com.mxcomplier.FrontEnd.IRBuilder.ZERO;
import static java.lang.Math.min;

public class IRfixer extends IRScanner {

    private FuncIR curFunc = null;

    @Override
    public void visit(BasicBlockIR node) {
        InstIR inst = node.getHead().next;
        while(inst != node.getTail()){
            inst.accept(this);
            inst = inst.next;
        }
    }

    @Override
    public void visit(ProgramIR node) {
        for (FuncIR func : node.getFuncs()){
            curFunc = func;
            func.accept(this);
            curFunc = null;
        }
    }

    @Override
    public void visit(FuncIR node) {
        BasicBlockIR entry = node.entryBB, leave = node.leaveBB;

        for (BasicBlockIR bb : node.getBBList()){
            bb.accept(this);
        }
    }

    @Override
    public void visit(MoveInstIR node) {
        if (node.getDest() instanceof MemoryIR && (node.getSrc() instanceof MemoryIR || node.getSrc() instanceof  ImmediateIR)){
            VirtualRegisterIR tmp = new VirtualRegisterIR("move_tmp");
            node.prepend(new MoveInstIR(tmp, node.getSrc()));
            node.setSrc(tmp);
        }
    }

    @Override
    public void visit(LeaInstIR node) {
        if (node.getDest() instanceof MemoryIR && node.getSrc() instanceof MemoryIR){
            VirtualRegisterIR tmp = new VirtualRegisterIR("lea_tmp");
            node.append(new MoveInstIR(node.getDest(), tmp));
            node.dest = tmp;
        }
    }

    @Override
    public void visit(BinaryInstIR node) {
        switch (node.getOp()){
            case MUL:
            case DIV:
            case MOD:
                node.prepend(new MoveInstIR(RegisterSet.Vrax, node.dest));
                node.prepend(new MoveInstIR(RegisterSet.Vrbx, node.src));
                node.prepend(new MoveInstIR(RegisterSet.Vrdx, ZERO));
                node.src = RegisterSet.Vrbx;
                if (node.getOp() == BinaryInstIR.Op.MOD)
                    node.append(new MoveInstIR(node.dest, RegisterSet.Vrdx));
                else
                    node.append(new MoveInstIR(node.dest, RegisterSet.Vrax));
                break;
            default: break;
        }
    }

    @Override
    public void visit(PushInstIR node) {
        if (node.getSrc() instanceof ImmediateIR){
            VirtualRegisterIR tmp = new VirtualRegisterIR("push_tmp");
            node.prepend(new MoveInstIR(tmp, node.getSrc()));
            node.setSrc(tmp);
        }
    }

    @Override
    public void visit(CJumpInstIR node) {
        if (node.getLhs() instanceof ImmediateIR){
            if (node.getRhs() instanceof ImmediateIR)
                node.prepend(new MoveInstIR(new VirtualRegisterIR("Cjump_imm_temp"), node.getLhs()));
            else
                node.swap();
        }

        if (node.getLhs() instanceof MemoryIR && node.getRhs() instanceof MemoryIR){
            VirtualRegisterIR tmp = new VirtualRegisterIR("Cjump_tmp");
            node.prepend(new MoveInstIR(tmp, node.getRhs()));
            node.rhs = tmp;
        }
    }

    @Override
    public void visit(CallInstIR node) {
        FuncIR caller = curFunc;
        FuncIR callee = node.getFunc();
        if (callee.getType() != FuncIR.Type.USER)
            return;
        HashSet<VirtualRegisterIR> globalVar = new HashSet<>(caller.usedGlobalVar);
        globalVar.retainAll(callee.usedGlobalVar);
        InstIR preInst = node.prev;
        for (int i = 1; i < min(callee.getParameters().size(), 6); i++)
            preInst = preInst.prev;
        for (VirtualRegisterIR vreg : globalVar){
            preInst.append(new MoveInstIR(vreg.memory, vreg));
            node.append(new MoveInstIR(vreg, vreg.memory));
        }
    }
}
