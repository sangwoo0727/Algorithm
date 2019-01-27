/*1094 막대기 문제
그냥 문제 주어진대로 조건쓰면 된다.*/
#include <iostream>
using namespace std;

int main() {
	int X;
	int cnt = 0;
	int result = 0;
	int garbage = 64;

	scanf("%d", &X);

	if (X == 64) {
		printf("1\n");
		return 0;
	}
	while (X != result) {
		garbage = garbage / 2;
		if (garbage + result > X) continue;
		result += garbage;
		cnt++;
	}
	printf("%d\n", cnt);
	return 0;
}