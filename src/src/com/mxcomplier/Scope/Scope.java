package com.mxcomplier.Scope;

import java.util.HashMap;

public class Scope {
    private Scope parent;
    private boolean isTop;

    public Scope(Scope parent){
        this.parent = parent;
        this.isTop = parent == null;
    }

    public Scope getParent() {
        return parent;
    }

    public boolean getIsTop() {
        return isTop;
    }
}
