package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Scope.ClassSymbol;
import com.mxcomplier.Scope.Scope;
import com.mxcomplier.Scope.Symbol;
import com.mxcomplier.Type.*;

import java.util.ArrayList;
import java.util.List;

public class ScopeBuilderASTScanner extends ASTScanner{

    static private Location startLocation = new Location(0,0);
    static private TypeNode intType = new TypeNode(IntType.getInstance(), startLocation);
    static private TypeNode voidType = new TypeNode(VoidType.getInstance(), startLocation);
    static private TypeNode boolType = new TypeNode(BoolType.getInstance(), startLocation);
    static private TypeNode stringType = new TypeNode(StringType.getInstance(), startLocation);

    private void addBuildInFunc(Scope scope, String name, TypeNode returnType, List<TypeNode> args){
    }

    private void prepareGlobalScope(){
        Scope stringScope = new Scope(currentScope);
        Scope arrayScope = new Scope(currentScope);

        List<TypeNode> args = new ArrayList<>();
        addBuildInFunc(stringScope, "length", intType, args);
        addBuildInFunc(stringScope, "parseInt", voidType, args);
        addBuildInFunc(arrayScope, "size", intType, args);
        addBuildInFunc(currentScope, "getString", stringType, args);
        addBuildInFunc(currentScope, "getInt", intType, args);
        args.add(stringType);
        addBuildInFunc(currentScope, "print", voidType, args);
        addBuildInFunc(currentScope, "println", voidType, args);
        args.clear();
        args.add(intType);
        addBuildInFunc(stringScope, "ord", intType, args);
        addBuildInFunc(currentScope, "toString", stringType, args);
        args.add(intType);
        addBuildInFunc(stringScope, "subString", stringType, args);

        ClassDefNode node = new ClassDefNode("String", null, null, new Location(0,0));
        node.setScope(stringScope);
        Symbol symbol = new ClassSymbol("String", node);
        currentScope.put("String", symbol);

        node = new ClassDefNode("Array", null, null, new Location(0, 0));
        node.setScope(stringScope);
        symbol = new ClassSymbol("Array", node);
        currentScope.put("Array", symbol);
    }


    @Override
    public void visit(ProgramNode node) {

    }

    @Override
    public void visit(FuncDefNode node) {

    }

    @Override
    public void visit(ClassDefNode node) {

    }

    @Override
    public void visit(VarDefNode node) {

    }

    @Override
    public void visit(TypeNode node) {

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

    }

    @Override
    public void visit(BinaryExprNode node) {

    }

    @Override
    public void visit(AssignExprNode node) {

    }

    @Override
    public void visit(IdentExprNode node) {

    }

    @Override
    public void visit(ThisExprNode node) {

    }

    @Override
    public void visit(IntConstExprNode node) {

    }

    @Override
    public void visit(StringConstExprNode node) {

    }

    @Override
    public void visit(BoolConstExprNode node) {

    }

    @Override
    public void visit(NullExprNode node) {

    }
}
