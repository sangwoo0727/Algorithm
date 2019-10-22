#include <iostream>
#include <cstring>
#define endl '\n'
using namespace std;

int N;
int ans;
int arr[101];
long long dp[21][101];

void comb(int n) {
	if (n == N - 1) {
		if (ans == arr[N - 1]) dp[ans][n] = 1;
		return;
	}
	long long &ret = dp[ans][n];
	if (ret != -1) return;
	if (ans + arr[n] <= 20) {
		ans += arr[n];
		comb(n + 1);
		ans -= arr[n];
		if (dp[ans + arr[n]][n + 1] != -1) {
			if (ret == -1) ret = 0;
			ret += dp[ans + arr[n]][n + 1];
		}
	}
	if (ans - arr[n] >= 0) {
		ans -= arr[n];
		comb(n + 1);
		ans += arr[n];
		if (dp[ans - arr[n]][n + 1] != -1) {
			if (ret == -1) ret = 0;
			ret += dp[ans - arr[n]][n + 1];
		}
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	memset(dp, -1, sizeof(dp));
	for (int n = 0; n < N; n++) {
		cin >> arr[n];
	}
	ans += arr[0];
	comb(1);
	cout << dp[arr[0]][1] << endl;
	return 0;
}