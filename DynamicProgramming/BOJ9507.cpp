/*9507 Generations of Tribbles
�� ������ �׳� �Ǻ���ġ Ȯ��������� dp�� Ǯ�� �ٷ� �ذ�ȴ�.*/
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