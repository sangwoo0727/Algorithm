#include <iostream>
#include <cstring>
using namespace std;

int check[101][101];
int board[101][101];
int N;

int jump(int n, int m) {
	int k = board[n][m];
	if (n == N - 1 && m == N - 1) return 1;
	if (n > N - 1 || m > N - 1) return 0;
	int& ret = check[n][m];
	if (ret != -1) return ret;
	return ret = (jump(n + k, m) || jump(n, m + k)); //retÀÌ ¹Ù²î¸é check¹è¿­µµ ¹Ù²ï´Ù.
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int C;
	cin >> C;
	while (C--) {
		cin >> N;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				cin >> board[n][m];
			}
		}
		memset(check, -1, sizeof(check));
		int ans = jump(0, 0);
		if (ans == 1) cout << "YES" << "\n";
		if (ans == 0) cout << "NO" << "\n";
	}
	return 0;
}