#include <iostream>
#include <queue>
#include <utility>
#include <cstring>
using namespace std;

typedef struct {
	int n;
	int m;
	int year;
}ice;

int N, M;
int board[300][300];
int check[300][300];
int landcheck[300][300];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };
queue <ice> q;
queue <pair <int,int>> landq;
queue <pair <int, int>> checkq;

void icebreak() {
	int year = q.front().year;
	while (!q.empty()) {
		int n = q.front().n;
		int m = q.front().m;
		int cnt = q.front().year;
		int breakcnt = 0;
		if (cnt != year) break;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = n + dc[k];
			int mnext = m + dr[k];
			if (nnext<0 || nnext>N || mnext<0 || mnext>M) continue;
			else if(board[nnext][mnext]==0 && check[nnext][mnext]==0){
				breakcnt++;
			} 
		}
		board[n][m] -= breakcnt;
		if (board[n][m] < 0) board[n][m] = 0;
		if (board[n][m] == 0) checkq.push(make_pair(n, m));
		q.push({ n,m,cnt + 1 });
	}
}

void bfs(int n, int m, int cnt) {
	landq.push({n,m});
	landcheck[n][m] = 1;
	while (!landq.empty()) {
		int n = landq.front().first;
		int m = landq.front().second;
		landq.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = n + dc[k];
			int mnext = m + dr[k];
			if (nnext<0 || nnext>N || mnext<0 || mnext>M || landcheck[nnext][mnext] == 1) continue;
			else if (board[nnext][mnext] != 0 && landcheck[nnext][mnext]==0) {
				landq.push({ nnext, mnext});
				landcheck[nnext][mnext] = 1;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	int ans = 0;
	for (int n = 0; n < N; n++) {
		for (int m = 0; m < M; m++) {
			cin >> board[n][m];
			if (board[n][m] != 0) {
				q.push({ n,m,0 });
				check[n][m] = 1;
			}
		}
	}
	int landcnt = 0;
	int tmp = 0;
	int tmp2 = 0;
	while (1) {
		icebreak();
		while (!checkq.empty()) {
			check[checkq.front().first][checkq.front().second] = 0;
			checkq.pop();
		}
		tmp = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (board[n][m] != 0) {
					tmp = 1;
					bfs(n,m,landcnt);
					break;
				}
			}
			if (tmp == 1) break;
		}
		tmp2 = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (board[n][m] != 0 && landcheck[n][m]==0) {
					ans = q.front().year;
					tmp2 = 1;
					break;
				}
			}
			if (tmp2 != 0) break;
		}
		int tmp3 = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (board[n][m] != 0) {
					tmp3 = 1;
					break;
				}
			}
			if (tmp3 == 1) break;
		}
		memset(landcheck, 0, sizeof(landcheck));
		if (tmp2 != 0) break;
		if (tmp3 == 1) continue;
		if (tmp3 == 0) {
			cout << '0' << '\n';
			return 0;
		}
	}
	cout << ans << '\n';
	return 0;
}