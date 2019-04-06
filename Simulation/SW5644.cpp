/* SW 5644 ��������*/
#include <iostream>
#include <vector>
#include <queue>
#include <utility>
#include <algorithm>
#include <cstring>
using namespace std;

typedef struct {
	int allcheck;
	int BC[10];
}BC_check; // �����ǿ� ���� ���� check�� � BC ���ִ���, �װͿ����� �迭�� ������ ����

typedef struct {
	int y;
	int x;
	int C; //���� ����
	int P; //���� ����
}BC_infor; // BC�� ���� �Է�

BC_check board[15][15];
int M, A; //M�� �����ð�, A�� BC�� ����
int Person_dc[5] = {0,-1,0,1,0};
int Person_dr[5] = {0,0,1,0,-1};
int dc[4] = { -1,1,0,0 };
int dr[4] = { 0,0,-1,1 };

void BC_preBFS(vector <BC_infor> &BCmachine, int idx) {
	queue <pair <int, int>> pre_Q;
	queue <int> q_cnt;
	int x = BCmachine[idx].x;
	int y = BCmachine[idx].y;
	int cnt = 0;
	board[x][y].allcheck++;
	board[x][y].BC[idx] = BCmachine[idx].P;
	pre_Q.push({ x,y });
	q_cnt.push({ cnt });
	while (pre_Q.empty() == 0) {
		int xnow = pre_Q.front().first;
		int ynow = pre_Q.front().second;
		cnt = q_cnt.front();
		pre_Q.pop();
		q_cnt.pop();
		if (cnt < BCmachine[idx].C) {
			for (int k = 0; k < 4; k++) {
				int xnext = xnow + dc[k];
				int ynext = ynow + dr[k];
				if (xnext >= 1 && xnext <= 10 && ynext >= 1 && ynext <= 10 && board[xnext][ynext].BC[idx]==0) {
					board[xnext][ynext].allcheck++;
					board[xnext][ynext].BC[idx] = BCmachine[idx].P;
					pre_Q.push({ xnext,ynext });
					q_cnt.push(cnt + 1);
				}
			}
		}
	}
}
int main() {
	int T;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d%d", &M, &A);
		//A�� (1,1)����, B��(10,10)���� ����Ѵ�.
		vector <int> A_move(M+1); //A������ ����迭
		vector <int> B_move(M+1); //B ������ ����迭
		vector <BC_infor> BCmachine(A+1); //BC��� ���� �迭
		A_move[0] = 0;
		B_move[0] = 0;
		for (int i = 1; i <= M; i++) {
			scanf("%d", &A_move[i]);
		} //��� A������
		for (int i = 1; i <= M; i++) {
			scanf("%d", &B_move[i]);
		} //��� B������
		for (int i = 1; i <= A; i++) {
			scanf("%d%d%d%d", &BCmachine[i].y, &BCmachine[i].x, &BCmachine[i].C, &BCmachine[i].P);
		} //������� �Է� , ���忡 ��� ���� �� ���� üũ
		for (int i = 1; i <= A; i++) {
			BC_preBFS(BCmachine, i);
		} 
		
		int ax = 1, ay = 1;
		int bx = 10, by = 10;
		int sum=0;
		int TTT = 0;
		for (int i = 0; i <= M; i++) {
			//printf("T%d ", TTT++);
			ax = ax + Person_dc[A_move[i]];
			ay = ay + Person_dr[A_move[i]];
			bx = bx + Person_dc[B_move[i]];
			by = by + Person_dr[B_move[i]];
			if (board[ax][ay].allcheck == 0 && board[bx][by].allcheck == 0) {
				//printf("%d ", sum);
				continue; // �� �� 0 �� ���
			}
			if (board[ax][ay].allcheck == 0 && board[bx][by].allcheck !=0) { // a�� 0 �� ���
				int tmp = 0;
				for (int j = 1; j <= A; j++) {
					tmp = max(tmp, board[bx][by].BC[j]);
				}
				sum += tmp;
			}
			if (board[ax][ay].allcheck != 0 && board[bx][by].allcheck == 0) { // b�� 0 �� ���
				int tmp = 0;
				for (int j = 1; j <= A; j++) {
					tmp = max(tmp, board[ax][ay].BC[j]);
				}
				sum += tmp;
			}
			if(board[ax][ay].allcheck!=0 && board[bx][by].allcheck!=0) {// �Ѵ� 0�� �ƴ� ���
				if (board[ax][ay].allcheck == 1 && board[bx][by].allcheck == 1) { //�� �� 1�� ���
					int acheck, bcheck, atmp, btmp;
					for (int j = 1; j <= A; j++) {
						if (board[ax][ay].BC[j] != 0) {
							acheck = j;
							atmp = board[ax][ay].BC[j];
						}
						if (board[bx][by].BC[j] != 0) {
							bcheck = j;
							btmp = board[bx][by].BC[j];
						}
					}
					if (acheck == bcheck && atmp==btmp) { // ���� ����� ���
						sum += atmp;
					}
					else { //�ٸ� ����� ���
						sum += atmp;
						sum += btmp;
					}
				}
				if (board[ax][ay].allcheck == 1 && board[bx][by].allcheck > 1) { //a�� ��� �Ѱ� , b�� �������� ���
					int acheck = 0, atmp = 0;
					int bcheck = 0, btmp = 0;
					int maxcheck = 0, maxtmp = 0;
					int case1 = 0, case2 = 0, case3 = 0, case4 = 0;
					for (int j = 1; j <= A; j++) { //A�� ���� ��� ã��
						if (board[ax][ay].BC[j] != 0) {
							acheck = j;
							atmp = board[ax][ay].BC[j];
							break;
						}
					}
					for (int j = 1; j <= A; j++) { // A�� ���� ��谡 B���� ���� ��
						if (atmp == board[bx][by].BC[j] && acheck == j) {
							bcheck = j;
							btmp = board[bx][by].BC[j];
						}
					}
					for (int j = 1; j <= A; j++) { // B�� ���� ū ��� ���ϱ�
						if (board[bx][by].BC[j] > maxtmp) {
							maxtmp = board[bx][by].BC[j];
							maxcheck = j;
						}
					}
					if (bcheck == 0) { //a�� b�� ��ġ�� ������,
						case1 += maxtmp;
						case1 += atmp;
					}
					else if (bcheck != 0) { //��ĥ ��
						int nextb = 0;
						if (maxcheck == acheck && maxtmp == atmp) { // �ִ밪�� ������
							case2 += maxtmp;
							for (int j = 1; j <= A; j++) { //�ι�°�� ū �ƽ���
								if (board[bx][by].BC[j] == maxtmp) continue;
								nextb = max(nextb, board[bx][by].BC[j]);
							}
							case3 += atmp;
							case3 += nextb;
						}
						else if (maxcheck != acheck && maxtmp != atmp) {
							case4 += maxtmp;
							case4 += atmp;
						}
					}
					int maxcase = max(case1, max(case2, max(case3, case4)));
					sum += maxcase;
				}
				if (board[ax][ay].allcheck > 1 && board[bx][by].allcheck == 1) {//a�� ��� ������, b�� ��� �Ѱ��� ���
					int acheck = 0, atmp = 0;
					int bcheck = 0, btmp = 0;
					int maxcheck = 0, maxtmp = 0;
					int case1 = 0, case2 = 0, case3=0, case4=0;
					for (int j = 1; j <= A; j++) { //B�� ���� ��� ã��
						if (board[bx][by].BC[j] != 0) {
							bcheck = j;
							btmp = board[bx][by].BC[j];
							break;
						}
					}
					for (int j = 1; j <= A; j++) { // B�� ���� ��谡 A���� ���� ��
						if (btmp == board[ax][ay].BC[j] && bcheck==j) {
							acheck = j;
							atmp = board[ax][ay].BC[j];
						}
					}
					for (int j = 1; j <= A; j++) { // A�� ���� ū ��� ���ϱ�
						if (board[ax][ay].BC[j] > maxtmp) {
							maxtmp = board[ax][ay].BC[j];
							maxcheck = j;
						}
					}
					if (acheck == 0) { //a�� b�� ��ġ�� ������,
						case1 += maxtmp;
						case1 += btmp;
					}
					else if (acheck != 0) { //��ĥ ��
						int nexta = 0;
						if (maxcheck == bcheck && maxtmp == btmp) { // �ִ밪�� ������
							case2 += maxtmp;
							for (int j = 1; j <= A; j++) { //�ι�°�� ū �ƽ���
								if (board[ax][ay].BC[j] == maxtmp) continue;
								nexta = max(nexta, board[ax][ay].BC[j]);
							}
							case3 += btmp;
							case3 += nexta;
						}
						else if (maxcheck != bcheck && maxtmp != btmp) {
							case4 += maxtmp;
							case4 += btmp;
						}
					}
					int maxcase = max(case1, max(case2, max(case3, case4)));
					sum += maxcase;
				}
				if (board[ax][ay].allcheck > 1 && board[bx][by].allcheck > 1) { // �� �� �������� ���
					int acheck = 0, atmp = 0;
					int bcheck = 0, btmp = 0;
					int case1 = 0, case2 = 0, case3=0;
					for (int j = 1; j <= A; j++) {
						if (board[ax][ay].BC[j] > atmp) {
							atmp = board[ax][ay].BC[j];
							acheck = j;
						}
					}
					for (int j = 1; j <= A; j++) {
						if (board[bx][by].BC[j] > btmp) {
							btmp = board[bx][by].BC[j];
							bcheck = j;
						}
					}
					if (acheck == bcheck && atmp == btmp) { //���� �ִ� ��谡 ���� ���
						case1 = atmp;
						int nextmaxA = 0;
						int nextmaxB = 0;
						for (int j = 1; j <= A; j++) {
							if (board[ax][ay].BC[j] == atmp) continue;
							nextmaxA = max(nextmaxA, board[ax][ay].BC[j]);
						}
						case2 = atmp + nextmaxA;
						for (int j = 1; j <= A; j++) {
							if (board[bx][by].BC[j] == btmp) continue;
							nextmaxB = max(nextmaxB, board[bx][by].BC[j]);
						}
						case3 = btmp + nextmaxB;
						sum += max(case1, max(case2, case3));
					}
					else if (acheck != bcheck) { //���� �ִ� ��谡 �ٸ� ���
						sum += atmp;
						sum += btmp;
					}
				}
			}
		}
		printf("#%d %d\n", t, sum);
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				board[i][j].allcheck = 0;
				for (int k = 1; k <= A; k++) {
					board[i][j].BC[k] = 0;
				}
			}
		}
	}
	return 0;
}