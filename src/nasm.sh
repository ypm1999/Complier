rm -rf $1.elf $1.o
nasm $1.asm -f elf64 -o $1 -g
gcc $1 -fno-pie -no-pie -o $1.elf -g
time -p ./$1.elf < a.in
echo "exit code: "$? >&2
