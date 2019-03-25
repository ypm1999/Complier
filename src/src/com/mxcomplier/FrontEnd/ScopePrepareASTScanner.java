package com.mxcomplier.FrontEnd;

import com.mxcomplier.AST.*;
import com.mxcomplier.Scope.*;
import com.mxcomplier.Type.IntType;
import com.mxcomplier.Type.StringType;
import com.mxcomplier.Type.Type;
import com.mxcomplier.Type.VoidType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScopePrepareASTScanner extends ASTScanner{

    private void addBuildInFunc(Scope scope, String name, Type returnType, List<Symbol> args){
        scope.put(new FuncSymbol(name, returnType, null, args));
    }

    private void prepareGlobalScope(){
        Scope stringScope = new Scope(currentScope);
        Scope arrayScope = new Scope(currentScope);

        Type intType = IntType.getInstance();
        Type voidType = VoidType.getInstance();
        Type stringType = StringType.getInstance();

        addBuildInFunc(stringScope, "length", intType, new ArrayList<>());
        addBuildInFunc(stringScope, "parseInt", voidType, new ArrayList<>());
        addBuildInFunc(arrayScope, "size", intType, new ArrayList<>());
        addBuildInFunc(currentScope, "getString", stringType, new ArrayList<>());
        addBuildInFunc(currentScope, "getInt", intType, new ArrayList<>());

        addBuildInFunc(currentScope, "print", voidType,
                Collections.singletonList(new VarSymbol("str", stringType)));

        addBuildInFunc(currentScope, "println", voidType,
                Collections.singletonList(new VarSymbol("str", stringType)));

        addBuildInFunc(stringScope, "ord", intType,
                Collections.singletonList(new VarSymbol("pos", intType)));

        addBuildInFunc(currentScope, "toString", stringType,
                Collections.singletonList(new VarSymbol("i", intType)));

        addBuildInFunc(stringScope, "subString", stringType,
                Arrays.asList(new VarSymbol("left", intType), new VarSymbol("right", intType)));

//        currentScope.put(new ClassSymbol("int", new Scope(currentScope)));
//        currentScope.put(new ClassSymbol("bool", new Scope(currentScope)));
//        currentScope.put(new ClassSymbol("void", new Scope(currentScope)));
        currentScope.put(new ClassSymbol("string", stringScope));
        currentScope.put(new ClassSymbol("__array", arrayScope));
    }

    @Override
    public void visit(ProgramNode node) {
        currentScope = node.getScope();

        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);
        for (ClassDefNode classes: node.getClassDefs())
            classes.accept(this);

        currentScope = currentScope.getParent();
    }

    @Override
    public void visit(FuncDefNode node) {
        Symbol symbol = new FuncSymbol(node.getName(), node);
        currentScope.put(symbol, node.getLocation());

        node.getScope().setParent(currentScope);
    }

    @Override
    public void visit(ClassDefNode node) {
        Symbol symbol = new ClassSymbol(node.getName(), node);
        currentScope.put(symbol, node.getLocation());

        node.getScope().setParent(currentScope);
        currentScope = node.getScope();

        for (FuncDefNode func : node.getFuncDefs())
            func.accept(this);

        currentScope = currentScope.getParent();
    }
}
