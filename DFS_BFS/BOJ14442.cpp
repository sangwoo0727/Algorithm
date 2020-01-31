/*
14442 벽부수고 이동하기 2
정말 힘들게 풀었다.
입력받은 k번에 대해서는 벽을 뚫을 수 있다.
k번을 다쓰게되면 그 다음 부터는 벽을 뚫을 수 없고, 0이 있는 곳으로만 이동할 수 있다
목적지까지왔을때 최단 거리를 구하는 bfs 문제
삼차원배열에 몇번 벽을 뚫었는지를 체크한다.(이 부분에 대한 구현을 못해서 고생했었다.)
*/
#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;

int N, M, K;
queue <pair <pair <int, int>, int>> q; //i,j, 그리고 벽을 부순 횟수 target 정보가 들어간다.
int board[1005][1005];
int ans_target[1005][1005][12]; // 벽을 부순 횟수 target정보를 표시하기 위해 3차원 배열
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };

void bfs(int target) { 
	ans_target[1][1][0] = 1; //첫시작은 1로 시작
	q.push({ { 1,1 }, target });
	while (q.empty() == 0) {
		int n = q.front().first.first;
		int m = q.front().first.second;
		target = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if (nnext<1 || nnext>N || mnext<1 || mnext>M) continue;
			if (board[nnext][mnext] == 0 && ans_target[nnext][mnext][target] == 0) { //벽이 아닌 곳을 만났을 때
				ans_target[nnext][mnext][target] = ans_target[n][m][target] + 1;
				q.push({ { nnext,mnext }, target });
			}
			if (target+1<=K&&board[nnext][mnext] == 1 && ans_target[nnext][mnext][target + 1] == 0) { //벽을 만났을 때
				ans_target[nnext][mnext][target + 1] = ans_target[n][m][target] + 1;
				q.push({ {nnext,mnext},target + 1 });
			}
		}
	}
}
int main() {
	scanf("%d%d%d", &N, &M, &K);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			scanf("%1d", &board[i][j]);
		}
	}
	bfs(0);
	int ans = -1;
	for (int i = 0; i <= K; i++) {
		if (ans_target[N][M][i] == 0) continue; //목적지에 값이 0이라면 탐색을 못한 것이므로 continue
		if (ans == -1) { //목적지에 어떤 값이 있다는 것
			ans = ans_target[N][M][i];
		}
		else if (ans > ans_target[N][M][i]) { //최소값 출력을 위해
			ans = ans_target[N][M][i];
		}
	}
	printf("%d", ans);
	return 0;
}