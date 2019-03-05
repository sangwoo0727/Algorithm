/*14499 주사위 굴리기
이 문제는 시뮬레이션 문제로서, 주사위의 전개도가 주어지고,
지도의 동서남북을 한칸씩 주사위가 굴러가면서
조건대로 구현하는 문제다.
https://www.acmicpc.net/problem/14499
*/
#include <iostream>
using namespace std;

int dice[7];
int board[25][25];
int N, M;
int dr[4] = {0,0,-1,1};
int dc[4] = {1,-1,0,0};
int x, y, k;
int main() {
	scanf("%d%d%d%d%d", &N, &M, &x, &y, &k);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	while (k--) {
		int num;
		scanf("%d", &num);
		num = num - 1;
		int nx = x + dr[num];
		int ny = y + dc[num];
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
		if (num == 0) { //동쪽
			int tmp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
		}
		else if (num == 1) { //서쪽
			int tmp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
		}
		else if (num == 2) { //북쪽
			int tmp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
		}
		else if (num == 3) { //남쪽
			int tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
		}
		x = nx;
		y = ny;
		if (board[x][y] == 0) { //조건1
			board[x][y] = dice[6];
		}
		else if (board[x][y] != 0) { //조건2
			dice[6] = board[x][y];
			board[x][y] = 0;
		}
		printf("%d\n", dice[1]);
	}
	return 0;
}