<random>
	<_BB3_random0_entry_random>
		mov vReg14_airthmeticBinary vReg12_seed
		mod vReg14_airthmeticBinary vReg10_Q
		mov vReg15_airthmeticBinary vReg8_A
		mul vReg15_airthmeticBinary vReg14_airthmeticBinary
		mov vReg16_airthmeticBinary vReg12_seed
		div vReg16_airthmeticBinary vReg10_Q
		mov vReg17_airthmeticBinary vReg11_R
		mul vReg17_airthmeticBinary vReg16_airthmeticBinary
		sub vReg15_airthmeticBinary vReg17_airthmeticBinary
		mov vReg13_tempseed vReg15_airthmeticBinary
		cjmp if(vReg13_tempseed GE 0) goto _BB4_random1_Ifthen else _BB6_random3_Ifelse
	<_BB4_random1_Ifthen>
		mov vReg12_seed vReg13_tempseed
		jmp _BB5_random2_Ifafter
	<_BB5_random2_Ifafter>
		mov vReg0_returnValue_of_random vReg12_seed
		jmp _BB7_random4_leave_random
	<_BB6_random3_Ifelse>
		mov vReg19_airthmeticBinary vReg13_tempseed
		add vReg19_airthmeticBinary vReg9_M
		mov vReg12_seed vReg19_airthmeticBinary
		jmp _BB5_random2_Ifafter
	<_BB7_random4_leave_random>
		leave
		ret

********************************************************************************

<initialize>
	<_BB8_initialize0_entry_initialize>
		mov vReg12_seed vReg20_initialize_arg_val
		jmp _BB9_initialize1_leave_initialize
	<_BB9_initialize1_leave_initialize>
		leave
		ret

********************************************************************************

<swap>
	<_BB10_swap0_entry_swap>
		mov vReg23_temp qword [vReg7_a + vReg21_swap_arg_x*8]
		mov qword [vReg7_a + vReg21_swap_arg_x*8] qword [vReg7_a + vReg22_swap_arg_y*8]
		mov qword [vReg7_a + vReg22_swap_arg_y*8] vReg23_temp
		jmp _BB11_swap1_leave_swap
	<_BB11_swap1_leave_swap>
		leave
		ret

********************************************************************************

<pd>
	<_BB12_pd0_entry_pd>
		jmp _BB13_pd1_forCondition
	<_BB13_pd1_forCondition>
		cjmp if(vReg5_h LE vReg24_pd_arg_x) goto _BB15_pd3_forBody else _BB16_pd4_forAfter
	<_BB14_pd2_forexpr3>
		inc vReg5_h
		jmp _BB13_pd1_forCondition
	<_BB15_pd3_forBody>
		mov vReg25_airthmeticBinary vReg5_h
		inc vReg25_airthmeticBinary
		mov vReg26_airthmeticBinary vReg5_h
		mul vReg26_airthmeticBinary vReg25_airthmeticBinary
		shr vReg26_airthmeticBinary 1
		cjmp if(vReg24_pd_arg_x E vReg26_airthmeticBinary) goto _BB17_pd5_Ifthen else _BB18_pd6_Ifafter
	<_BB16_pd4_forAfter>
		jmp _BB23_pd11_assignFalse
	<_BB17_pd5_Ifthen>
		jmp _BB19_pd7_assignTrue
	<_BB18_pd6_Ifafter>
		jmp _BB14_pd2_forexpr3
	<_BB19_pd7_assignTrue>
		mov vReg1_returnValue_of_pd 1
		jmp _BB21_pd9_assignafter
	<_BB20_pd8_assignFalse>
		mov vReg1_returnValue_of_pd 0
		jmp _BB21_pd9_assignafter
	<_BB21_pd9_assignafter>
		jmp _BB25_pd13_leave_pd
	<_BB22_pd10_assignTrue>
		mov vReg1_returnValue_of_pd 1
		jmp _BB24_pd12_assignafter
	<_BB23_pd11_assignFalse>
		mov vReg1_returnValue_of_pd 0
		jmp _BB24_pd12_assignafter
	<_BB24_pd12_assignafter>
		jmp _BB25_pd13_leave_pd
	<_BB25_pd13_leave_pd>
		leave
		ret

********************************************************************************

<show>
	<_BB26_show0_entry_show>
		mov vReg28_i 0
		jmp _BB27_show1_forCondition
	<_BB27_show1_forCondition>
		cjmp if(vReg28_i L vReg6_now) goto _BB29_show3_forBody else _BB30_show4_forAfter
	<_BB28_show2_forexpr3>
		inc vReg28_i
		jmp _BB27_show1_forCondition
	<_BB29_show3_forBody>
		call toString (qword [vReg7_a + vReg28_i*8])
		call __stradd (vReg29_returnValue_of_toString,vReg30_constString_addr)
		call print (vReg31_airthmeticBinary)
		jmp _BB28_show2_forexpr3
	<_BB30_show4_forAfter>
		call println (vReg32_constString_addr)
		jmp _BB31_show5_leave_show
	<_BB31_show5_leave_show>
		leave
		ret

********************************************************************************

<win>
	<_BB32_win0_entry_win>
		mov vReg37_new_size 100
		inc vReg37_new_size
		shl vReg37_new_size 3
		call malloc (vReg37_new_size)
		mov qword [vReg36_arrayNew] 100
		add vReg36_arrayNew 8
		mov vReg35_b vReg36_arrayNew
		cjmp if(vReg6_now NE vReg5_h) goto _BB33_win1_Ifthen else _BB34_win2_Ifafter
	<_BB33_win1_Ifthen>
		jmp _BB36_win4_assignFalse
	<_BB34_win2_Ifafter>
		mov vReg34_j 0
		jmp _BB38_win6_forCondition
	<_BB35_win3_assignTrue>
		mov vReg2_returnValue_of_win 1
		jmp _BB37_win5_assignafter
	<_BB36_win4_assignFalse>
		mov vReg2_returnValue_of_win 0
		jmp _BB37_win5_assignafter
	<_BB37_win5_assignafter>
		jmp _BB64_win32_leave_win
	<_BB38_win6_forCondition>
		cjmp if(vReg34_j L vReg6_now) goto _BB40_win8_forBody else _BB41_win9_forAfter
	<_BB39_win7_forexpr3>
		inc vReg34_j
		jmp _BB38_win6_forCondition
	<_BB40_win8_forBody>
		mov qword [vReg35_b + vReg34_j*8] qword [vReg7_a + vReg34_j*8]
		jmp _BB39_win7_forexpr3
	<_BB41_win9_forAfter>
		mov vReg33_i 0
		jmp _BB42_win10_forCondition
	<_BB42_win10_forCondition>
		mov vReg39_airthmeticBinary vReg6_now
		dec vReg39_airthmeticBinary
		cjmp if(vReg33_i L vReg39_airthmeticBinary) goto _BB44_win12_forBody else _BB45_win13_forAfter
	<_BB43_win11_forexpr3>
		inc vReg33_i
		jmp _BB42_win10_forCondition
	<_BB44_win12_forBody>
		mov vReg40_airthmeticBinary vReg33_i
		inc vReg40_airthmeticBinary
		mov vReg34_j vReg40_airthmeticBinary
		jmp _BB46_win14_forCondition
	<_BB45_win13_forAfter>
		mov vReg33_i 0
		jmp _BB52_win20_forCondition
	<_BB46_win14_forCondition>
		cjmp if(vReg34_j L vReg6_now) goto _BB48_win16_forBody else _BB49_win17_forAfter
	<_BB47_win15_forexpr3>
		inc vReg34_j
		jmp _BB46_win14_forCondition
	<_BB48_win16_forBody>
		cjmp if(qword [vReg35_b + vReg33_i*8] G qword [vReg35_b + vReg34_j*8]) goto _BB50_win18_Ifthen else _BB51_win19_Ifafter
	<_BB49_win17_forAfter>
		jmp _BB43_win11_forexpr3
	<_BB50_win18_Ifthen>
		mov vReg38_temp qword [vReg35_b + vReg33_i*8]
		mov qword [vReg35_b + vReg33_i*8] qword [vReg35_b + vReg34_j*8]
		mov qword [vReg35_b + vReg34_j*8] vReg38_temp
		jmp _BB51_win19_Ifafter
	<_BB51_win19_Ifafter>
		jmp _BB47_win15_forexpr3
	<_BB52_win20_forCondition>
		cjmp if(vReg33_i L vReg6_now) goto _BB54_win22_forBody else _BB55_win23_forAfter
	<_BB53_win21_forexpr3>
		inc vReg33_i
		jmp _BB52_win20_forCondition
	<_BB54_win22_forBody>
		mov vReg41_airthmeticBinary vReg33_i
		inc vReg41_airthmeticBinary
		cjmp if(qword [vReg35_b + vReg33_i*8] NE vReg41_airthmeticBinary) goto _BB56_win24_Ifthen else _BB57_win25_Ifafter
	<_BB55_win23_forAfter>
		jmp _BB61_win29_assignTrue
	<_BB56_win24_Ifthen>
		jmp _BB59_win27_assignFalse
	<_BB57_win25_Ifafter>
		jmp _BB53_win21_forexpr3
	<_BB58_win26_assignTrue>
		mov vReg2_returnValue_of_win 1
		jmp _BB60_win28_assignafter
	<_BB59_win27_assignFalse>
		mov vReg2_returnValue_of_win 0
		jmp _BB60_win28_assignafter
	<_BB60_win28_assignafter>
		jmp _BB64_win32_leave_win
	<_BB61_win29_assignTrue>
		mov vReg2_returnValue_of_win 1
		jmp _BB63_win31_assignafter
	<_BB62_win30_assignFalse>
		mov vReg2_returnValue_of_win 0
		jmp _BB63_win31_assignafter
	<_BB63_win31_assignafter>
		jmp _BB64_win32_leave_win
	<_BB64_win32_leave_win>
		leave
		ret

********************************************************************************

<merge>
	<_BB65_merge0_entry_merge>
		mov vReg42_i 0
		jmp _BB66_merge1_forCondition
	<_BB66_merge1_forCondition>
		cjmp if(vReg42_i L vReg6_now) goto _BB68_merge3_forBody else _BB69_merge4_forAfter
	<_BB67_merge2_forexpr3>
		inc vReg42_i
		jmp _BB66_merge1_forCondition
	<_BB68_merge3_forBody>
		cjmp if(qword [vReg7_a + vReg42_i*8] E 0) goto _BB70_merge5_Ifthen else _BB71_merge6_Ifafter
	<_BB69_merge4_forAfter>
		mov vReg42_i 0
		jmp _BB78_merge13_forCondition
	<_BB70_merge5_Ifthen>
		mov vReg44_airthmeticBinary vReg42_i
		inc vReg44_airthmeticBinary
		mov vReg43_j vReg44_airthmeticBinary
		jmp _BB72_merge7_forCondition
	<_BB71_merge6_Ifafter>
		jmp _BB67_merge2_forexpr3
	<_BB72_merge7_forCondition>
		cjmp if(vReg43_j L vReg6_now) goto _BB74_merge9_forBody else _BB75_merge10_forAfter
	<_BB73_merge8_forexpr3>
		inc vReg43_j
		jmp _BB72_merge7_forCondition
	<_BB74_merge9_forBody>
		cjmp if(qword [vReg7_a + vReg43_j*8] NE 0) goto _BB76_merge11_Ifthen else _BB77_merge12_Ifafter
	<_BB75_merge10_forAfter>
		jmp _BB71_merge6_Ifafter
	<_BB76_merge11_Ifthen>
		call swap (vReg42_i,vReg43_j)
		jmp _BB75_merge10_forAfter
	<_BB77_merge12_Ifafter>
		jmp _BB73_merge8_forexpr3
	<_BB78_merge13_forCondition>
		cjmp if(vReg42_i L vReg6_now) goto _BB80_merge15_forBody else _BB81_merge16_forAfter
	<_BB79_merge14_forexpr3>
		inc vReg42_i
		jmp _BB78_merge13_forCondition
	<_BB80_merge15_forBody>
		cjmp if(qword [vReg7_a + vReg42_i*8] E 0) goto _BB82_merge17_Ifthen else _BB83_merge18_Ifafter
	<_BB81_merge16_forAfter>
		jmp _BB84_merge19_leave_merge
	<_BB82_merge17_Ifthen>
		mov vReg6_now vReg42_i
		jmp _BB81_merge16_forAfter
	<_BB83_merge18_Ifafter>
		jmp _BB79_merge14_forexpr3
	<_BB84_merge19_leave_merge>
		leave
		ret

********************************************************************************

<move>
	<_BB85_move0_entry_move>
		mov vReg45_i 0
		jmp _BB86_move1_forCondition
	<_BB86_move1_forCondition>
		cjmp if(vReg45_i L vReg6_now) goto _BB88_move3_forBody else _BB89_move4_forAfter
	<_BB87_move2_forexpr3>
		jmp _BB86_move1_forCondition
	<_BB88_move3_forBody>
		dec qword [vReg7_a + vReg45_i*8]
		mov vReg46_airthmeticBinary vReg45_i
		inc vReg46_airthmeticBinary
		mov vReg45_i vReg46_airthmeticBinary
		jmp _BB87_move2_forexpr3
	<_BB89_move4_forAfter>
		mov qword [vReg7_a + vReg6_now*8] vReg6_now
		mov vReg47_ vReg6_now
		inc vReg6_now
		jmp _BB90_move5_leave_move
	<_BB90_move5_leave_move>
		leave
		ret

********************************************************************************

<main>
	<_BB91_main0_entry_main>
		call __init ()
		mov vReg48_i 0
		mov vReg49_temp 0
		mov vReg50_count 0
		mov vReg4_n 210
		mov vReg5_h 0
		mov vReg52_new_size 100
		inc vReg52_new_size
		shl vReg52_new_size 3
		call malloc (vReg52_new_size)
		mov qword [vReg51_arrayNew] 100
		add vReg51_arrayNew 8
		mov vReg7_a vReg51_arrayNew
		mov vReg53_airthmeticBinary vReg9_M
		div vReg53_airthmeticBinary vReg8_A
		mov vReg10_Q vReg53_airthmeticBinary
		mov vReg54_airthmeticBinary vReg9_M
		mod vReg54_airthmeticBinary vReg8_A
		mov vReg11_R vReg54_airthmeticBinary
		call pd (vReg4_n)
		cjmp if(vReg55_returnValue_of_pd E 1) goto _BB93_main2_Ifafter else _BB92_main1_Ifthen
	<_BB92_main1_Ifthen>
		call println (vReg56_constString_addr)
		mov vReg3_returnValue_of_main 1
		jmp _BB104_main13_leave_main
	<_BB93_main2_Ifafter>
		call println (vReg57_constString_addr)
		call initialize (3654898)
		call random ()
		mov vReg59_airthmeticBinary vReg58_returnValue_of_random
		mod vReg59_airthmeticBinary 10
		inc vReg59_airthmeticBinary
		mov vReg6_now vReg59_airthmeticBinary
		call toString (vReg6_now)
		call println (vReg61_returnValue_of_toString)
		jmp _BB94_main3_forCondition
	<_BB94_main3_forCondition>
		mov vReg62_airthmeticBinary vReg6_now
		dec vReg62_airthmeticBinary
		cjmp if(vReg48_i L vReg62_airthmeticBinary) goto _BB96_main5_forBody else _BB97_main6_forAfter
	<_BB95_main4_forexpr3>
		inc vReg48_i
		jmp _BB94_main3_forCondition
	<_BB96_main5_forBody>
		call random ()
		mov vReg64_airthmeticBinary vReg63_returnValue_of_random
		mod vReg64_airthmeticBinary 10
		inc vReg64_airthmeticBinary
		mov qword [vReg7_a + vReg48_i*8] vReg64_airthmeticBinary
		jmp _BB98_main7_whileCondition
	<_BB97_main6_forAfter>
		mov vReg71_airthmeticBinary vReg6_now
		dec vReg71_airthmeticBinary
		mov vReg72_airthmeticBinary vReg4_n
		sub vReg72_airthmeticBinary vReg49_temp
		mov qword [vReg7_a + vReg71_airthmeticBinary*8] vReg72_airthmeticBinary
		call show ()
		call merge ()
		jmp _BB101_main10_whileCondition
	<_BB98_main7_whileCondition>
		mov vReg66_airthmeticBinary qword [vReg7_a + vReg48_i*8]
		add vReg66_airthmeticBinary vReg49_temp
		cjmp if(vReg66_airthmeticBinary G vReg4_n) goto _BB99_main8_whileBody else _BB100_main9_whileAfter
	<_BB99_main8_whileBody>
		call random ()
		mov vReg68_airthmeticBinary vReg67_returnValue_of_random
		mod vReg68_airthmeticBinary 10
		inc vReg68_airthmeticBinary
		mov qword [vReg7_a + vReg48_i*8] vReg68_airthmeticBinary
		jmp _BB98_main7_whileCondition
	<_BB100_main9_whileAfter>
		mov vReg70_airthmeticBinary vReg49_temp
		add vReg70_airthmeticBinary qword [vReg7_a + vReg48_i*8]
		mov vReg49_temp vReg70_airthmeticBinary
		jmp _BB95_main4_forexpr3
	<_BB101_main10_whileCondition>
		call win ()
		cjmp if(vReg73_returnValue_of_win E 1) goto _BB103_main12_whileAfter else _BB102_main11_whileBody
	<_BB102_main11_whileBody>
		inc vReg50_count
		call toString (vReg50_count)
		call __stradd (vReg74_constString_addr,vReg75_returnValue_of_toString)
		call __stradd (vReg76_airthmeticBinary,vReg77_constString_addr)
		call println (vReg78_airthmeticBinary)
		call move ()
		call merge ()
		call show ()
		jmp _BB101_main10_whileCondition
	<_BB103_main12_whileAfter>
		call toString (vReg50_count)
		call __stradd (vReg79_constString_addr,vReg80_returnValue_of_toString)
		call __stradd (vReg81_airthmeticBinary,vReg82_constString_addr)
		call println (vReg83_airthmeticBinary)
		mov vReg3_returnValue_of_main 0
		jmp _BB104_main13_leave_main
	<_BB104_main13_leave_main>
		leave
		ret

********************************************************************************

<__init>
	<_BB1___init0_initFuncEntry>
		mov vReg8_A 48271
		mov [rel A] vReg8_A
		mov vReg9_M 2147483647
		mov [rel M] vReg9_M
		mov vReg12_seed 1
		mov [rel seed] vReg12_seed
		jmp _BB2___init1_leave_initFunc
	<_BB2___init1_leave_initFunc>
		leave
		ret
