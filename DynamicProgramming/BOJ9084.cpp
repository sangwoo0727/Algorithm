/*동전 문제 9084번
이전에 푼 동전1? 문제와 완전히 똑같은 문제다
dp 1차원 배열을 이용해서 풀 수 있다*/
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