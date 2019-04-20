package com.mxcomplier.Ir.Operands;

import com.mxcomplier.Ir.IRVisitor;

public class MemoryIR extends AddressIR {
    private RegisterIR base = null;
    private RegisterIR offset = null;
    private int scale = 1;
    private int num = 0;
    private ConstantIR constant = null;


    public MemoryIR(){}

    public MemoryIR(RegisterIR base){
        this.base = base;
    }

    public MemoryIR(RegisterIR base, RegisterIR offset){
        this.base = base;
        this.offset = offset;
    }

    public MemoryIR(RegisterIR base, int num){
        this.base = base;
        this.num = num;
    }

    public MemoryIR(ConstantIR constant){
        this.constant = constant;
    }


    public OperandIR getBase() {
        return base;
    }

    public OperandIR getOffset() {
        return offset;
    }

    public ConstantIR getConstant() {
        return constant;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        if (constant != null)
            return "[" + constant.lable + "]";
        String str1, str2, str3;
        str1 = "" + base;
        if (offset == null)
            str2 = "";
        else{
            if (scale == 1)
                str2 = " + " + offset.toString();
            else
                str2 = " + " + offset.toString() + "*" + scale;
        }
        if (num > 0)
            str3 = " + " + num;
        else if (num < 0)
            str3 = " - " + (-num);
        else
            str3 = "";
        return "qword [" + str1 + str2 + str3 + ']';
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
