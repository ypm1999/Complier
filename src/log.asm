/usr/lib/jvm/java-1.11.0-openjdk-amd64/bin/java -javaagent:/home/sjtu-ypm/Downloads/ideaIU-2018.3.5/lib/idea_rt.jar=44037:/home/sjtu-ypm/Downloads/ideaIU-2018.3.5/bin -Dfile.encoding=UTF-8 -classpath /home/sjtu-ypm/complier/src/out/production/src:/home/sjtu-ypm/complier/src/lib/antlr-4.7.2-complete.jar com.mxcomplier.Main -DEBUG
<fibo>
	<fibo0_entry_fibo>
		cjmp if(vReg2_fibo_arg_x L 2) goto fibo1_Ifthen else fibo2_Ifafter
	<fibo1_Ifthen>
		mov vReg0_returnValue_of_fibo vReg2_fibo_arg_x
		jmp fibo3_leave_fibo
	<fibo2_Ifafter>
		mov vReg4_airthmeticBinary vReg2_fibo_arg_x
		dec vReg4_airthmeticBinary
		mov vReg23_fibo_arg_x__cp vReg4_airthmeticBinary
		cjmp if(vReg23_fibo_arg_x__cp L 2) goto fibo5_Ifthen__inline else fibo6_Ifafter__inline
	<fibo3_leave_fibo>
		leave
		ret
	<fibo4_leave_fibo__inline>
		mov vReg6_airthmeticBinary vReg2_fibo_arg_x
		sub vReg6_airthmeticBinary 2
		call fibo (vReg6_airthmeticBinary)
		mov vReg7_airthmeticBinary vReg3_returnValue_of_fibo
		add vReg7_airthmeticBinary vReg5_returnValue_of_fibo
		mov vReg0_returnValue_of_fibo vReg7_airthmeticBinary
		jmp fibo3_leave_fibo
	<fibo5_Ifthen__inline>
		mov vReg3_returnValue_of_fibo vReg23_fibo_arg_x__cp
		jmp fibo4_leave_fibo__inline
	<fibo6_Ifafter__inline>
		mov vReg26_airthmeticBinary__cp vReg23_fibo_arg_x__cp
		dec vReg26_airthmeticBinary__cp
		call fibo (vReg26_airthmeticBinary__cp)
		mov vReg28_airthmeticBinary__cp vReg23_fibo_arg_x__cp
		sub vReg28_airthmeticBinary__cp 2
		call fibo (vReg28_airthmeticBinary__cp)
		mov vReg29_airthmeticBinary__cp vReg25_returnValue_of_fibo__cp
		add vReg29_airthmeticBinary__cp vReg27_returnValue_of_fibo__cp
		mov vReg3_returnValue_of_fibo vReg29_airthmeticBinary__cp
		jmp fibo4_leave_fibo__inline

********************************************************************************

<main>
	<main0_entry_main>
		call getInt ()
		mov vReg8_n vReg9_returnValue_of_getInt
		mov vReg30_fibo_arg_x_cp vReg8_n
		cjmp if(vReg30_fibo_arg_x_cp L 2) goto main5_Ifthen_inline else main9_Ifafter_inline
	<main1_forBody>
		mov vReg43_fibo_arg_x_cp 30
		cjmp if(vReg43_fibo_arg_x_cp L 2) goto main11_Ifthen_inline else main15_Ifafter_inline
	<main2_forAfter>
		mov vReg1_returnValue_of_main 0
		jmp main3_leave_main
	<main3_leave_main>
		leave
		ret
	<main4_leave_fibo_inline>
		call toString (vReg11_returnValue_of_fibo)
		call println (vReg10_returnValue_of_toString)
		mov vReg12_i 0
		cjmp if(vReg12_i LE 100) goto main1_forBody else main2_forAfter
	<main5_Ifthen_inline>
		mov vReg11_returnValue_of_fibo vReg30_fibo_arg_x_cp
		jmp main4_leave_fibo_inline
	<main6_leave_fibo__inline_inline>
		mov vReg35_airthmeticBinary_cp vReg30_fibo_arg_x_cp
		sub vReg35_airthmeticBinary_cp 2
		call fibo (vReg35_airthmeticBinary_cp)
		mov vReg36_airthmeticBinary_cp vReg32_returnValue_of_fibo_cp
		add vReg36_airthmeticBinary_cp vReg34_returnValue_of_fibo_cp
		mov vReg11_returnValue_of_fibo vReg36_airthmeticBinary_cp
		jmp main4_leave_fibo_inline
	<main7_Ifthen__inline_inline>
		mov vReg32_returnValue_of_fibo_cp vReg37_fibo_arg_x__cp_cp
		jmp main6_leave_fibo__inline_inline
	<main8_Ifafter__inline_inline>
		mov vReg39_airthmeticBinary__cp_cp vReg37_fibo_arg_x__cp_cp
		dec vReg39_airthmeticBinary__cp_cp
		call fibo (vReg39_airthmeticBinary__cp_cp)
		mov vReg41_airthmeticBinary__cp_cp vReg37_fibo_arg_x__cp_cp
		sub vReg41_airthmeticBinary__cp_cp 2
		call fibo (vReg41_airthmeticBinary__cp_cp)
		mov vReg42_airthmeticBinary__cp_cp vReg38_returnValue_of_fibo__cp_cp
		add vReg42_airthmeticBinary__cp_cp vReg40_returnValue_of_fibo__cp_cp
		mov vReg32_returnValue_of_fibo_cp vReg42_airthmeticBinary__cp_cp
		jmp main6_leave_fibo__inline_inline
	<main9_Ifafter_inline>
		mov vReg33_airthmeticBinary_cp vReg30_fibo_arg_x_cp
		dec vReg33_airthmeticBinary_cp
		mov vReg37_fibo_arg_x__cp_cp vReg33_airthmeticBinary_cp
		cjmp if(vReg37_fibo_arg_x__cp_cp L 2) goto main7_Ifthen__inline_inline else main8_Ifafter__inline_inline
	<main10_leave_fibo_inline>
		call toString (vReg14_returnValue_of_fibo)
		call println (vReg13_returnValue_of_toString)
		inc vReg12_i
		cjmp if(vReg12_i LE 100) goto main1_forBody else main2_forAfter
	<main11_Ifthen_inline>
		mov vReg14_returnValue_of_fibo vReg43_fibo_arg_x_cp
		jmp main10_leave_fibo_inline
	<main12_leave_fibo__inline_inline>
		mov vReg48_airthmeticBinary_cp vReg43_fibo_arg_x_cp
		sub vReg48_airthmeticBinary_cp 2
		call fibo (vReg48_airthmeticBinary_cp)
		mov vReg49_airthmeticBinary_cp vReg45_returnValue_of_fibo_cp
		add vReg49_airthmeticBinary_cp vReg47_returnValue_of_fibo_cp
		mov vReg14_returnValue_of_fibo vReg49_airthmeticBinary_cp
		jmp main10_leave_fibo_inline
	<main13_Ifthen__inline_inline>
		mov vReg45_returnValue_of_fibo_cp vReg50_fibo_arg_x__cp_cp
		jmp main12_leave_fibo__inline_inline
	<main14_Ifafter__inline_inline>
		mov vReg52_airthmeticBinary__cp_cp vReg50_fibo_arg_x__cp_cp
		dec vReg52_airthmeticBinary__cp_cp
		call fibo (vReg52_airthmeticBinary__cp_cp)
		mov vReg54_airthmeticBinary__cp_cp vReg50_fibo_arg_x__cp_cp
		sub vReg54_airthmeticBinary__cp_cp 2
		call fibo (vReg54_airthmeticBinary__cp_cp)
		mov vReg55_airthmeticBinary__cp_cp vReg51_returnValue_of_fibo__cp_cp
		add vReg55_airthmeticBinary__cp_cp vReg53_returnValue_of_fibo__cp_cp
		mov vReg45_returnValue_of_fibo_cp vReg55_airthmeticBinary__cp_cp
		jmp main12_leave_fibo__inline_inline
	<main15_Ifafter_inline>
		mov vReg46_airthmeticBinary_cp vReg43_fibo_arg_x_cp
		dec vReg46_airthmeticBinary_cp
		mov vReg50_fibo_arg_x__cp_cp vReg46_airthmeticBinary_cp
		cjmp if(vReg50_fibo_arg_x__cp_cp L 2) goto main13_Ifthen__inline_inline else main14_Ifafter__inline_inline

********************************************************************************
