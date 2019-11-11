#include <iostream>
using namespace std;

bool dp[2005][2005];
int arr[2005];
int N, M;

void palind() {
	for (int i = N; i >= 1; i--) {
		for (int j = i; j <= N; j++) {
			if (i == j) {
				dp[i][j] = true;
			}
			else if (i + 1 == j) {
				dp[i][j] = (arr[i] == arr[j] ? true : false);
			}
			else {
				if (!dp[i + 1][j - 1]) {
					dp[i][j] = false;
				}
				else {
					dp[i][j] = (arr[i] == arr[j] ? true : false);
				}
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
	}
	palind();
	cin >> M;
	while (M--) {
		int a, b;
		cin >> a >> b;
		cout << dp[a][b] << '\n';
	}
	return 0;
}