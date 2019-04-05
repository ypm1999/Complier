package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Config;
import com.mxcomplier.Error.IRError;
import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.*;
import com.mxcomplier.Ir.Operands.*;
import com.mxcomplier.Scope.*;
import com.mxcomplier.Type.*;

import java.util.*;

public class IRBuilder extends ASTScanner{
    private Scope globalScope;
    private List<StaticDataIR> staticDataList = new ArrayList<>();
    private Map<String, FuncIR> funcMap = new HashMap<>();
    private Map<ExprNode, BasicBlockIR> trueBBMap = new HashMap<>();
    private Map<ExprNode, BasicBlockIR> falseBBMap = new HashMap<>();
    private FuncIR initFunc = new FuncIR("__init");

    private FuncIR currentFunc;
    private BasicBlockIR curBB, curLoopAfter, curLoopCondition;
    private VirtualRegisterIR curThisPointor;

    private ImmediateIR ONE = new ImmediateIR(1), ZERO = new ImmediateIR(0);
    private ImmediateIR REGSIZE = new ImmediateIR(Config.getREGSIZE());

    private FuncIR externMalloc;


    private void initBuildInFunc(){
        //TODO
    }

    public IRBuilder(){
        //TODO



        initBuildInFunc();
    }

    private void addVarInitInst(RegisterIR reg, ExprNode initExpr){
        if (initExpr.getType() instanceof BoolType){
            boolAssign(reg, initExpr);
        }
        else {
            initExpr.accept(this);
            curBB.append(new MoveInstIR(reg, initExpr.resultReg));
        }
    }

    private void initFunc(FuncDefNode node){
        funcMap.put(node.getName(), new FuncIR(node.getName()));
    }

    @Override
    public void visit(ProgramNode node) {
        globalScope = currentScope = node.getScope();

        curBB = initFunc.entryBB = new BasicBlockIR(initFunc, "initFuncEntry");
        currentFunc = initFunc;
        for (Node section: node.getSections())
            if (section instanceof VarDefNode){
                VarSymbol var = currentScope.getVar(((VarDefNode) section).getName());
                var.vReg = new VirtualRegisterIR(((VarDefNode) section).getName());
                StaticDataIR staticData = new StaticDataIR();
                staticData.lable = var.getName();
                staticDataList.add(staticData);
                var.vReg.memory = new MemoryIR(staticData);
                if (((VarDefNode) section).getInitExpr() != null)
                    addVarInitInst(var.vReg, ((VarDefNode) section).getInitExpr());
            }
        initFunc.leaveBB = curBB;


        for (Node section: node.getSections())
            if (section instanceof FuncDefNode){
                initFunc((FuncDefNode) section);
            }
            else if (section instanceof ClassDefNode){
                for (FuncDefNode func : ((ClassDefNode) section).getFuncDefs())
                    initFunc(func);
            }

        for (Node section: node.getSections())
            if (!(section instanceof VarDefNode))
                section.accept(this);

        globalScope = currentScope = currentScope.getParent();
    }

    @Override
    public void visit(FuncDefNode node) {
        currentFunc = funcMap.get(node.getName());
        curBB = currentFunc.entryBB = new BasicBlockIR(currentFunc, "entry " + currentFunc.getName());
        //TODO add parameters

        node.getFuncBody().accept(this);

        //TODO merge return && find leaveBB

        currentFunc = null;
    }

    @Override
    public void visit(ClassDefNode node) {
        curThisPointor = new VirtualRegisterIR(String.format("this of %s", node.getName()));
        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);
    }

    @Override
    public void visit(VarDefNode node) {
        VarSymbol var = currentScope.getVar(node.getName());
        var.vReg = new VirtualRegisterIR(node.getName());
        var.vReg.memory = new MemoryIR();
        if (node.getInitExpr() != null)
            addVarInitInst(var.vReg, node.getInitExpr());
    }

    @Override
    public void visit(TypeNode node) {
        assert false;
    }

    @Override
    public void visit(CompStmtNode node) {
        for (Node stmt : node.getStmtlist())
            stmt.accept(this);
    }

    @Override
    public void visit(ExprStmtNode node) {
        node.getExpr().accept(this);
    }

    @Override
    public void visit(IfStmtNode node) {
        BasicBlockIR thenBB = new BasicBlockIR(currentFunc, "Ifthen");
        BasicBlockIR afterBB = new BasicBlockIR(currentFunc, "Ifafter");
        trueBBMap.put(node.getJudgeExpr(), thenBB);
        if (node.getElseStmt() != null){
            BasicBlockIR elseBB = new BasicBlockIR(currentFunc, "Ifelse");
            falseBBMap.put(node.getJudgeExpr(), elseBB);
            node.getJudgeExpr().accept(this);

            curBB = elseBB;
            node.getElseStmt().accept(this);
            elseBB.append(new JumpInstIR(afterBB));
        }
        else{
            falseBBMap.put(node.getJudgeExpr(), afterBB);
            node.getJudgeExpr().accept(this);
        }

        curBB = thenBB;
        node.getThenStmt().accept(this);
        thenBB.append(new JumpInstIR(afterBB));
        curBB = afterBB;
    }

    @Override
    public void visit(WhileStmtNode node) {
        BasicBlockIR condBB = new BasicBlockIR(currentFunc, "whileCondition");
        BasicBlockIR bodyBB = new BasicBlockIR(currentFunc, "whileBody");
        BasicBlockIR afterBB = new BasicBlockIR(currentFunc, "whileAfter");
        curBB.append(new JumpInstIR(condBB));

        trueBBMap.put(node.getJudgeExpr(), bodyBB);
        falseBBMap.put(node.getJudgeExpr(), afterBB);
        curBB = condBB;
        node.getJudgeExpr().accept(this);

        curBB = bodyBB;
        BasicBlockIR oldLoop = curLoopAfter, oldLoopCondition = curLoopCondition;
        curLoopAfter = afterBB;
        curLoopCondition = condBB;
        node.getStmt().accept(this);
        curLoopAfter = oldLoop;
        curLoopCondition = oldLoopCondition;
        bodyBB.append(new JumpInstIR(condBB));

        curBB = afterBB;
    }

    @Override
    public void visit(ForStmtNode node) {
        BasicBlockIR condBB = new BasicBlockIR(currentFunc, "forCondition");
        BasicBlockIR bodyBB = new BasicBlockIR(currentFunc, "forBody");
        BasicBlockIR afterBB = new BasicBlockIR(currentFunc, "forAfter");
        node.getExpr1().accept(this);
        curBB.append(new JumpInstIR(bodyBB));

        trueBBMap.put(node.getExpr2(), bodyBB);
        falseBBMap.put(node.getExpr2(), afterBB);
        curBB = condBB;
        node.getExpr3().accept(this);
        node.getExpr2().accept(this);

        curBB = bodyBB;
        BasicBlockIR oldLoop = curLoopAfter, oldLoopCondition = curLoopCondition;
        curLoopAfter = afterBB;
        curLoopCondition = condBB;
        node.getStmt().accept(this);
        curLoopAfter = oldLoop;
        curLoopCondition = oldLoopCondition;
        bodyBB.append(new JumpInstIR(condBB));

        curBB = afterBB;
    }

    @Override
    public void visit(ContinueStmtNode node) {
        curBB.append(new JumpInstIR(curLoopCondition));
    }

    @Override
    public void visit(BreakStmtNode node) {
        curBB.append(new JumpInstIR(curLoopAfter));
    }

    @Override
    public void visit(ReturnStmtNode node) {
        RegisterIR ret = null;
        if (node.getReturnExpr() != null) {
            node.accept(this);
            if (node.getReturnExpr().resultReg instanceof VirtualRegisterIR)
                ret = node.getReturnExpr().resultReg;
            else {
                ret = new VirtualRegisterIR("retValue");
                curBB.append(new MoveInstIR(ret, node.getReturnExpr().resultReg));
            }
        }
        curBB.append(new ReturnInstIR(ret));
    }

    @Override
    public void visit(BlankStmtNode node) {
        //nothing
    }

    @Override
    public void visit(SuffixExprNode node) {
        UnaryInstIR.Op op = (node.getSuffixOp() == SuffixExprNode.SuffixOp.SUFFIX_DEC) ?
                UnaryInstIR.Op.DEC : UnaryInstIR.Op.INC;
        node.getSubExpr().accept(this);
        node.resultReg = new VirtualRegisterIR("");
        curBB.append(new MoveInstIR((AddressIR) node.resultReg, node.getSubExpr().resultReg));
        curBB.append(new UnaryInstIR(op, (AddressIR) node.getSubExpr().resultReg));
    }

    @Override
    public void visit(FuncCallExprNode node) {
        VirtualRegisterIR returnValue = null;
        if (!(node.getType() instanceof VoidType))
            returnValue = new VirtualRegisterIR(String.format("returnValue of %s", node.getBaseExpr()));
        List<OperandIR> args = new ArrayList<>();
        FuncSymbol func = globalScope.getFunc(node.getFuncName());
        if (func.getBelongClass() != null)
            args.add(node.getBaseExpr().resultReg);
        for (ExprNode arg : node.getArgumentList()){
            arg.accept(this);
            args.add(arg.resultReg);
        }
        curBB.append(new CallInstIR(funcMap.get(node.getFuncName()), args, returnValue));
        if (node.getType() instanceof BoolType){
            curBB.append(new CJumpInstIR(CJumpInstIR.Op.EQ, ONE, returnValue,
                                         trueBBMap.get(node), falseBBMap.get(node)));
        }
        else
            node.resultReg = returnValue;
    }

    @Override
    public void visit(ArrCallExprNode node) {
        node.getSubscriptExpr().accept(this);
        node.getBaseExpr().accept(this);
        VirtualRegisterIR res = new VirtualRegisterIR("array call");
        RegisterIR offset = node.getSubscriptExpr().resultReg;
        RegisterIR base = node.getBaseExpr().resultReg;
        if (offset instanceof ImmediateIR)
            res.memory = new MemoryIR(base, new ImmediateIR(((ImmediateIR) offset).getValue() * (Config.getREGSIZE() / 8)));
        else {
            res.memory = new MemoryIR(base, offset);
            res.memory.setIndexLeftShift(Config.getREGSIZE() / 8);
        }
        node.resultReg = res;
        //TODO uncertaion
    }

    @Override
    public void visit(MemberCallExprNode node) {
        node.getBaseExpr().accept(this);
        if (node.getType() instanceof ArrayType || node.getType() instanceof StringType){
            node.resultReg = node.getBaseExpr().resultReg;
        }
        else if (node.getType() instanceof ClassType){
            Symbol member = currentScope.get(node.getMemberName());
            if (member instanceof FuncSymbol){
                node.resultReg = node.getBaseExpr().resultReg;
            }
            else{
                VirtualRegisterIR res = new VirtualRegisterIR("memCall");
                ClassSymbol memClass = globalScope.getClass(((ClassType) node.getType()).getName());
                res.memory = new MemoryIR(node.getBaseExpr().resultReg, new ImmediateIR(memClass.getVarOffset(node.getMemberName())));
                node.resultReg = res;
            }
        }
    }

    @Override
    public void visit(PrefixExprNode node) {
        UnaryInstIR.Op op = UnaryInstIR.Op.ERROR;
        switch (node.getPrefixOp()){
            case PREFIX_INC : op = UnaryInstIR.Op.INC; break;
            case PREFIX_DEC : op = UnaryInstIR.Op.DEC; break;
            case PLUS       : op = UnaryInstIR.Op.NULL; break;
            case MINUS      : op = UnaryInstIR.Op.NEG; break;
            case INV        : op = UnaryInstIR.Op.INV; break;
            case NOT        : {
                BasicBlockIR trueBB = trueBBMap.get(node);
                BasicBlockIR falseBB = falseBBMap.get(node);
                trueBBMap.put(node.getSubExpr(), falseBB);
                falseBBMap.put(node.getSubExpr(), trueBB);
                node.getSubExpr().accept(this);
                return;
            }
            default: assert false;
        }
        node.getSubExpr().accept(this);
        node.resultReg = node.getSubExpr().resultReg;
        curBB.append(new UnaryInstIR(op, node.resultReg));
    }

    private VirtualRegisterIR allocaClass(String name){
        VirtualRegisterIR res = new VirtualRegisterIR("new_Class");
        if (name.equals("string")){
            curBB.append(new CallInstIR(externMalloc,
                    Collections.singletonList(new ImmediateIR(Config.getREGSIZE() * 2)), res));
            curBB.append(new MoveInstIR(res, ZERO));
            curBB.append(new BinaryInstIR(BinaryInstIR.Op.ADD, res, REGSIZE));
            curBB.append(new MoveInstIR(res, ZERO));
            curBB.append(new BinaryInstIR(BinaryInstIR.Op.SUB, res, REGSIZE));
        }
        else{
            ClassSymbol symbol = globalScope.getClass(name);
            curBB.append(new CallInstIR(externMalloc, Collections.singletonList(new ImmediateIR(symbol.getSize())), res));
            FuncIR constructor = funcMap.getOrDefault(name, null);
            if (constructor != null) {
                VirtualRegisterIR tmp = new VirtualRegisterIR("tmp");
                curBB.append(new MoveInstIR(tmp, res));
                curBB.append(new CallInstIR(constructor, Collections.singletonList(tmp), res));
            }
        }
        return res;
    }

    private VirtualRegisterIR allocaArray(int order, List<RegisterIR> dims){
        assert(order > 0 && !dims.isEmpty());
        VirtualRegisterIR res = new VirtualRegisterIR("arrayNew");
        RegisterIR dim = dims.get(0);
        dims.remove(0);

        VirtualRegisterIR size = new VirtualRegisterIR("new_size");
        curBB.append(new MoveInstIR(size, dim));
        curBB.append(new BinaryInstIR(BinaryInstIR.Op.MUL, size, dim));
        curBB.append(new CallInstIR(externMalloc, Collections.singletonList(size), res));
        if (dims.size() == 1)
            return res;

        BasicBlockIR condBB = new BasicBlockIR(currentFunc, "newWhileCondition");
        BasicBlockIR bodyBB = new BasicBlockIR(currentFunc, "newWhileBody");
        BasicBlockIR afterBB = new BasicBlockIR(currentFunc, "newWhileAfter");
        VirtualRegisterIR end = size;
        curBB.append(new BinaryInstIR(BinaryInstIR.Op.ADD, end, res));
        curBB.append(new JumpInstIR(condBB));
        condBB.append(new CJumpInstIR(CJumpInstIR.Op.EQ, res, end, afterBB, bodyBB));
        curBB = bodyBB;
        curBB.append(new MoveInstIR(res, allocaArray(order - 1, dims)));

        curBB.append(new BinaryInstIR(BinaryInstIR.Op.ADD, res, REGSIZE));
        curBB.append(new JumpInstIR(condBB));
        curBB = afterBB;
        curBB.append(new BinaryInstIR(BinaryInstIR.Op.SUB, res, dim));
        return res;
    }

    @Override
    public void visit(NewExprNode node) {
        if (node.getDims().isEmpty()) {
            if (node.getBaseType().getType() instanceof  ClassType){
                node.resultReg = allocaClass(((ClassType) node.getBaseType().getType()).getName());
            }
            else if (node.getBaseType().getType() instanceof  StringType)
                node.resultReg = allocaClass("string");
            else
                throw new IRError("new " + node.getBaseType().getType() + " is invalid");
        }
        else {
            List<RegisterIR> dims = new ArrayList<>();
            for(ExprNode dim : node.getDims()){
                dim.accept(this);
                dims.add(dim.resultReg);
            }
            node.resultReg = allocaArray(node.getOrder(), dims);
        }
    }

    private void doLogicBinaryExpr(BinaryExprNode node, ExprNode lhs, ExprNode rhs){
        BasicBlockIR nextLogicBB = new BasicBlockIR(currentFunc, "logicNext");

        if (node.getOp() == BinaryExprNode.Op.ANDAND){
            trueBBMap.put(lhs, nextLogicBB);
            falseBBMap.put(lhs, falseBBMap.get(node));
        }
        else{
            trueBBMap.put(lhs, trueBBMap.get(node));
            falseBBMap.put(lhs, nextLogicBB);
        }
        lhs.accept(this);

        curBB = nextLogicBB;
        trueBBMap.put(rhs, trueBBMap.get(node));
        falseBBMap.put(rhs, falseBBMap.get(node));
        rhs.accept(this);
    }

    private void doRelationBinaryExpr(BinaryExprNode node, ExprNode lhs, ExprNode rhs){
        CJumpInstIR.Op op = CJumpInstIR.Op.ERROR;
        switch (node.getOp()){
            case LESS       : op = CJumpInstIR.Op.L; break;
            case LARGE      : op = CJumpInstIR.Op.G; break;
            case LESS_EQUAL : op = CJumpInstIR.Op.LE; break;
            case LARGE_EQUAL: op = CJumpInstIR.Op.GE; break;
            case EQUAL      : op = CJumpInstIR.Op.EQ; break;
            case UNEQUAL    : op = CJumpInstIR.Op.NEQ; break;
            default         : assert false;
        }
        lhs.accept(this);
        rhs.accept(this);
        //TODO deal with String cmp String
        curBB.append(new CJumpInstIR(op, lhs.resultReg, rhs.resultReg,
                                    trueBBMap.get(node), falseBBMap.get(node)));
    }

    private void doArithmeticBinaryExpr(BinaryExprNode node, ExprNode lhs, ExprNode rhs){
        node.resultReg = new VirtualRegisterIR("airthmeticBinary");
        BinaryInstIR.Op op = BinaryInstIR.Op.ERROR;
        switch (node.getOp()){
            case MUL    : op = BinaryInstIR.Op.MUL; break;
            case DIV    : op = BinaryInstIR.Op.DIV; break;
            case MOD    : op = BinaryInstIR.Op.MOD; break;
            case PLUS   : op = BinaryInstIR.Op.ADD; break;
            case MINUS  : op = BinaryInstIR.Op.SUB; break;
            case LSH    : op = BinaryInstIR.Op.SHL; break;
            case RSH    : op = BinaryInstIR.Op.SHR; break;
            case AND    : op = BinaryInstIR.Op.AND; break;
            case XOR    : op = BinaryInstIR.Op.XOR; break;
            case OR     : op = BinaryInstIR.Op.OR; break;
            default: assert false;
        }
        lhs.accept(this);
        rhs.accept(this);
        //TODO deal with str + str
        curBB.append(new MoveInstIR(node.resultReg, lhs.resultReg));
        curBB.append(new BinaryInstIR(op, node.resultReg, rhs.resultReg));
    }

    @Override
    public void visit(BinaryExprNode node) {
        ExprNode lhs = node.getLeftExpr(), rhs = node.getRightExpr();
        switch (node.getOp()){
            case MUL:
            case DIV:
            case MOD:
            case PLUS:
            case MINUS:
            case LSH:
            case RSH:
            case AND:
            case XOR:
            case OR:
                doArithmeticBinaryExpr(node, lhs, rhs);

            case LESS:
            case LARGE:
            case LESS_EQUAL:
            case LARGE_EQUAL:
            case EQUAL:
            case UNEQUAL:
                doRelationBinaryExpr(node, lhs, rhs);
                break;

            case ANDAND:
            case OROR:
                doLogicBinaryExpr(node, lhs, rhs);
        }


    }

    //lhs accepted, rsh haven't accepted
    private void boolAssign(AddressIR dest, ExprNode rhs){
        BasicBlockIR trueBB = new BasicBlockIR(currentFunc, "assignTrue");
        BasicBlockIR falseBB = new BasicBlockIR(currentFunc, "assignFalse");
        BasicBlockIR afterBB = new BasicBlockIR(currentFunc, "assignafter");
        trueBBMap.put(rhs, trueBB);
        falseBBMap.put(rhs, falseBB);
        rhs.accept(this);
        trueBB.append(new MoveInstIR(dest, ONE));
        trueBB.append(new JumpInstIR(afterBB));
        falseBB.append(new MoveInstIR(dest, ZERO));
        falseBB.append(new JumpInstIR(afterBB));
        curBB = afterBB;
    }

    private void valueAssign(ExprNode lhs, ExprNode rhs){
        rhs.accept(this);
        curBB.append(new MoveInstIR((AddressIR) lhs.resultReg, rhs.resultReg));
    }

    @Override
    public void visit(AssignExprNode node) {
        ExprNode lhs = node.getLeftExpr(), rhs = node.getRightExpr();
        lhs.accept(this);
        if (rhs.getType() instanceof BoolType)
            boolAssign(lhs.resultReg, rhs);
        else
            valueAssign(lhs, rhs);
    }

    @Override
    public void visit(IdentExprNode node) {
        if (node.isVar()){
            VirtualRegisterIR reg = new VirtualRegisterIR(node.getName());
            VarSymbol var = currentScope.getVar(node.getName());
            if(var.vReg == null)
                throw new IRError("varReg " + node.getName() + " used before define");
            curBB.append(new MoveInstIR(reg, var.vReg));
            node.resultReg = reg;
        }
        else if (node.isFunc()){
            throw new IRError("find FuncCall  dealing with Identifier");
        }

    }

    @Override
    public void visit(ThisExprNode node) {
        node.resultReg = curThisPointor;
    }

    @Override
    public void visit(IntConstExprNode node) {
        node.resultReg = new ImmediateIR(node.getValue());
    }

    @Override
    public void visit(StringConstExprNode node) {
        VirtualRegisterIR vreg = new VirtualRegisterIR("constString");
        StaticDataIR staticData = new StaticDataIR(node.getString());
        staticDataList.add(staticData);
        vreg.memory = new MemoryIR(staticData);
        node.resultReg = vreg;
    }

    @Override
    public void visit(BoolConstExprNode node) {
        if (node.getValue() == BoolConstExprNode.BoolValue.TRUE)
            curBB.append(new JumpInstIR(trueBBMap.get(node)));
        else
            curBB.append(new JumpInstIR(falseBBMap.get(node)));
    }

    @Override
    public void visit(NullExprNode node) {
        node.resultReg = ZERO;
    }


}
