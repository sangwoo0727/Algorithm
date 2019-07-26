#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int check[16];
int board[16];
int moving[10][5] = { {0,1,2,-1,-1},{3,7,9,11,-1},{4,10,14,15,-1},{0,4,5,6,7},{6,7,8,10,12},
					{0,2,14,15,-1},{3,14,15,-1,-1},{4,5,7,14,15},{1,2,3,4,5},{3,4,5,9,13} };
int Min= 1000000000;
int movcnt[10];

void dfs(int swit, int cnt) {
	if (cnt >= Min) return;
	for (int i = 0; i < 16; i++) {
		if (check[i] % 4 != 0) break;
		else if (i < 15 && check[i] % 4 == 0) continue;
		else if (i == 15 && check[i] % 4 == 0) {
			Min = min(Min, cnt);
			return;
		}
	}
	if (swit > 9) return;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 5; j++) {
			if (moving[swit][j] != -1) {
				check[moving[swit][j]] +=i;
			}
		}
		dfs(swit + 1, cnt + i);
		for (int j = 0; j < 5; j++) {
			if (moving[swit][j] != -1) {
				check[moving[swit][j]] -= i;
			}
		}
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int C;
	cin >> C;
	for (int c = 1; c <= C; c++) {
		for (int i = 0; i < 16; i++) {
			cin >> board[i];
			if (board[i] == 12) check[i] = 0;
			else if (board[i] == 3) check[i] = 1;
			else if (board[i] == 6) check[i] = 2;
			else if (board[i] == 9) check[i] = 3;
		}
		if (board[8] != board[12]) cout << "-1" << '\n';
		else if (board[14] != board[15]) cout << "-1" << '\n';
		else {
			dfs(0,0);
			if (Min == 1000000000) Min = -1;
			cout << Min << '\n';
			Min = 1000000000;
			memset(check, 0, sizeof(check));
			memset(movcnt, 0, sizeof(movcnt));
		}
	}
	return 0;
}