/* ���� 2858 2*nŸ�ϸ�2����
�̹����� ��ȭ�ĸ� ã���� �Ǵ� ��������.
dp[n]=dp[n-1]+dp[n-2]*2 ��ȭ���� ã�Ƽ� �ذ��ߴ�
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