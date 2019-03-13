#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int N;
int board[18][18];
int cnt;
queue <pair <int, int>> tail; //������ �ڲǹ���
queue < pair <int, int>> head; //������ �ղǹ���

void bfs() {
	if (board[0][0] == 0 && board[0][1] == 0) { //������ ���������� ����� �� ���� ��
		tail.push({ 0,0 });
		head.push({ 0,1 });
	}
	if (board[0][0] == 0 && board[1][0] == 0) { //������ �Ʒ������� ��� �� �� ���� ��
		tail.push({ 0,0 });
		head.push({ 1,0 });
	}
	while (tail.empty() == 0 && head.empty()==0) {
		int tx = tail.front().first;
		int ty = tail.front().second;
		int hx = head.front().first;
		int hy = head.front().second;
		head.pop();
		tail.pop();
		if (hx==N-1 && hy== N-1 && tx==hx-1 && ty==hy) cnt++; //���������� ���� �밢�������� �ƴҶ��� ī��Ʈ �ø���.
		if (hx == N - 1 && hy == N - 1 && tx == hx && ty == hy - 1) cnt++;

		if (hx == tx + 1 && hy == ty) { //������ �Ʒ� ������ ���� ���� ��
			if (hx + 1 < N&& board[hx + 1][hy] == 0) { //�Ʒ��� �� ������ ���
				tail.push({ tx + 1,ty });
				head.push({ hx + 1,hy });
			}
			if (hx + 1 < N&&hy + 1 < N&&board[hx + 1][hy] == 0 && board[hx + 1][hy + 1] == 0 && board[hx][hy + 1] == 0) { //������ �밢������ �� �� �������
				tail.push({ tx + 1,ty });
				head.push({ hx + 1,hy + 1 });
			}
		}
		else if (hx == tx + 1 && hy == ty + 1) { //������ �밢�� ������ ���� ���� ��
			if (hy + 1 < N&&board[hx][hy + 1]==0) { //���������� ������ �� �ִ� ���
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx,hy + 1 });
			}
			if (hx + 1 < N&&hy + 1 < N&&board[hx + 1][hy + 1] == 0) { //�밢������ ������ �� �ִ� ���
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx + 1,hy + 1 });
			}
			if (hx + 1 < N&&board[hx + 1][hy] == 0) { //�Ʒ������� ������ �� �ִ� ���
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx + 1,hy });
			}
		}
		else if (hx == tx && hy == ty + 1) { //������ ������ ������ ���� ���� ��
			if (hy + 1 < N&&board[hx][hy + 1] == 0) { //���������� ������ �� �ִ� ���
				tail.push({ tx,ty + 1 });
				head.push({ hx,hy + 1 });
			}
			if (hy + 1 < N&&hx + 1 < N&&board[hx + 1][hy + 1] == 0 && board[hx][hy + 1] == 0 && board[hx + 1][hy] == 0) { //�밢������ ������ �� �ִ� ���
				tail.push({ tx,ty + 1 });
				head.push({ hx + 1,hy + 1 });
			}
		}
	}
}
int main() {
	int T;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d", &N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				scanf("%d", &board[i][j]);
			}
		}
		bfs();
		printf("%d\n", cnt);
		cnt = 0;
	}
	return 0;
}