/*SW 4012 요리사
재귀로 선택할 번호 반개 선택하고
선택된 숫자들 과 선택안된 숫자들을 각각 합해서 최소를 구해나가는 풀이
재귀는 항상 너무 어렵다.. */

#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;

int board[20][20];
int check[20];
int N;
int Min = 100000000;
int result;
void food_maker(int idx, int size) {
	if(idx>0) check[idx] = 1;
	int ansA=0 , ansB = 0;
	if (size == N / 2) { //재귀가 끝났을 땐 연산 수행
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (check[i] != 0 && check[j] != 0) ansA += board[i][j];
				if (check[i] == 0 && check[j] == 0) ansB += board[i][j];
			}
		}
		result = abs(ansA - ansB);
		Min = min(Min, result);
	}
	else { //재귀를 계속 한다
		for (int i = idx; i <= N; i++) {
			food_maker(i+1, size + 1);
			check[i+1] = 0;
		}
	}
}
int main() {
	int T;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d", &N);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				scanf("%d", &board[i][j]);
			}
		}
		food_maker(0, 0);
		printf("#%d %d\n",t, Min);
		Min = 1000000000;
		memset(check, 0, sizeof(check));
		memset(board, 0, sizeof(board));
	}
	return 0;
}