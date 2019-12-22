#include <iostream>
#define endl '\n'
using namespace std;

int N, M;
int board[22][22];
int dice[7];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { 1,-1,0,0 };

void diceCopy(int x, int y) {
	if (!board[x][y]) {
		board[x][y] = dice[1];
	}
	else {
		dice[1] = board[x][y];
		board[x][y] = 0;
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int x,y,K;
	cin >> N >> M >> x >> y >> K;
	for (int n = 0; n < N; n++) {
		for (int m = 0; m < M; m++) {
			cin >> board[n][m];
		}
	}
	while (K--) {
		int op;
		cin >> op;
		op -= 1;
		int nx = x + dc[op];
		int ny = y + dr[op];
		if (nx < 0 || nx >= N || ny < 0 || ny >= M) 
			continue;
		x = nx;
		y = ny;
		if (op == 0) {
			//east
			int tmp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			cout << dice[6] <<' ';
			diceCopy(nx, ny);
		}
		else if (op == 1) {
			//west
			int tmp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
			cout << dice[6] << ' ';
			diceCopy(nx, ny);
		}
		else if (op == 2) {
			//north
			int tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			cout << dice[6] << ' ';
			diceCopy(nx, ny);
		}
		else {
			//south
			int tmp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			cout << dice[6] << ' ';
			diceCopy(nx, ny);
		}
	}
	return 0;
}