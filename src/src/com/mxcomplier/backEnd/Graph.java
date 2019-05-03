package com.mxcomplier.backEnd;

import com.mxcomplier.Error.IRError;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;

import java.util.HashMap;
import java.util.HashSet;

public class Graph{
    private HashMap<VirtualRegisterIR, HashSet<VirtualRegisterIR>> graphLink = new HashMap<>();

    void addPoint(VirtualRegisterIR p){
        if (!graphLink.containsKey(p))
            graphLink.put(p, new HashSet<>());
    }

    void removePoint(VirtualRegisterIR p){
        graphLink.remove(p);
    }

    void addEdge(VirtualRegisterIR u, VirtualRegisterIR v){
        if (u == v)
            throw new IRError("add self-loop edge");
        graphLink.get(u).add(v);
        graphLink.get(v).add(u);
    }

    void addEdges(HashSet<VirtualRegisterIR> u, HashSet<VirtualRegisterIR> v){
        for(VirtualRegisterIR x:u)
            for (VirtualRegisterIR y:v)
                addEdge(x, y);
    }

    void removeEdge(VirtualRegisterIR u, VirtualRegisterIR v){
        if (u == v)
            throw new IRError("add self-loop edge");
        graphLink.get(u).remove(v);
        graphLink.get(v).remove(u);
    }

    HashSet<VirtualRegisterIR> getNeighbor(VirtualRegisterIR u){
        return graphLink.get(u);
    }

    void clear(){
        graphLink.clear();
    }
}
