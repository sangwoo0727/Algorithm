/*2589 ������ 
bfs�� �� i�� j������ �ٲ��� �ʾƼ� ����ߴ�.
�� �ٲٴ��� �����ϰ�, �ذ�
https://www.acmicpc.net/problem/2589 ����
�ִ� ��ι����� BFS�� Ǯ��� �ð��ʰ��� ���� �ʴ´�.

*/
#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
#include <cstring>
using namespace std;


char board[55][55];
int check[55][55];
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1,0,1 };
int MAX;
int n,m;
int cnt;


void bfs(int j, int i) {
	queue <pair<int, int>> q;
	queue <int> result;
	check[j][i] = 1;
	q.push({ j, i });
	result.push(0);
	while (q.empty() == 0) {
		int ynow = q.front().first;
		int xnow = q.front().second;
		cnt = result.front();
		q.pop();
		result.pop();
		for (int k = 0; k< 4; k++) {
			int xnext = xnow + dx[k];
			int ynext = ynow + dy[k];
			if (xnext >= 0 && ynext >= 0 && xnext < m && ynext < n && check[ynext][xnext] == 0 && board[ynext][xnext]=='L') {
				check[ynext][xnext] = 1;
				q.push({ ynext,xnext });
				result.push(cnt + 1);
			}
		}

	}
}
int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%s", board[i]);
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
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