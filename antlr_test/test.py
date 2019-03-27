import os
import fileinput
make = "java -jar /usr/local/lib/antlr-4.7.2-complete.jar -visitor MxStar.g4 && javac MxStar*.java"
run = "java org.antlr.v4.gui.TestRig MxStar program semantic/"
os.system(make)
for now in open("temp", "r"):
    line = now[:-1]
    if line[0:8] != "testcase":
        continue
    command = run + line + " 2> output.txt"
    os.system(command)
    if (os.path.getsize("output.txt") != 0):
        print(line + " FAILED!!!")
        for line in open("output.txt", "r"):
            print(line)
        break    
    else:
        print(line + " PASSED")