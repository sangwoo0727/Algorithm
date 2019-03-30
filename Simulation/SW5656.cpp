/*SW5656. ���� ����*/

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

void recur(int checkp) { //������ ���� Ƚ���� ���� ��������� ����
	int copy[20][20] = {};
	if (checkp == 0) { //N����ŭ ���� ���� ���
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (board[i][j] != 0) cnt++;
			}
		}
		Min = min(Min, cnt);
		return;
	}
	for (int i = 0; i < W; i++) { //N����ŭ ���� �� ���� ���
		int x = 0;
		while (x < H&&board[x][i] == 0) x++;
		for (int h = 0; h < H; h++) { // ��� ������ ������ ���ư������� ������ �����س���!
			for (int w = 0; w < W; w++) {
				copy[h][w] = board[h][w];
			}
		}
		stonebreak(x, i); //���� �ϳ� �Ἥ ���� �������� �Լ�
		stonesort(); // �ν��� �κ� ����
		recur(checkp - 1); // ���� �ϳ��Ἥ ��ͷ� ����
		for (int h = 0; h < H; h++) { //������ �����س����� �����´�.
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
			int xnext = x + dc[n] * k; //�׹����� ����, �� ������ �� ������ŭ ��������
			int ynext = y + dr[n] * k;
			if (xnext < H&&xnext >= 0 && ynext >= 0 && ynext < W&&board[xnext][ynext] != 0) stonebreak(xnext, ynext);
		}
	}
}

void stonesort() { //���� ������
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