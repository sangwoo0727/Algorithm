#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int board[22][22]; //moving board
int field[22][22];
int check[22][22];
char dir[4] = { 'u','d','l','r' };
char pick[5];
int N;
int Max;

void gamestart() {
	memcpy(board, field, sizeof(board));
	for (int i = 0; i < 5; i++) {
		memset(check, 0, sizeof(check));
		if (pick[i] == 'u') {
			for (int m = 0; m < N; m++) {
				for (int n = 0; n < N; n++) {
					if (n == 0) continue;
					if (board[n][m] == 0) continue;
					int idx = n;
					while (1) {
						idx--;
						if (idx >= 0 && board[idx][m] == 0) {
							if (idx == 0) {
								board[idx][m] = board[n][m];
								check[idx][m] = check[n][m];
								board[n][m] = 0;
								check[n][m] = 0;
								break;
							}
						}
						if (idx >= 0 && board[idx][m] != 0) {
							if (board[idx][m] == board[n][m]) {
								if (check[n][m] == 0 && check[idx][m] == 0) {
									board[idx][m] = board[idx][m] + board[n][m];
									board[n][m] = 0;
									check[idx][m] = 1;
									break;
								}
								else {
									if (idx + 1 == n) break;
									else {
										board[idx + 1][m] = board[n][m];
										check[idx + 1][m] = check[n][m];
										board[n][m] = 0;
										check[n][m] = 0;
										break;
									}
								}
							}
							else {
								if (idx + 1 == n) break;
								else {
									board[idx + 1][m] = board[n][m];
									check[idx + 1][m] = check[n][m];
									board[n][m] = 0;
									check[n][m] = 0;
									break;
								}
							}
						}
					}
				}
			}
		}
		if (pick[i] == 'd') {
			for (int m = 0; m < N ; m++) {
				for (int n = N-1; n >=0 ; n--) {
					if (n == N - 1) continue;
					if (board[n][m] == 0) continue;
					int idx = n;
					while (1) {
						idx++;
						if (idx < N && board[idx][m] == 0) {
							if (idx == N - 1) {
								board[idx][m] = board[n][m];
								check[idx][m] = check[n][m];
								board[n][m] = check[n][m] = 0;
								break;
							}
						}
						if (idx < N && board[idx][m] != 0) {
							if (board[idx][m] == board[n][m]) {
								if (check[n][m] == 0 && check[idx][m] == 0) {
									board[idx][m] = board[idx][m] + board[n][m];
									board[n][m] = 0;
									check[idx][m] = 1;
									break;
								}
								else {
									if (idx - 1 == n) break;
									else {
										board[idx - 1][m] = board[n][m];
										check[idx - 1][m] = check[n][m];
										board[n][m] = 0;
										check[n][m] = 0;
										break;
									}
								}
							}
							else {
								if (idx - 1 == n) break;
								else {
									board[idx - 1][m] = board[n][m];
									check[idx - 1][m] = check[n][m];
									board[n][m] = 0;
									check[n][m] = 0;
									break;
								}
							}
						}
					}
				}
			}
		}
		if (pick[i] == 'l') {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (m == 0) continue;
					if (board[n][m] == 0) continue;
					int idx = m;
					while (1) {
						idx--;
						if (idx >=0 && board[n][idx] == 0) {
							if (idx == 0) {
								board[n][idx] = board[n][m];
								check[n][idx] = check[n][m];
								board[n][m] = check[n][m] = 0;
								break;
							}
						}
						if(idx>=0 && board[n][idx]!=0) {
							if (board[n][idx] == board[n][m]) {
								if (check[n][m] == 0 && check[n][idx] == 0) {
									board[n][idx] = board[n][idx] + board[n][m];
									board[n][m] = 0;
									check[n][idx] = 1;
									break;
								}
								else {
									if (idx + 1 == m) break;
									else {
										board[n][idx + 1] = board[n][m];
										check[n][idx + 1] = check[n][m];
										board[n][m] = 0;
										check[n][m] = 0;
										break;
									}
								}
							}
							else {
								if (idx + 1 == m) break;
								else {
									board[n][idx + 1] = board[n][m];
									check[n][idx + 1] = check[n][m];
									board[n][m] = 0;
									check[n][m] = 0;
									break;
								}
							}
						}
					}
				}
			}
		}
		if (pick[i] == 'r') {
			for (int n = 0; n < N; n++) {
				for (int m = N - 1; m >= 0; m--) {
					if (m == N - 1) continue;
					if (board[n][m] == 0) continue;
					int idx = m;
					while (1) {
						idx++;
						if (idx < N && board[n][idx] == 0) {
							if (idx == N-1) {
								board[n][idx] = board[n][m];
								check[n][idx] = check[n][m];
								board[n][m] = check[n][m] = 0;
								break;
							}
						}
						if (idx < N  && board[n][idx] != 0) {
							if (board[n][idx] == board[n][m]) {
								if (check[n][m] == 0 && check[n][idx] == 0) {
									board[n][idx] = board[n][idx] + board[n][m];
									board[n][m] = 0;
									check[n][idx] = 1;
									break;
								}
								else {
									if (idx - 1 == m) break;
									else {
										board[n][idx - 1] = board[n][m];
										check[n][idx - 1] = check[n][m];
										board[n][m] = 0;
										check[n][m] = 0;
										break;
									}
								}
							}
							else {
								if (idx - 1 == m) break;
								else {
									board[n][idx - 1] = board[n][m];
									check[n][idx - 1] = check[n][m];
									board[n][m] = 0;
									check[n][m] = 0;
									break;
								}
							}
						}
					}
				}
			}
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			Max = max(Max, board[i][j]);
		}
	}
}

void dfs(int cnt) {
	if (cnt == 5) {
		gamestart();
		return;
	}
	for (int i = 0; i < 4; i++) {
		pick[cnt] = dir[i];
		dfs(cnt + 1);
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int n = 0; n < N; n++) {
		for (int m = 0; m < N; m++) {
			cin >> field[n][m];
		}
	}
	dfs(0);
	cout << Max << '\n';
	return 0;
}