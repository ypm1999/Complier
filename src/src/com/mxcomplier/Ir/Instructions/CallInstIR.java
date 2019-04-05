package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.IRVisitor;
import com.mxcomplier.Ir.Operands.OperandIR;
import com.mxcomplier.Ir.Operands.RegisterIR;

import java.util.List;

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

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
