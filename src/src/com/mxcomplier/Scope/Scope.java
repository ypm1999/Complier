package com.mxcomplier.Scope;

import com.mxcomplier.AST.Location;
import com.mxcomplier.Error.ComplierError;
import com.mxcomplier.Type.ClassType;
import com.mxcomplier.Type.FuncType;

import java.util.HashMap;

public class Scope {
    private Scope parent;
    private HashMap<String, Symbol> identMap = new HashMap<>();

    public Scope() {
        this.parent = null;
    }

    public Scope(Scope parent) {
        this.parent = parent;
    }


    public void put(Symbol symbol, Location location) {
        if (identMap.containsKey(symbol.getName()))
            throw new ComplierError(location, String.format("Symbol %s is decleared before", symbol.getName()));
        else identMap.put(symbol.getName(), symbol);
    }

    public void put(Symbol symbol) {
        if (identMap.containsKey(symbol.getName()))
            throw new ComplierError(String.format("Symbol %s is decleared before", symbol.getName()));
        else identMap.put(symbol.getName(), symbol);
    }

    public Symbol getSelf(String name, Location location) {
        if (!identMap.containsKey(name))
            throw new ComplierError(location, String.format("Symbol %s is not decleared", name));
        else
            return identMap.get(name);
    }

    public Symbol get(String name, Location location) {
        if (!identMap.containsKey(name))
            if (parent != null)
                return parent.get(name, location);
            else
                throw new ComplierError(location, String.format("Symbol %s is not decleared", name));
        else
            return identMap.get(name);
    }

    public ClassSymbol getClass(String name, Location location) {
        if (!identMap.containsKey(name))
            if (parent != null)
                return parent.getClass(name, location);
            else
                throw new ComplierError(location, String.format("Class %s is not decleared", name));
        else {
            Symbol symbol = identMap.get(name);
            if (symbol.getType() instanceof ClassType)
                return (ClassSymbol) symbol;
            else
                throw new ComplierError(location, String.format("Class %s is not decleared as class", name));
        }
    }

    public FuncSymbol getFunc(String name, Location location) {
        if (!identMap.containsKey(name))
            if (parent != null)
                return parent.getFunc(name, location);
            else
                throw new ComplierError(location, String.format("Function %s is not decleared", name));
        else {
            Symbol symbol = identMap.get(name);
            if (symbol.getType() instanceof FuncType)
                return (FuncSymbol) symbol;
            else
                throw new ComplierError(location, String.format("Function %s is not decleared as class", name));
        }
    }


    public VarSymbol getVar(String name, Location location) {
        if (!identMap.containsKey(name))
            if (parent != null)
                return parent.getVar(name, location);
            else
                throw new ComplierError(location, String.format("Variable %s is not decleared", name));
        else {
            Symbol symbol = identMap.get(name);
            if (!(symbol.getType() instanceof FuncType || symbol.getType() instanceof ClassType))
                return (VarSymbol) symbol;
            else
                throw new ComplierError(location, String.format("Variable %s is not decleared as class", name));
        }
    }


    public Scope getParent() {
        return parent;
    }

    public void setParent(Scope parent) {
        this.parent = parent;
    }

    public boolean isTop() {
        return parent == null;
    }
}
