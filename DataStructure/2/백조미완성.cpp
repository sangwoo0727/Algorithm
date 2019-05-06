#include <iostream>
#include <queue>
#include <cstring>
#include <utility>
using namespace std;

char board[1505][1505];
int check[1505][1505];
int check2[1505][1505];
int r, c;
int start_x = 100000, start_y = 100000;
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
queue < pair <int, int>> q;
queue <pair<int, int>> plat_next;
queue <pair<int, int>> plat_q;
queue <int> level;


void ice_break() {  //얼음깨는 bfs
	int cnt = level.front();
	while (q.empty() == 0) {
		int xnow = q.front().first;
		int ynow = q.front().second;
		int compa = level.front();
		if (cnt != compa) return;
		q.pop();
		level.pop();
		for (int k = 0; k < 4; k++) {
			int xnext = xnow + dx[k];
			int ynext = ynow + dy[k];
			if (xnext < 0 || xnext >= r || ynext < 0 || ynext >= c || check[xnext][ynext] == 1 || board[xnext][ynext] != 'X') continue;
			if (xnext >= 0 && xnext < r&&ynext >= 0 && ynext < c&& check[xnext][ynext] == 0 && board[xnext][ynext] == 'X') {
				board[xnext][ynext] = '.';
				check[xnext][ynext] = 1;
				q.push({ xnext,ynext });
				level.push(compa + 1);
			}
		}
	}
}

int plat1_bfs() {
	while (plat_q.empty() == 0) {
		int xnow = plat_q.front().first;
		int ynow = plat_q.front().second;
		plat_q.pop();
		if (board[xnow][ynow] == 'L'&& xnow != x && ynow != y) return 1;
		for (int k = 0; k < 4; k++) {
			int xnext = xnow + dx[k];
			int ynext = ynow + dy[k];
			if (xnext >= 0 && xnext < r&&ynext >= 0 && ynext < c&&check2[xnext][ynext] == 0 && (board[xnext][ynext] == '.' || board[xnext][ynext] == 'L')) {
				plat_next.push({ xnext,ynext });
				check2[xnext][ynext] = 1;
			}
		}
	}
	return 0;
}


int plat2_bfs() { //백조 만나는지 확인하는 bfs

}

int main() {
	scanf("%d%d", &r, &c);
	for (int i = 0; i < r; i++) {
		scanf("%s", &board[i]);
	}
	for (int i = 0; i < r; i++) {  //백조 시작위치 하나 잡기
		for (int j = 0; j < c; j++) {
			if (board[i][j] == 'L') {
				plat_q.push({ i,j });
				break;
			}
		}
		if (plat_q.empty() == 0) break;
	}

	for (int i = 0; i < r; i++) {  // 호수 좌표들 푸쉬
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 4; k++) {
				int x = i + dx[k];
				int y = j + dy[k];
				if (board[i][j] == '.' && (board[x][y] == 'X' || board[x][y] == 'L')) {
					q.push({ i,j });
					level.push(0);
					check[i][j] = 1;
					break;
				}
			}
		}
	}
	int cnt = 0;

	while (1) {
		int result;
		if(plat_q.empty()==0) result = plat1_bfs(); //리턴값 1일 경우 만난 거라 무한루프 탈출, 0이면 못만낫으니 cnt올려놓고 반복
		else if (plat_next.empty() == 0) result = plat2_bfs();
		memset(check2, 0, sizeof(check2));
		if (result == 1) break;
		if (result == 0) cnt++; // 얼음깨기 1단계 올렸다는거 표시
		ice_break(); //얼음깨기
	}
	printf("%d", cnt);
	return 0;
}