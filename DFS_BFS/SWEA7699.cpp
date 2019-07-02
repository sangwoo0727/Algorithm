#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int R, C;
char board[25][25];
int checkalp[30];
int dr[4] = { 0,0,-1,1 };
int dc[4] = { -1,1,0,0 };
int MAX;

void dfs(int n, int m, int cnt) {
	checkalp[board[n][m]-'A'] = 1;
	for (int k = 0; k < 4; k++) {
		int xnext = n + dr[k];
		int ynext = m + dc[k];
		if (checkalp[board[xnext][ynext]-'A'] == 0 && xnext >= 0 && xnext < R && ynext >= 0 && ynext < C) {
			dfs(xnext, ynext, cnt + 1);
		}
	}
	checkalp[board[n][m] - 'A'] = 0; 
	MAX = max(MAX, cnt);
}


int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int T;
	cin >> T;
	for (int t = 1; t <= T; t++) {
		cin >> R >> C;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cin >> board[i][j];
			}
		}
		dfs(0, 0, 1);
		cout << "#" << t << " " << MAX << "\n";
		memset(checkalp, 0, sizeof(checkalp));
		MAX = 0;
	}
	return 0;
}