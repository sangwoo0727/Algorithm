/* 백준 2858 2*n타일링2문제
이문제는 점화식만 찾으면 되는 문제였다.
dp[n]=dp[n-1]+dp[n-2]*2 점화식을 찾아서 해결했다
*/
#include <iostream>
using namespace std;
long long dp[1000];
int main() {
	int n;
	scanf("%d", &n);
	dp[1] = 1;
	dp[2] = 3;
	for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1]%10007 + (dp[i - 2]*2)%10007)%10007;
	}
	printf("%lld\n", dp[n]%10007);
	return 0;
}