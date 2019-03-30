package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Instructions.BinaryInstIR;

public interface IRVisitor {
    void visit(BinaryInstIR node);
}
