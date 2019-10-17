#include <iostream>
#include <queue>
#include <cstring>
#include <utility>
#include <algorithm>

#define endl '\n'
using namespace std;

typedef struct {
	int n;
	int m;
	int dist;
}Queue;

vector <int> v;
int N, M, D;
int last_enemy;
int MAX , kill_cnt;
int dr[3] = { 0,-1,0 };
int dc[3] = { -1,0,1 };
bool board[17][17];
bool tmp_board[17][17];
bool check[17][17];

void bfs() {
	memcpy(tmp_board, board, sizeof(board));
	kill_cnt = 0;
	int tmp_enemy = last_enemy;
	while (tmp_enemy++ < N) {
		vector <pair <int, int> > v_tmp;
		for (int t = 0; t < 3; t++) {
			memset(check, false , sizeof(check));
			queue <Queue> q;
			Queue tmp = { N,v[t],0 };
			q.push(tmp);
			while (!q.empty()) {
				int nnow = q.front().n;
				int mnow = q.front().m;
				int d = q.front().dist;
				bool break_flag = 0;
				if (d == D) break;
				q.pop();
				for (int k = 0; k < 3; k++) {
					int nnext = nnow + dr[k];
					int mnext = mnow + dc[k];
					if (nnext > N || nnext < 0 || mnext > M || mnext < 0 || check[nnext][mnext]) 
						continue;
					if (tmp_board[nnext][mnext] && nnext < N) {
						v_tmp.push_back(make_pair(nnext, mnext));
						break_flag = true;
						break;
					}
					Queue next_tmp = { nnext,mnext,d + 1 };
					check[nnext][mnext] = true;
					q.push(next_tmp);
				}
				if (break_flag) break;
			}
		}
		for (int i = 0; i < v_tmp.size(); i++) {
			if (tmp_board[v_tmp[i].first][v_tmp[i].second]) {
				kill_cnt++;
				tmp_board[v_tmp[i].first][v_tmp[i].second] = 0;
			}
		}
		for (int go = N - 1; go >= 0; go--) {
			if (go == N - 1) continue;
			for (int j = 0; j < M; j++) {
				tmp_board[go + 1][j] = tmp_board[go][j];
				if (go == 0) tmp_board[go][j] = 0;
			}
		}
	}
}

void comb(int m, int idx) {
	if (m == 3) {
		for (int i = 0; i < M; i++) {
			if (board[N][i]) {
				v.push_back(i);
			}
		}
		bfs();
		v.resize(0);
		MAX = max(MAX, kill_cnt);
		return;
	}
	if (idx >= M) return;
	board[N][idx] = true;
	comb(m + 1, idx + 1);
	board[N][idx] = false;
	comb(m, idx + 1);
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M >> D;
	int tmp = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
			if (board[i][j]) {
				tmp++;
				if (tmp == 1) {
					last_enemy = i;
				}
			}
		}
	}
	comb(0,0);
	cout << MAX << endl;
	return 0;
}