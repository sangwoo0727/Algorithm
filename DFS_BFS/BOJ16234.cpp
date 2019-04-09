/*BOJ16234 인구이동*/

#include <iostream>
#include <queue>
#include <cmath>
#include <cstring>
#include <vector>
using namespace std;

int N, L, R;
int board[55][55];
int check[55][55];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };

typedef struct {
	int x;
	int y;
	int part_coloring;
}country;

typedef struct {
	int cnt;
	int sum;
	int result;
}map;

void bfs(int n, int m, int part) {
	queue <country> q;
	q.push({ n,m,part });
	while (q.empty() == 0) {
		int nx = q.front().x;
		int ny = q.front().y;
		int level = q.front().part_coloring;
		check[nx][ny] = level;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = nx + dc[k];
			int mnext = ny + dr[k];
			if (nnext < 0 || nnext >= N || mnext < 0 || mnext >= N || check[nnext][mnext] == check[nx][ny])
				continue;
			if (abs(board[nnext][mnext] - board[nx][ny]) >= L && abs(board[nnext][mnext] - board[nx][ny]) <= R) {
				check[nnext][mnext] = level;
				q.push({ nnext,mnext,level });
			}
		}
	}
}
int main() {
	scanf("%d%d%d", &N, &L, &R);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	int cnt = 0; 
	while (1) {
		int part_cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] != 0) continue;
				part_cnt++;
				bfs(i, j, part_cnt);
			}
		}
		if (part_cnt == N * N) break;

		vector <map> v(part_cnt + 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				v[check[i][j]].cnt++;
				v[check[i][j]].sum += board[i][j];
			}
		}
		for (int i = 1; i < part_cnt + 1; i++) {
			v[i].result = v[i].sum / v[i].cnt;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = v[check[i][j]].result;
			}
		}
		cnt++;
		memset(check, 0, sizeof(check));
	}
	printf("%d", cnt);
	return 0;
}