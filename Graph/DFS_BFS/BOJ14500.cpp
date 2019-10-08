/* 14500 테트로미노 */
#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int MAX = 0;
int board[505][505];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };
int check[505][505];


int dfs(int x, int y, int idx) {
	if (idx == 4) return board[x][y];
	check[x][y] = 1;
	int ret = 0;
	for (int k = 0; k < 4; k++) {
		int nx = x + dc[k];
		int ny = y + dr[k];
		if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0) {
			ret = max(ret, board[x][y] + dfs(nx, ny, idx + 1));
		}
	}
	check[x][y] = 0;
	return ret;
}

int main() {
	scanf("%d%d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	int ans = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			ans = max(ans, dfs(i, j, 1));
			int x1 = i, y1 = j - 1;
			int x2 = i, y2 = j + 1;
			int x3 = i - 1, y3 = j;
			int x4 = i + 1, y4 = j;
			int result1 = 0, result2 = 0, result3 = 0, result4 = 0;
			if (y1 >= 0 && y2 < M && x4<N) {
				result1 = board[i][j] + board[x1][y1] + board[x2][y2] + board[x4][y4];
			}
			if (y1 >= 0 && y2 < M && x3 >= 0) {
				result2 = board[i][j] + board[x1][y1] + board[x2][y2] + board[x3][y3];
			}
			if (x3 >= 0 && x4 < N && y1 >= 0) {
				result3 = board[i][j] + board[x3][y3] + board[x4][y4] + board[x1][y1];
			}
			if (x3 >= 0 && x4 < N && y2 < M) {
				result4 = board[i][j] + board[x3][y3] + board[x4][y4] + board[x2][y2];
			}
			ans = max(ans, max(result1, max(result2, max(result3, result4))));
		}
	}
	printf("%d", ans);
}