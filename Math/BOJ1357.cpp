/*1357 숫자뒤집기문제
rev 함수 만들어서 풀면되는 간단한 문제*/

#include <iostream>
#include <algorithm>
using namespace std;

int rev(int n) {
	int fourN, threeN, twoN, oneN;
	fourN = n / 1000;
	n -= (fourN * 1000);
	threeN = n / 100;
	n -= (threeN * 100);
	twoN = n / 10;
	oneN = n % 10;
	if (fourN > 0) return oneN * 1000 + twoN * 100 + threeN * 10 + fourN;
	else if (threeN > 0) return oneN * 100 + twoN * 10 + threeN;
	else if (twoN > 0) return oneN * 10 + twoN;
	else return oneN;
}

int main() {
	int x, y;
	scanf("%d%d", &x, &y);
	printf("%d", rev(rev(x) + rev(y)));
	return 0;
}

