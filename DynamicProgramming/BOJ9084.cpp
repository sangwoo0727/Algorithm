/*���� ���� 9084��
������ Ǭ ����1? ������ ������ �Ȱ��� ������
dp 1���� �迭�� �̿��ؼ� Ǯ �� �ִ�*/
#include <iostream>
#include <cstring>
using namespace std;

int coin[25];
int dp[10002];
int main() {
	int T;
	int N,M;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d", &N);
		for (int i = 1; i <= N; i++) {
			scanf("%d", &coin[i]);
		}
		scanf("%d", &M);
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if (j < coin[i]) dp[j] = dp[j];
				else if (j >= coin[i])
					dp[j] += dp[j - coin[i]];
			}
		}
		printf("%d\n", dp[M]);
		memset(dp, 0, sizeof(dp));
		memset(coin, 0, sizeof(coin));
	}
	return 0;
}