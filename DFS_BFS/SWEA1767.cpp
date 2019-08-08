#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

typedef struct {
	int line_leng;
	int core_cnt;
}Result;

typedef struct {
	int n;
	int m;
}Core;

Core core[13];
Result ans;
int board[13][13];
int check[13][13];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };
int pos;
int N;

void dfs(int idx, int ccnt, int leng) {
	if (idx == pos) {
		if (ans.core_cnt == 0 && ans.line_leng == 0) {
			ans.core_cnt = ccnt;
			ans.line_leng = leng;
			return;
		}
		else if (ans.core_cnt > ccnt) {
			return;
		}
		else if (ans.core_cnt == ccnt) {
			ans.line_leng = min(ans.line_leng, leng);
			return;
		}
		else if (ans.core_cnt < ccnt) {
			ans.core_cnt = ccnt;
			ans.line_leng = leng;
			return;
		}
	}
	else {
		int n = core[idx].n;
		int m = core[idx].m;
		for (int k = 0; k < 4; k++) {
			int tmp = 0;
			for (int i = 1; i < N; i++) {
				int nnext = n + i * dc[k];
				int mnext = m + i * dr[k];
				if (nnext < 0 || nnext >= N || mnext < 0 || mnext >= N) break;
				else if (i == 1 && (check[nnext][mnext] == 1 || board[nnext][mnext] == 1)) {
					dfs(idx + 1, ccnt, leng);
					break;
				}
				else if (i > 1 && (check[nnext][mnext] == 1 || board[nnext][mnext] == 1)) {
					break;
				}
				else {
					if (nnext == 0 || nnext == N - 1 || mnext == 0 || mnext == N - 1) {
						dfs(idx + 1, ccnt + 1, leng + i);
						tmp++;
						check[nnext][mnext] = 1;
						break;
					}
					tmp++;
					check[nnext][mnext] = 1;
				}
			}
			for (int i = 1; i <= tmp; i++) {
				int nnext = n + i * dc[k];
				int mnext = m + i * dr[k];
				check[nnext][mnext] = 0;
			}
		}
	}
	return;
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int T;
	cin >> T;
	for (int t = 1; t <= T; t++) {
		for (int i = 0; i < 13; i++) {
			core[i].n = 0; core[i].m = 0;
		}
		ans.core_cnt = 0; ans.line_leng = 0;
		memset(check, 0, sizeof(check));
		memset(board, 0, sizeof(board));
		pos = 0;
		cin >> N;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cin >> board[i][j];
				if (board[i][j] == 1) {
					if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
						check[i][j] = 1;
						continue;
					}
					core[pos].n = i;
					core[pos].m = j;
					check[i][j] = 1;
					pos++;
				}
			}
		}
		dfs(0, 0, 0);
		cout << "#" << t << " " << ans.line_leng << '\n';
	}
	return 0;
}