#include <iostream>
#include <cstdio>
#include <queue>
#include <utility>
#include <cstring>
using namespace std;

typedef pair<int, int> p;
queue <p> q;
int N;
int board[105][105];
int result[105][105];
int dr[4] = { 0,0,-1,1 };
int dc[4] = { -1,1,0,0 };

void bfs(int i, int j) {
	result[i][j] = board[i][j];
	q.push(make_pair(i, j));
	while (!q.empty()) {
		int inow = q.front().first;
		int jnow = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int inext = inow + dr[k];
			int jnext = jnow + dc[k];
			if (inext >= 0 && inext < N && jnext >= 0 && jnext < N) {
				if (result[inext][jnext] == -1 || result[inext][jnext] > result[inow][jnow] + board[inext][jnext]) {
					result[inext][jnext] = result[inow][jnow] + board[inext][jnext];
					q.push(make_pair(inext, jnext));
				}
			}
		}
	}
}

int main() {
	int T;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d", &N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				scanf("%1d", &board[i][j]);
			}
		}
		memset(result, -1, sizeof(result));
		bfs(0, 0);
		printf("#%d %d\n", t, result[N - 1][N - 1]);
	}
	return 0;
}