#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

typedef struct {
	int h;
	int w;
	int cnt;
}moving;

int W, H;
int check[1005][1005];
int scheck[1005][1005];
char board[1005][1005];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { -1,1,0,0 };

void fbfs(queue <moving> &fq) {
	int tmp = fq.front().cnt;
	check[fq.front().h][fq.front().w] = 1;
	while (!fq.empty()) {
		int h = fq.front().h;
		int w = fq.front().w;
		int cnt = fq.front().cnt;
		if (cnt != tmp) break;
		fq.pop();
		for (int k = 0; k < 4; k++) {
			int wnext = w + dc[k];
			int hnext = h + dr[k];
			if (wnext < 0 || wnext >= W || hnext < 0 || hnext >= H) continue;
			if (board[hnext][wnext] == '#' || check[hnext][wnext] == 1 || board[hnext][wnext] == '*') continue;
			if (board[hnext][wnext] == '.' && check[hnext][wnext] == 0) {
				fq.push({ hnext,wnext,cnt + 1 });
				check[hnext][wnext] = 1;
				board[hnext][wnext] = '*';
			}
		}

	}
}

int sbfs(queue <moving> &sq) {
	int move = sq.front().cnt;
	scheck[sq.front().h][sq.front().w] = 1;
	while (!sq.empty()) {
		int w = sq.front().w;
		int h = sq.front().h;
		int cnt = sq.front().cnt;
		if (move != cnt) return 0;
		sq.pop();
		for (int k = 0; k < 4; k++) {
			int hnext = h + dc[k];
			int wnext = w + dr[k];
			if (hnext >= 0 && hnext < H && wnext >= 0 && wnext < W) {
				if (scheck[hnext][wnext] == 1 || board[hnext][wnext] == '#' || board[hnext][wnext] == '*') {
					continue;
				}
				else if (scheck[hnext][wnext] == 0 && board[hnext][wnext] == '.') {
					sq.push({ hnext,wnext,cnt + 1 });
					scheck[hnext][wnext] = 1;
				}
			}
			else if ((board[h][w] == '.' || board[h][w] == '*') && ((hnext < 0 || hnext >= H) || (wnext < 0 || wnext >= W)))
				return cnt + 1;
		}
	}
	return 0;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int T;
	cin >> T;
	for (int t = 0; t < T; t++) {
		queue <moving> fq;
		queue <moving> sq;
		int ans = 0;
		memset(check, 0, sizeof(check));
		memset(scheck, 0, sizeof(scheck));
		cin >> W >> H;
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				cin >> board[h][w];
				if (board[h][w] == '*') {
					fq.push({ h,w,0 });
				}
				if (board[h][w] == '@') {
					sq.push({ h,w,0 });
					board[h][w] = '.';
				}
			}
		}
		while (1) {
			if (fq.empty() && sq.empty()) {
				cout << "IMPOSSIBLE" << '\n';
				break;
			}
			if(!fq.empty())fbfs(fq);
			if (!sq.empty())ans = sbfs(sq);
			if (ans > 0) {
				cout << ans << '\n';
				break;
			}
		}
	}
	return 0;
}