#include <iostream>
#include <algorithm>
using namespace std;

int stair[305];
int dp[2][305];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> stair[i];
	}
	dp[0][1] = stair[1];
	dp[0][2] = stair[2];
	dp[1][2] = dp[0][1] + stair[2];
	for (int i = 3; i <= n; i++) {
		if (dp[0][i - 2] > dp[1][i - 2]) dp[0][i] = dp[0][i - 2] + stair[i];
		if (dp[0][i - 2] <= dp[1][i - 2]) dp[0][i] = dp[1][i - 2] + stair[i];
		dp[1][i] = dp[0][i - 1] + stair[i];
	}
	int result = max(dp[0][n], dp[1][n]);
	cout << result << '\n';
	return 0;
}