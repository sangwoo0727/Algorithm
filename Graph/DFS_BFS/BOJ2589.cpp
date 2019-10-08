/*BOJ2589 보물섬 문제
단순 BFS 문제였다.
최단거리 문제에 대해서는 BFS로 풀어야 시간초과가 나지 않는다.*/

#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
#include <cstring>
using namespace std;


char board[55][55];
int check[55][55];
int dr[4] = { 0,-1,0,1 };
int dc[4] = { 1,0,-1,0 };
int MAX;
int N,M;
int cnt;


void bfs(int i, int j) {
	queue <pair<int, int>> q;
	queue <int> result;
	check[i][j] = 1;
	q.push({ i, j });
	result.push(0);
	while (q.empty() == 0) {
		int n = q.front().first;
		int m = q.front().second;
		cnt = result.front();
		q.pop();
		result.pop();
		for (int k = 0; k< 4; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if (nnext >= 0 && mnext >= 0 && nnext < N && mnext < M && check[nnext][mnext] == 0 && board[nnext][mnext]=='L') {
				check[nnext][mnext] = 1;
				q.push({ nnext,mnext });
				result.push(cnt + 1);
			}
		}

	}
}
int main() {
	scanf("%d%d", &N, &M);
	for (int i = 0; i < N; i++) {
		scanf("%s", board[i]);
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 'L') {
				bfs(i, j);
				MAX = max(MAX, cnt);
				memset(check, 0, sizeof(check));
			}
			cnt = 0;
		}
	}
	printf("%d", MAX);
	return 0;
}