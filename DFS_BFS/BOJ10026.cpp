/*���ϻ��� ���� 10026��
dfs�� bfs�� Ǯ��Ǵµ�, ���ͷ� �Է¹��� �׷����� �ƴ�
�迭�̱⶧���� ��,�Ʒ�,��,�츦 ���鼭 dfs Ž���� �ѹ� ������
ī��Ʈ�� 1������Ű��ȴ�.
���� �ʱ�ȭ��Ų�� ���ϻ����� ����� r�� g�� �ٲ㼭 Ǯ�� �ȴ�.*/

#include <iostream>
#include <cstring>
using namespace std;

int n;
char board[105][105];
int check[105][105];
int dr[4] = { 0,0,-1,1 };
int dc[4] = { -1,1,0,0 };
int cnt = 0;

void dfs(int i, int j) {
	check[i][j] = 1;
	for (int m = 0; m < 4; m++) {
		int ri = i + dr[m];
		int cj = j + dc[m];
		if (check[ri][cj] == 0 && ri>=0 && cj>=0 && ri<n && cj<n && board[ri][cj]==board[i][j]) {
			check[ri][cj] = 1;
			dfs(ri, cj);
		}
	}
}
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%s", &board[i]);
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] != 0) continue;
			dfs(i, j);
			cnt++;
		}
	}
	printf("%d ", cnt);
	cnt = 0;
	memset(check, 0, sizeof(check));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (board[i][j] == 'R')
				board[i][j] = 'G';
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] != 0) continue;
			dfs(i, j);
			cnt++;
		}
	}
	printf("%d ", cnt);
	return 0;
}