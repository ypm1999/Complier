package com.mxcomplier.AST;

import com.mxcomplier.Ir.Operands.OperandIR;
import com.mxcomplier.Type.Type;

abstract public class ExprNode extends Node {
    private Type type;
    private boolean leftValue;
    private OperandIR resultReg;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isLeftValue() {
        return leftValue;
    }

    public void setLeftValue(boolean leftValue) {
        this.leftValue = leftValue;
    }

    public OperandIR getResultReg() {
        return resultReg;
    }

    public void setResultOperand(OperandIR resultReg) {
        this.resultReg = resultReg;
    }
}
