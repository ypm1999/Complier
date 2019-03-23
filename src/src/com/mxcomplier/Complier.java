package com.mxcomplier;

import com.mxcomplier.AST.ProgramNode;
import com.mxcomplier.FrontEnd.ASTBuilder;
import com.mxcomplier.LaxerParser.MxStarLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.InputStream;

public class Complier {
    private ProgramNode ast;
    private InputStream codeInput;

    public Complier(InputStream codeInput){
        this.codeInput = codeInput;
    }

    private void buildAST() throws Exception  {

    }


    public boolean run() throws Exception {
        try{
            buildAST();
            return true;
        }
        catch (Error error){
            return false;
        }
    }
}
