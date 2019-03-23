package com.mxcomplier.Scope;

import java.util.HashMap;

public class Scope {
    private Scope parent;

    public Scope(){
        this.parent = null;
    }

    public Scope(Scope parent){
        this.parent = parent;
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
