





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
        push    r13
        push    r12
        mov     r12, rsi
        push    rbp
        push    rbx
        mov     rbx, rdi
        sub     rsp, 8
        mov     r13, qword [rdi]
        mov     r14, qword [rsi]
        lea     rbp, [r13+8H]
        lea     r15, [rbp+r14]
        lea     rdi, [r15+1H]
        call    malloc
        lea     rdx, [r13+r14]
        test    r13, r13
        lea     r8, [rax+8H]
        mov     qword [rax], rdx
        mov     byte [rax+r15], 0
        jle     L_022
        mov     ecx, 8






L_021:  movzx   edi, byte [rbx+rcx]
        mov     byte [rax+rcx], dil
        add     rcx, 1
        cmp     rcx, rbp
        jnz     L_021
        add     r8, r13
L_022:  lea     rsi, [r12+8H]
        mov     rdx, r14
        mov     rdi, r8
        call    memcpy
        add     rsp, 8
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
	__Static0_init_anger:
		db 00H, 00H, 00H, 00H, 00H, 00H, 00H, 00H
	__Static1_work_anger:
		db 00H, 00H, 00H, 00H, 00H, 00H, 00H, 00H
	__Static2_constString0:
		dq 2
		db 2CH, 20H, 00H
	__Static3_constString1:
		dq 22
		db 20H, 77H, 61H, 6EH, 74H, 73H, 20H, 74H, 6FH, 20H, 67H, 69H, 76H, 65H, 20H, 75H, 70H, 21H, 21H, 21H, 21H, 21H, 00H
	__Static4_constString2:
		dq 2
		db 2CH, 20H, 00H
	__Static5_constString3:
		dq 21
		db 20H, 65H, 6EH, 6AH, 6FH, 79H, 73H, 20H, 74H, 68H, 69H, 73H, 20H, 77H, 6FH, 72H, 6BH, 2EH, 20H, 58H, 44H, 00H
	__Static6_constString4:
		dq 14
		db 74H, 68H, 65H, 20H, 6CH, 65H, 61H, 64H, 69H, 6EH, 67H, 20H, 54H, 41H, 00H
	__Static7_constString5:
		dq 15
		db 74H, 68H, 65H, 20H, 73H, 74H, 72H, 69H, 6BH, 69H, 6EH, 67H, 20H, 54H, 41H, 00H
	__Static8_constString6:
		dq 2
		db 4DH, 52H, 00H
	__Static9_constString7:
		dq 4
		db 4DH, 61H, 72H, 73H, 00H
	__Static10_constString8:
		dq 4
		db 4DH, 61H, 72H, 73H, 00H

section .text

work:
	_BB3_work0_entry_work:
		push rbp
		mov rbp, rsp
		sub rsp, 0
		push r13
		push r12
		mov r12, [rel __Static1_work_anger]
		mov r13, rsi
		cmp qword [r13 + 8], 100
		jg _BB6_work2_Ifelse
		lea rsi, [rel __Static4_constString2]
		call __stradd
		mov rdi, rax
		mov rsi, qword [r13]
		call __stradd
		mov rdi, rax
		lea rsi, [rel __Static5_constString3]
		call __stradd
		mov rdi, rax
		call println
		mov rdi, qword [r13 + 8]
		add rdi, r12
		mov qword [r13 + 8], rdi
	_BB7_work1_leave_work:
		pop r12
		pop r13
		leave
		ret
	_BB6_work2_Ifelse:
		lea rsi, [rel __Static2_constString0]
		call __stradd
		mov rdi, rax
		mov rsi, qword [r13]
		call __stradd
		mov rdi, rax
		lea rsi, [rel __Static3_constString1]
		call __stradd
		mov rdi, rax
		call println
		mov rdi, qword [r13 + 8]
		add rdi, r12
		mov qword [r13 + 8], rdi
		jmp _BB7_work1_leave_work
main:
	_BB8_main0_entry_main:
		push rbp
		mov rbp, rsp
		sub rsp, 0
		call __init
		mov r12, [rel __Static0_init_anger]
		mov rdi, 16
		call malloc
		mov r15, rax
		lea r13, [rel __Static6_constString4]
		mov qword [r15], r13
		mov r13, 0
		mov qword [r15 + 8], r13
		mov rdi, 16
		call malloc
		mov r14, rax
		lea r13, [rel __Static7_constString5]
		mov qword [r14], r13
		mov qword [r14 + 8], r12
		lea rdi, [rel __Static8_constString6]
		mov rsi, r15
		call work
		lea rdi, [rel __Static9_constString7]
		mov rsi, r14
		call work
		lea rdi, [rel __Static10_constString8]
		mov rsi, r14
		call work
		mov rax, 0
		leave
		ret
__init:
	_BB1___init0_initFuncEntry:
		push rbp
		mov rbp, rsp
		sub rsp, 0
		mov rcx, 100
		mov [rel __Static0_init_anger], rcx
		mov rcx, 10
		mov [rel __Static1_work_anger], rcx
		leave
		ret
