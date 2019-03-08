/*14442 ���μ��� �̵��ϱ� 2
���� ����� Ǯ����.
�Է¹��� k���� ���ؼ��� ���� ���� �� �ִ�.
k���� �پ��ԵǸ� �� ���� ���ʹ� ���� ���� �� ����, 0�� �ִ� �����θ� �̵��� �� �ִ�
���������������� �ִ� �Ÿ��� ���ϴ� bfs ����
�������迭�� ��� ���� �վ������� üũ�Ѵ�.
*/
#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int N, M, K;
int board[1005][1005];
int path_break[1005][1005][15];
int Min = 1000000000;
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };
queue <pair <pair <int, int>, int>> q;

void bfs(int target) {
	path_break[0][0][target] = 1;
	q.push({ { 0,0 }, target });
	while (q.empty() == 0) {
		int n = q.front().first.first;
		int m = q.front().first.second;
		int target = q.front().second;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if (nnext<0 || nnext>=N || mnext<0 || mnext>=M) continue;
			if (board[nnext][mnext] == 0 && path_break[nnext][mnext][target]==0) {
				path_break[nnext][mnext][target] = path_break[n][m][target] + 1;
				q.push({{ nnext,mnext }, target });
			}
			if (target+1 <= K && board[nnext][mnext] == 1 && path_break[nnext][mnext][target+1]==0) {
				path_break[nnext][mnext][target + 1] = path_break[n][m][target] + 1;
				q.push({{ nnext,mnext }, target+1});
			}
		}
	}
}

int main() {
	scanf("%d%d%d", &N, &M, &K);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%1d", &board[i][j]);
		}
	}
	bfs(0);
	for (int i = 0; i <= K; i++) {
		if (path_break[N-1][M-1][i] == 0) continue;
		Min = min(Min, path_break[N-1][M-1][i]);
	}
	if (Min == 1000000000) printf("-1");
	else printf("%d", Min);
	return 0;
}
