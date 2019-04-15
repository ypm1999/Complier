package com.mxcomplier.backEnd;

import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.*;
import com.mxcomplier.Ir.Operands.*;
import com.mxcomplier.Ir.ProgramIR;
import com.mxcomplier.Ir.RegisterSet;

public class RegisterAllocater extends IRScanner {



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
        int cnt = 0;
        for (StaticDataIR mem : node.getStaticData()){
            mem.lable = "__Static" + cnt + "_" + mem.lable;
            cnt++;
        }
        for (FuncIR func : node.getFuncs()){
            func.accept(this);
        }
    }

    @Override
    public void visit(FuncIR node) {
        for (BasicBlockIR bb : node.getBBList()){
            bb.accept(this);
        }
    }

    @Override
    public void visit(CallInstIR node) {

    }

    @Override
    public void visit(UnaryInstIR node) {
        MemoryIR mem = getMemory(node.dest);
        assert(mem != null);
//        node.prepend(new MoveInstIR(RegisterSet.rax, mem));
        node.dest = mem;
//        node.append(new MoveInstIR(mem, RegisterSet.rax));
    }

    @Override
    public void visit(JumpInstIR node) {

    }

    @Override
    public void visit(CJumpInstIR node) {
        MemoryIR lhs = getMemory(node.getLhs());
        MemoryIR rhs = getMemory(node.getRhs());
        CompInstIR cmp = new CompInstIR(node.getLhs(), node.getRhs());
        node.prepend(cmp);
        if (lhs != null) {
            cmp.prepend(new MoveInstIR(RegisterSet.rax, lhs));
            cmp.lhs = RegisterSet.rax;
//            cmp.append(new MoveInstIR(lhs, RegisterSet.rax));
        }
        if (rhs != null) {
            cmp.prepend(new MoveInstIR(RegisterSet.rdx, rhs));
            cmp.rhs = RegisterSet.rdx;
//            cmp.append(new MoveInstIR(rhs, RegisterSet.rdx));
        }
    }

    @Override
    public void visit(BinaryInstIR node) {
        MemoryIR dest = getVregMemory(node.getDest());
        MemoryIR src = getVregMemory(node.getSrc());
        if (dest != null) {
//            node.prepend(new MoveInstIR(RegisterSet.rax, dest));
            node.dest = dest;
//            node.append(new MoveInstIR(dest, RegisterSet.rax));
        }
        if (src != null) {
            node.prepend(new MoveInstIR(RegisterSet.rdx, src));
            node.src = RegisterSet.rdx;
        }
    }

    @Override
    public void visit(MoveInstIR node) {
        MemoryIR dest = getVregMemory(node.getDest());
        MemoryIR src = getVregMemory(node.getSrc());
        if (dest != null) {
//            node.prepend(new MoveInstIR(RegisterSet.rax, dest));
            node.dest = dest;
//            node.append(new MoveInstIR(dest, RegisterSet.rax));
        }
        if (src != null) {
            node.prepend(new MoveInstIR(RegisterSet.rdx, src));
            node.src = RegisterSet.rdx;
//            node.append(new MoveInstIR(src, RegisterSet.rdx));
        }
    }

    @Override
    public void visit(PopInstIR node) {

    }

    @Override
    public void visit(PushInstIR node) {

    }

    @Override
    public void visit(ReturnInstIR node) {

    }

}
