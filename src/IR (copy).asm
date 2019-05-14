/usr/lib/jvm/java-1.11.0-openjdk-amd64/bin/java -javaagent:/home/sjtu-ypm/Downloads/ideaIU-2018.3.5/lib/idea_rt.jar=39401:/home/sjtu-ypm/Downloads/ideaIU-2018.3.5/bin -Dfile.encoding=UTF-8 -classpath /home/sjtu-ypm/complier/src/out/production/src:/home/sjtu-ypm/complier/src/lib/antlr-4.7.2-complete.jar com.mxcomplier.Main -DEBUG
<main>
	<main0_entry_main>
		call __init ()
		mov vReg6_new_size 4
		inc vReg6_new_size
		shl vReg6_new_size 3
		call malloc (vReg6_new_size)
		mov qword [vReg5_arrayNew] 4
		add vReg5_arrayNew 8
		mov vReg4_b vReg5_arrayNew
		mov qword [vReg4_b] vReg1_a
		mov qword [vReg4_b + 8] vReg1_a
		mov qword [vReg4_b + 16] vReg1_a
		mov qword [vReg4_b + 24] vReg1_a
		call ___array_size (vReg4_b)
		call toString (vReg9_returnValue_of_size)
		call println (vReg8_returnValue_of_toString)
		mov vReg0_returnValue_of_main 0
		leave
		ret

********************************************************************************

<__init>
	<__init0_initFuncEntry>
		mov vReg3_new_size 4
		inc vReg3_new_size
		shl vReg3_new_size 3
		call malloc (vReg3_new_size)
		mov qword [vReg2_arrayNew] 4
		add vReg2_arrayNew 8
		mov vReg1_a vReg2_arrayNew
		mov [rel a] vReg1_a
		leave
		ret

********************************************************************************

<main>
	<main0_entry_main>
	<main1_initFuncEntry_inline>
		mov vReg6_new_size 4
		inc vReg6_new_size
		shl vReg6_new_size 3
		call malloc (vReg6_new_size)
		mov qword [vReg5_arrayNew] 4
		add vReg5_arrayNew 8
		mov vReg4_b vReg5_arrayNew
		mov qword [vReg4_b] vReg1_a
		mov qword [vReg4_b + 8] vReg1_a
		mov qword [vReg4_b + 16] vReg1_a
		mov qword [vReg4_b + 24] vReg1_a
		call ___array_size (vReg4_b)
		call toString (vReg9_returnValue_of_size)
		call println (vReg8_returnValue_of_toString)
		mov vReg0_returnValue_of_main 0
		leave
		ret

********************************************************************************


Process finished with exit code 0
