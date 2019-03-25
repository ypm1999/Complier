package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Error.ComplierError;
import com.mxcomplier.Scope.*;
import com.mxcomplier.Type.*;



public class ScopeBuilderASTScanner extends ASTScanner{
    private ClassSymbol currentClass = null;


    private void checkVarInit(VarDefNode node){
        ExprNode initExpr = node.getInitExpr();
        if (initExpr != null){
            boolean valid = !node.isFuncArgs();
            initExpr.accept(this);



            if (!valid)
                throw new ComplierError(node.getLocation(), "Variable initialization is invalid");
        }

    }

    @Override
    public void visit(ProgramNode node) {
        currentScope = node.getScope();

        for (ClassDefNode classes: node.getClassDefs())
            classes.accept(this);

        currentScope = currentScope.getParent();
    }

    @Override
    public void visit(FuncDefNode node) {
        currentScope = node.getScope();

        for (VarDefNode arg : node.getParameters())
            arg.accept(this);



        currentScope = currentScope.getParent();
    }

    @Override
    public void visit(ClassDefNode node) {
        currentClass = currentScope.getClass(node.getName(), node.getLocation());
        currentScope = node.getScope();

        for (VarDefNode vars : node.getMemberDefs())
            vars.accept(this);

        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);//vistor

        currentScope = currentScope.getParent();
        currentClass = null;
    }

    @Override
    public void visit(VarDefNode node) {
        checkVarInit(node);
        if (!node.isMemberDef())
            currentScope.put(new VarSymbol(node.getName(), node.getType().getType()));
    }

    @Override
    public void visit(TypeNode node) {
        switch (node.getType().getHyperType()){
            case INT:
                break;
            case BOOL:
                break;
            case STRING:
                break;
            case VOID:
                break;
            case NULL:
                break;
            case ARRAY:
                break;
            case CLASS:
                break;
            case FUNC:
                break;
        }
    }

    @Override
    public void visit(CompStmtNode node) {

    }

    @Override
    public void visit(ExprStmtNode node) {

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
        for(ExprNode dim : node.getDims()){
            dim.accept(this);
            if (!(dim.getType() instanceof IntType))
                throw new ComplierError(node.getLocation(), "dim of array must be int");
        }
        node.setLeftValue(false);
        node.setType(node.getBaseType().getType());
    }

    @Override
    public void visit(BinaryExprNode node) {
        node.getLeftExpr().accept(this);
        node.getRightExpr().accept(this);
        Type lType = node.getLeftExpr().getType(), rType = node.getRightExpr().getType();
        BinaryExprNode.Op op = node.getOp();

        boolean valid;
        switch (lType.getHyperType()){
            case INT:
                valid = true;
                break;
            case BOOL:
                switch (op) {
                    case MUL:
                    case DIV:
                    case MOD:
                    case PLUS:
                    case MINUS:
                    case LSH:
                    case RSH:
                        valid = false;
                        break;
                    default:
                        valid = true;
                }
                break;
            case STRING:
                switch (op){
                    case PLUS:
                    case EQUAL:
                    case LESS:
                    case LARGE:
                    case LESS_EQUAL:
                    case LARGE_EQUAL:
                    case UNEQUAL:
                        valid = true;
                        break;
                    default:
                        valid = false;
                }
                break;
            default: valid = false;
        }

        if (!valid || !lType.equals(rType))
            throw new ComplierError(node.getLocation(),
                    String.format("type error with: %s %s %s", lType.toString(), op.toString(), rType.toString()));

        node.setLeftValue(false);
        node.setType(lType);
    }

    @Override
    public void visit(AssignExprNode node) {
        node.getLeftExpr().accept(this);
        node.getRightExpr().accept(this);
        Type lType = node.getLeftExpr().getType(), rType = node.getRightExpr().getType();

        if (!node.getLeftExpr().isLeftValue())
            throw new ComplierError(node.getLocation(),
                    String.format("left value(%s) is not assignable", lType.toString()));

        if (!lType.equals(rType) &&
            !(lType instanceof ArrayType || rType instanceof NullType))
            throw new ComplierError(node.getLocation(),
                    String.format("type error with %s and %s", lType.toString(), rType.toString()));


        node.setLeftValue(false);
        node.setType(lType);
    }

    @Override
    public void visit(IdentExprNode node) {
        Symbol symbol = currentScope.get(node.getName(), node.getLocation());
        if (symbol instanceof VarSymbol){
            node.setLeftValue(true);
            node.setType(symbol.getType());
        }
        else if (symbol instanceof FuncSymbol){
            node.setLeftValue(false);
            node.setType(((FuncSymbol) symbol).getReturnType());
        }
        else
            throw new ComplierError(node.getLocation(), "Identifier must be a variable or function");

    }

    @Override
    public void visit(ThisExprNode node) {
        if (currentClass == null)
            throw new ComplierError(node.getLocation(), "this pointer is not in class");
        node.setType(currentClass.getType());
        node.setLeftValue(false);
    }

    @Override
    public void visit(IntConstExprNode node) {
        node.setType(IntType.getInstance());
        node.setLeftValue(false);
    }

    @Override
    public void visit(StringConstExprNode node) {
        node.setType(StringType.getInstance());
        node.setLeftValue(false);
    }

    @Override
    public void visit(BoolConstExprNode node) {
        node.setType(BoolType.getInstance());
        node.setLeftValue(false);
    }

    @Override
    public void visit(NullExprNode node) {
        node.setType(NullType.getInstance());
        node.setLeftValue(false);
    }
}
