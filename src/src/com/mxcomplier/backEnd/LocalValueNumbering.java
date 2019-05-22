package com.mxcomplier.backEnd;

import com.mxcomplier.Error.IRError;
import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.*;
import com.mxcomplier.Ir.Operands.ImmediateIR;
import com.mxcomplier.Ir.Operands.OperandIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;
import com.mxcomplier.Ir.ProgramIR;

import java.util.HashMap;
import java.util.HashSet;


public class LocalValueNumbering extends IRScanner {


    private int valueCountor;
    private HashMap<VirtualRegisterIR, Integer> registerValueMap = new HashMap<>();
    private HashMap<Pair, Integer> pairValueMap = new HashMap<>();
    private HashMap<Integer, HashSet<VirtualRegisterIR>> valueRegisterMap = new HashMap<>();
    private HashMap<Integer, Integer> immValueMap = new HashMap<>();
    private HashMap<Integer, Integer> valueImmMap = new HashMap<>();

    private Integer getOperandValue(OperandIR oper) {
        if (oper instanceof VirtualRegisterIR)
            return getRegValue((VirtualRegisterIR) oper);
        else if (oper instanceof ImmediateIR)
            return getImmValue((ImmediateIR) oper);
        else
            return ++valueCountor;
    }

    private OperandIR getValueOperand(Integer value) {
        if (valueImmMap.containsKey(value))
            return new ImmediateIR(valueImmMap.get(value));
        else if (valueRegisterMap.containsKey(value)) {
            HashSet<VirtualRegisterIR> vregSet = valueRegisterMap.get(value);
            if (vregSet.isEmpty())
                return null;
            else
                return vregSet.iterator().next();
        } else
            return null;
    }

    private Integer getImmValue(ImmediateIR imm) {
        Integer immInt = (int) imm.getValue();
        if (!immValueMap.containsKey(immInt)) {

            ++valueCountor;
            immValueMap.put(immInt, valueCountor);
            valueImmMap.put(valueCountor, immInt);
        }
        return immValueMap.get(immInt);
    }

    private Integer getRegValue(VirtualRegisterIR reg) {
        if (!registerValueMap.containsKey(reg)) {
            addRegisterValue(reg, ++valueCountor);
        }
        return registerValueMap.get(reg);
    }

    private void addRegisterValue(VirtualRegisterIR vreg, Integer val) {
        if (!valueRegisterMap.containsKey(val))
            valueRegisterMap.put(val, new HashSet<>());
        valueRegisterMap.get(val).add(vreg);
        registerValueMap.put(vreg, val);
    }

    private void deleteRegisterValue(VirtualRegisterIR vreg) {
        if (registerValueMap.containsKey(vreg)) {
            Integer value = registerValueMap.get(vreg);
            if (valueRegisterMap.containsKey(value))
                valueRegisterMap.get(value).remove(vreg);
            registerValueMap.remove(vreg);
        }
    }

    private void changeRegisterValue(VirtualRegisterIR vreg, Integer newVal) {
        deleteRegisterValue(vreg);
        addRegisterValue(vreg, newVal);
    }

    @Override
    public void visit(ProgramIR node) {
        for (FuncIR func : node.getFuncs())
            func.accept(this);
    }

    @Override
    public void visit(FuncIR node) {
        for (BasicBlockIR bb : node.getBBList())
            bb.accept(this);
    }

    @Override
    public void visit(BasicBlockIR node) {
        valueCountor = 0;
        registerValueMap.clear();
        pairValueMap.clear();
        valueRegisterMap.clear();
        immValueMap.clear();
        valueImmMap.clear();
        for (InstIR inst = node.getHead().next; inst != node.getTail(); ) {
            InstIR next = inst.next;
            inst.accept(this);
            inst = next;
        }
    }

    @Override
    public void visit(CallInstIR node) {
        changeRegisterValue((VirtualRegisterIR) node.getReturnValue(), ++valueCountor);
    }

    private Integer doUnary(UnaryInstIR.Op op, Integer imm) {
        switch (op) {
            case INV:
                return ~imm;
            case NEG:
                return -imm;
            case INC:
                return imm + 1;
            case DEC:
                return imm - 1;
            default:
                throw new IRError("Unary error in LVN");
        }
    }

    private Integer doBinary(BinaryInstIR.Op op, Integer limm, Integer rimm) {
        switch (op) {
            case SUB:
                return limm - rimm;
            case XOR:
                return limm ^ rimm;
            case MUL:
                return limm * rimm;
            case MOD:
                if (rimm == 0) rimm = 1;
                return limm % rimm;
            case DIV:
                if (rimm == 0) rimm = 1;
                return limm / rimm;
            case AND:
                return limm & rimm;
            case ADD:
                return limm + rimm;
            case OR:
                return limm | rimm;
            case SHL:
                return limm << rimm;
            case SHR:
                return limm >> rimm;
            default:
                throw new IRError("Binary error in LVN");
        }
    }

    @Override
    public void visit(UnaryInstIR node) {
        Integer value = getOperandValue(node.getDest());
        if (valueImmMap.containsKey(value)) {
            Integer imm = doUnary(node.getOp(), valueImmMap.get(value));
            value = immValueMap.containsKey(imm) ? immValueMap.get(imm) : ++valueCountor;
            node.append(new MoveInstIR(node.getDest(), new ImmediateIR(imm)));
            node.remove();
        } else
            value = ++valueCountor;

        if (node.getDest() instanceof VirtualRegisterIR)
            changeRegisterValue((VirtualRegisterIR) node.getDest(), value);
    }

    private boolean doComp(CJumpInstIR.Op op, long lhs, long rhs) {
        switch (op) {
            case L:
                return lhs < rhs;
            case G:
                return lhs > rhs;
            case LE:
                return lhs <= rhs;
            case GE:
                return lhs >= rhs;
            case E:
                return lhs == rhs;
            case NE:
                return lhs != rhs;
            case ERROR:
                throw new IRError("unknow Cmp");
        }
        return false;
    }

    @Override
    public void visit(CJumpInstIR node) {
        Integer lhs = getOperandValue(node.getLhs());
        Integer rhs = getOperandValue(node.getRhs());
        if (valueImmMap.containsKey(lhs))
            node.setLhs(new ImmediateIR(valueImmMap.get(lhs)));
        if (valueImmMap.containsKey(rhs))
            node.setRhs(new ImmediateIR(valueImmMap.get(rhs)));
        if (node.getLhs() instanceof ImmediateIR && node.getRhs() instanceof ImmediateIR) {
            boolean res = doComp(node.getOp(), ((ImmediateIR) node.getLhs()).getValue(), ((ImmediateIR) node.getRhs()).getValue());
            if (res)
                node.append(new JumpInstIR(node.getTrueBB()));
            else
                node.append(new JumpInstIR(node.getFalseBB()));
            node.remove();
        }
    }

    @Override
    public void visit(BinaryInstIR node) {
        Integer src = getOperandValue(node.getSrc());
        Integer dest = getOperandValue(node.getDest());
        Integer result;
        Pair binaryPair = new Pair(node.getOp(), src, dest);
        if (pairValueMap.containsKey(binaryPair)) {
            result = pairValueMap.get(binaryPair);
            OperandIR oper = getValueOperand(result);
            if (oper != null) {
                node.append(new MoveInstIR(node.getDest(), oper));
                node.remove();
            }
        } else {
            result = ++valueCountor;
            pairValueMap.put(binaryPair, result);
        }
        if (node.getDest() instanceof VirtualRegisterIR)
            changeRegisterValue((VirtualRegisterIR) node.getDest(), result);
    }

    @Override
    public void visit(MoveInstIR node) {
        Integer src = getOperandValue(node.getSrc());
        if (valueImmMap.containsKey(src))
            node.setSrc(new ImmediateIR(valueImmMap.get(src)));
        if (node.getDest() instanceof VirtualRegisterIR)
            changeRegisterValue((VirtualRegisterIR) node.getDest(), src);
    }

    @Override
    public void visit(PopInstIR node) {
        if (node.getDest() instanceof VirtualRegisterIR)
            changeRegisterValue((VirtualRegisterIR) node.getDest(), ++valueCountor);
    }

    @Override
    public void visit(LeaInstIR node) {
        if (node.getDest() instanceof VirtualRegisterIR)
            changeRegisterValue((VirtualRegisterIR) node.getDest(), ++valueCountor);
    }

    class Pair {
        BinaryInstIR.Op op;
        Integer lhs, rhs;

        Pair(BinaryInstIR.Op op, Integer lhs, Integer rhs) {
            this.op = op;
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public int hashCode() {
            return op.ordinal() * 100000000 + lhs * 10000 + rhs;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair other = (Pair) obj;
                return op == other.op && lhs.equals(other.lhs) && rhs.equals(other.rhs);

            }
            return false;
        }
    }
}


//FIXME
//package com.mxcomplier.backEnd;
//
//import com.mxcomplier.Error.IRError;
//import com.mxcomplier.Ir.BasicBlockIR;
//import com.mxcomplier.Ir.FuncIR;
//import com.mxcomplier.Ir.Instructions.*;
//import com.mxcomplier.Ir.Operands.ImmediateIR;
//import com.mxcomplier.Ir.Operands.MemoryIR;
//import com.mxcomplier.Ir.Operands.OperandIR;
//import com.mxcomplier.Ir.Operands.VirtualRegisterIR;
//import com.mxcomplier.Ir.ProgramIR;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//
//
//public class LocalValueNumbering extends IRScanner {
//    private static final int P = 10000;
//
//
//    private int valueCountor;
//    private HashMap<VirtualRegisterIR, Integer> registerValueMap = new HashMap<>();
//    private HashMap<AddressValue, Integer> memoryValueMap = new HashMap<>();
//    private HashMap<Pair, Integer> pairValueMap = new HashMap<>();
//    private HashMap<Integer, HashSet<VirtualRegisterIR>> valueRegisterMap = new HashMap<>();
//    private HashMap<Integer, HashSet<AddressValue>> valueMemoryMap = new HashMap<>();
//    private HashMap<Integer, Integer> immValueMap = new HashMap<>();
//    private HashMap<Integer, Integer> valueImmMap = new HashMap<>();
//
//    private Integer getOperandValue(OperandIR oper) {
//        if (oper instanceof VirtualRegisterIR)
//            return getRegValue((VirtualRegisterIR) oper);
//        else if (oper instanceof ImmediateIR)
//            return getImmValue((ImmediateIR) oper);
//        else if (oper instanceof  MemoryIR && ((MemoryIR) oper).getConstant() == null)
//            return getMemValue((MemoryIR) oper);
//        else
//            return ++valueCountor;
//    }
//
//    private OperandIR getValueOperand(Integer value) {
//        if (valueImmMap.containsKey(value))
//            return new ImmediateIR(valueImmMap.get(value));
//        else if (valueRegisterMap.containsKey(value)) {
//            HashSet<VirtualRegisterIR> vregSet = valueRegisterMap.get(value);
//            if (vregSet.isEmpty())
//                return null;
//            else
//                return vregSet.iterator().next();
//        } else
//            return null;
//    }
//
//    private Integer getImmValue(ImmediateIR imm) {
//        Integer immInt = (int) imm.getValue();
//        if (!immValueMap.containsKey(immInt)) {
//
//            immValueMap.put(immInt, ++valueCountor);
//            valueImmMap.put(valueCountor, immInt);
//        }
//        return immValueMap.get(immInt);
//    }
//
//    private int getMemAddrValueNumber(MemoryIR mem){
//        int res = 0;
//        if (mem.getBase() != null)
//            res += getOperandValue(mem.getBase()) * P;
//        if (mem.getOffset() != null)
//            res += getOperandValue(mem.getOffset());
//        return res;
//    }
//
//    private Integer getMemValue(MemoryIR mem){
//        AddressValue addr = new AddressValue(mem);
//        if (memoryValueMap.containsKey(addr)){
//            Integer value = memoryValueMap.get(addr);
////            valueMemoryMap.get(value).add(mem);
//            return value;
//        }
//        else{
//            deleteMemoryValue(addr);
//            addMemoryValue(addr, ++valueCountor);
//            return valueCountor;
//        }
//    }
//
//    private Integer getRegValue(VirtualRegisterIR reg) {
//        if (!registerValueMap.containsKey(reg)) {
//            addRegisterValue(reg, ++valueCountor);
//        }
//        return registerValueMap.get(reg);
//    }
//
//    private void addRegisterValue(VirtualRegisterIR vreg, Integer val) {
//        if (!valueRegisterMap.containsKey(val))
//            valueRegisterMap.put(val, new HashSet<>());
//        valueRegisterMap.get(val).add(vreg);
//        registerValueMap.put(vreg, val);
//    }
//
//    private void deleteRegisterValue(VirtualRegisterIR vreg) {
//        if (registerValueMap.containsKey(vreg)) {
//            Integer value = registerValueMap.get(vreg);
//            if (valueRegisterMap.containsKey(value))
//                valueRegisterMap.get(value).remove(vreg);
//            registerValueMap.remove(vreg);
//        }
//    }
//
//    private void changeRegisterValue(VirtualRegisterIR vreg, Integer newVal) {
//        deleteRegisterValue(vreg);
//        addRegisterValue(vreg, newVal);
//    }
//
//    private void addMemoryValue(AddressValue addr, Integer val) {
//        if (!valueMemoryMap.containsKey(val))
//            valueMemoryMap.put(val, new HashSet<>(Collections.singletonList(addr)));
//        memoryValueMap.put(addr, val);
//    }
//
//    private void deleteMemoryValue(AddressValue addr) {
//        if (memoryValueMap.containsKey(addr)){
//            Integer value = memoryValueMap.get(addr);
//            if (valueMemoryMap.containsKey(value))
//                valueMemoryMap.get(value).remove(addr);
//            memoryValueMap.remove(addr);
//        }
//    }
//
//    private void changeMemoryValue(MemoryIR mem, Integer newVal) {
//        if (mem.getConstant() == null) {
//            AddressValue addr = new AddressValue(mem);
//            deleteMemoryValue(addr);
//            addMemoryValue(addr, newVal);
//        }
//    }
//
//
//    @Override
//    public void visit(ProgramIR node) {
//        for (FuncIR func : node.getFuncs())
//            func.accept(this);
//    }
//
//    @Override
//    public void visit(FuncIR node) {
//        for (BasicBlockIR bb : node.getBBList())
//            bb.accept(this);
//    }
//
//    @Override
//    public void visit(BasicBlockIR node) {
//        valueCountor = 0;
//        registerValueMap.clear();
//        pairValueMap.clear();
//        valueRegisterMap.clear();
//        immValueMap.clear();
//        valueImmMap.clear();
//        memoryValueMap.clear();
//        valueMemoryMap.clear();
//        for (InstIR inst = node.getHead().next; inst != node.getTail(); ) {
//            InstIR next = inst.next;
////            System.err.println(inst);
//            inst.accept(this);
//            inst = next;
//        }
//    }
//
//    @Override
//    public void visit(CallInstIR node) {
//        changeRegisterValue((VirtualRegisterIR) node.getReturnValue(), ++valueCountor);
//    }
//
//    private Integer doUnary(UnaryInstIR.Op op, Integer imm) {
//        switch (op) {
//            case INV:
//                return ~imm;
//            case NEG:
//                return -imm;
//            case INC:
//                return imm + 1;
//            case DEC:
//                return imm - 1;
//            default:
//                throw new IRError("Unary error in LVN");
//        }
//    }
//
//    private Integer doBinary(BinaryInstIR.Op op, Integer limm, Integer rimm) {
//        switch (op) {
//            case SUB:
//                return limm - rimm;
//            case XOR:
//                return limm ^ rimm;
//            case MUL:
//                return limm * rimm;
//            case MOD:
//                if (rimm == 0) rimm = 1;
//                return limm % rimm;
//            case DIV:
//                if (rimm == 0) rimm = 1;
//                return limm / rimm;
//            case AND:
//                return limm & rimm;
//            case ADD:
//                return limm + rimm;
//            case OR:
//                return limm | rimm;
//            case SHL:
//                return limm << rimm;
//            case SHR:
//                return limm >> rimm;
//            default:
//                throw new IRError("Binary error in LVN");
//        }
//    }
//
//    @Override
//    public void visit(UnaryInstIR node) {
//        Integer value = getOperandValue(node.getDest());
//        if (valueImmMap.containsKey(value)) {
//            Integer imm = doUnary(node.getOp(), valueImmMap.get(value));
//            value = immValueMap.containsKey(imm) ? immValueMap.get(imm) : ++valueCountor;
//            node.append(new MoveInstIR(node.getDest(), new ImmediateIR(imm)));
//            node.remove();
//        } else
//            value = ++valueCountor;
//
//        if (node.getDest() instanceof VirtualRegisterIR)
//            changeRegisterValue((VirtualRegisterIR) node.getDest(), value);
//    }
//
//    private boolean doComp(CJumpInstIR.Op op, long lhs, long rhs) {
//        switch (op) {
//            case L:
//                return lhs < rhs;
//            case G:
//                return lhs > rhs;
//            case LE:
//                return lhs <= rhs;
//            case GE:
//                return lhs >= rhs;
//            case E:
//                return lhs == rhs;
//            case NE:
//                return lhs != rhs;
//            case ERROR:
//                throw new IRError("unknow Cmp");
//        }
//        return false;
//    }
//
//    @Override
//    public void visit(CJumpInstIR node) {
//        Integer lhs = getOperandValue(node.getLhs());
//        Integer rhs = getOperandValue(node.getRhs());
//        if (valueImmMap.containsKey(lhs))
//            node.setLhs(new ImmediateIR(valueImmMap.get(lhs)));
//        else if (node.getLhs() instanceof MemoryIR && valueRegisterMap.containsKey(lhs)){
//            if (!valueRegisterMap.get(lhs).isEmpty())
//                node.setLhs(valueRegisterMap.get(lhs).iterator().next());
//        }
//        if (valueImmMap.containsKey(rhs))
//            node.setRhs(new ImmediateIR(valueImmMap.get(rhs)));
//        else if (node.getRhs() instanceof MemoryIR && valueRegisterMap.containsKey(rhs)){
//            if (!valueRegisterMap.get(rhs).isEmpty())
//                node.setLhs(valueRegisterMap.get(rhs).iterator().next());
//        }
//        if (node.getLhs() instanceof ImmediateIR && node.getRhs() instanceof ImmediateIR) {
//            boolean res = doComp(node.getOp(), ((ImmediateIR) node.getLhs()).getValue(), ((ImmediateIR) node.getRhs()).getValue());
//            if (res)
//                node.append(new JumpInstIR(node.getTrueBB()));
//            else
//                node.append(new JumpInstIR(node.getFalseBB()));
//            node.remove();
//        }
//    }
//
//    @Override
//    public void visit(BinaryInstIR node) {
//        Integer src = getOperandValue(node.getSrc());
//        Integer dest = getOperandValue(node.getDest());
//        Integer result;
//        Pair binaryPair = new Pair(node.getOp(), src, dest);
//        if (pairValueMap.containsKey(binaryPair)) {
//            result = pairValueMap.get(binaryPair);
//            OperandIR oper = getValueOperand(result);
//            if (oper != null) {
//                node.append(new MoveInstIR(node.getDest(), oper));
//                node.remove();
//            }
//        }
//        else {
//            if (node.getSrc() instanceof MemoryIR && valueRegisterMap.containsKey(src) && !valueRegisterMap.get(src).isEmpty()){
//                node.setSrc(valueRegisterMap.get(src).iterator().next());
//            }
//            result = ++valueCountor;
//            pairValueMap.put(binaryPair, result);
//        }
//        if (node.getDest() instanceof VirtualRegisterIR)
//            changeRegisterValue((VirtualRegisterIR) node.getDest(), result);
//        else if (node.getDest() instanceof MemoryIR)
//            changeMemoryValue((MemoryIR) node.getDest(), result);
//    }
//
//    @Override
//    public void visit(MoveInstIR node) {
//        Integer src = getOperandValue(node.getSrc());
//        if (valueImmMap.containsKey(src))
//            node.setSrc(new ImmediateIR(valueImmMap.get(src)));
//        else if (node.getSrc() instanceof MemoryIR && valueRegisterMap.containsKey(src)){
//            if (!valueRegisterMap.get(src).isEmpty())
//                node.setSrc(valueRegisterMap.get(src).iterator().next());
//        }
//        if (node.getDest() instanceof VirtualRegisterIR)
//            changeRegisterValue((VirtualRegisterIR) node.getDest(), src);
//        else if (node.getDest() instanceof MemoryIR)
//            changeMemoryValue((MemoryIR) node.getDest(), src);
//    }
//
//    @Override
//    public void visit(PopInstIR node) {
//        if (node.getDest() instanceof VirtualRegisterIR)
//            changeRegisterValue((VirtualRegisterIR) node.getDest(), ++valueCountor);
//    }
//
//    @Override
//    public void visit(LeaInstIR node) {
//        if (node.getDest() instanceof VirtualRegisterIR)
//            changeRegisterValue((VirtualRegisterIR) node.getDest(), ++valueCountor);
//    }
//
//    class AddressValue{
//        Integer base = 0, offset = 0;
//        int scale, num;
//
//        AddressValue (MemoryIR mem){
//            if (mem.getBase() != null)
//                base = getOperandValue(mem.getBase());
//            if (mem.getOffset() != null)
//                offset = getOperandValue(mem.getOffset());
//            scale = mem.getScale();
//            num = mem.getNum();
//        }
//
//        @Override
//        public int hashCode() {
//            int x = base * P + offset;
//            x <<= 2;
//            if (scale == 2)
//                x |= 1;
//            else if (scale == 4)
//                x |= 2;
//            else if (scale == 8)
//                x |= 3;
//            return x;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj instanceof AddressValue){
//                AddressValue other = (AddressValue)obj;
//                return base.equals(other.base) && offset.equals(other.offset) && num == other.num && scale == other.scale;
//            }
//            else
//                return false;
//        }
//    }
//
//
//    class Pair {
//        BinaryInstIR.Op op;
//        Integer lhs, rhs;
//
//        Pair(BinaryInstIR.Op op, Integer lhs, Integer rhs) {
//            this.op = op;
//            this.lhs = lhs;
//            this.rhs = rhs;
//        }
//
//        @Override
//        public int hashCode() {
//            return op.ordinal() * P * P + lhs * P + rhs;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj instanceof Pair) {
//                Pair other = (Pair) obj;
//                return op == other.op && lhs.equals(other.lhs) && rhs.equals(other.rhs);
//
//            }
//            return false;
//        }
//    }
//}
