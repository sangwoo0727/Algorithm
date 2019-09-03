#include <iostream>
#include <queue>
#include <utility>
using namespace std;

typedef struct {
	int apple;
	int dir;
	int check;
}Board;

typedef struct {
	int r;
	int c;
}snake_info;

Board board[102][102];
queue <pair<int, char>> q;
int dr[4] = { 0,1,0,-1 };
int dc[4] = { 1,0,-1,0 };
snake_info head;
snake_info tail;
int N;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	int K;
	cin >> K;
	while(K--){
		int r, c;
		cin >> r >> c;
		board[r][c].apple = 1;
	}
	int L;
	cin >> L;
	while (L--) {
		int t;
		char c;
		cin >> t >> c;
		q.push(make_pair(t, c));
	}
	int t = 0;
	board[1][1].apple = board[1][1].dir = 0;
	board[1][1].check = 1;
	tail.r = tail.c = head.r = head.c = 1;
	while (++t) {
		int rnext = head.r + dr[board[head.r][head.c].dir];
		int cnext = head.c + dc[board[head.r][head.c].dir];
		board[rnext][cnext].dir = board[head.r][head.c].dir;
		if (board[rnext][cnext].check == 1) break;
		board[rnext][cnext].check = 1;
		if (rnext < 1 || rnext> N || cnext < 1 || cnext > N) break;
		if (board[rnext][cnext].apple == 0) {
			head.r = rnext;
			head.c = cnext;
			int idx = board[tail.r][tail.c].dir;
			board[tail.r][tail.c].check = 0;
			tail.r = tail.r + dr[idx];
			tail.c = tail.c + dc[idx];
		}
		if(board[rnext][cnext].apple != 0){
			board[rnext][cnext].apple = 0;
			head.r = rnext;
			head.c = cnext;
		}
		if (!q.empty()) {
			if (q.front().first == t) {
				if (q.front().second == 'D') {
					if (board[head.r][head.c].dir == 3) board[head.r][head.c].dir = 0;
					else board[head.r][head.c].dir++;
					q.pop();
				}
				else {
					if (board[head.r][head.c].dir == 0) board[head.r][head.c].dir = 3;
					else board[head.r][head.c].dir--;
					q.pop();
				}
			}
		}
	}
	cout << t;
	return 0;
}