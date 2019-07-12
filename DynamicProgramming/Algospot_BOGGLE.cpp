#include <iostream>
#include <string>
#include <cstring>
using namespace std;

string s[10];
char board[5][5];
int check[5][5][10];
int len[10];
int dr[8] = { 0,1,1,1,0,-1,-1,-1 };
int dc[8] = { -1,-1,0,1,1,1,0,-1 };

int dfs(int i, int j, int pos, int n) {
	if (pos == len[n]-1) {
		check[i][j][pos] = 1;
		return 1;
	}
	for (int k = 0; k < 8; k++) {
		int xnow = i + dr[k];
		int ynow = j + dc[k];
		if (xnow < 0 || xnow >= 5 || ynow < 0 || ynow >= 5) continue;
		else if (board[xnow][ynow] == s[n][pos + 1]) {
			if (check[xnow][ynow][pos + 1] == 1) {
				return 1;
			}
			else if (check[xnow][ynow][pos + 1] == 0) {
				continue;
			}
			else {
				check[xnow][ynow][pos+1] = dfs(xnow, ynow, pos + 1, n);
				if (check[xnow][ynow][pos + 1] == 1) return 1;
			}
		}
	}
	return 0;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int C;
	cin >> C;
	for (int c = 1; c <= C; c++) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cin >> board[i][j];
			}
		}
		int N;
		cin >> N;
		for (int i = 0; i < N; i++) {
			cin >> s[i];
			len[i] = s[i].length();
		}
		for (int n = 0; n < N; n++) {
			int result = 0;
			memset(check, -1, sizeof(check));
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == s[n][0]) {
						result = dfs(i, j, 0, n);
						if (result == 1) break;
					}
				}
				if (result == 1) break;
			}
			cout << s[n];
			if (result == 1) cout << " YES" << '\n';
			else if (result == 0) cout << " NO" << '\n';
		}
	}
	return 0;
}