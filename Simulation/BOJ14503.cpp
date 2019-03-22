/* BOJ 14503 �κ� û�ұ�
�ùķ��̼��ε� �� �߱���..
���ð� ���� �ɷȴٴ°� ������ �ð��� �����ؾߵ� ��
https://www.acmicpc.net/problem/14503
*/

#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int board[55][55];
int N, M, r, c, d;
queue <pair <int, int >> q;
queue <int> di;
int dr[4] = { -1,0,1,0 };
int dc[4] = { 0,1,0,-1 };
int back_r[4] = { 1,0,-1,0 };
int back_c[4] = { 0,-1,0,1 };

void robot_cleaner(int y, int x, int dir) {
	board[y][x] = 2;
	q.push({ y,x });
	di.push(dir);
	while (q.empty() == 0) {
		int ynow = q.front().first;
		int xnow = q.front().second;
		int dir_now = di.front(); //���� ����
		int dir_sim = di.front(); //Ž�� ����
		q.pop();
		di.pop();
		for (int i = 0; i < 4; i++) {
			int ynext, xnext;
			if (dir_sim == 0) {
				ynext = ynow + dr[dir_sim + 3];
				xnext = xnow + dc[dir_sim + 3];
				dir_sim += 3;
			}
			else {
				ynext = ynow + dr[dir_sim - 1];
				xnext = xnow + dc[dir_sim - 1];
				dir_sim -= 1;
			}
			if (ynext < 0 || ynext >= N || xnext < 0 || xnext >= M) continue;
			if (board[ynext][xnext] == 0 && ynext >= 0 && ynext < N && xnext >= 0 && xnext < M) { //Ž������ �������� �� �� ������
				board[ynext][xnext] = 2;
				q.push({ ynext,xnext });
				di.push(dir_sim);
				break;
			}
			if (i<3 && board[ynext][xnext] != 0 && ynext >= 0 && ynext < N&&xnext >= 0 && xnext < M) { //Ž�� ���۹����� �� �� ������
				continue;
			}
			if (i == 3 && board[ynext][xnext] != 0 && ynext >= 0 && ynext < N && xnext >= 0 && xnext < M) { //4������ ������ ������ ���� �� �� ���� ���
				int back_y = ynow + back_r[dir_now];
				int back_x = xnow + back_c[dir_now];
				if (board[back_y][back_x] == 1 && back_y >= 0 && back_y < N && back_x >= 0 && back_x < M) return; //�����Ҷ� ���̸� ����
				else if (board[back_y][back_x] != 1 && back_y >= 0 && back_y < N && back_x >= 0 && back_x < M) { //���� �ƴϸ� ���� 
					q.push({ back_y,back_x });
					di.push(dir_now);
					break;
				}
			}
		}
	}
}

int main() {
	scanf("%d%d", &N, &M);
	scanf("%d%d%d", &r, &c, &d);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	robot_cleaner(r, c, d);
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 2) cnt++;
		}
	}
	printf("%d", cnt);
	return 0;
}