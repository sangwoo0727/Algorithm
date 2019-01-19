/*2167
2차원 배열의 합 문제*/

#include <iostream>
using namespace std;

int main() {
	int N, M, K;
	int value = 0;
	int sum[10000] = {};
	int x1, x2, y1, y2;
	int dp[301][301] = {}; //(0,0)에서 (n,m)까지의 합
	scanf("%d %d", &N, &M);
	for (int i = 1; i <= N; i++){
		for (int j = 1; j <= M; j++) {
			scanf("%d", &value);
			dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + value;
		}
    }
	scanf("%d", &K);
	for (int testCase = 0; testCase<K; testCase++) {
		scanf("%d %d %d %d", &y1, &x1, &y2, &x2);
		sum[testCase] = dp[y2][x2] - dp[y2][x1 - 1] - dp[y1 - 1][x2] + dp[y1 - 1][x1 - 1];
	}
	for (int i = 0; i < K; i++) {
		printf("%d\n", sum[i]);
	}
	return 0;
}
