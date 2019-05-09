#include <iostream>
#include <queue>
#include <cstring>
#include <utility>
using namespace std;

int board[105][105];
int check[105][105];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { 1,-1,0,0 };


int bfs(int x, int y) {
	queue <pair <int, int>> q;
	q.push({ x,y });
	check[x][y] = 1;
	while (q.empty() == 0) {
		int xnow = q.front().first;
		int ynow = q.front().second;
		check[xnow][ynow] = 1;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int xnext = xnow + dc[k];
			int ynext = ynow + dr[k];
			if (xnext < 0 || xnext >= 100 || ynext < 0 || ynext >= 100) continue;
			if (check[xnext][ynext] == 1) continue;
			if (board[xnext][ynext] !=1) {
				if (board[xnext][ynext] == 3) return 1;
				q.push({ xnext, ynext });
			}
		}
	}
	return 0;
}
int main() {
	while(1){
		int t;
		scanf("%d", &t);
		int x, y;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				scanf("%1d", &board[i][j]);
				if (board[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		int result = bfs(x, y);
		printf("#%d %d\n", t, result);
		if (t == 10) break;
		memset(check, 0, sizeof(check));
	}
	return 0;
}