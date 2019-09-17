#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int board[105][105];
int dp[105][105];
int result;
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int C;
	cin >> C;
	while (C--) {
		int n;
		cin >> n;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				cin >> board[i][j];
			}
		}
		dp[1][1] = board[1][1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1) {
					dp[i][j] = dp[i - 1][j] + board[i][j];
					if (i == n) result = max(result, dp[i][j]);
				}
				else {
					dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + board[i][j];
					if (i == n) result = max(result, dp[i][j]);
				}
			}
		}
		cout << result<< "\n";
		result = 0;
		memset(board, 0, sizeof(board));
		memset(dp, 0, sizeof(dp));
	}
	return 0;
}