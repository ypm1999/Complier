package com.mxcomplier.backEnd;

import com.mxcomplier.FrontEnd.IRBuilder;
import com.mxcomplier.Ir.BasicBlockIR;
import com.mxcomplier.Ir.FuncIR;
import com.mxcomplier.Ir.Instructions.*;
import com.mxcomplier.Ir.Operands.StaticDataIR;
import com.mxcomplier.Ir.ProgramIR;

import java.util.List;

public class NasmPrinter extends IRScanner {
    private String indentation = "";

    public NasmPrinter(IRBuilder builder){
        this.builder = builder;
    }

    private void println(String str){
        str = str.replace("\n", "\n"+indentation);
        System.out.println(indentation+str);
    }


    private void indent(){
        indentation += '\t';
    }

    private void unindent(){
        indentation = indentation.substring(1);
    }

    private void init_print(List<StaticDataIR> staticData){
        println("default rel");
        println("global start");
        println("section .data");
        indent();
        for (StaticDataIR data : staticData){
            println(data.lable + ':');
            indent();
            println(data.nasmString());
            unindent();
        }
        unindent();
        println("");
        println("section .text\n");
        println("start:");
        indent();
        println("call __init");
        println("call main");
        println("jmp __done");
        unindent();
        println("");
    }


    @Override
    public void visit(BasicBlockIR node) {
        InstIR inst = node.getHead().next;
        indent();
        while(inst != node.getTail()){
            inst.accept(this);
            inst = inst.next;
        }
        unindent();
    }

    @Override
    public void visit(ProgramIR node) {
        init_print(node.getStaticData());
        for (FuncIR func : node.getFuncs()){
            func.accept(this);
        }
        println("__done:");
    }

    @Override
    public void visit(FuncIR node) {
        println(String.format("%s:", node.getName()));
        indent();
        for (BasicBlockIR bb : node.getBBList()){
            println(String.format("%s:", bb));
            bb.accept(this);
        }
        unindent();
        println("");
//        println(";********************************************************************************\n");
    }


    @Override
    public void visit(CallInstIR node) {
        println(node.nasmString());
    }

    @Override
    public void visit(UnaryInstIR node) {
        println(node.toString());
    }

    @Override
    public void visit(JumpInstIR node) {
        println(node.toString());
    }

    @Override
    public void visit(CJumpInstIR node) {
        println(node.nasmString());
    }

    @Override
    public void visit(CompInstIR node) {
        println(node.nasmString());
    }

    @Override
    public void visit(BinaryInstIR node) {
        println(node.nasmString());
    }

    @Override
    public void visit(MoveInstIR node) {
        println(node.nasmString());
    }

    @Override
    public void visit(PopInstIR node) {
        println(node.nasmString());
    }

    @Override
    public void visit(PushInstIR node) {
        println(node.nasmString());
    }

    @Override
    public void visit(ReturnInstIR node) {
        println(node.toString());
    }

}
