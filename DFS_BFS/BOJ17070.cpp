/*BOJ 17070 �������ű�� 1
��� ������ ã�Ƽ� Ǯ��Ǵµ�, �� ������ ����� ���� �� �˷��༭ ������
�Ｚ SW �׽�Ʈ�� ���� �������� �� ���� ���̵��� �� ���� ����.
https://www.acmicpc.net/problem/17070
*/

#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int N;
int board[18][18];
int cnt;
queue <pair <int, int>> tail; 
queue < pair <int, int>> head; 

void bfs() {
	tail.push({ 1, 1 }); //�����ϴ� ��ǥ�� (1,1) (1,2)������ ���
	head.push({ 1, 2 });
	while (tail.empty() == 0 && head.empty() == 0) { 
		int tx = tail.front().first;
		int ty = tail.front().second;
		int hx = head.front().first;
		int hy = head.front().second;
		head.pop();
		tail.pop();
		if (hx == N && hy == N) cnt++; //������ �պκ��� ���������� �����ϸ� ī��Ʈ++
		if (hx == tx + 1 && hy == ty) {  //�������� �Ʒ��� ���� ���� ��
			if (hx + 1 <= N&& board[hx + 1][hy] == 0) { //������������ �Ʒ��� �� ���
				tail.push({ tx + 1,ty });
				head.push({ hx + 1,hy });
			}
			if (hx + 1 <= N&&hy + 1 <= N&&board[hx + 1][hy] == 0 && board[hx + 1][hy + 1] == 0 && board[hx][hy + 1] == 0) { 
				//���� �������� �밢���� ���ϴ� ���
				head.push({ hx + 1,hy + 1 });
			}
		}
		else if (hx == tx + 1 && hy == ty + 1) {  //�������� �밢���� ���� ���� ��
			if (hy + 1 <= N&&board[hx][hy + 1] == 0) { //���� �������� ���������� �� ���
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx,hy + 1 });
			}
			if (hx + 1 <= N&&hy + 1 <= N&&board[hx + 1][hy + 1] == 0&&board[hx+1][hy]==0&&board[hx][hy+1]==0) { 
				//���� �������� �밢������ �� ���
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx + 1,hy + 1 });
			}
			if (hx + 1 <= N&&board[hx + 1][hy] == 0) { //���� �������� �������� �� ���
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx + 1,hy });
			}
		}
		else if (hx == tx && hy == ty + 1) { //�������� �������� ���� ���� ��
			if (hy + 1 <= N&&board[hx][hy + 1] == 0) { //���� �������� ���������� �� ���
				tail.push({ tx,ty + 1 });
				head.push({ hx,hy + 1 });
			}
			if (hy + 1 <= N&&hx + 1 <= N&&board[hx + 1][hy + 1] == 0 && board[hx][hy + 1] == 0 && board[hx + 1][hy] == 0) { 
				//���� �������� �밢������ �� ���
				tail.push({ tx,ty + 1 });
				head.push({ hx + 1,hy + 1 });
			}
		}
	}
}
int main() {
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	bfs();
	printf("%d\n", cnt);
	return 0;
}