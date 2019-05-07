#include <iostream>
#include <cstring>
using namespace std;

int N;
int board[1005][1005];
int check[1005][1005];
int tmp_num, tmp_result;
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };

typedef struct {
	int x;
	int y;
}pre_process;

typedef struct {
	int start_pos;
	int end_pos;
	int maxnum;
}MAX;

pre_process pre_board[1000005];
MAX result;

void dfs(int start) {
	int xnow = pre_board[start].x;
	int ynow = pre_board[start].y;
	tmp_result += 1;
	result.end_pos = start;
	check[xnow][ynow] = 1;
	for (int k = 0; k < 4; k++) {
		int xnext = xnow + dc[k];
		int ynext = ynow + dr[k];
		if (xnext < 0 || xnext >= N || ynext < 0 || ynext >= N || check[xnext][ynext] == 1 || board[xnext][ynext] != board[xnow][ynow] + 1)
			continue;
		dfs(start+1);
		check[xnext][ynext] = 0;
		return;
	}
}

int main() {
	int T;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d", &N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				scanf("%d", &board[i][j]);
				pre_board[board[i][j]].x = i;
				pre_board[board[i][j]].y = j;
			}
		}
		int start = 1;
		while (start <= N * N) {
			tmp_num = start;
			dfs(start);
			check[pre_board[start].x][pre_board[start].y] = 0;
			if (tmp_result > result.maxnum) {
				result.start_pos = tmp_num;
				result.maxnum = tmp_result;
			}
			tmp_result = 0;
			start = result.end_pos + 1;
		}
		printf("#%d %d %d\n", t, result.start_pos, result.maxnum);
		result.start_pos = 0;
		result.end_pos = 0;
		result.maxnum = 0;
	}
	return 0;
}