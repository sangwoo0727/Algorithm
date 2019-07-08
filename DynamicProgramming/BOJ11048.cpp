#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int board[1005][1005];
int dp[1005][1005];


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> board[i][j];
		}
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			dp[i][j] = max(dp[i-1][j-1]+board[i][j],max(dp[i][j - 1] + board[i][j], dp[i - 1][j] + board[i][j]));
		}
	}
	cout << dp[N][M] << '\n';
	return 0;
}