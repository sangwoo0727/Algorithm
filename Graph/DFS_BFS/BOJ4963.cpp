/*4963 섬의개수
이 문제는 그래프탐색으로 영역의 개수를 구하는 기본 문제인데,
좌표이동을 4방향이 아닌 8방향으로만 하는 되는 문제이다.*/

#include <iostream>
#include <utility>
#include <queue>
#include <cstring>
using namespace std;

int board[55][55];
int check[55][55];
int w, h;
int dr[8] = {0,1,1,1,0,-1,-1,-1};
int dc[8] = { -1,-1,0,1,1,1,0,-1 };
int cnt = 0;

void bfs(int i, int j) {
	queue <pair<int, int>> q;
	check[i][j] = 1;
	q.push({ i,j });
	while (q.empty() == 0) {
		int n = q.front().first;
		int m = q.front().second;
		q.pop();
		for (int k = 0; k < 8; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if (nnext >= 0 && nnext < h&&mnext >= 0 && mnext < w&&check[nnext][mnext] == 0 && board[nnext][mnext] == 1) {
				check[nnext][mnext] = 1;
				q.push({ nnext,mnext });
			}
		}
	}
}
int main() {
	while (1) {
		scanf("%d%d", &w, &h);
		if (w == 0 && h == 0) break;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				scanf("%d", &board[i][j]);
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (check[i][j] == 0 && board[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		printf("%d\n", cnt);
		cnt = 0;
		memset(check, 0, sizeof(check));
		memset(board, 0, sizeof(board));
	}
	return 0;
}