#include <bits/stdc++.h>
using namespace std;

const int N = 100000;
int n;
int a[N], bak[N], a_left[N], a_right[N], heap[N];

void restore(){
	int i;
	for(i = 1; i <= n; i++)
		a[i] = bak[i];
}
int quicksort(int l, int r){
	int i1;int i2;int i3;int i4;int i5;int i6;int i7;int i8;
	int i9;int i10;int i11;int i12; int i13; int i14;
	int sum = 0;
	int x = a[l];
	int z_l = 0;
	int z_r = 0;
	int i;
	for(i = l + 1; i < r; i++){
		sum++;
		if(a[i] < x)
			a_left[z_l++] = a[i];
		else
			a_right[z_r++] = a[i];
	}
	int p = l;
	for(i = 0; i < z_l; i++)
		a[p++] = a_left[i];
	a[p++] = x;
	for(i = 0; i < z_r; i++)
		a[p++] = a_right[i];
	if(z_l > 1)
		sum = sum + quicksort(l, l + z_l);
	if(z_r > 1)
		sum = sum + quicksort(r - z_r, r);
	return sum;
}
int calc(){
	int i1;int i2;int i3;int i4;int i5;int i6;int i7;int i8;
	int i9;int i10;int i11;int i12; int i13; int i14;
	int i;
	for(i = 1; i <= n; i++){
		a_left[i] = i - 1;
		a_right[i] = i + 1;
	}
	int sum = 0;
	for(i = n; i >= 1; i--){
		int l = a_left[a[i]];
		int r = a_right[a[i]];
		printf("%d %d %d\n", a[i], l, r);
		a_right[l] = r;
		a_left[r] = l;
		sum = sum + r - l - 2;
	}
	return sum;
}
int mergesort(int l, int r){
	int i1;int i2;int i3;int i4;int i5;int i6;int i7;int i8;
	int i9;int i10;int i11;int i12; int i13; int i14;
	if(l + 1 == r) return 0;
	int mid = l + r >> 1;
	int sum = 0;
	sum = sum + mergesort(l, mid);
	sum = sum + mergesort(mid, r);
	int n_l = 0;
	int n_r = 0;
	int i;
	for(i = l; i < mid; i++)
		a_left[n_l++] = a[i];
	for(i = mid; i < r; i++)
		a_right[n_r++] = a[i];
	int z_l = 0;
	int z_r = 0;
	int z = l;
	while(z_l < n_l && z_r < n_r){
		sum++;
		if(a_left[z_l] < a_right[z_r])
			a[z++] = a_left[z_l++];
		else
			a[z++] = a_right[z_r++];
	}
	while(z_l < n_l)
		a[z++] = a_left[z_l++];
	while(z_r < n_r)
		a[z++] = a_right[z_r++];
	return sum;
}
int heapsort(){
	int i1;int i2;int i3;int i4;int i5;int i6;int i7;int i8;
	int i9;int i10;int i11;int i12; int i13; int i14;
	int sum = 0;
	int i;
	int tmp;
	for(i = 1; i <= n; i++){
		heap[i] = a[i];
		int x = i;
		while(x != 1){
			sum++;
			if(heap[x] > heap[x >> 1])
				break;
			tmp = heap[x];
			heap[x] = heap[x >> 1];
			heap[x >> 1] = tmp;
			x = x >> 1;
		}
	}
	int heap_size = n;
	for(i = 1; i <= n; i++){
		a[i] = heap[1];
		heap[1] = heap[heap_size--];
		int x = 1;
		while((x << 1) <= heap_size){
			int l = x << 1;
			int r = l + 1;
			int y = l;
			if(r <= heap_size){
				sum++;
				if(heap[r] < heap[l])
					y = r;
			}
			sum++;
			if(heap[x] < heap[y])
				break;
			tmp = heap[x];
			heap[x] = heap[y];
			heap[y] = tmp;
			tmp = x;
			x = y;
			y = tmp;
		}
	}
	return sum;
}
int main(){
	int i1;int i2;int i3;int i4;int i5;int i6;int i7;int i8;
	int i9;int i10;int i11;int i12; int i13; int i14;
	int k;
	scanf("%d%d", &n, &k);
	int i;
	for(i = 1; i <= n; i++){
		a[i] = i;
		if(i <= k){
			a[i] = k + 1 - i;
		}
		// printf("%d\n", a[i]);
		bak[i] = a[i];
	}
	// int ans1 = quicksort(1, n + 1);

	// restore();
	int ans2 = calc();

	// restore();
	// int ans3 = mergesort(1, n + 1);

	// restore();
	// int ans4 = heapsort();

	// printf("%d\n%d\n%d\n%d\n", ans1, ans2, ans3, ans4);
    return 0;
}




/*!! metadata:
=== comment ===
optim-515030910637-xuzhenjia.txt
=== is_public ===
True
=== assert ===
output
=== timeout ===
2.0
=== input ===
10000 1000
=== phase ===
optim pretest
=== output ===
41004000
41004000
65513
233628
623500
8623500
=== exitcode ===


!!*/