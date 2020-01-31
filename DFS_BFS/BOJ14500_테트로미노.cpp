#include <iostream>
#include <algorithm>
#include <vector>
#define endl '\n';
using namespace std;

int N, M;
int board[501][501];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { 1,-1,0,0 };
bool check[501][501];
int MAX, sum;

bool OOB(int n, int m) {
	if (n >= 0 && n < N && m >= 0 && m < M) {
		return true;
	}
	return false;
}

void dfs(int n, int m, int cnt) {
	if (cnt == 4) {
		MAX = max(MAX, sum);
		return;
	}
	for (int k = 0; k < 4; k++) {
		int nn = n + dc[k];
		int mn = m + dr[k];
		if (!check[nn][mn] && OOB(nn,mn)) {
			check[nn][mn] = true;
			sum += board[nn][mn];
			dfs(nn, mn, cnt + 1);
			check[nn][mn] = false;
			sum -= board[nn][mn];
		}
	}
}

int hat(int n, int m) {
	int tmp1, tmp2, tmp3, tmp4;
	tmp1 = tmp2 = tmp3 = tmp4 = board[n][m];
	if (OOB(n - 1, m) && OOB(n, m + 1) && OOB(n + 1, m)) {
		tmp1 += board[n - 1][m] + board[n][m + 1] + board[n + 1][m];
	}
	if (OOB(n - 1, m) && OOB(n, m - 1) && OOB(n + 1, m)) {
		tmp2 += board[n - 1][m] + board[n][m - 1] + board[n + 1][m];
	}
	if (OOB(n - 1, m) && OOB(n, m - 1) && OOB(n, m + 1)) {
		tmp3 += board[n - 1][m] + board[n][m - 1] + board[n][m + 1];
	}
	if (OOB(n, m - 1) && OOB(n + 1, m) && OOB(n, m + 1)) {
		tmp4 += board[n][m - 1] + board[n + 1][m] + board[n][m + 1];
	}
	return max(tmp1, max(tmp2, max(tmp3, tmp4)));
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			check[i][j] = true;
			sum += board[i][j];
			dfs(i, j, 1);
			MAX = max(MAX,hat(i, j));
			sum -= board[i][j];
			check[i][j] = false;
		}
	}
	cout << MAX << endl;
	return 0;
}