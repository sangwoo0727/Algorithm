#include <iostream>
using namespace std;
long long dp[50];

long long fib(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	long long &ret = dp[n];
	if (ret != -1) return ret;
	ret = 0;
	return ret = go(n - 1) + go(n - 2);
}

int main()[
	int n = 0;
	scanf("%d", &n);
	memset(dp, -1, sizeof(dp));
	printf("%lld", fib(n));
	return 0;
]