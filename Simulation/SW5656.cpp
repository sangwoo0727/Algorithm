/*SW5656. 벽돌 깨기*/

#include <iostream>
#include <algorithm>
#include <cstring>
#define INF 0xFFFFFF;
using namespace std;

int N, W, H;
int board[20][20];
int dc[4] = { 0,0,1,-1 };
int dr[4] = { 1,-1,0,0 };
int Min = INF;

void recur(int);
void stonesort();
void stonebreak(int, int);

void recur(int checkp) { //구슬을 던진 횟수에 대해 재귀적으로 접근
	int copy[20][20] = {};
	if (checkp == 0) { //N번만큼 구슬 던진 경우
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (board[i][j] != 0) cnt++;
			}
		}
		Min = min(Min, cnt);
		return;
	}
	for (int i = 0; i < W; i++) { //N번만큼 아직 안 던진 경우
		int x = 0;
		while (x < H&&board[x][i] == 0) x++;
		for (int h = 0; h < H; h++) { // 재귀 돌리기 전으로 돌아가기위해 보드판 복사해놓기!
			for (int w = 0; w < W; w++) {
				copy[h][w] = board[h][w];
			}
		}
		stonebreak(x, i); //구슬 하나 써서 벽돌 깨러가는 함수
		stonesort(); // 부숴진 부분 정렬
		recur(checkp - 1); // 구슬 하나써서 재귀로 들어가기
		for (int h = 0; h < H; h++) { //보드판 복사해놓은것 가져온다.
			for (int w = 0; w < W; w++) {
				board[h][w] = copy[h][w];
			}
		}
	}
}

void stonebreak(int x, int y) {
	int score = board[x][y];
	board[x][y] = 0;
	for (int k = 0; k < score; k++) { 
		for (int n = 0; n < 4; n++) {
			int xnext = x + dc[n] * k; //네방향을 보되, 그 벽돌에 들어간 점수만큼 보기위해
			int ynext = y + dr[n] * k;
			if (xnext < H&&xnext >= 0 && ynext >= 0 && ynext < W&&board[xnext][ynext] != 0) stonebreak(xnext, ynext);
		}
	}
}

void stonesort() { //벽돌 재정렬
	for (int i = 0; i < W; i++) {
		for (int j = H - 1; j > 0; j--) {
			if (board[j][i] == 0) {
				for (int k = j - 1; k >= 0; k--) {
					if (board[k][i] != 0) {
						board[j][i] = board[k][i];
						board[k][i] = 0;
						break;
					}
				}
			}
		}
	}
}
int main() {
	int T;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d%d%d", &N, &W, &H);
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				scanf("%d", &board[i][j]);
			}
		}
		recur(N);
		printf("#%d %d\n", t, Min);
		memset(board, 0, sizeof(board));
		Min = INF;
	}
	return 0;
}