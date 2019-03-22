/* BOJ 14503 로봇 청소기
시뮬레이션인데 걍 쌩구현..
세시간 반이 걸렸다는게 문제다 시간을 단축해야될 듯
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
		int dir_now = di.front(); //기준 방향
		int dir_sim = di.front(); //탐색 방향
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
			if (board[ynext][xnext] == 0 && ynext >= 0 && ynext < N && xnext >= 0 && xnext < M) { //탐색시작 방향으로 들어갈 수 있을때
				board[ynext][xnext] = 2;
				q.push({ ynext,xnext });
				di.push(dir_sim);
				break;
			}
			if (i<3 && board[ynext][xnext] != 0 && ynext >= 0 && ynext < N&&xnext >= 0 && xnext < M) { //탐색 시작방향이 들어갈 수 없을때
				continue;
			}
			if (i == 3 && board[ynext][xnext] != 0 && ynext >= 0 && ynext < N && xnext >= 0 && xnext < M) { //4방향중 마지막 방향을 볼때 들어갈 수 없는 경우
				int back_y = ynow + back_r[dir_now];
				int back_x = xnow + back_c[dir_now];
				if (board[back_y][back_x] == 1 && back_y >= 0 && back_y < N && back_x >= 0 && back_x < M) return; //후진할때 벽이면 리턴
				else if (board[back_y][back_x] != 1 && back_y >= 0 && back_y < N && back_x >= 0 && back_x < M) { //벽이 아니면 들어가센 
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