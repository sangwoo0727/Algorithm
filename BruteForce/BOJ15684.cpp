#include <iostream>
using namespace std;

typedef struct {
	int num;
	char dir;
}Board;

int N, M, H;
Board board[35][12];
int ans = 100000;

int checkladder() {
	for (int n = 1; n <= N; n++) {
		int nnow = n;
		int hnow = 1;
		while (hnow <= H + 1) {
			if (board[hnow][nnow].num == 0) hnow++;
			else if (board[hnow][nnow].num == 1) {
				if (board[hnow][nnow].dir == 'r') {
					nnow++;
				}
				else nnow--;
				hnow++;
			}
		}
		if (nnow != n) return 0;
	}
	return 1;
}

void dfs(int n, int m, int cnt) {
	if (cnt >= ans) return;
	if (n > N || m > H) return;
	if (checkladder()) ans = cnt;
	if (cnt == 3) return;
	for (int nnow = n; nnow < N; nnow++) {
		for (int hnow = 0; hnow <= H; hnow++) {
			if (board[hnow][nnow].num == 1) continue;
			if (nnow + 1 <= N && board[hnow][nnow + 1].num == 0) {
				board[hnow][nnow].num = 1;
				board[hnow][nnow].dir = 'r';
				board[hnow][nnow+1].num = 1;
				board[hnow][nnow+1].dir = 'l';
				dfs(nnow, hnow, cnt + 1);
				board[hnow][nnow + 1].num = 0;
				board[hnow][nnow].num = 0;
			}
		}
	}

}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M >> H;
	if (M == 0) {
		cout << "0\n";
		return 0;
	}
	for (int m = 0; m < M; m++) {
		int a, b;
		cin >> a >> b;
		board[a][b].num = 1;
		board[a][b].dir = 'r';
		board[a][b + 1].num = 1;
		board[a][b + 1].dir = 'l';
	}
	dfs(1, 1, 0);
	if (ans == 100000) ans = -1;
	cout << ans << '\n';
	return 0;
}