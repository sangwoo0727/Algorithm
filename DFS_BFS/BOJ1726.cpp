#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

typedef struct {
	int m;
	int n;
	int dir;
	int cnt;
}Queue;

int N, M;
int board[101][101];
int min_check[101][101];
int dc[4] = { 0,0,1,-1 };
int dr[4] = { 1,-1,0,0 };
int endm, endn, endd;
int ans = 1000000000;
queue <Queue> q;

void bfs() {
	while (!q.empty()) {
		int m = q.front().m;
		int n = q.front().n;
		int dir = q.front().dir;
		int cnt = q.front().cnt;
		if (m == endm && n == endn) {
			if (dir == endd) {
				ans = min(ans, cnt);
			}
			else {
				if ((dir == 1 && endd == 2) || (dir == 2 && endd == 1) || (dir == 3 && endd == 4) || (dir == 4 && endd == 3)) {
					ans = min(ans, cnt + 2);
				}
				else {
					ans = min(ans, cnt + 1);
				}
			}
		}
		q.pop();
		for (int d = 0; d < 4; d++) {
			for (int k = 1; k <= 3; k++) {
				int mnext = m + k * dc[d];
				int nnext = n + k * dr[d];
				if (mnext < 1 || mnext > M || nnext < 1 || nnext > N) break;
				else if (board[mnext][nnext] == 1) break;
				else {
					if(dir!=d+1){
						if ((dir == 1 && d+1 == 2) || (dir == 2 && d+1 == 1) || (dir == 3 && d+1 == 4) || (dir == 4 && d+1 == 3)) {
							if (min_check[mnext][nnext] == 0 || min_check[mnext][nnext] > cnt + 3) {
								min_check[mnext][nnext] = cnt + 3;
								q.push({ mnext,nnext,d+1,cnt + 3 });
							}
						}
						else {
							if (min_check[mnext][nnext] == 0 || min_check[mnext][nnext] > cnt + 2) {
								min_check[mnext][nnext] = cnt + 2;
								q.push({ mnext,nnext,d+1,cnt + 2 });
							}
						}
					}
					else {
						if (min_check[mnext][nnext] == 0 || min_check[mnext][nnext] > cnt + 1) {
							min_check[mnext][nnext] = cnt + 1;
							q.push({ mnext,nnext,d+1,cnt + 1 });
						}
					}
				}
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> M >> N;
	for (int m = 1; m <= M; m++) {
		for (int n = 1; n <= N; n++) {
			cin >> board[m][n];
		}
	}
	int startm, startn, startd;
	cin >> startm >> startn >> startd;
	cin >> endm >> endn >> endd;
	q.push({ startm,startn,startd,0});
	min_check[startm][startn] = q.front().cnt;
	bfs();
	cout << ans << '\n';
	return 0;
}