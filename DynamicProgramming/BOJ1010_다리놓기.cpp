/*BOJ 1010 �ٸ�����
���ã�µ� �̻��ϰ� �ð��� ���� �ɷȴ�.
�ᱹ ��ȭ���� ã�Ƽ� �ݺ����� �̿��� dp�� Ǯ����.
dp[n][m]= dp[n-1][m-1]+dp[n-1][m-2]+ '''' + dp[n-1][n-1]
https://www.acmicpc.net/problem/1010
*/

#include <iostream>
#include <cstring>
using namespace std;

int dp[30][30];

int main() {
	int T;
	int N, M;
	scanf("%d", &T);
	for (int t = 0; t < T; t++) {
		scanf("%d%d", &N, &M);
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= M; j++) {
				if (i == 1) dp[i][j] = j; //i�� 1�� �� ����� ���� j
				else if (i == j) dp[i][j] = 1; //i �� j�� �������� ��� ���� �ϴ��� �̹Ƿ� ����� ���� 1��
				else if (j > i) {
					for (int k = j-1; k >= i-1; k--)
						dp[i][j] += dp[i - 1][k]; //��ȭ��
				}
			}
		}
		printf("%d\n", dp[N][M]);
		memset(dp, 0, sizeof(dp));
	}
	return 0;
}