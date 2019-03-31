package com.mxcomplier.Ir.Instructions;

import com.mxcomplier.Ir.Operands.RegisterIR;

public class UnaryInstIR extends InstIR {
    public enum Op{
        NEG, NOT, INV, INC, DEC
    }

    private Op op;
    private RegisterIR dest;
    private RegisterIR src;



}
