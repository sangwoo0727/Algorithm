#include <iostream>
#include <queue>
#include <cstring>
#include <utility>
#define endl '\n';
using namespace std;

bool board[51][51];
bool check[51][51];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { 1,-1,0,0 };
int N, M, K;

void bfs(int i, int j) {
	queue <pair <int, int>> q;
	q.push(make_pair(i, j));
	while (!q.empty()) {
		int n = q.front().first;
		int m = q.front().second;
		check[n][m] = true;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nn = n + dc[k];
			int mn = m + dr[k];
			if (nn < 0 || nn >= N || mn < 0 || mn >= M) {
				continue;
			}
			if (check[nn][mn] || !board[nn][mn]) {
				continue;
			}
			q.push(make_pair(nn, mn));
			check[nn][mn] = true;
		}
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int T;
	cin >> T;
	while (T--) {
		cin >> M >> N >> K;
		for (int k = 0; k < K; k++) {
			int x, y;
			cin >> x >> y;
			board[y][x] = true;
		}
		int ans = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (board[n][m] && !check[n][m]) {
					bfs(n, m);
					ans++;
				}
			}
		}
		cout << ans << endl;
		memset(check, false, sizeof(check));
		memset(board, false, sizeof(board));
	}
	return 0;
}