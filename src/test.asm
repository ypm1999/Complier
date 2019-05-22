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
        push    r13
        push    r12
        mov     r12, rdi
        push    rbp
        push    rbx
        mov     rbp, rsi
        sub     rsp, 8
        mov     rbx, qword [rdi]
        mov     r13, qword [rsi]
        lea     rdi, [rbx+r13+9H]
        add     rbx, r13
        call    malloc
        movzx   ecx, byte [r12+8H]
        mov     qword [rax], rbx
        lea     rdx, [rax+8H]
        test    cl, cl
        jz      L_022
        lea     rdi, [r12+8H]
L_021:  add     rdi, 1
        add     rdx, 1
        mov     byte [rdx-1H], cl
        movzx   ecx, byte [rdi]
        test    cl, cl
        jnz     L_021
L_022:  movzx   ecx, byte [rbp+8H]
        lea     rdi, [rbp+8H]
        test    cl, cl
        jz      L_024
L_023:  add     rdi, 1
        add     rdx, 1
        mov     byte [rdx-1H], cl
        movzx   ecx, byte [rdi]
        test    cl, cl
        jnz     L_023
L_024:  mov     byte [rdx], 0
        add     rsp, 8
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
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
  __Static0_a:
    db 00H, 00H, 00H, 00H, 00H, 00H, 00H, 00H
  __Static1_i:
    db 00H, 00H, 00H, 00H, 00H, 00H, 00H, 00H
  __Static2_j:
    db 00H, 00H, 00H, 00H, 00H, 00H, 00H, 00H
  __Static3_b:
    db 00H, 00H, 00H, 00H, 00H, 00H, 00H, 00H

section .text

main:
  _BB5_main0_entry_main:
    push rbp
    mov rbp, rsp
    mov r14, [rel __Static0_a]
    mov r13, [rel __Static1_i]
    mov r12, [rel __Static2_j]
    mov rbx, [rel __Static3_b]
    mov rdi, 5
    shl rdi, 3
    call malloc
    mov r14, rax
    mov rcx, 4
    mov qword [r14], rcx
    add r14, 8
    mov [rel __Static0_a], r14
    mov rdi, 6
    shl rdi, 3
    call malloc
    mov rbx, rax
    mov rcx, 5
    mov qword [rbx], rcx
    add rbx, 8
    mov [rel __Static3_b], rbx
    mov r13, 0
    cmp r13, 4
    jl _BB8_main1_forBody
    mov r13, 0
    cmp r13, 4
    jl _BB12_main3_forBody
    mov r13, 0
    cmp r13, 5
    jl _BB20_main4_forBody
    jmp _BB21_main2_forAfter
  _BB8_main1_forBody:
    mov rdi, 12
    shl rdi, 3
    call malloc
    mov rcx, 11
    mov qword [rax], rcx
    add rax, 8
    mov qword [r14 + r13*8], rax
    inc r13
    cmp r13, 4
    jl _BB8_main1_forBody
    mov r13, 0
    cmp r13, 4
    jl _BB12_main3_forBody
    mov r13, 0
    cmp r13, 5
    jl _BB20_main4_forBody
  _BB21_main2_forAfter:
    mov rcx, qword [r14 + 24]
    mov rdi, qword [rcx + 72]
    call toString
    mov rdi, rax
    call println
    mov r13, 0
    cmp r13, 3
    jle _BB24_main6_forBody
    mov r13, 0
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    jmp _BB32_main10_forBody
  _BB12_main3_forBody:
    mov r12, 0
    cmp r12, 10
    jl _BB16_main5_forBody
    inc r13
    cmp r13, 4
    jl _BB12_main3_forBody
    mov r13, 0
    cmp r13, 5
    jl _BB20_main4_forBody
    jmp _BB21_main2_forAfter
  _BB20_main4_forBody:
    mov rdi, 16
    call malloc
    mov qword [rbx + r13*8], rax
    mov rdx, qword [rbx + r13*8]
    mov rcx, -1
    mov qword [rdx], rcx
    inc r13
    cmp r13, 5
    jl _BB20_main4_forBody
    jmp _BB21_main2_forAfter
  _BB16_main5_forBody:
    mov rdx, qword [r14 + r13*8]
    mov rcx, 888
    mov qword [rdx + r12*8], rcx
    inc r12
    cmp r12, 10
    jl _BB16_main5_forBody
    inc r13
    cmp r13, 4
    jl _BB12_main3_forBody
    mov r13, 0
    cmp r13, 5
    jl _BB20_main4_forBody
    jmp _BB21_main2_forAfter
  _BB24_main6_forBody:
    mov r12, 0
    cmp r12, 9
    jle _BB28_main11_forBody
    inc r13
    cmp r13, 3
    jle _BB24_main6_forBody
    mov r13, 0
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
  _BB31_main7_forexpr3:
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    jmp _BB32_main10_forBody
  _BB33_main8_forAfter:
    mov rdx, qword [r14 + 16]
    mov rcx, 0
    mov qword [rdx + 80], rcx
    mov rcx, qword [r14 + 16]
    mov rdi, qword [rcx + 80]
    call toString
    mov rdi, rax
    call println
    mov rdx, qword [rbx]
    mov rcx, -2
    mov qword [rdx], rcx
    mov rcx, qword [r14 + 16]
    mov rcx, qword [rcx + 80]
    mov rdx, qword [rbx + rcx*8]
    mov rcx, -10
    mov qword [rdx], rcx
    mov rcx, qword [rbx]
    mov rdi, qword [rcx]
    call toString
    mov rdi, rax
    call println
    mov rcx, qword [rbx + 8]
    mov rdi, qword [rcx]
    call toString
    mov rdi, rax
    call println
    mov rax, 0
    leave
    ret
  _BB36_main9_forBody:
    mov rcx, qword [r14 + r13*8]
    mov rdi, qword [rcx + r12*8]
    call toString
    mov rdi, rax
    call println
    inc r12
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
  _BB32_main10_forBody:
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    inc r13
    cmp r13, 3
    jg _BB33_main8_forAfter
    jmp _BB32_main10_forBody
  _BB28_main11_forBody:
    mov rsi, qword [r14 + r13*8]
    mov rcx, r13
    mov rax, rcx
    mov r11, 10
    xor rdx, rdx
    mul r11
    mov rcx, rax
    add rcx, r12
    mov qword [rsi + r12*8], rcx
    inc r12
    cmp r12, 9
    jle _BB28_main11_forBody
    inc r13
    cmp r13, 3
    jle _BB24_main6_forBody
    mov r13, 0
    cmp r13, 3
    jg _BB33_main8_forAfter
    mov r12, 0
    cmp r12, 9
    jle _BB36_main9_forBody
    jmp _BB31_main7_forexpr3
