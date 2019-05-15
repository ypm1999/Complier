/usr/lib/jvm/java-1.11.0-openjdk-amd64/bin/java -javaagent:/home/sjtu-ypm/Downloads/ideaIU-2018.3.5/lib/idea_rt.jar=42637:/home/sjtu-ypm/Downloads/ideaIU-2018.3.5/bin -Dfile.encoding=UTF-8 -classpath /home/sjtu-ypm/complier/src/out/production/src:/home/sjtu-ypm/complier/src/lib/antlr-4.7.2-complete.jar com.mxcomplier.Main -DEBUG
_BB35_main18_Ifthen <- _BB32_main16_forexpr3
<main>
	<_BB5_main0_entry_main>
		call getInt ()
		mov vReg9_returnValue_of_getInt rax
		mov vReg8_n vReg9_returnValue_of_getInt
		mov vReg12_new_size vReg8_n
		inc vReg12_new_size
		shl vReg12_new_size 3
		mov rdi vReg12_new_size
		call malloc (vReg12_new_size)
		mov vReg11_arrayNew rax
		mov qword [vReg11_arrayNew] vReg8_n
		add vReg11_arrayNew 8
		mov vReg12_new_size vReg8_n
		mov vReg13_new_cnt 0
		cjmp if(vReg12_new_size E 0) goto _BB8_main2_newWhileAfter else _BB7_main1_newWhileBody
		jmp _BB7_main1_newWhileBody
	<_BB7_main1_newWhileBody>
		mov vReg15_new_size vReg8_n
		inc vReg15_new_size
		shl vReg15_new_size 3
		mov rdi vReg15_new_size
		call malloc (vReg15_new_size)
		mov vReg14_arrayNew rax
		mov qword [vReg14_arrayNew] vReg8_n
		add vReg14_arrayNew 8
		mov qword [vReg11_arrayNew + vReg13_new_cnt*8] vReg14_arrayNew
		inc vReg13_new_cnt
		cjmp if(vReg13_new_cnt NE vReg12_new_size) goto _BB7_main1_newWhileBody else _BB8_main2_newWhileAfter
		jmp _BB8_main2_newWhileAfter
	<_BB8_main2_newWhileAfter>
		mov vReg10_f vReg11_arrayNew
		mov vReg18_new_size vReg8_n
		inc vReg18_new_size
		shl vReg18_new_size 3
		mov rdi vReg18_new_size
		call malloc (vReg18_new_size)
		mov vReg17_arrayNew rax
		mov qword [vReg17_arrayNew] vReg8_n
		add vReg17_arrayNew 8
		mov vReg18_new_size vReg8_n
		mov vReg19_new_cnt 0
		cjmp if(vReg18_new_size E 0) goto _BB11_main4_newWhileAfter else _BB10_main3_newWhileBody
		jmp _BB10_main3_newWhileBody
	<_BB10_main3_newWhileBody>
		mov vReg21_new_size vReg8_n
		inc vReg21_new_size
		shl vReg21_new_size 3
		mov rdi vReg21_new_size
		call malloc (vReg21_new_size)
		mov vReg20_arrayNew rax
		mov qword [vReg20_arrayNew] vReg8_n
		add vReg20_arrayNew 8
		mov qword [vReg17_arrayNew + vReg19_new_cnt*8] vReg20_arrayNew
		inc vReg19_new_cnt
		cjmp if(vReg19_new_cnt NE vReg18_new_size) goto _BB10_main3_newWhileBody else _BB11_main4_newWhileAfter
		jmp _BB11_main4_newWhileAfter
	<_BB11_main4_newWhileAfter>
		mov vReg16_g vReg17_arrayNew
		mov vReg24_new_size vReg8_n
		inc vReg24_new_size
		shl vReg24_new_size 3
		mov rdi vReg24_new_size
		call malloc (vReg24_new_size)
		mov vReg23_arrayNew rax
		mov qword [vReg23_arrayNew] vReg8_n
		add vReg23_arrayNew 8
		mov vReg24_new_size vReg8_n
		mov vReg25_new_cnt 0
		cjmp if(vReg24_new_size NE 0) goto _BB13_main5_newWhileBody else _BB14_main6_newWhileAfter
		jmp _BB14_main6_newWhileAfter
	<_BB13_main5_newWhileBody>
		mov vReg27_new_size vReg8_n
		inc vReg27_new_size
		shl vReg27_new_size 3
		mov rdi vReg27_new_size
		call malloc (vReg27_new_size)
		mov vReg26_arrayNew rax
		mov qword [vReg26_arrayNew] vReg8_n
		add vReg26_arrayNew 8
		mov qword [vReg23_arrayNew + vReg25_new_cnt*8] vReg26_arrayNew
		inc vReg25_new_cnt
		cjmp if(vReg25_new_cnt NE vReg24_new_size) goto _BB13_main5_newWhileBody else _BB14_main6_newWhileAfter
		jmp _BB14_main6_newWhileAfter
	<_BB14_main6_newWhileAfter>
		mov vReg22_g_useless vReg23_arrayNew
		mov vReg28_i 0
		cjmp if(vReg8_n G 0) goto _BB17_main8_forBody else _BB18_main9_forAfter
		jmp _BB18_main9_forAfter
	<_BB16_main7_forexpr3>
		inc vReg28_i
		cjmp if(vReg28_i L vReg8_n) goto _BB17_main8_forBody else _BB18_main9_forAfter
		jmp _BB18_main9_forAfter
	<_BB17_main8_forBody>
		mov vReg29_j 0
		cjmp if(vReg8_n G 0) goto _BB21_main10_forBody else _BB16_main7_forexpr3
		jmp _BB16_main7_forexpr3
	<_BB18_main9_forAfter>
		mov vReg28_i 0
		cjmp if(vReg8_n LE 0) goto _BB26_main13_forAfter else _BB25_main12_forBody
		jmp _BB25_main12_forBody
	<_BB21_main10_forBody>
		mov vReg31_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg32_airthmeticBinary vReg28_i
		add vReg32_airthmeticBinary vReg29_j
		mov qword [vReg31_arrCall_to_reg + vReg29_j*8] vReg32_airthmeticBinary
		inc vReg29_j
		cjmp if(vReg29_j L vReg8_n) goto _BB21_main10_forBody else _BB16_main7_forexpr3
		jmp _BB16_main7_forexpr3
	<_BB24_main11_forexpr3>
		inc vReg28_i
		cjmp if(vReg28_i GE vReg8_n) goto _BB26_main13_forAfter else _BB25_main12_forBody
		jmp _BB25_main12_forBody
	<_BB25_main12_forBody>
		mov vReg29_j 0
		cjmp if(vReg8_n LE 0) goto _BB24_main11_forexpr3 else _BB29_main15_forBody
		jmp _BB29_main15_forBody
	<_BB26_main13_forAfter>
		mov vReg53_sum 0
		mov vReg28_i 0
		cjmp if(vReg8_n LE 0) goto _BB40_main21_forAfter else _BB39_main20_forBody
		jmp _BB39_main20_forBody
	<_BB28_main14_forexpr3>
		inc vReg29_j
		cjmp if(vReg29_j GE vReg8_n) goto _BB24_main11_forexpr3 else _BB29_main15_forBody
		jmp _BB29_main15_forBody
	<_BB29_main15_forBody>
		mov vReg30_k 0
		cjmp if(vReg8_n LE 0) goto _BB28_main14_forexpr3 else _BB33_main17_forBody
		jmp _BB33_main17_forBody
	<_BB32_main16_forexpr3>
		inc vReg30_k
		cjmp if(vReg30_k GE vReg8_n) goto _BB28_main14_forexpr3 else _BB33_main17_forBody
		jmp _BB33_main17_forBody
	<_BB33_main17_forBody>
		cjmp if(vReg29_j L vReg28_i) goto _BB32_main16_forexpr3 else _BB35_main18_Ifthen
		jmp _BB35_main18_Ifthen
	<_BB35_main18_Ifthen>
		mov vReg33_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg35_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg36_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg37_arrCall_to_reg qword [vReg10_f + vReg30_k*8]
		mov vReg115_func_arg_a__cp qword [vReg35_arrCall_to_reg + vReg29_j*8]
		mov vReg116_func_arg_b__cp qword [vReg36_arrCall_to_reg + vReg30_k*8]
		mov vReg117_func_arg_c__cp qword [vReg37_arrCall_to_reg + vReg29_j*8]
		mov vReg119_airthmeticBinary__cp vReg115_func_arg_a__cp
		add vReg119_airthmeticBinary__cp vReg116_func_arg_b__cp
		add vReg119_airthmeticBinary__cp vReg117_func_arg_c__cp
		and vReg119_airthmeticBinary__cp 1073741823
		mov vReg34_returnValue_of_func vReg119_airthmeticBinary__cp
		jmp _BB73_main24_leave_func__inline
	<_BB38_main19_forexpr3>
		inc vReg28_i
		cjmp if(vReg28_i GE vReg8_n) goto _BB40_main21_forAfter else _BB39_main20_forBody
		jmp _BB39_main20_forBody
	<_BB39_main20_forBody>
		mov vReg29_j 0
		cjmp if(vReg8_n G 0) goto _BB43_main22_forBody else _BB38_main19_forexpr3
		jmp _BB38_main19_forexpr3
	<_BB40_main21_forAfter>
		mov rdi vReg53_sum
		call toString (vReg53_sum)
		mov vReg57_returnValue_of_toString rax
		mov rdi vReg57_returnValue_of_toString
		call print (vReg57_returnValue_of_toString)
		mov rax 0
		jmp _BB45_main23_leave_main
	<_BB43_main22_forBody>
		mov vReg54_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg55_airthmeticBinary vReg53_sum
		add vReg55_airthmeticBinary qword [vReg54_arrCall_to_reg + vReg29_j*8]
		and vReg55_airthmeticBinary 1073741823
		mov vReg53_sum vReg55_airthmeticBinary
		inc vReg29_j
		cjmp if(vReg29_j L vReg8_n) goto _BB43_main22_forBody else _BB38_main19_forexpr3
		jmp _BB38_main19_forexpr3
	<_BB45_main23_leave_main>
		leave
		ret
	<_BB73_main24_leave_func__inline>
		mov qword [vReg33_arrCall_to_reg + vReg29_j*8] vReg34_returnValue_of_func
		mov vReg38_arrCall_to_reg qword [vReg22_g_useless + vReg28_i*8]
		mov vReg40_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg41_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg42_arrCall_to_reg qword [vReg10_f + vReg30_k*8]
		mov vReg120_func_arg_a__cp qword [vReg40_arrCall_to_reg + vReg29_j*8]
		mov vReg121_func_arg_b__cp qword [vReg41_arrCall_to_reg + vReg30_k*8]
		mov vReg122_func_arg_c__cp qword [vReg42_arrCall_to_reg + vReg29_j*8]
		mov vReg124_airthmeticBinary__cp vReg120_func_arg_a__cp
		add vReg124_airthmeticBinary__cp vReg121_func_arg_b__cp
		add vReg124_airthmeticBinary__cp vReg122_func_arg_c__cp
		and vReg124_airthmeticBinary__cp 1073741823
		mov vReg39_returnValue_of_func vReg124_airthmeticBinary__cp
		jmp _BB74_main25_leave_func__inline
	<_BB74_main25_leave_func__inline>
		mov qword [vReg38_arrCall_to_reg + vReg29_j*8] vReg39_returnValue_of_func
		mov vReg43_arrCall_to_reg qword [vReg22_g_useless + vReg28_i*8]
		mov vReg45_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg46_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg47_arrCall_to_reg qword [vReg10_f + vReg30_k*8]
		mov vReg125_func_arg_a__cp qword [vReg45_arrCall_to_reg + vReg29_j*8]
		mov vReg126_func_arg_b__cp qword [vReg46_arrCall_to_reg + vReg30_k*8]
		mov vReg127_func_arg_c__cp qword [vReg47_arrCall_to_reg + vReg29_j*8]
		mov vReg129_airthmeticBinary__cp vReg125_func_arg_a__cp
		add vReg129_airthmeticBinary__cp vReg126_func_arg_b__cp
		add vReg129_airthmeticBinary__cp vReg127_func_arg_c__cp
		and vReg129_airthmeticBinary__cp 1073741823
		mov vReg44_returnValue_of_func vReg129_airthmeticBinary__cp
		jmp _BB75_main26_leave_func__inline
	<_BB75_main26_leave_func__inline>
		mov qword [vReg43_arrCall_to_reg + vReg29_j*8] vReg44_returnValue_of_func
		mov vReg48_arrCall_to_reg qword [vReg22_g_useless + vReg28_i*8]
		mov vReg50_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg51_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg52_arrCall_to_reg qword [vReg10_f + vReg30_k*8]
		mov vReg130_func_arg_a__cp qword [vReg50_arrCall_to_reg + vReg29_j*8]
		mov vReg131_func_arg_b__cp qword [vReg51_arrCall_to_reg + vReg30_k*8]
		mov vReg132_func_arg_c__cp qword [vReg52_arrCall_to_reg + vReg29_j*8]
		mov vReg134_airthmeticBinary__cp vReg130_func_arg_a__cp
		add vReg134_airthmeticBinary__cp vReg131_func_arg_b__cp
		add vReg134_airthmeticBinary__cp vReg132_func_arg_c__cp
		and vReg134_airthmeticBinary__cp 1073741823
		mov vReg49_returnValue_of_func vReg134_airthmeticBinary__cp
		jmp _BB76_main27_leave_func__inline
	<_BB76_main27_leave_func__inline>
		mov qword [vReg48_arrCall_to_reg + vReg29_j*8] vReg49_returnValue_of_func
		inc vReg30_k
		cjmp if(vReg30_k GE vReg8_n) goto _BB28_main14_forexpr3 else _BB33_main17_forBody
		jmp _BB33_main17_forBody

********************************************************************************

<main>
	<_BB5_main0_entry_main>
		call getInt ()
		mov vReg9_returnValue_of_getInt rax
		mov vReg8_n vReg9_returnValue_of_getInt
		mov vReg12_new_size vReg8_n
		inc vReg12_new_size
		shl vReg12_new_size 3
		mov rdi vReg12_new_size
		call malloc (vReg12_new_size)
		mov vReg11_arrayNew rax
		mov qword [vReg11_arrayNew] vReg8_n
		add vReg11_arrayNew 8
		mov vReg12_new_size vReg8_n
		mov vReg13_new_cnt 0
		cjmp if(vReg12_new_size E 0) goto _BB8_main2_newWhileAfter else _BB7_main1_newWhileBody
		jmp _BB7_main1_newWhileBody
	<_BB7_main1_newWhileBody>
		mov vReg15_new_size vReg8_n
		inc vReg15_new_size
		shl vReg15_new_size 3
		mov rdi vReg15_new_size
		call malloc (vReg15_new_size)
		mov vReg14_arrayNew rax
		mov qword [vReg14_arrayNew] vReg8_n
		add vReg14_arrayNew 8
		mov qword [vReg11_arrayNew + vReg13_new_cnt*8] vReg14_arrayNew
		inc vReg13_new_cnt
		cjmp if(vReg13_new_cnt NE vReg12_new_size) goto _BB7_main1_newWhileBody else _BB8_main2_newWhileAfter
		jmp _BB8_main2_newWhileAfter
	<_BB8_main2_newWhileAfter>
		mov vReg10_f vReg11_arrayNew
		mov vReg18_new_size vReg8_n
		inc vReg18_new_size
		shl vReg18_new_size 3
		mov rdi vReg18_new_size
		call malloc (vReg18_new_size)
		mov vReg17_arrayNew rax
		mov qword [vReg17_arrayNew] vReg8_n
		add vReg17_arrayNew 8
		mov vReg18_new_size vReg8_n
		mov vReg19_new_cnt 0
		cjmp if(vReg18_new_size E 0) goto _BB11_main4_newWhileAfter else _BB10_main3_newWhileBody
		jmp _BB10_main3_newWhileBody
	<_BB10_main3_newWhileBody>
		mov vReg21_new_size vReg8_n
		inc vReg21_new_size
		shl vReg21_new_size 3
		mov rdi vReg21_new_size
		call malloc (vReg21_new_size)
		mov vReg20_arrayNew rax
		mov qword [vReg20_arrayNew] vReg8_n
		add vReg20_arrayNew 8
		mov qword [vReg17_arrayNew + vReg19_new_cnt*8] vReg20_arrayNew
		inc vReg19_new_cnt
		cjmp if(vReg19_new_cnt NE vReg18_new_size) goto _BB10_main3_newWhileBody else _BB11_main4_newWhileAfter
		jmp _BB11_main4_newWhileAfter
	<_BB11_main4_newWhileAfter>
		mov vReg16_g vReg17_arrayNew
		mov vReg24_new_size vReg8_n
		inc vReg24_new_size
		shl vReg24_new_size 3
		mov rdi vReg24_new_size
		call malloc (vReg24_new_size)
		mov vReg23_arrayNew rax
		mov qword [vReg23_arrayNew] vReg8_n
		add vReg23_arrayNew 8
		mov vReg24_new_size vReg8_n
		mov vReg25_new_cnt 0
		cjmp if(vReg24_new_size NE 0) goto _BB13_main5_newWhileBody else _BB14_main6_newWhileAfter
		jmp _BB14_main6_newWhileAfter
	<_BB13_main5_newWhileBody>
		mov vReg27_new_size vReg8_n
		inc vReg27_new_size
		shl vReg27_new_size 3
		mov rdi vReg27_new_size
		call malloc (vReg27_new_size)
		mov vReg26_arrayNew rax
		mov qword [vReg26_arrayNew] vReg8_n
		add vReg26_arrayNew 8
		mov qword [vReg23_arrayNew + vReg25_new_cnt*8] vReg26_arrayNew
		inc vReg25_new_cnt
		cjmp if(vReg25_new_cnt NE vReg24_new_size) goto _BB13_main5_newWhileBody else _BB14_main6_newWhileAfter
		jmp _BB14_main6_newWhileAfter
	<_BB14_main6_newWhileAfter>
		mov vReg22_g_useless vReg23_arrayNew
		mov vReg28_i 0
		cjmp if(vReg8_n G 0) goto _BB17_main8_forBody else _BB18_main9_forAfter
		jmp _BB18_main9_forAfter
	<_BB16_main7_forexpr3>
		inc vReg28_i
		cjmp if(vReg28_i L vReg8_n) goto _BB17_main8_forBody else _BB18_main9_forAfter
		jmp _BB18_main9_forAfter
	<_BB17_main8_forBody>
		mov vReg29_j 0
		cjmp if(vReg8_n G 0) goto _BB21_main10_forBody else _BB16_main7_forexpr3
		jmp _BB16_main7_forexpr3
	<_BB18_main9_forAfter>
		mov vReg28_i 0
		cjmp if(vReg8_n LE 0) goto _BB26_main13_forAfter else _BB25_main12_forBody
		jmp _BB25_main12_forBody
	<_BB21_main10_forBody>
		mov vReg31_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg32_airthmeticBinary vReg28_i
		add vReg32_airthmeticBinary vReg29_j
		mov qword [vReg31_arrCall_to_reg + vReg29_j*8] vReg32_airthmeticBinary
		inc vReg29_j
		cjmp if(vReg29_j L vReg8_n) goto _BB21_main10_forBody else _BB16_main7_forexpr3
		jmp _BB16_main7_forexpr3
	<_BB24_main11_forexpr3>
		inc vReg28_i
		cjmp if(vReg28_i GE vReg8_n) goto _BB26_main13_forAfter else _BB25_main12_forBody
		jmp _BB25_main12_forBody
	<_BB25_main12_forBody>
		mov vReg29_j 0
		cjmp if(vReg8_n LE 0) goto _BB24_main11_forexpr3 else _BB29_main15_forBody
		jmp _BB29_main15_forBody
	<_BB26_main13_forAfter>
		mov vReg53_sum 0
		mov vReg28_i 0
		cjmp if(vReg8_n LE 0) goto _BB40_main21_forAfter else _BB39_main20_forBody
		jmp _BB39_main20_forBody
	<_BB28_main14_forexpr3>
		inc vReg29_j
		cjmp if(vReg29_j GE vReg8_n) goto _BB24_main11_forexpr3 else _BB29_main15_forBody
		jmp _BB29_main15_forBody
	<_BB29_main15_forBody>
		mov vReg30_k 0
		cjmp if(vReg8_n LE 0) goto _BB28_main14_forexpr3 else _BB33_main17_forBody
		jmp _BB33_main17_forBody
	<_BB32_main16_forexpr3>
		inc vReg30_k
		cjmp if(vReg30_k GE vReg8_n) goto _BB28_main14_forexpr3 else _BB33_main17_forBody
		jmp _BB33_main17_forBody
	<_BB33_main17_forBody>
		cjmp if(vReg29_j L vReg28_i) goto _BB32_main16_forexpr3 else _BB35_main18_Ifthen
		jmp _BB35_main18_Ifthen
	<_BB35_main18_Ifthen>
		mov vReg33_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg35_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg36_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg37_arrCall_to_reg qword [vReg10_f + vReg30_k*8]
		mov vReg115_func_arg_a__cp qword [vReg35_arrCall_to_reg + vReg29_j*8]
		mov vReg116_func_arg_b__cp qword [vReg36_arrCall_to_reg + vReg30_k*8]
		mov vReg117_func_arg_c__cp qword [vReg37_arrCall_to_reg + vReg29_j*8]
		mov vReg119_airthmeticBinary__cp vReg115_func_arg_a__cp
		add vReg119_airthmeticBinary__cp vReg116_func_arg_b__cp
		add vReg119_airthmeticBinary__cp vReg117_func_arg_c__cp
		and vReg119_airthmeticBinary__cp 1073741823
		mov vReg34_returnValue_of_func vReg119_airthmeticBinary__cp
		mov qword [vReg33_arrCall_to_reg + vReg29_j*8] vReg34_returnValue_of_func
		mov vReg38_arrCall_to_reg qword [vReg22_g_useless + vReg28_i*8]
		mov vReg40_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg41_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg42_arrCall_to_reg qword [vReg10_f + vReg30_k*8]
		mov vReg120_func_arg_a__cp qword [vReg40_arrCall_to_reg + vReg29_j*8]
		mov vReg121_func_arg_b__cp qword [vReg41_arrCall_to_reg + vReg30_k*8]
		mov vReg122_func_arg_c__cp qword [vReg42_arrCall_to_reg + vReg29_j*8]
		mov vReg124_airthmeticBinary__cp vReg120_func_arg_a__cp
		add vReg124_airthmeticBinary__cp vReg121_func_arg_b__cp
		add vReg124_airthmeticBinary__cp vReg122_func_arg_c__cp
		and vReg124_airthmeticBinary__cp 1073741823
		mov vReg39_returnValue_of_func vReg124_airthmeticBinary__cp
		mov qword [vReg38_arrCall_to_reg + vReg29_j*8] vReg39_returnValue_of_func
		mov vReg43_arrCall_to_reg qword [vReg22_g_useless + vReg28_i*8]
		mov vReg45_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg46_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg47_arrCall_to_reg qword [vReg10_f + vReg30_k*8]
		mov vReg125_func_arg_a__cp qword [vReg45_arrCall_to_reg + vReg29_j*8]
		mov vReg126_func_arg_b__cp qword [vReg46_arrCall_to_reg + vReg30_k*8]
		mov vReg127_func_arg_c__cp qword [vReg47_arrCall_to_reg + vReg29_j*8]
		mov vReg129_airthmeticBinary__cp vReg125_func_arg_a__cp
		add vReg129_airthmeticBinary__cp vReg126_func_arg_b__cp
		add vReg129_airthmeticBinary__cp vReg127_func_arg_c__cp
		and vReg129_airthmeticBinary__cp 1073741823
		mov vReg44_returnValue_of_func vReg129_airthmeticBinary__cp
		mov qword [vReg43_arrCall_to_reg + vReg29_j*8] vReg44_returnValue_of_func
		mov vReg48_arrCall_to_reg qword [vReg22_g_useless + vReg28_i*8]
		mov vReg50_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg51_arrCall_to_reg qword [vReg10_f + vReg28_i*8]
		mov vReg52_arrCall_to_reg qword [vReg10_f + vReg30_k*8]
		mov vReg130_func_arg_a__cp qword [vReg50_arrCall_to_reg + vReg29_j*8]
		mov vReg131_func_arg_b__cp qword [vReg51_arrCall_to_reg + vReg30_k*8]
		mov vReg132_func_arg_c__cp qword [vReg52_arrCall_to_reg + vReg29_j*8]
		mov vReg134_airthmeticBinary__cp vReg130_func_arg_a__cp
		add vReg134_airthmeticBinary__cp vReg131_func_arg_b__cp
		add vReg134_airthmeticBinary__cp vReg132_func_arg_c__cp
		and vReg134_airthmeticBinary__cp 1073741823
		mov vReg49_returnValue_of_func vReg134_airthmeticBinary__cp
		mov qword [vReg48_arrCall_to_reg + vReg29_j*8] vReg49_returnValue_of_func
		inc vReg30_k
		cjmp if(vReg30_k GE vReg8_n) goto _BB28_main14_forexpr3 else _BB33_main17_forBody
		jmp _BB33_main17_forBody
	<_BB38_main19_forexpr3>
		inc vReg28_i
		cjmp if(vReg28_i GE vReg8_n) goto _BB40_main21_forAfter else _BB39_main20_forBody
		jmp _BB39_main20_forBody
	<_BB39_main20_forBody>
		mov vReg29_j 0
		cjmp if(vReg8_n G 0) goto _BB43_main22_forBody else _BB38_main19_forexpr3
		jmp _BB38_main19_forexpr3
	<_BB40_main21_forAfter>
		mov rdi vReg53_sum
		call toString (vReg53_sum)
		mov vReg57_returnValue_of_toString rax
		mov rdi vReg57_returnValue_of_toString
		call print (vReg57_returnValue_of_toString)
		mov rax 0
		jmp _BB45_main23_leave_main
	<_BB43_main22_forBody>
		mov vReg54_arrCall_to_reg qword [vReg16_g + vReg28_i*8]
		mov vReg55_airthmeticBinary vReg53_sum
		add vReg55_airthmeticBinary qword [vReg54_arrCall_to_reg + vReg29_j*8]
		and vReg55_airthmeticBinary 1073741823
		mov vReg53_sum vReg55_airthmeticBinary
		inc vReg29_j
		cjmp if(vReg29_j L vReg8_n) goto _BB43_main22_forBody else _BB38_main19_forexpr3
		jmp _BB38_main19_forexpr3
	<_BB45_main23_leave_main>
		leave
		ret

********************************************************************************

_BB11_main4_newWhileAfter <- _BB14_main6_newWhileAfter
_BB14_main6_newWhileAfter <- _BB18_main9_forAfter
_BB18_main9_forAfter <- _BB25_main12_forBody
_BB25_main12_forBody <- _BB29_main15_forBody
_BB29_main15_forBody <- _BB33_main17_forBody
_BB35_main18_Ifthen <- _BB33_main17_forBody
_BB28_main14_forexpr3 <- _BB29_main15_forBody
_BB26_main13_forAfter <- _BB39_main20_forBody
_BB39_main20_forBody <- _BB38_main19_forexpr3
_BB43_main22_forBody <- _BB38_main19_forexpr3
_BB32_main16_forexpr3 <- _BB33_main17_forBody
_BB17_main8_forBody <- _BB16_main7_forexpr3
_BB21_main10_forBody <- _BB16_main7_forexpr3
_BB18_main9_forAfter <- _BB29_main15_forBody
_BB25_main12_forBody <- _BB33_main17_forBody
_BB26_main13_forAfter <- _BB38_main19_forexpr3

Process finished with exit code 0
