package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Error.IRError;
import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.MoveInstIR;
import com.mxcomplier.Ir.Operands.*;
import com.mxcomplier.Scope.Scope;
import com.mxcomplier.Scope.VarSymbol;
import com.mxcomplier.Type.BoolType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IRBuilder extends ASTScanner{
    private Scope globalScope;
    private List<StaticDataIR> staticDataList = new ArrayList<>();
    private Map<String, FuncIR> funcMap = new HashMap<>();
    private FuncIR initFunc;
    private FuncIR currentFunc;
    private BasicBlockIR curBB;
    private VirtualRegisterIR curThisPointor;


    private void initBuildInFunc(){
        //TODO
    }

    public IRBuilder(Scope globalScope){
        this.globalScope = globalScope;
        //TODO
        initBuildInFunc();
    }

    private void addVarInitInst(FuncIR func, VarDefNode var){
        if (var.getInitExpr() == null)
            throw new IRError("init global var");
        //TODO
    }

    private void initFunc(FuncDefNode node){
        funcMap.put(node.getName(), new FuncIR(node.getName()));
    }

    @Override
    public void visit(ProgramNode node) {
        globalScope = currentScope = node.getScope();

        for (Node section: node.getSections())
            if (section instanceof VarDefNode){
                VarSymbol var = currentScope.getVar(((VarDefNode) section).getName());
                var.vReg = new VirtualRegisterIR(((VarDefNode) section).getName());
                StaticDataIR staticData = new StaticDataIR();
                staticData.lable = var.getName();
                staticDataList.add(staticData);
                var.vReg.memory = new MemoryIR(staticData);
                if (((VarDefNode) section).getInitExpr() != null)
                    addVarInitInst(initFunc, (VarDefNode) section);
            }

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
        //TODO set curThisPointor
        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);
    }

    @Override
    public void visit(VarDefNode node) {

    }

    @Override
    public void visit(TypeNode node) {

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

    }

    @Override
    public void visit(WhileStmtNode node) {

    }

    @Override
    public void visit(ForStmtNode node) {

    }

    @Override
    public void visit(ContinueStmtNode node) {

    }

    @Override
    public void visit(BreakStmtNode node) {

    }

    @Override
    public void visit(ReturnStmtNode node) {

    }

    @Override
    public void visit(BlankStmtNode node) {

    }

    @Override
    public void visit(SuffixExprNode node) {

    }

    @Override
    public void visit(FuncCallExprNode node) {

    }

    @Override
    public void visit(ArrCallExprNode node) {

    }

    @Override
    public void visit(MemberCallExprNode node) {

    }

    @Override
    public void visit(PrefixExprNode node) {

    }

    @Override
    public void visit(NewExprNode node) {

    }

    @Override
    public void visit(BinaryExprNode node) {

    }

    private void boolAssign(ExprNode lhs, ExprNode rhs){

    }

    private void valueAssign(ExprNode lhs, ExprNode rhs){
        rhs.accept(this);
        curBB.append(new MoveInstIR((AddressIR) lhs.getResultReg(), rhs.getResultReg()));
    }

    @Override
    public void visit(AssignExprNode node) {
        ExprNode lhs = node.getLeftExpr(), rhs = node.getRightExpr();
        lhs.accept(this);
        assert(lhs.getResultReg() instanceof AddressIR);
        if (rhs.getType() instanceof BoolType)
            boolAssign(lhs, rhs);
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
            node.setResultOperand(reg);
        }
        else if (node.isFunc()){
            throw new IRError("find FuncCall  dealing with Identifier");
        }

    }

    @Override
    public void visit(ThisExprNode node) {
        node.setResultOperand(curThisPointor);
    }

    @Override
    public void visit(IntConstExprNode node) {
        node.setResultOperand(new ImmediateIR(node.getValue()));
    }

    @Override
    public void visit(StringConstExprNode node) {
        VirtualRegisterIR vreg = new VirtualRegisterIR("constString");
        StaticDataIR staticData = new StaticDataIR(node.getString());
        vreg.memory = new MemoryIR(staticData);
        node.setResultOperand(vreg);
    }

    @Override
    public void visit(BoolConstExprNode node) {
        if (node.getValue() == BoolConstExprNode.BoolValue.TRUE)
            node.setResultOperand(new ImmediateIR(1));
        else
            node.setResultOperand(new ImmediateIR(0));
    }

    @Override
    public void visit(NullExprNode node) {
        node.setResultOperand(new ImmediateIR(0));
    }


}
