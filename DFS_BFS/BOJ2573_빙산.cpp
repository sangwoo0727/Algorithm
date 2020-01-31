#include <iostream>
#include <queue>
#include <utility>
#include <cstring>
#define endl '\n';
using namespace std;

queue <pair <int, int>> q;
int board[301][301];
int tmp[301][301];
int dr[4] = { 0,0,-1,1 };
int dc[4] = { -1,1,0,0 };
bool check[301][301];
int N, M;

void melt() {
	while (!q.empty()) {
		int n = q.front().first;
		int m = q.front().second;
		int cnt = 0;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nn = n + dc[k];
			int mn = m + dr[k];
			if (nn < 0 || nn >= N || mn < 0 || mn >= M) {
				continue;
			}
			if (tmp[nn][mn] == 0) {
				cnt++;
			}
		}
		if (board[n][m] - cnt <= 0) board[n][m] = 0;
		else board[n][m] -= cnt;
	}
}

void bfs(int i, int j) {
	queue <pair <int, int>> chk;
	chk.push(make_pair(i, j));
	while (!chk.empty()) {
		int n = chk.front().first;
		int m = chk.front().second;
		chk.pop();
		for (int k = 0; k < 4; k++) {
			int nn = n + dc[k];
			int mn = m + dr[k];
			if (nn < 0 || nn >= N || mn < 0 || mn >= M) {
				continue;
			}
			if (check[nn][mn] || !board[nn][mn]) {
				continue;
			}
			check[nn][mn] = true;
			chk.push(make_pair(nn, mn));
		}
	}
}

bool checkLand() {
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] && !check[i][j]) {
				if (cnt >= 1) {
					return true;
				}
				bfs(i, j);
				cnt++;
			}
		}
	}
	return false;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}
	int ans = 0;
	while (1) {
		memcpy(tmp, board, sizeof(tmp));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j]) {
					q.push(make_pair(i, j));
				}
			}
		}
		if (checkLand()) {
			cout << ans << endl;
			return 0;
		}
		if (q.empty()) {
			cout << '0' << endl;
			return 0;
		}
		melt();
		ans++;
		memset(check, false, sizeof(check));
	}
	return 0;
}