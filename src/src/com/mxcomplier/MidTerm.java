package com.mxcomplier;

import com.mxcomplier.AST.ProgramNode;
import com.mxcomplier.FrontEnd.ASTBuilder;
import com.mxcomplier.LaxerParser.MxStarLexer;
import com.mxcomplier.LaxerParser.MxStarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;

public class MidTerm {
    private ProgramNode ast;
    public void main() {
        try{
            InputStream codeInput= System.in;
            CharStream charInput = CharStreams.fromStream(codeInput);
            MxStarLexer lexer = new MxStarLexer(charInput);
            CommonTokenStream token= new CommonTokenStream(lexer);
            MxStarParser parser = new MxStarParser(token);
            ParseTree tree = parser.program();
            ASTBuilder astBuilder = new ASTBuilder();
            ast = (ProgramNode) astBuilder.visit(tree);

        }
        catch (Exception e) {
            System.exit(-1);
        }
    }

}
