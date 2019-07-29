#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
	int check;
}Board;

typedef struct {
	int dir;
	int x;
	int y;
}Robot;

Robot robot[10000];
Board board[100][100];
int A, B;
char direct[4] = { 'N','W','S','E' };

int robot_simul(int * robotNum, char * di_func, int * cnt) {
	if (*di_func == 'L') {
		for (int c = 0; c < *cnt; c++) {
			if (robot[*robotNum].dir != 3) {
				robot[*robotNum].dir++;
			}
			else if (robot[*robotNum].dir == 3) {
				robot[*robotNum].dir = 0;
			}
		}
		return 0;
	}
	else if (*di_func == 'R') {
		for (int c = 0; c < *cnt; c++) {
			if (robot[*robotNum].dir != 0) {
				robot[*robotNum].dir--;
			}
			else if (robot[*robotNum].dir == 0) {
				robot[*robotNum].dir = 3;
			}
		}
	}
	else if (*di_func == 'F') {
		for (int c = 0; c < *cnt; c++) {
			
			if (robot[*robotNum].dir == 0) {
				int xnext = robot[*robotNum].x;
				int ynext = robot[*robotNum].y + 1;
				if (xnext<1 || xnext>A || ynext<1 || ynext>B) {
					return -1;
				}
				if (board[B - ynext][xnext + 1].check != 0) {
					return board[B - ynext][xnext + 1].check;
				}
				if (board[B - ynext][xnext + 1].check == 0) {
					board[B - ynext][xnext + 1].check = *robotNum;
					board[B- robot[*robotNum].y][robot[*robotNum].x+1].check = 0;
					robot[*robotNum].x = xnext;
					robot[*robotNum].y = ynext;
				}
			}
			else if (robot[*robotNum].dir == 1) {
				int xnext = robot[*robotNum].x - 1;
				int ynext = robot[*robotNum].y;
				if (xnext<1 || xnext>A || ynext<1 || ynext>B) {
					return -1;
				}
				if (board[B - ynext][xnext + 1].check != 0) {
					return board[B - ynext][xnext + 1].check;
				}
				if (board[B - ynext][xnext + 1].check == 0) {
					board[B - ynext][xnext + 1].check = *robotNum;
					board[B- robot[*robotNum].y][robot[*robotNum].x+1].check = 0;
					robot[*robotNum].x = xnext;
					robot[*robotNum].y = ynext;
				}
			}
			else if (robot[*robotNum].dir == 2) {
				int xnext = robot[*robotNum].x;
				int ynext = robot[*robotNum].y - 1;
				if (xnext<1 || xnext>A || ynext<1 || ynext>B) {
					return -1;
				}
				if (board[B - ynext][xnext + 1].check != 0) {
					return board[B - ynext][xnext + 1].check;
				}
				if (board[B - ynext][xnext + 1].check == 0) {
					board[B - ynext][xnext + 1].check = *robotNum;
					board[B- robot[*robotNum].y][robot[*robotNum].x+1].check = 0;
					robot[*robotNum].x = xnext;
					robot[*robotNum].y = ynext;
				}
			}
			else if (robot[*robotNum].dir == 3) {
				int xnext = robot[*robotNum].x + 1;
				int ynext = robot[*robotNum].y;
				if (xnext<1 || xnext>A || ynext<1 || ynext>B) {
					return -1;
				}
				if (board[B - ynext][xnext + 1].check != 0) {
					return board[B - ynext][xnext + 1].check;
				}
				if (board[B - ynext][xnext + 1].check == 0) {
					board[B - ynext][xnext + 1].check = *robotNum;
					board[B- robot[*robotNum].y][robot[*robotNum].x+1].check = 0;
					robot[*robotNum].x = xnext;
					robot[*robotNum].y = ynext;
				}
			}
		}
	}
	return 0;
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> A >> B;
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < B; i++) {
		for (int j = 0; j < A; j++) {
			board[i][j].y = B - i;
			board[i][j].x = j + 1;
			board[i][j].check = 0;
		}
	}
	for (int n = 1; n <= N; n++) {
		int x, y;
		char d;
		cin >> x >> y >> d;
		robot[n].x = x;
		robot[n].y = y;
		board[B-y][x+1].check = n;
		for (int i = 0; i < 4; i++) {
			if (direct[i] == d) robot[n].dir = i;
		}
	}
	
	for (int m = 0; m < M; m++) {
		int robot_num;
		char func;
		int func_cnt;
		cin >> robot_num >> func >> func_cnt;
		int ans = robot_simul(&robot_num, &func, &func_cnt);
		if (ans == -1) {
			cout << "Robot " << robot_num << " crashes into the wall" << '\n';
			break;
		}
		else if (ans > 0) {
			cout << "Robot " << robot_num << " crashes into robot " << ans << '\n';
			break;
		}
		else if (m == M - 1 && ans == 0) {
			cout << "OK" << '\n';
		}
	}
	return 0;
}