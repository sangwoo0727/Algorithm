/*BOJ 17070 파이프옮기기 1
모든 조건을 찾아서 풀면되는데, 이 문제는 경우의 수를 다 알려줘서 쉬웠다
삼성 SW 테스트와 같은 문제지만 이 문제 난이도가 더 쉬운 문제.
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
	tail.push({ 1, 1 }); //시작하는 좌표는 (1,1) (1,2)에서만 출발
	head.push({ 1, 2 });
	while (tail.empty() == 0 && head.empty() == 0) { 
		int tx = tail.front().first;
		int ty = tail.front().second;
		int hx = head.front().first;
		int hy = head.front().second;
		head.pop();
		tail.pop();
		if (hx == N && hy == N) cnt++; //파이프 앞부분이 도착지점에 도착하면 카운트++
		if (hx == tx + 1 && hy == ty) {  //파이프가 아래를 향해 있을 때
			if (hx + 1 <= N&& board[hx + 1][hy] == 0) { //다음파이프가 아래로 갈 경우
				tail.push({ tx + 1,ty });
				head.push({ hx + 1,hy });
			}
			if (hx + 1 <= N&&hy + 1 <= N&&board[hx + 1][hy] == 0 && board[hx + 1][hy + 1] == 0 && board[hx][hy + 1] == 0) { 
				//다음 파이프가 대각선을 향하는 경우
				head.push({ hx + 1,hy + 1 });
			}
		}
		else if (hx == tx + 1 && hy == ty + 1) {  //파이프가 대각선을 향해 있을 때
			if (hy + 1 <= N&&board[hx][hy + 1] == 0) { //다음 파이프가 오른쪽으로 갈 경우
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx,hy + 1 });
			}
			if (hx + 1 <= N&&hy + 1 <= N&&board[hx + 1][hy + 1] == 0&&board[hx+1][hy]==0&&board[hx][hy+1]==0) { 
				//다음 파이프가 대각선으로 갈 경우
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx + 1,hy + 1 });
			}
			if (hx + 1 <= N&&board[hx + 1][hy] == 0) { //다음 파이프가 왼쪽으로 갈 경우
				tail.push({ tx + 1,ty + 1 });
				head.push({ hx + 1,hy });
			}
		}
		else if (hx == tx && hy == ty + 1) { //파이프가 오른쪽을 향해 있을 때
			if (hy + 1 <= N&&board[hx][hy + 1] == 0) { //다음 파이프가 오른쪽으로 갈 경우
				tail.push({ tx,ty + 1 });
				head.push({ hx,hy + 1 });
			}
			if (hy + 1 <= N&&hx + 1 <= N&&board[hx + 1][hy + 1] == 0 && board[hx][hy + 1] == 0 && board[hx + 1][hy] == 0) { 
				//다음 파이프가 대각선으로 갈 경우
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