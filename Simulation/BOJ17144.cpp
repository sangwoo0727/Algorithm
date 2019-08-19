#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

typedef struct {
	int r;
	int c;
}location;

queue <location> dust;
int m1r, m1c, m2r, m2c;
int board[51][51];
int dr[4] = { 0,0,-1,1 };
int dc[4] = { -1,1,0,0 };
int tmpboard[51][51];
int R, C, T;

void dust_sp() {
	memset(tmpboard,0, sizeof(tmpboard));
	while (!dust.empty()) {
		int r = dust.front().r;
		int c = dust.front().c;
		dust.pop();
		int scnt = 0;
		for (int k = 0; k < 4; k++) {
			int rnext = r + dr[k];
			int cnext = c + dc[k];
			if (rnext < 0 || rnext >= R || cnext < 0 || cnext >= C || 
				(rnext == m1r && cnext == m2c) || (rnext == m2r && cnext == m2c))
				continue;
			tmpboard[rnext][cnext] += board[r][c] / 5;
			scnt++;
		}
		board[r][c] -= (board[r][c] / 5) * scnt;
	}
	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			board[r][c] += tmpboard[r][c];
		}
	}
}

void cycle1() {
	int rstart = m1r;
	int cstart = m1c;
	for (int r = rstart - 1; r >= 0; r--) {
		if (r == rstart - 1) continue;
		board[r + 1][cstart] = board[r][cstart];
	}
	for (int c = cstart + 1; c < C; c++) {
		board[0][c - 1] = board[0][c];
	}
	for (int r = 1; r <= rstart; r++) {
		board[r - 1][C - 1] = board[r][C - 1];
	}
	for (int c = C - 2; c >= cstart; c--) {
		if (c == cstart) board[rstart][c + 1] = 0;
		else board[rstart][c + 1] = board[rstart][c];
	}
}

void cycle2() {
	int rstart = m2r;
	int cstart = m2c;
	for (int r = rstart + 1; r < R; r++) {
		if (r == rstart + 1) continue;
		board[r - 1][cstart] = board[r][cstart];
	}
	for (int c = cstart + 1; c < C; c++) {
		board[R - 1][c - 1] = board[R - 1][c];
	}
	for (int r = R - 2; r >= rstart; r--) {
		board[r + 1][C - 1] = board[r][C - 1];
	}
	for (int c = C - 2; c >= cstart; c--) {
		if (c == cstart) board[rstart][c + 1] = 0;
		else board[rstart][c + 1] = board[rstart][c];
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> R >> C >> T;
	
	int idx = 0;
	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			cin >> board[r][c];
			if (board[r][c] != 0 && board[r][c] != -1) {
				dust.push({ r,c });
			}
			if (board[r][c] == -1 && idx == 0) {
				m1r = r; m1c = c;
				idx++;
			}
			if (board[r][c] == -1 && idx == 1) {
				m2r = r; m2c = c;
			}
		}
	}
	while (T--) {
		dust_sp();
		cycle1();
		cycle2();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c] != 0 && board[r][c] != -1) {
					dust.push({ r,c });
				}
			}
		}
	}
	int ans = 0;
	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			if (board[r][c] == -1) continue;
			ans += board[r][c];
		}
	}
	cout << ans << '\n';
	return 0;
}