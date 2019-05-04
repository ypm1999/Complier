package com.mxcomplier.backEnd;

import com.mxcomplier.Config;
import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.*;
import com.mxcomplier.Ir.Operands.*;
import com.mxcomplier.Ir.ProgramIR;
import com.mxcomplier.Ir.RegisterSet;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Math.min;

public class StackFrameAllocater extends IRScanner {

    private class Frame{
        public List<AddressIR> tempVar = new ArrayList<>();
        public AddressIR old_rbp = new StackSoltIR("old_rbp");
    }

    Frame curFrame = null;

    static PhysicalRegisterIR[] paratReg = {
            RegisterSet.rdi,
            RegisterSet.rsi,
            RegisterSet.rdx,
            RegisterSet.rcx,
            RegisterSet.r8,
            RegisterSet.r9
    };


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
            func.accept(this);
        }
    }

    @Override
    public void visit(FuncIR node) {
        InstIR firstInst = node.entryBB.getHead().next;
        firstInst.prepend(new PushInstIR(RegisterSet.rbp));
        firstInst.prepend(new MoveInstIR(RegisterSet.rbp, RegisterSet.rsp));

        HashSet<StackSoltIR> stackSolts = new HashSet<>();
        for(BasicBlockIR bb: node.getBBList()){
            InstIR inst = bb.getHead().next;
            while(inst != bb.getTail()){
                stackSolts.addAll(inst.getStackSolt());
                inst = inst.next;
            }
        }

        int stackSize = (stackSolts.size()) * Config.getREGSIZE();
        firstInst.prepend(new BinaryInstIR(BinaryInstIR.Op.SUB, RegisterSet.rsp, new ImmediateIR(stackSize)));

        int i = 0;
        for (StackSoltIR stackSolt: stackSolts)
            stackSolt.setNum(-Config.getREGSIZE() * (++i));


        for (BasicBlockIR bb : node.getBBList()){
            bb.accept(this);
        }
    }

    @Override
    public void visit(CallInstIR node) {
        if (node.getArgs().size() > 6)
            node.append(new BinaryInstIR(BinaryInstIR.Op.ADD, RegisterSet.rsp,
                                        new ImmediateIR(Config.getREGSIZE()*(node.getArgs().size() - 6))));
    }
}

