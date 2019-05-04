package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.IRVisitor;
import com.mxcomplier.Ir.Operands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CallInstIR extends InstIR {

    private FuncIR func;
    private List<OperandIR> args;
    private RegisterIR returnValue;

    public CallInstIR(FuncIR func, List<OperandIR> args, RegisterIR returnValue){
        this.func = func;
        this.args = args;
        this.returnValue = returnValue;
    }

    public FuncIR getFunc() {
        return func;
    }

    public List<OperandIR> getArgs() {
        return args;
    }

    public RegisterIR getReturnValue() {
        return returnValue;
    }

    @Override
    public List<StackSoltIR> getStackSolt() {
        List<StackSoltIR> res = new ArrayList<>();
        VirtualRegisterIR ret = (VirtualRegisterIR) returnValue;
        if (ret != null && ret.memory instanceof StackSoltIR)
            res.add((StackSoltIR) ret.memory);
        for (OperandIR arg : args){
            if (arg instanceof VirtualRegisterIR){
                MemoryIR mem = ((VirtualRegisterIR) arg).memory;
                if (mem instanceof StackSoltIR)
                    res.add((StackSoltIR) mem);
            }
        }
        return res;
    }

    @Override
    public List<VirtualRegisterIR> getUsedVReg() {
        List<VirtualRegisterIR> regs = new ArrayList<>();
        for (OperandIR arg : args)
            regs.addAll(getVreg(arg));
        return regs;
    }

    @Override
    public void replaceVreg(Map<VirtualRegisterIR, VirtualRegisterIR> renameMap){
        returnValue = (RegisterIR) replacedVreg(returnValue, renameMap);
        List<OperandIR> tmp = new ArrayList<>();
        for (OperandIR arg : args)
            tmp.add(replacedVreg(arg, renameMap));
        args = tmp;
    }

    @Override
    public List<VirtualRegisterIR> getDefinedVreg() {
        return getVreg(returnValue);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("call " + func.getName() + " (");
        for (OperandIR arg : args){
            str.append(arg).append(",");
        }
        if (!args.isEmpty())
            str.setCharAt(str.length() - 1, ')');
        else
            str.append(')');
        return str.toString();
    }

    public String nasmString() {
        return "call " + func.getName();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
