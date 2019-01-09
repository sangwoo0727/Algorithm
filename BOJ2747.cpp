/* 2747번 피보나치수
재귀로 하면 시간초과가 난다.
동적계획법을 통해 풀어야한다.*/

#include <iostream>
#include <string.h> //memset 함수를 쓰기위해 헤더를 정의한다
using namespace std;

long long dp[50];

long long fib(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	long long &ret = dp[n];
	if (ret != -1) return ret;
	ret = 0;
	return ret = fib(n - 1) + fib(n - 2);
}

int main() {
	int n = 0;
	scanf("%d", &n);
	memset(dp, -1, sizeof(dp));
	/*memset 함수는 어떤 메모리의 시작점부터 연속된 범위를
	어떤 값으로(바이트단위) 모두 지정하고 싶을 때 사용하는 함수
	memset함수는 특정범위에 있는 연속된 메모리에 값을 지정하고 싶을때
	사용하는데, for문보다 빠른속도가 나올 수 있다. */
	printf("%lld", fib(n));
	return 0;
}