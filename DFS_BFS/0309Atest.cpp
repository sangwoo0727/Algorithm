#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int N;
int board[18][18];
int cnt;
queue <pair <int, int>> tail; //버스의 뒤꽁무니
queue < pair <int, int>> head; //버스의 앞꽁무니

void bfs() {
	if (board[0][0] == 0 && board[0][1] == 0) { //버스가 오른쪽으로 출발할 수 있을 때
		tail.push({ 0,0 });
		head.push({ 0,1 });
	}
	if (board[0][0] == 0 && board[1][0] == 0) { //버스가 아래쪽으로 출발 할 수 있을 때
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
		if (hx==N-1 && hy== N-1 && tx==hx-1 && ty==hy) cnt++; //도착지점에 대해 대각선방향이 아닐때만 카운트 올린다.
		if (hx == N - 1 && hy == N - 1 && tx == hx && ty == hy - 1) cnt++;

		if (hx == tx + 1 && hy == ty) { //버스가 아래 방향을 향해 있을 때
			if (hx + 1 < N&& board[hx + 1][hy] == 0) { //아래로 갈 수있을 경우
				tail.push({ tx + 1,ty });
				head.push({ hx + 1,hy });
			}
			if (hx + 1 < N&&hy + 1 < N&&board[hx + 1][hy] == 0 && board[hx + 1][hy + 1] == 0 && board[hx][hy + 1] == 0) { //버스가 대각선으로 갈 수 있을경우
				tail.push({ tx + 1,ty });
				head.push({ hx + 1,hy + 1 });
			}
		}
		else if (hx == tx + 1 && hy == ty + 1) { //버스가 대각선 방향을 향해 있을 때
			if (hy + 1 < N&&board[hx][hy + 1]==0) { //오른쪽으로 진행할 수 있는 경우
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx,hy + 1 });
			}
			if (hx + 1 < N&&hy + 1 < N&&board[hx + 1][hy + 1] == 0) { //대각선으로 진행할 수 있는 경우
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx + 1,hy + 1 });
			}
			if (hx + 1 < N&&board[hx + 1][hy] == 0) { //아래쪽으로 진행할 수 있는 경우
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx + 1,hy });
			}
		}
		else if (hx == tx && hy == ty + 1) { //버스가 오른쪽 방향을 향해 있을 때
			if (hy + 1 < N&&board[hx][hy + 1] == 0) { //오른쪽으로 진행할 수 있는 경우
				tail.push({ tx,ty + 1 });
				head.push({ hx,hy + 1 });
			}
			if (hy + 1 < N&&hx + 1 < N&&board[hx + 1][hy + 1] == 0 && board[hx][hy + 1] == 0 && board[hx + 1][hy] == 0) { //대각선으로 진행할 수 있는 경우
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