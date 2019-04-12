/* BOJ14502 연구소*/

#include <iostream>
#include <vector>
#include <queue>
#include <utility>
#include <cstring>
#include <algorithm>
#define p pair<int,int>
using namespace std;

int N, M;
int MAX;
int board[10][10];
int cpy_board[10][10];
int check[10][10];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };

vector <p> empty_space;
vector <p> wall;
vector <p> danger;
queue <p> q;

void bfs() {
	while (q.empty() == 0) {
		int xnow = q.front().first;
		int ynow = q.front().second;
		board[xnow][ynow] = 1;
		check[xnow][ynow] = 1;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int xnext = xnow + dc[k];
			int ynext = ynow + dr[k];
			if (xnext < 0 || xnext >= N || ynext < 0 || ynext >= M || check[xnext][ynext] != 0 || board[xnext][ynext]!=0) continue;
			q.push({ xnext,ynext });
		}
	}
}

void dfs(int idx, int cnt) {
	if (cnt==3) {
		for (int i = 0; i < 3; i++) {
			board[wall[i].first][wall[i].second] = 1;
		}
		int ans = 0;
		for (int i = 0; i < danger.size(); i++) {
			q.push({ danger[i].first, danger[i].second });
		}
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) ans++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = cpy_board[i][j];
			}
		}
		MAX = max(MAX, ans);
		memset(check, 0, sizeof(check));
		return;
	}
	else if (idx >= empty_space.size()) {
		return;
	}
	else {
		wall.push_back({ empty_space[idx].first,empty_space[idx].second });
		dfs(idx + 1, cnt + 1);
		wall.pop_back();
		dfs(idx + 1, cnt);
	}
}

int main() {
	scanf("%d%d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
			cpy_board[i][j] = board[i][j];
			if (board[i][j] == 0) empty_space.push_back({ i,j }); //벽 세울수있는 부분들
			if (board[i][j] == 2) danger.push_back({ i,j });
		}
	}
	dfs(0, 0);
	printf("%d", MAX);
	return 0;
}