/*BOJ 2178 미로탐색
단순 최단 경로 구하는 문제인데, 탐색지점이 N,M에 도착하였을 때
그래프 탐색을 종료하고 저장된 cnt를 출력하였다.*/

#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int N, M;
int board[105][105];
int check[105][105];
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };
int cnt, n, m;
queue < pair <int, int>> q;

void bfs(int i, int j) {
	queue <int> level;
	check[i][j] = 1;
	q.push({ i,j });
	level.push(1);
	while (q.empty() == 0) {
		n = q.front().first;
		m = q.front().second;
		cnt = level.front();
		q.pop(); level.pop();
		if (n == N && m == M) return;
		for (int k = 0; k < 4; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if (nnext >= 1 && nnext <= N && mnext >= 1 && mnext <= M && check[nnext][mnext] == 0 && board[nnext][mnext] == 1) {
				check[nnext][mnext] = 1;
				q.push({ nnext,mnext }); level.push(cnt + 1);
			}
		}
	}
}
int main() {
	scanf("%d%d", &N, &M);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			scanf("%1d", &board[i][j]);
		}
	}
	bfs(1, 1);
	printf("%d", cnt);
	return 0;
}