/*2748 피보나치2
피보나치 1문제는 n이 45까지였고 이는 int반환형 범위에서 해결할 수 있는 수의 크기였는데
이 문제는 반환형을 늘려야되는게 포인트인 문제인 것같다. 
long long을 통해 해결*/
#include <iostream>
using namespace std;

long long dp[100];
int n;

long long go(int num) {
	if (num == 0) return 0;
	if (num == 1) return 1;
	long long &ret = dp[num];
	if (ret != 0) return ret;
	ret = go(num - 1) + go(num - 2);
	return ret;
}
int main() {
	scanf("%d", &n);
	printf("%lld", go(n));
	return 0;
}