/*������ȣ ���̱� ����
������ ��Ը��� �׷���, ������ ������, ������ ������
�� ������ ���̸� ���ϴ� �ܼ��� ��������.
DFS�� �̿��ؼ� �ذ��Ͽ���.
�ٸ� ���ڸ� �����̽��� ������� �Է¹޴� �������
%1d��� ���� ó�� �˰� �Ǿ���.*/
#include <iostream>
#include <algorithm>
using namespace std;

int N, board[30][30], check[30][30];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1,0,1 };
int ans[200];
int result;
int cnt=1;

int dfs(int i, int j) {
	check[i][j] = 1;
	for (int k = 0; k < 4; k++) {
		int xnext = i + dx[k];
		int ynext = j + dy[k];
		if (check[xnext][ynext] == 0 && board[xnext][ynext] == 1 && xnext >= 0 && ynext >= 0 && xnext < N&&ynext < N) {
			dfs(xnext, ynext);
			cnt++;
		}
	}
	return cnt;
}
int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%1d", &board[i][j]);
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (check[i][j] == 0 && board[i][j] == 1) {
				ans[result]=dfs(i, j);
				result++;
				cnt = 1;
			}
		}
	}
	sort(ans, ans + result);
	printf("%d\n", result);
	for (int i = 0; i < result; i++) {
		printf("%d\n", ans[i]);
	}
	return 0;
}