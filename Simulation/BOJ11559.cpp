/* BOJ 11559 Puyo Puyo*/

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

char board[15][8];
int check[15][8];

typedef struct { //뿌요 구조체
	int x;
	int y;
	char color;
}Node;

queue <Node> checkq; //터지는 뿌요가 몇개인지 체크하는 큐
queue <Node> q; //같은 색 뿌요를 탐색하기 위한 큐
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };

void bfs() { //뿌요를 탐색한다
	while (q.empty() == 0) {
		int xnow = q.front().x;
		int ynow = q.front().y;
		char nowcol = q.front().color;
		checkq.push({ xnow,ynow,nowcol }); //뿌요를 checkq에 집어넣어 나중에 몇개의 뿌요를 탐색했는지 개수파악
		check[xnow][ynow] = 1;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int xnext = xnow + dc[k];
			int ynext = ynow + dr[k];
			if (board[xnext][ynext] == nowcol && xnext >= 0 && xnext < 12 && ynext >= 0 && ynext < 6 && check[xnext][ynext] == 0) {
				Node point = { xnext,ynext,board[xnext][ynext]};
				q.push(point);
				check[xnext][ynext] = 1;
			}
		}
	}
}

void boardsort() { //한번의 연쇄작용이 끝난 후 뿌요들 재정렬
	for (int i = 0; i < 6; i++) {
		for (int j = 11; j > 0; j--) {
			if (board[j][i] == '.') {
				for (int k = j - 1; k >= 0; k--) {
					if (board[k][i] != '.') {
						board[j][i] = board[k][i];
						board[k][i] = '.';
						break;
					}
				}
			}
		}
	}
}
int main() {
	for (int i = 0; i < 12; i++) {
		scanf("%s", &board[i]);
	}
	int cnt = 0;
	int checkbomb = 1;
	while (checkbomb != 0) { //checkbomb는 4개이상의 뿌요가 터질때 올려주는 변수
		checkbomb = 0;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] == '.') continue;
				else {
					if (check[i][j] == 0) {
						Node point = { i,j,board[i][j] }; //뿌요하나를 탐색하기 위해 정보입력
						q.push(point); //뿌요 탐색을 위해 q에 푸쉬
						bfs();
						if (checkq.size() < 4) { //checkq의 사이즈가 4보다 작을땐 어떠한 변화도 없다
							while (checkq.empty() == 0) checkq.pop(); //pop만 하면됨
						}
						else if (checkq.size() >= 4) { //4보다 클땐 checkbomb 올려줘서 4개이상 뿌요가 터졋다는 걸 표시
							checkbomb++;
							while (checkq.empty() == 0) {// checkq를 비우면서 보드판도 . 으로 바꿔준다
								int nowx = checkq.front().x;
								int nowy = checkq.front().y;
								board[nowx][nowy] = '.'; 
								checkq.pop();
							}
						}
					}
				}
			}
		}
		if (checkbomb > 0) cnt++; // 4개이상의 뿌요가 터진 경우가 존재할때 연쇄폭발 한번 증가
		boardsort(); 
		memset(check, 0, sizeof(check));
	}
	printf("%d\n", cnt);
	return 0;
}