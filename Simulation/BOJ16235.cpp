/*BOJ16235 ���� ����ũ*/

#include <iostream>
using namespace std;

int N, M, K; //N�� �� ���� ,M�� ���� ���� , K�� ��� ��������
int x, y, z; //���� ��ġ (x,y) ���� ���� z
int A[15][15];
int board[15][15][1020]; //���� ���̺��� ���� ���� ����
int store_board[15][15][1020]; //���� ������ �۾��Ǵ� ������ ����� �����س��� �迭

void pre_foods() {
	for (int i = 1; i <= N; i++) { //�ʱ� ������ ����� 5�� ����ִ�.(0 �� ����)
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
						if (k <= board[i][j][0]) { // ������ ���̰� ��к��� ���� ���
							board[i][j][0] -= k;
							store_board[i][j][k + 1]++; //���⼭ �ٷ� board�� �ø���, �ݺ��� ���鼭 �� ���ԵǼ�
							board[i][j][k]--;
						}
						else { //ū ���
							store_board[i][j][0] += (board[i][j][k] * (k / 2)); //������ ���� ����
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
		board[x][y][z]++; //���̰� z�� ������ ��ǥ�� ���� ī��Ʈ ��
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