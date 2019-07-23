#include <iostream>
using namespace std;

int shape[4][3][2] = { {{0,0},{0,1},{1,1}},
					   {{0,0},{1,0},{1,1}},
					   {{0,0},{1,0},{1,-1}},
					   {{0,0},{1,0},{0,1}} };
int check[21][21];
char board[21][21];
int H, W;

bool checkshape(int k, int x, int y) {
	for (int i = 0; i < 3; i++) {
		int nx = x + shape[k][i][0];
		int ny = y + shape[k][i][1];
		if (nx < 0 || nx >= H || ny < 0 || ny >= W || check[nx][ny]==1 || board[nx][ny]!='.') return false;
	}
	return true;
}

int dfs() {
	int x = -1; int y = -1;
	for (int i=0; i < H; i++) {
		for (int j = 0; j < W; j++) {
			if (board[i][j] == '.' && check[i][j]==0) {
				x = i; y = j;
				break;
			}
		}
		if (x != -1 && y != -1) break;
	}
	if (x == -1 && y == -1) return 1;
	int result = 0;
	for (int k = 0; k < 4; k++) {
		if (checkshape(k, x, y)) {
			for (int i = 0; i < 3; i++) {
				int nx = x + shape[k][i][0];
				int ny = y + shape[k][i][1];
				check[nx][ny] = 1;
			}
			result += dfs();
			for (int i = 0; i < 3; i++) {
				int nx = x + shape[k][i][0];
				int ny = y + shape[k][i][1];
				check[nx][ny] = 0;
			}
		}
	}
	return result;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int C;
	cin >> C;
	for (int c = 1; c <= C; c++) {
		cin >> H >> W;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				cin >> board[i][j];
			}
		}
		cout << dfs() << '\n';
	}
	return 0;
}