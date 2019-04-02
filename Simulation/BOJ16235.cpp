/*BOJ16235 나무 제테크*/

#include <iostream>
using namespace std;

int N, M, K; //N은 땅 길이 ,M은 나무 갯수 , K는 몇년 지났는지
int x, y, z; //나무 위치 (x,y) 나무 나이 z
int A[15][15];
int board[15][15][1020]; //땅에 나이별로 나무 갯수 저장
int store_board[15][15][1020]; //봄과 여름에 작업되는 나무와 양분을 저장해놓는 배열

void pre_foods() {
	for (int i = 1; i <= N; i++) { //초기 땅에는 양분이 5로 들어있다.(0 에 저장)
		for (int j = 1; j <= N; j++) {
			board[i][j][0] = 5;
		}
	}
}
void spring() { //for spring
	for (int i = 1; i <= N; i++) { 
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k < 1020; k++) {
				if (board[i][j][k] != 0) {
					while (board[i][j][k] > 0) {
						if (k <= board[i][j][0]) { // 나무의 나이가 양분보다 작은 경우
							board[i][j][0] -= k;
							store_board[i][j][k + 1]++; //여기서 바로 board를 올리면, 반복문 돌면서 또 보게되서
							board[i][j][k]--;
						}
						else { //큰 경우
							store_board[i][j][0] += (board[i][j][k] * (k / 2)); //위에와 같은 이유
							board[i][j][k] = 0;
						}
					}
				}
			}
		}
	}
}
void summer() { //for summer
	for (int i = 1; i <= N; i++) { 
		for (int j = 1; j <= N; j++) {
			for (int k = 0; k < 1020; k++) {
				board[i][j][k] += store_board[i][j][k];
				store_board[i][j][k] = 0;
			}
		}
	}
}
void fall() { //for fall
	int dr[8] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int dc[8] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	for (int i = 1; i <= N; i++) { 
		for (int j = 1; j <= N; j++) {
			int k = 5;
			while (k<1020) {
				if (board[i][j][k] != 0) {
					for (int n = 0; n < 8; n++) {
						int nnext = i + dr[n];
						int mnext = j + dc[n];
						if (nnext >= 1 && nnext <= N && mnext >= 1 && mnext <= N) {
							board[nnext][mnext][1] += board[i][j][k];
						}
					}
				}
				k += 5;
			}
		}
	}
}

void winter() {
	for (int i = 1; i <= N; i++) { //for winter
		for (int j = 1; j <= N; j++) {
			board[i][j][0] += A[i][j];
		}
	}
}

int count_up() {
	int cnt = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k < 1020; k++) {
				if (board[i][j][k] != 0) {
					cnt += board[i][j][k];
				}
			}
		}
	}
	return cnt;
}

int main() {
	scanf("%d%d%d", &N, &M, &K);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%d", &A[i][j]);
		}
	}
	for (int i = 1; i <= M; i++) {
		scanf("%d%d%d", &x, &y, &z);
		board[x][y][z]++; //나이가 z인 나무를 좌표에 따라 카운트 업
	}
	pre_foods();
	while (K > 0) {
		spring();
		summer();
		fall();
		winter();
		K--;
	}
	printf("%d", count_up());
	return 0;
}