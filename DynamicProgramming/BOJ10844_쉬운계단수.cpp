#include <iostream>
#define MOD 1000000000
using namespace std;

int N;
int dp[100][10];

int main() {
	cin >> N;
	for (int i = 0; i < 10; i++) dp[1][i] = 1;
	for (int i = 2; i <= N; i++) {
		for (int j = 0; j < 10; j++) {
			if (j + 1 < 10) dp[i][j] += dp[i - 1][j + 1] % MOD;
			if (j - 1 >= 0) dp[i][j] += dp[i - 1][j - 1] % MOD;
		}
	}
	int result = 0;
	for (int j = 1; j < 10; j++) {
		result = (result + dp[N][j] % MOD) % MOD;
	}
	cout << result;
	return 0;
}