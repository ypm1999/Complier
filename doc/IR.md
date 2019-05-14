
>BB  
>
>INST  
    >>binary `dest = lhs op rsh, op = (+,-,*,/,^,&,|,>>,<<)`  
    >>unary `dest = op rsc, op = (+,-,!,~,INC,DEC)`  
    >>cpm `dest = lhs op rsh, op = (==,!=,> < >= <=)`  
    >>jump `targetBB`  
    >>cjump `if (src1 op src2) then thenBB else elseBB, cmp_jump`  
    >>move `dest = src`  
    >>load `dest = memAccess(addr)`  
    >>store `memAccess(addr) = (src)`  
    >>pop `pop the top of stack`  
    >>push `push a stackslot into stack`  
    >>funcCall `goto func lable`  
    >>heapalloc `dest = getHeapMemory(size)`   
    >>return `return` 
>
>OPPERAND   
    >> Vreg  
    >> Preg  
    >> Imm  
    >> StaticData
    >> StackSlot
    >> MemAddr
