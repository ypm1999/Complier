/usr/lib/jvm/java-1.11.0-openjdk-amd64/bin/java -javaagent:/home/sjtu-ypm/Downloads/ideaIU-2018.3.5/lib/idea_rt.jar=37115:/home/sjtu-ypm/Downloads/ideaIU-2018.3.5/bin -Dfile.encoding=UTF-8 -classpath /home/sjtu-ypm/complier/src/out/production/src:/home/sjtu-ypm/complier/src/lib/antlr-4.7.2-complete.jar com.mxcomplier.Main -DEBUG
<worka>
	<_BB3_worka0_entry_worka>
		mov vReg6_airthmeticBinary vReg4_worka_arg_x
		add vReg6_airthmeticBinary vReg4_worka_arg_x
		sub vReg6_airthmeticBinary vReg5_worka_arg_y
		mov vReg0_returnValue_of_worka vReg6_airthmeticBinary
		jmp _BB4_worka1_leave_worka
	<_BB4_worka1_leave_worka>
		leave
		ret

********************************************************************************

<workb>
	<_BB5_workb0_entry_workb>
		mov vReg10_Unary_temp vReg8_workb_arg_x
		neg vReg10_Unary_temp
		mov vReg11_airthmeticBinary vReg10_Unary_temp
		add vReg11_airthmeticBinary vReg9_workb_arg_y
		add vReg11_airthmeticBinary vReg9_workb_arg_y
		mov vReg1_returnValue_of_workb vReg11_airthmeticBinary
		jmp _BB6_workb1_leave_workb
	<_BB6_workb1_leave_workb>
		leave
		ret

********************************************************************************

<workc>
	<_BB7_workc0_entry_workc>
		mov vReg15_airthmeticBinary vReg13_workc_arg_x
		add vReg15_airthmeticBinary vReg13_workc_arg_x
		add vReg15_airthmeticBinary vReg13_workc_arg_x
		sub vReg15_airthmeticBinary vReg14_workc_arg_y
		sub vReg15_airthmeticBinary vReg14_workc_arg_y
		mov vReg2_returnValue_of_workc vReg15_airthmeticBinary
		jmp _BB8_workc1_leave_workc
	<_BB8_workc1_leave_workc>
		leave
		ret

********************************************************************************

<main>
	<_BB9_main0_entry_main>
		call getInt ()
		mov vReg19_a vReg20_returnValue_of_getInt
		mov vReg21_b 0
		mov vReg23_d 0
		mov vReg24_e 1
		mov vReg25_f 0
		mov vReg26_g 1
		mov vReg27_i 1
		jmp _BB12_main2_forBody
	<_BB11_main1_forexpr3>
		inc vReg27_i
		cjmp if(vReg27_i LE 100000000) goto _BB12_main2_forBody else _BB13_main3_forAfter
	<_BB12_main2_forBody>
		call worka (vReg19_a,vReg21_b)
		mov vReg19_a vReg29_returnValue_of_worka
		call workb (vReg19_a,vReg21_b)
		mov vReg21_b vReg30_returnValue_of_workb
		call workc (vReg19_a,vReg21_b)
		mov vReg22_c vReg31_returnValue_of_workc
		mov vReg32_Unary_temp vReg19_a
		neg vReg32_Unary_temp
		mov vReg33_airthmeticBinary vReg32_Unary_temp
		add vReg33_airthmeticBinary vReg21_b
		sub vReg33_airthmeticBinary vReg22_c
		add vReg33_airthmeticBinary vReg23_d
		add vReg33_airthmeticBinary vReg24_e
		sub vReg33_airthmeticBinary vReg25_f
		add vReg33_airthmeticBinary vReg26_g
		mov vReg23_d vReg33_airthmeticBinary
		mov vReg39_airthmeticBinary vReg19_a
		add vReg39_airthmeticBinary vReg21_b
		add vReg39_airthmeticBinary vReg22_c
		sub vReg39_airthmeticBinary vReg23_d
		sub vReg39_airthmeticBinary vReg24_e
		sub vReg39_airthmeticBinary vReg25_f
		add vReg39_airthmeticBinary vReg26_g
		mov vReg24_e vReg39_airthmeticBinary
		mov vReg45_airthmeticBinary vReg19_a
		add vReg45_airthmeticBinary vReg21_b
		sub vReg45_airthmeticBinary vReg22_c
		add vReg45_airthmeticBinary vReg23_d
		sub vReg45_airthmeticBinary vReg24_e
		add vReg45_airthmeticBinary vReg25_f
		sub vReg45_airthmeticBinary vReg26_g
		mov vReg25_f vReg45_airthmeticBinary
		mov vReg51_airthmeticBinary vReg19_a
		sub vReg51_airthmeticBinary vReg21_b
		sub vReg51_airthmeticBinary vReg22_c
		sub vReg51_airthmeticBinary vReg23_d
		add vReg51_airthmeticBinary vReg24_e
		add vReg51_airthmeticBinary vReg25_f
		add vReg51_airthmeticBinary vReg26_g
		mov vReg26_g vReg51_airthmeticBinary
		mov vReg57_airthmeticBinary vReg19_a
		add vReg57_airthmeticBinary vReg21_b
		add vReg57_airthmeticBinary vReg22_c
		add vReg57_airthmeticBinary vReg23_d
		add vReg57_airthmeticBinary vReg24_e
		add vReg57_airthmeticBinary vReg25_f
		add vReg57_airthmeticBinary vReg26_g
		cjmp if(vReg57_airthmeticBinary G 100000000) goto _BB14_main4_Ifthen else _BB11_main1_forexpr3
	<_BB13_main3_forAfter>
		call toString (vReg26_g)
		call println (vReg63_returnValue_of_toString)
		mov vReg3_returnValue_of_main 0
		jmp _BB16_main5_leave_main
	<_BB14_main4_Ifthen>
		mov vReg19_a 123
		mov vReg21_b 456
		mov vReg23_d 155
		mov vReg24_e 123
		mov vReg25_f 55
		mov vReg26_g 32
		inc vReg27_i
		cjmp if(vReg27_i LE 100000000) goto _BB12_main2_forBody else _BB13_main3_forAfter
	<_BB16_main5_leave_main>
		leave
		ret

********************************************************************************


Process finished with exit code 0
