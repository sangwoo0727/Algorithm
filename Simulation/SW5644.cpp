/* SW 5644 무선충전*/
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
}BC_check; // 보드판에 들어가는 정보 check는 몇개 BC 들어가있는지, 그것에따른 배열에 충전량 저장

typedef struct {
	int y;
	int x;
	int C; //충전 범위
	int P; //충전 성능
}BC_infor; // BC의 정보 입력

BC_check board[15][15];
int M, A; //M은 충전시간, A는 BC의 개수
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
		//A는 (1,1)에서, B는(10,10)에서 출발한다.
		vector <int> A_move(M+1); //A움직임 저장배열
		vector <int> B_move(M+1); //B 움직임 저장배열
		vector <BC_infor> BCmachine(A+1); //BC기계 저장 배열
		A_move[0] = 0;
		B_move[0] = 0;
		for (int i = 1; i <= M; i++) {
			scanf("%d", &A_move[i]);
		} //사람 A움직임
		for (int i = 1; i <= M; i++) {
			scanf("%d", &B_move[i]);
		} //사람 B움직임
		for (int i = 1; i <= A; i++) {
			scanf("%d%d%d%d", &BCmachine[i].y, &BCmachine[i].x, &BCmachine[i].C, &BCmachine[i].P);
		} //기계정보 입력 , 보드에 기계 범위 및 정보 체크
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
				continue; // 둘 다 0 인 경우
			}
			if (board[ax][ay].allcheck == 0 && board[bx][by].allcheck !=0) { // a만 0 인 경우
				int tmp = 0;
				for (int j = 1; j <= A; j++) {
					tmp = max(tmp, board[bx][by].BC[j]);
				}
				sum += tmp;
			}
			if (board[ax][ay].allcheck != 0 && board[bx][by].allcheck == 0) { // b만 0 인 경우
				int tmp = 0;
				for (int j = 1; j <= A; j++) {
					tmp = max(tmp, board[ax][ay].BC[j]);
				}
				sum += tmp;
			}
			if(board[ax][ay].allcheck!=0 && board[bx][by].allcheck!=0) {// 둘다 0이 아닌 경우
				if (board[ax][ay].allcheck == 1 && board[bx][by].allcheck == 1) { //둘 다 1인 경우
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
					if (acheck == bcheck && atmp==btmp) { // 같은 기계인 경우
						sum += atmp;
					}
					else { //다른 기계인 경우
						sum += atmp;
						sum += btmp;
					}
				}
				if (board[ax][ay].allcheck == 1 && board[bx][by].allcheck > 1) { //a는 기계 한개 , b는 여러개인 경우
					int acheck = 0, atmp = 0;
					int bcheck = 0, btmp = 0;
					int maxcheck = 0, maxtmp = 0;
					int case1 = 0, case2 = 0, case3 = 0, case4 = 0;
					for (int j = 1; j <= A; j++) { //A가 속한 기계 찾기
						if (board[ax][ay].BC[j] != 0) {
							acheck = j;
							atmp = board[ax][ay].BC[j];
							break;
						}
					}
					for (int j = 1; j <= A; j++) { // A가 속한 기계가 B에도 속할 때
						if (atmp == board[bx][by].BC[j] && acheck == j) {
							bcheck = j;
							btmp = board[bx][by].BC[j];
						}
					}
					for (int j = 1; j <= A; j++) { // B중 가장 큰 기계 구하기
						if (board[bx][by].BC[j] > maxtmp) {
							maxtmp = board[bx][by].BC[j];
							maxcheck = j;
						}
					}
					if (bcheck == 0) { //a랑 b가 겹치지 않을때,
						case1 += maxtmp;
						case1 += atmp;
					}
					else if (bcheck != 0) { //겹칠 때
						int nextb = 0;
						if (maxcheck == acheck && maxtmp == atmp) { // 최대값이 같을때
							case2 += maxtmp;
							for (int j = 1; j <= A; j++) { //두번째로 큰 맥스값
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
				if (board[ax][ay].allcheck > 1 && board[bx][by].allcheck == 1) {//a는 기계 여러개, b는 기계 한개인 경우
					int acheck = 0, atmp = 0;
					int bcheck = 0, btmp = 0;
					int maxcheck = 0, maxtmp = 0;
					int case1 = 0, case2 = 0, case3=0, case4=0;
					for (int j = 1; j <= A; j++) { //B가 속한 기계 찾기
						if (board[bx][by].BC[j] != 0) {
							bcheck = j;
							btmp = board[bx][by].BC[j];
							break;
						}
					}
					for (int j = 1; j <= A; j++) { // B가 속한 기계가 A에도 속할 때
						if (btmp == board[ax][ay].BC[j] && bcheck==j) {
							acheck = j;
							atmp = board[ax][ay].BC[j];
						}
					}
					for (int j = 1; j <= A; j++) { // A중 가장 큰 기계 구하기
						if (board[ax][ay].BC[j] > maxtmp) {
							maxtmp = board[ax][ay].BC[j];
							maxcheck = j;
						}
					}
					if (acheck == 0) { //a랑 b가 겹치지 않을때,
						case1 += maxtmp;
						case1 += btmp;
					}
					else if (acheck != 0) { //겹칠 때
						int nexta = 0;
						if (maxcheck == bcheck && maxtmp == btmp) { // 최대값이 같을때
							case2 += maxtmp;
							for (int j = 1; j <= A; j++) { //두번째로 큰 맥스값
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
				if (board[ax][ay].allcheck > 1 && board[bx][by].allcheck > 1) { // 둘 다 여러개인 경우
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
					if (acheck == bcheck && atmp == btmp) { //둘의 최대 기계가 같은 경우
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
					else if (acheck != bcheck) { //둘의 최대 기계가 다른 경우
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