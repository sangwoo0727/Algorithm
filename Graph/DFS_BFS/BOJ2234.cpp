#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;
typedef pair<int, int> p;

typedef struct {
	int num;
	int room; // 방의 번호
}board_info;

board_info board[51][51];
vector <int> v;
queue <p> q;
int check[51][51];
int n, m;
int roomnum;
int cnt;
int sum_MAX;
int cnt_MAX;
int dc[4] = { 0,-1,0,1 };
int dr[4] = { -1,0,1,0 };

void bfs(int i, int j) {
	q.push(make_pair(i, j));
	while (!q.empty()) {
		int xnow = q.front().first;
		int ynow = q.front().second;
		board[xnow][ynow].room = roomnum;
		cnt++;
		q.pop();
		for (int k = 0; k < 4; k++) {
			if (board[xnow][ynow].num % 2 == 0 ) {
				int xnext = xnow + dc[k];
				int ynext = ynow + dr[k];
				if (board[xnext][ynext].room == 0) {
					q.push(make_pair(xnext, ynext));
					board[xnext][ynext].room = roomnum;
				}
			}
			board[xnow][ynow].num = board[xnow][ynow].num / 2;
		}
	}
}
void sum_BFS(int i, int j) {
	q.push(make_pair(i, j));
	while (!q.empty()) {
		int xnow = q.front().first;
		int ynow = q.front().second;
		check[xnow][ynow] = 1;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int xnext = xnow + dc[k];
			int ynext = ynow + dr[k];
			if (xnext < 0 || xnext >= m || ynext < 0 || ynext >= n || check[xnext][ynext]!=0) continue;
			else if (board[xnow][ynow].room != board[xnext][ynext].room) {
				sum_MAX = max(sum_MAX, v[board[xnow][ynow].room - 1] + v[board[xnext][ynext].room - 1]);
			}
			q.push(make_pair(xnext, ynext));
			check[xnext][ynext] = 1;
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> board[i][j].num;
		}
	}
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (board[i][j].room == 0) {
				roomnum++;
				bfs(i, j);
				cnt_MAX = max(cnt_MAX, cnt);
				v.push_back(cnt);
				cnt = 0;
			}
		}
	}
	sum_BFS(0, 0);
	v.clear();
	cout << roomnum << '\n';
	cout << cnt_MAX << '\n';
	cout << sum_MAX << '\n';
	return 0;
}
