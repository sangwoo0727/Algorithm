/*BOJ15683 °¨½Ã*/

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef struct {
	int x;
	int y;
	int cctv_num;
}cctv_info;

int N, M;
int board[10][10];
int check[10][10][10];
int ans = 0;
int MAX = 10000000;


void all_search(vector <cctv_info> &cctv,int idx, int n) {
	if (idx == n) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[n][i][j] == 0 && board[i][j]==0) ans++;
			}
		}
		MAX = min(MAX, ans);
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check[n][i][j] = 0;
			}
		}
		return;
	}
	if (cctv[idx].cctv_num == 1) {
		for (int i = 1; i <= 4; i++) {
			if (i == 1) {
				for (int k = cctv[idx].y; k < M; k++) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}	
			}
			else if (i == 2) {
				for (int k = cctv[idx].x; k < N; k++) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 3) {
				for (int k = cctv[idx].y; k >= 0; k--) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 4) {
				for (int k = cctv[idx].x; k >=0; k--) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
		
		}
	}
	else if (cctv[idx].cctv_num == 2) {
		for (int i = 1; i <= 2; i++) {
			if (i == 1) {
				for (int k = cctv[idx].x; k < N; k++) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].x; k >= 0; k--) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 2) {
				for (int k = cctv[idx].y; k < M; k++) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int k = cctv[idx].y; k >= 0; k--) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			
		}
	}
	else if (cctv[idx].cctv_num == 3) {
		for (int i = 1; i <= 4; i++) {
			if (i == 1) {
				for (int k = cctv[idx].x; k < N; k++) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].y; k < M; k++) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 2) {
				for (int k = cctv[idx].x; k < N; k++) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].y; k >= 0; k--) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 3) {
				for (int k = cctv[idx].x; k >= 0; k--) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].y; k < M; k++) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 4) {
				for (int k = cctv[idx].x; k >= 0; k--) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].y; k >= 0; k--) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			
		}
	}
	else if (cctv[idx].cctv_num == 4) {
		for (int i = 1; i <= 4; i++) {
			if (i == 1) {
				for (int k = cctv[idx].x; k < N; k++) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].x; k >= 0; k--) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].y; k < M; k++) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 2) {
				for (int k = cctv[idx].x; k < N; k++) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].x; k >= 0; k--) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int k = cctv[idx].y; k >=0; k--) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 3) {
				for (int k = cctv[idx].y; k < M; k++) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int k = cctv[idx].y; k >= 0; k--) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int k = cctv[idx].x; k < N; k++) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
			else if (i == 4) {
				for (int k = cctv[idx].y; k < M; k++) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int k = cctv[idx].y; k >= 0; k--) {
					if (board[cctv[idx].x][k] == 6) break;
					check[idx][cctv[idx].x][k] = 1;
				}
				for (int k = cctv[idx].x; k >= 0; k--) {
					if (board[k][cctv[idx].y] == 6) break;
					check[idx][k][cctv[idx].y] = 1;
				}
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < M; m++) {
						check[idx + 1][n][m] = check[idx][n][m];
					}
				}
				all_search(cctv, idx + 1, n);
				if (idx == 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = 0;
						}
					}
				}
				if (idx > 0) {
					for (int n = 0; n < N; n++) {
						for (int m = 0; m < M; m++) {
							check[idx][n][m] = check[idx - 1][n][m];
						}
					}
				}
			}
		}
	}
	else if (cctv[idx].cctv_num == 5) {
		for (int k = cctv[idx].x; k < N; k++) {
			if (board[k][cctv[idx].y] == 6) break;
			check[idx][k][cctv[idx].y] = 1;
		}
		for (int k = cctv[idx].x; k >= 0; k--) {
			if (board[k][cctv[idx].y] == 6) break;
			check[idx][k][cctv[idx].y] = 1;
		}
		for (int k = cctv[idx].y; k < M; k++) {
			if (board[cctv[idx].x][k] == 6) break;
			check[idx][cctv[idx].x][k] = 1;
		}
		for (int k = cctv[idx].y; k >= 0; k--) {
			if (board[cctv[idx].x][k] == 6) break;
			check[idx][cctv[idx].x][k] = 1;
		}
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				check[idx + 1][n][m] = check[idx][n][m];
			}
		}
		all_search(cctv, idx + 1, n);
		if (idx == 0) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					check[idx][n][m] = 0;
				}
			}
		}
		if (idx > 0) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					check[idx][n][m] = check[idx - 1][n][m];
				}
			}
		}
	}
}
int main() {
	scanf("%d%d", &N, &M);
	int cnt = 0;
	vector <cctv_info> cctv;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
			if (board[i][j] == 1 || board[i][j] == 2 || board[i][j] == 3 || board[i][j] == 4 || board[i][j] == 5) {
				cctv.push_back({ i,j,board[i][j] });
			}
		}
	}
	int n = cctv.size();
	all_search(cctv,0,n);
	printf("%d", MAX);
	return 0;
}