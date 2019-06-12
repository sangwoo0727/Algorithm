#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

char A[1005], B[1005];
int dp[1005][1005];

int d(char a, char b) {
	if (a==b) return 0;
	return 1;
}

int main() {
	scanf("%s", A);
	scanf("%s", B);
	int n = strlen(A);
	int m = strlen(B);
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= m; j++) {
			if (i == 0) dp[i][j] = j;
			else if (j == 0) dp[i][j] = i;
			else {
				dp[i][j] = min(dp[i-1][j - 1] + d(A[i-1], B[j-1]), min(dp[i-1][j] + 1, dp[i][j-1] + 1));
			}
		}
	}
	printf("%d", dp[n][m]);
	return 0;
}