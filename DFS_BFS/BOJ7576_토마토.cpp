/*7576 토마토
이 문제는 영역에 대해 bfs를 동시에 돌리기 시작하는 것을
알면 쉽게 풀 수 있는 문제였다.
간척사업 원리
https://www.acmicpc.net/problem/7576
*/

#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int N, M;
int board[1005][1005];
int check[1005][1005];
int Min = 1000000000;
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };
int cnt;

queue <pair <int, int>> q;

void bfs() {
	while (q.empty() == 0) {
		int n = q.front().first;
		int m = q.front().second;
		if (board[n][m] > cnt) {
				cnt++;
		}
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if (nnext >= 0 && nnext < N&&mnext >= 0 && mnext < M&&board[nnext][mnext] == 0 && check[nnext][mnext] == 0&&board[nnext][mnext]!=-1) {
				check[nnext][mnext] = 1;
				board[nnext][mnext] = cnt + 1;
				q.push({ nnext,mnext });
			}
		}
	}
	
}

int main() {
	scanf("%d%d", &M, &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 1 && check[i][j] == 0) q.push({ i,j });
		}
	}
	bfs();
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 0) {
				printf("-1\n");
				return 0;
			}
		}
	}
	printf("%d\n", cnt-1);
	return 0;
}
