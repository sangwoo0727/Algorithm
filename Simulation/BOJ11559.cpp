/* BOJ 11559 Puyo Puyo*/

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

char board[15][8];
int check[15][8];

typedef struct { //�ѿ� ����ü
	int x;
	int y;
	char color;
}Node;

queue <Node> checkq; //������ �ѿ䰡 ����� üũ�ϴ� ť
queue <Node> q; //���� �� �ѿ並 Ž���ϱ� ���� ť
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };

void bfs() { //�ѿ並 Ž���Ѵ�
	while (q.empty() == 0) {
		int xnow = q.front().x;
		int ynow = q.front().y;
		char nowcol = q.front().color;
		checkq.push({ xnow,ynow,nowcol }); //�ѿ並 checkq�� ����־� ���߿� ��� �ѿ並 Ž���ߴ��� �����ľ�
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

void boardsort() { //�ѹ��� �����ۿ��� ���� �� �ѿ�� ������
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
	while (checkbomb != 0) { //checkbomb�� 4���̻��� �ѿ䰡 ������ �÷��ִ� ����
		checkbomb = 0;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] == '.') continue;
				else {
					if (check[i][j] == 0) {
						Node point = { i,j,board[i][j] }; //�ѿ��ϳ��� Ž���ϱ� ���� �����Է�
						q.push(point); //�ѿ� Ž���� ���� q�� Ǫ��
						bfs();
						if (checkq.size() < 4) { //checkq�� ����� 4���� ������ ��� ��ȭ�� ����
							while (checkq.empty() == 0) checkq.pop(); //pop�� �ϸ��
						}
						else if (checkq.size() >= 4) { //4���� Ŭ�� checkbomb �÷��༭ 4���̻� �ѿ䰡 �͠��ٴ� �� ǥ��
							checkbomb++;
							while (checkq.empty() == 0) {// checkq�� ���鼭 �����ǵ� . ���� �ٲ��ش�
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
		if (checkbomb > 0) cnt++; // 4���̻��� �ѿ䰡 ���� ��찡 �����Ҷ� �������� �ѹ� ����
		boardsort(); 
		memset(check, 0, sizeof(check));
	}
	printf("%d\n", cnt);
	return 0;
}