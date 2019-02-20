/*1926 그림 문제
전형적인 dfs,bfs문제로
첫번째줄의 출력은, 그래프탐색 영역의 개수문제
두번째줄의 출력은, 그래프탐색영역중 가장 큰 넓이를 구하는 문제이다.*/

#include <iostream>
#include <vector>
#include <queue>
#include <utility>
#include <cstring>
#include <algorithm>
using namespace std;

int N, M;
int cnt;
int ans;
int MaxAns;
int board[505][505];
int check[505][505];
int dr[4] = { 0,-1,0,1 };
int dc[4] = { 1,0,-1,0 };


int bfs(int i, int j) {
	queue <pair<int,int>> q;
	check[i][j] = 1;
	q.push({ i,j });
	while (q.empty() == 0) {
		cnt++;
		int n = q.front().first;
		int m = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if (nnext >= 0 && mnext >= 0 && nnext < N&&mnext < M&&check[nnext][mnext] == 0 && board[nnext][mnext] == 1) {
				q.push({ nnext,mnext });
				check[nnext][mnext] = 1;
			}
		}
	}
	return cnt;
}
int main() {
	scanf("%d%d", &N , &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 1 && check[i][j] == 0) {
				MaxAns=max(MaxAns,bfs(i, j));
				cnt = 0;
				ans++;
			}
		}
	}
	printf("%d\n", ans);
	printf("%d", MaxAns);
	return 0;
}