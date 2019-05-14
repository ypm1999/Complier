
#include <cstdio>
int add(int x,int y){return (x+y)%233;}

int dp(int x){
	if(x<=1){
		int tmp=36;
		return tmp;
	}
	int sum=0;
	int i;
	for(i=2;i<=x;i++)if((x^i)<x)
		sum=add(sum,dp(x^i));
	return sum;
}

int main(){
	printf("%d\n", dp(2));
	return 0;
}


/*!! metadata:
=== comment ===
张凯羿 inline,constant folding,recursion - 张凯羿
=== is_public ===
True
=== assert ===
output
=== timeout ===
5.0
=== input ===
55
=== phase ===
optim pretest
=== output ===
36
36
72
36
72
19
55
36
72
19
55
167
203
179
215
36
72
19
55
167
203
179
215
64
100
103
139
186
222
3
39
36
72
19
55
167
203
179
215
64
100
103
139
186
222
3
39
145
181
113
149
216
19
93
129
=== exitcode ===
0

!!*/
