package com.mxcomplier.Ir;

import com.mxcomplier.Ir.Operands.PhysicalRegisterIR;
import com.mxcomplier.Ir.Operands.VirtualRegisterIR;

import java.security.PublicKey;

public class RegisterSet {

    static public PhysicalRegisterIR rax = new PhysicalRegisterIR("rax");
    static public PhysicalRegisterIR rcx = new PhysicalRegisterIR("rcx");
    static public PhysicalRegisterIR rdx = new PhysicalRegisterIR("rdx");
    static public PhysicalRegisterIR rbx = new PhysicalRegisterIR("rbx");
    static public PhysicalRegisterIR rsp = new PhysicalRegisterIR("rsp");
    static public PhysicalRegisterIR rbp = new PhysicalRegisterIR("rbp");
    static public PhysicalRegisterIR rsi = new PhysicalRegisterIR("rsi");
    static public PhysicalRegisterIR rdi = new PhysicalRegisterIR("rdi");
    static public PhysicalRegisterIR r8 = new PhysicalRegisterIR("r8");
    static public PhysicalRegisterIR r9 = new PhysicalRegisterIR("r9");
    static public PhysicalRegisterIR r10 = new PhysicalRegisterIR("r10");
    static public PhysicalRegisterIR r11 = new PhysicalRegisterIR("r11");
    static public PhysicalRegisterIR r12 = new PhysicalRegisterIR("r12");
    static public PhysicalRegisterIR r13 = new PhysicalRegisterIR("r13");
    static public PhysicalRegisterIR r14 = new PhysicalRegisterIR("r14");
    static public PhysicalRegisterIR r15 = new PhysicalRegisterIR("r15");


    static public VirtualRegisterIR Vrax = new VirtualRegisterIR("Vrax", rax);
    static public VirtualRegisterIR Vrcx = new VirtualRegisterIR("Vrcx", rcx);
    static public VirtualRegisterIR Vrdx = new VirtualRegisterIR("Vrdx", rdx);
    static public VirtualRegisterIR Vrbx = new VirtualRegisterIR("Vrbx", rbx);
    static public VirtualRegisterIR Vrsp = new VirtualRegisterIR("Vrsp", rsp);
    static public VirtualRegisterIR Vrbp = new VirtualRegisterIR("Vrbp", rbp);
    static public VirtualRegisterIR Vrsi = new VirtualRegisterIR("Vrsi", rsi);
    static public VirtualRegisterIR Vrdi = new VirtualRegisterIR("Vrdi", rdi);
    static public VirtualRegisterIR Vr8 = new VirtualRegisterIR("Vr8", r8);
    static public VirtualRegisterIR Vr9 = new VirtualRegisterIR("Vr9", r9);
    static public VirtualRegisterIR Vr10 = new VirtualRegisterIR("Vr10", r10);
    static public VirtualRegisterIR Vr11 = new VirtualRegisterIR("Vr11", r11);
    static public VirtualRegisterIR Vr12 = new VirtualRegisterIR("Vr12", r12);
    static public VirtualRegisterIR Vr13 = new VirtualRegisterIR("Vr13", r13);
    static public VirtualRegisterIR Vr14 = new VirtualRegisterIR("Vr14", r14);
    static public VirtualRegisterIR Vr15 = new VirtualRegisterIR("Vr15", r15);

    static public VirtualRegisterIR[] paratReg = {
            Vrdi,
            Vrsi,
            Vrdx,
            Vrcx,
            Vr8,
            Vr9
    };

    public RegisterSet(){
        
    }
}
