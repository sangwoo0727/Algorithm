/*2747�� �Ǻ���ġ��
DP�ε� üũ�迭�� �̿��ؼ� �ϴ� Ǯ�̹�*/

#include <iostream>
using namespace std;

long long dp[50];
int check[50];

long long fib(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	if (check[n] != 0) return dp[n];
	check[n] = 1;
	dp[n] = fib(n - 1) + fib(n - 2);
	return dp[n];
}

int main() {
	int n = 0;
	scanf("%d", &n);
	printf("%lld", fib(n));
	return 0;
}