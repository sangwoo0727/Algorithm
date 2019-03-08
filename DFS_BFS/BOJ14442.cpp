/*
14442 ���μ��� �̵��ϱ� 2
���� ����� Ǯ����.
�Է¹��� k���� ���ؼ��� ���� ���� �� �ִ�.
k���� �پ��ԵǸ� �� ���� ���ʹ� ���� ���� �� ����, 0�� �ִ� �����θ� �̵��� �� �ִ�
���������������� �ִ� �Ÿ��� ���ϴ� bfs ����
�������迭�� ��� ���� �վ������� üũ�Ѵ�.(�� �κп� ���� ������ ���ؼ� ����߾���.)
*/
#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;

int N, M, K;
queue <pair <pair <int, int>, int>> q; //i,j, �׸��� ���� �μ� Ƚ�� target ������ ����.
int board[1005][1005];
int ans_target[1005][1005][12]; // ���� �μ� Ƚ�� target������ ǥ���ϱ� ���� 3���� �迭
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };

void bfs(int target) { 
	ans_target[1][1][0] = 1; //ù������ 1�� ����
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
			if (board[nnext][mnext] == 0 && ans_target[nnext][mnext][target] == 0) { //���� �ƴ� ���� ������ ��
				ans_target[nnext][mnext][target] = ans_target[n][m][target] + 1;
				q.push({ { nnext,mnext }, target });
			}
			if (target+1<=K&&board[nnext][mnext] == 1 && ans_target[nnext][mnext][target + 1] == 0) { //���� ������ ��
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
		if (ans_target[N][M][i] == 0) continue; //�������� ���� 0�̶�� Ž���� ���� ���̹Ƿ� continue
		if (ans == -1) { //�������� � ���� �ִٴ� ��
			ans = ans_target[N][M][i];
		}
		else if (ans > ans_target[N][M][i]) { //�ּҰ� ����� ����
			ans = ans_target[N][M][i];
		}
	}
	printf("%d", ans);
	return 0;
}