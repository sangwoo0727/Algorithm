/*BOJ 1010 다리놓기
방법찾는데 이상하게 시간이 오래 걸렸다.
결국 점화식을 찾아서 반복문을 이용한 dp로 풀었다.
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
				if (i == 1) dp[i][j] = j; //i가 1일 때 경우의 수는 j
				else if (i == j) dp[i][j] = 1; //i 와 j가 같을때는 모든 점이 일대일 이므로 경우의 수는 1개
				else if (j > i) {
					for (int k = j-1; k >= i-1; k--)
						dp[i][j] += dp[i - 1][k]; //점화식
				}
			}
		}
		printf("%d\n", dp[N][M]);
		memset(dp, 0, sizeof(dp));
	}
	return 0;
}