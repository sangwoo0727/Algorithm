#include <iostream>
#include <queue>

#define endl '\n'
using namespace std;

struct Tomato {
	int h;
	int n;
	int m;
	int day;
};

queue <Tomato> q;
int N, M, H;
int board[101][101][101];
int dc[6] = { -1,1,0,0,0,0 };
int dr[6] = { 0,0,-1,1,0,0 };
int dh[6] = { 0,0,0,0,-1,1 };

int bfs() {
	int result = 0;
	while (!q.empty()) {
		int n = q.front().n;
		int m = q.front().m;
		int h = q.front().h;
		int cnt = q.front().day;
		result = cnt;
		q.pop();
		for (int k = 0; k < 6; k++) {
			int nn = n + dc[k];
			int mn = m + dr[k];
			int hn = h + dh[k];
			if (nn < 0 || nn >= N || mn < 0 || mn >= M || hn < 0 || hn >= H)
				continue;
			if (board[nn][mn][hn] == 0) {
				board[nn][mn][hn] = 1;
				q.push({ hn,nn,mn,cnt + 1 });
			}
		}
	}
	return result;
}

bool checkTomato() {
	for (int h = 0; h < H; h++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j][h] == 0) {
					return false;
				}
			}
		}
	}
	return true;
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> M >> N >> H;
	int tmp = 0;
	for (int h = 0; h < H; h++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cin >> board[i][j][h];
				if (board[i][j][h] == 1) {
					q.push({ h,i,j,0 });
				}
				if (board[i][j][h] == 0)
					tmp++;
			}
		}
	}
	if (!tmp) {
		cout << "0" << endl;
	}
	else {
		int ans = bfs();
		bool flag = checkTomato();
		if (flag) {
			cout << ans << endl;
		}
		else {
			cout << "-1" << endl;
		}
	}
	return 0;
}