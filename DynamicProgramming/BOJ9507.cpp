/*9507 Generations of Tribbles
이 문제는 그냥 피보나치 확장느낌으로 dp로 풀면 바로 해결된다.*/
#include <iostream>
#include <cstring>
using namespace std;

int num;
long long dp[70];

long long koong(int n) {
	if (n == 0 || n == 1) return 1;
	if (n == 2) return 2;
	if (n == 3) return 4;
	long long &ret = dp[n];
	if (ret != -1) return ret;
	ret = 0;
	ret = koong(n - 1) + koong(n - 2) + koong(n - 3) + koong(n - 4);
	return ret;
}

int main() {
	int t;
	scanf("%d", &t);
	for (int i = 1; i <= t; i++) {
		scanf("%d", &num);
		memset(dp, -1, sizeof(dp));
		printf("%lld\n", koong(num));
	}
	return 0;
}