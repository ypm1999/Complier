default rel

global print
global println
global getString
global getInt
global toString
global _string_length
global _string_substring
global _string_parseInt
global _string_ord
global __stradd
global __strcmp
global ___array_size

extern strcmp
extern memcpy
extern __sprintf_chk
extern strcpy
extern malloc
extern _IO_getc
extern stdin
extern _IO_putc
extern _GLOBAL_OFFSET_TABLE_
extern stdout


SECTION .text   

print:
        push    rbx
        lea     rbx, [rdi+8H]
        movsx   edi, byte [rdi+8H]
        test    dil, dil
        jz      L_002



L_001:  mov     rsi, qword [rel stdout]
        add     rbx, 1
        call    _IO_putc
        movsx   edi, byte [rbx]
        test    dil, dil
        jnz     L_001
L_002:  pop     rbx
        ret

println:
        push    rbx
        lea     rbx, [rdi+8H]
        movsx   edi, byte [rdi+8H]
        test    dil, dil
        jz      L_004
L_003:  mov     rsi, qword [rel stdout]
        add     rbx, 1
        call    _IO_putc
        movsx   edi, byte [rbx]
        test    dil, dil
        jnz     L_003
L_004:  pop     rbx
        mov     rsi, qword [rel stdout]
        mov     edi, 10
        jmp     _IO_putc


getString:
        mov     rdi, qword [rel stdin]
        push    r12
        push    rbp
        push    rbx
        call    _IO_getc
        cmp     al, 10
        mov     byte [rel buffer.3345], al
        jz      L_005
        cmp     al, 13
        mov     edx, eax
        jnz     L_007
L_005:  lea     rbx, [rel buffer.3345]
L_006:  mov     rdi, qword [rel stdin]
        call    _IO_getc
        cmp     al, 10
        mov     edx, eax
        mov     byte [rbx], al
        jz      L_006
        cmp     al, 13
        jz      L_006
L_007:  add     edx, 1
        xor     ebp, ebp
        lea     rbx, [rel buffer.3345]
        cmp     dl, 14
        ja      L_008
        mov     eax, 18433
        bt      rax, rdx
        jc      L_013
L_008:  mov     r12d, 18433
L_009:  mov     rdi, qword [rel stdin]
        add     rbx, 1
        call    _IO_getc
        mov     byte [rbx], al
        add     eax, 1
        lea     edx, [rbp+1H]
        cmp     al, 14
        ja      L_010
        bt      r12, rax
        jc      L_011
L_010:  mov     ebp, edx
        jmp     L_009
L_011:  lea     edi, [rbp+0AH]
        movsxd  rbp, edx
        movsxd  rdi, edi
L_012:  mov     byte [rbx], 0
        call    malloc
        lea     rsi, [rel buffer.3345]
        lea     rdi, [rax+8H]
        mov     rbx, rax
        mov     qword [rax], rbp
        call    strcpy
        mov     rax, rbx
        pop     rbx
        pop     rbp
        pop     r12
        ret
L_013:  xor     ebp, ebp
        mov     edi, 9
        jmp     L_012


getInt:
        mov     rdi, qword [rel stdin]
        push    r12
        push    rbp
        push    rbx
        xor     ebx, ebx
        call    _IO_getc
        movsx   rdx, al
        sub     eax, 48
        cmp     al, 9
        jbe     L_015
        mov     ebp, 1
L_014:  mov     rdi, qword [rel stdin]
        cmp     dl, 45
        cmove   ebx, ebp
        call    _IO_getc
        movsx   rdx, al
        sub     eax, 48
        cmp     al, 9
        ja      L_014
L_015:  xor     r12d, r12d
L_016:  lea     rax, [r12+r12]
        mov     rdi, qword [rel stdin]
        lea     rbp, [rax+r12*8]
        add     rbp, rdx
        call    _IO_getc
        movsx   rdx, al
        sub     eax, 48
        lea     r12, [rbp-30H]
        cmp     al, 9
        jbe     L_016
        mov     eax, 48
        sub     rax, rbp
        test    ebx, ebx
        cmovne  r12, rax
        mov     rax, r12
        pop     rbx
        pop     rbp
        pop     r12
        ret


toString:
        push    rbp
        push    rbx
        mov     rbp, rdi
        mov     edi, 32
        sub     rsp, 8
        call    malloc
        lea     rcx, [rel LC0]
        lea     rdi, [rax+8H]
        mov     rbx, rax
        mov     r8, rbp
        mov     edx, 24
        mov     esi, 1
        xor     eax, eax
        call    __sprintf_chk
        cdqe
        mov     qword [rbx], rax
        add     rsp, 8
        mov     rax, rbx
        pop     rbx
        pop     rbp
        ret


_string_length:
        mov     rax, qword [rdi]
        ret


_string_substring:
        sub     rdx, rsi
        push    r14
        mov     r14, rdi
        push    r13
        lea     rdi, [rdx+0AH]
        push    r12
        push    rbp
        push    rbx
        lea     r12, [rdx+1H]
        mov     r13, rsi
        mov     rbx, rdx
        call    malloc
        lea     rsi, [r14+r13+8H]
        lea     rdi, [rax+8H]
        mov     rbp, rax
        mov     qword [rax], r12
        mov     rdx, r12
        call    memcpy
        mov     byte [rbp+rbx+9H], 0
        mov     rax, rbp
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        ret


_string_parseInt:
        movsx   edx, byte [rdi+8H]
        cmp     dl, 45
        jz      L_019
        test    dl, dl
        jz      L_020
        lea     rcx, [rdi+8H]
        xor     esi, esi
L_017:  xor     eax, eax
L_018:  sub     edx, 48
        lea     rax, [rax+rax*4]
        add     rcx, 1
        movsxd  rdx, edx
        lea     rax, [rdx+rax*2]
        movsx   edx, byte [rcx]
        test    dl, dl
        jnz     L_018
        mov     rdx, rax
        neg     rdx
        test    esi, esi
        cmovne  rax, rdx
        ret
L_019:  movsx   edx, byte [rdi+9H]
        lea     rcx, [rdi+9H]
        test    dl, dl
        jz      L_020
        mov     esi, 1
        jmp     L_017
L_020:  xor     eax, eax
        ret


_string_ord:
        movsx   rax, byte [rdi+rsi+8H]
        ret


__stradd:
        push    r15
        push    r14
        mov     r14, rdi
        push    r13
        push    r12
        mov     r12, rsi
        push    rbp
        push    rbx
        sub     rsp, 24
        mov     r15, qword [rdi]
        mov     r13, qword [rsi]
        lea     rbp, [r15+8H]
        lea     rcx, [rbp+r13]
        lea     rdi, [rcx+1H]
        mov     qword [rsp+8H], rcx
        call    malloc
        mov     rbx, rax
        lea     rsi, [r14+8H]
        lea     rax, [r15+r13]
        lea     rdi, [rbx+8H]
        mov     rdx, r15
        mov     qword [rbx], rax
        call    memcpy
        lea     rdi, [rbx+rbp]
        lea     rsi, [r12+8H]
        mov     rdx, r13
        call    memcpy
        mov     rcx, qword [rsp+8H]
        mov     rax, rbx
        mov     byte [rbx+rcx], 0
        add     rsp, 24
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret


__strcmp:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        add     rsp, 8
        cdqe
        ret


___array_size:
        mov     rax, qword [rdi-8H]
        ret



SECTION .data   


SECTION .bss    align=32

buffer.3345:
        resb    1048576


SECTION .rodata.str1.1 

LC0:
        db 25H, 6CH, 64H, 00H



;********************************************************************************

global main
global __init
section .data

section .text

worka:
	_BB3_worka0_entry_worka:
		push rbp
		mov rbp, rsp
		sub rsp, 0
		mov rax, rdi
		shl rax, 1
		sub rax, rsi
		leave
		ret
workb:
	_BB5_workb0_entry_workb:
		push rbp
		mov rbp, rsp
		sub rsp, 0
		mov rax, rdi
		neg rax
		add rax, rsi
		add rax, rsi
		leave
		ret
workc:
	_BB7_workc0_entry_workc:
		push rbp
		mov rbp, rsp
		sub rsp, 0
		mov rax, rdi
		shl rax, 1
		add rax, rdi
		sub rax, rsi
		sub rax, rsi
		leave
		ret
main:
	_BB9_main0_entry_main:
		push rbp
		mov rbp, rsp
		sub rsp, 40
		call getInt
		mov qword [rbp - 32], rax
		mov r12, 0
		mov qword [rbp - 40], r12
		mov r12, 0
		mov qword [rbp - 8], r12
		mov r12, 1
		mov qword [rbp - 16], r12
		mov r12, 0
		mov qword [rbp - 24], r12
		mov rbx, 1
		mov r15, 1
		jmp _BB12_main1_forBody
	_BB12_main1_forBody:
		mov rsi, qword [rbp - 40]
		mov rdi, qword [rbp - 32]
		call worka
		mov qword [rbp - 32], rax
		mov rsi, qword [rbp - 40]
		mov rdi, qword [rbp - 32]
		call workb
		mov qword [rbp - 40], rax
		mov rsi, qword [rbp - 40]
		mov rdi, qword [rbp - 32]
		call workc
		mov r12, qword [rbp - 32]
		neg r12
		mov r13, qword [rbp - 40]
		add r12, r13
		sub r12, rax
		mov r13, qword [rbp - 8]
		add r12, r13
		mov qword [rbp - 8], r12
		mov r13, qword [rbp - 8]
		mov r12, qword [rbp - 16]
		add r13, r12
		mov qword [rbp - 8], r13
		mov r12, qword [rbp - 24]
		sub r13, r12
		mov qword [rbp - 8], r13
		mov r12, qword [rbp - 8]
		add r12, rbx
		mov qword [rbp - 8], r12
		mov r13, qword [rbp - 32]
		mov r12, qword [rbp - 40]
		add r13, r12
		mov r12, r13
		add r12, rax
		mov r14, r12
		mov rcx, qword [rbp - 8]
		sub r14, rcx
		mov rcx, qword [rbp - 16]
		sub r14, rcx
		mov qword [rbp - 16], r14
		mov rcx, qword [rbp - 24]
		mov r14, qword [rbp - 16]
		sub r14, rcx
		mov qword [rbp - 16], r14
		add r14, rbx
		mov qword [rbp - 16], r14
		sub r13, rax
		mov r14, qword [rbp - 8]
		add r13, r14
		mov r14, qword [rbp - 16]
		sub r13, r14
		mov r14, qword [rbp - 24]
		add r13, r14
		mov qword [rbp - 24], r13
		sub r13, rbx
		mov qword [rbp - 24], r13
		mov r13, qword [rbp - 32]
		mov r14, qword [rbp - 40]
		sub r13, r14
		sub r13, rax
		mov r14, qword [rbp - 8]
		sub r13, r14
		mov r14, qword [rbp - 16]
		add r13, r14
		mov r14, qword [rbp - 24]
		add r13, r14
		add r13, rbx
		mov rbx, r13
		mov r13, qword [rbp - 8]
		add r12, r13
		mov r13, qword [rbp - 16]
		add r12, r13
		mov r13, qword [rbp - 24]
		add r12, r13
		add r12, rbx
		cmp r12, 100000000
		jle _BB11_main2_forexpr3
		mov r12, 123
		mov qword [rbp - 32], r12
		mov r12, 456
		mov qword [rbp - 40], r12
		mov r12, 155
		mov qword [rbp - 8], r12
		mov r12, 123
		mov qword [rbp - 16], r12
		mov r12, 55
		mov qword [rbp - 24], r12
		mov rbx, 32
		inc r15
		cmp r15, 100000000
		jle _BB12_main1_forBody
		jmp _BB13_main3_forAfter
	_BB11_main2_forexpr3:
		inc r15
		cmp r15, 100000000
		jle _BB12_main1_forBody
	_BB13_main3_forAfter:
		mov rdi, rbx
		call toString
		mov rdi, rax
		call println
		mov rax, 0
		leave
		ret
