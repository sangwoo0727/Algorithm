/*BOJ 2858 기숙사 바닥문제 
이 문제는 점화식을 세워서 풀면된다. 
풀이는 다양할 것같음*/
#include <iostream>
using namespace std;

int main() {
	int R, B;
	int L, W;
	int sum = 0;
	scanf("%d %d", &R, &B);
	sum = R + B;
	for(int W = 3; W < 5000; W++) {
		L = (sum - B + 4 )/2 - W;
		if (W > L) break;
		if (L*W != sum) continue;
		if (L*W == sum) {
			printf("%d %d", L, W);
			break;
		}
	}
	return 0;
}