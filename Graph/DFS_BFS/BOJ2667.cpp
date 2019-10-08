/*단지번호 붙이기 문제
문제를 길게만들어서 그렇지, 요점만 뽑으면, 영역의 개수와
각 영역별 넓이를 구하는 단순한 문제였다.
DFS를 이용해서 해결하였다.
다만 숫자를 스페이스나 개행없이 입력받는 방법으로
%1d라는 것을 처음 알게 되었다.*/
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