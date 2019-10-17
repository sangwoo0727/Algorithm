#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
#include <utility>

#define endl '\n'
#define INF 999999999
using namespace std;

typedef struct {
	int n;
	int m;
	int cnt;
}virus;

vector <pair <int, int> > vv;
vector <pair <int, int> > av; 
int N, M;
int Min = INF;
int board[55][55];
int time_check[55][55];
int dr[4] = { 0,0,-1,1 };
int dc[4] = { -1,1,0,0 };
bool check[55][55];

int bfs() {
	int ans = 0;
	queue <virus> q;
	memset(check, 0, sizeof(check));
	memset(time_check, -1, sizeof(time_check));
	for (int i = 0; i < av.size(); i++) {
		virus tmp = { av[i].first,av[i].second,0 };
		q.push(tmp);
		check[av[i].first][av[i].second] = true;
		time_check[av[i].first][av[i].second] = 0;
	}
	while (!q.empty()) {
		int nnow = q.front().n;
		int mnow = q.front().m;
		int cnt = q.front().cnt;
		check[nnow][mnow] = true;
		time_check[nnow][mnow] = cnt;
		ans = cnt;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = nnow + dr[k];
			int mnext = mnow + dc[k];
			if (nnext < 0 || nnext >= N || mnext < 0 || mnext >= N || check[nnext][mnext])
				continue;
			if (board[nnext][mnext] == 1)
				continue;
			virus tmp = { nnext,mnext,cnt + 1 };
			check[nnext][mnext] = true;
			time_check[nnext][mnext] = cnt + 1;
			q.push(tmp);
		}
	}
	bool flag = false;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if ((board[i][j] == 2 || board[i][j] == 0) && check[i][j] == 0) {
				flag = true;
				break;
			}
			
		}
		if (flag) break;
	}
	bool max_check1 = false, max_check2 = false;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (board[i][j] == 2 && time_check[i][j] == ans) max_check1 = true;
			if (board[i][j] != 2 && time_check[i][j] == ans) max_check2 = true;
		}
	}
	if (flag) return -1;
	else {
		if (max_check1 && !max_check2) return ans - 1;
		else return ans;
	}
}

void comb(int m, int idx) {
	if (m == M) {
		int ans = bfs();
		if (ans != -1) {
			Min = min(Min, ans);
		}
		return;
	}
	if (idx >= vv.size()) return;
	av.push_back(make_pair(vv[idx].first, vv[idx].second));
	comb(m + 1, idx + 1);
	av.pop_back();
	comb(m, idx + 1);
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	bool flag = false;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
			if (board[i][j] == 2) {
				vv.push_back(make_pair(i, j));
			}
			if (board[i][j] == 0) flag = true;
		}
	}
	if (flag) {
		comb(0, 0);
		if (Min == INF) cout << "-1" << endl;
		else cout << Min << endl;
	}
	else {
		cout << "0" << endl;
	}
	return 0;
}