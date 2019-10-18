#include <iostream>
#include <algorithm>
#include <cstring>

#define endl '\n'
using namespace std;

int N;
int MAX;
int star[51][11];
int check[10];
int board[4];

void game_start() {
	int player = 0;
	int score = 0;
	for (int inning = 1; inning <= N; inning++) {
		int out = 0;
		memset(board, 0, sizeof(board));
		while (1) {
			if (player < 9) player++;
			else if(player==9) player = 1;
			int result = star[inning][check[player]];
			if (result == 0) {
				out++;
				if (out < 3) continue;
				else if (out == 3) {
					break;
				}
			}
			if (result == 1) {
				for (int i = 3; i >= 1; i--) {
					if (i == 3 && board[i] != 0) {
						board[i] = 0;
						score++;
					}
					if (i != 3 && board[i] != 0) {
						board[i + 1] = board[i];
						board[i] = 0;
					}
				}
				board[1] = 1;
			}
			if (result == 2) {
				for (int i = 3; i >= 1; i--) {
					if ((i == 3 || i == 2) && board[i] != 0) {
						score++;
						board[i] = 0;
					}
					if (i == 1) {
						board[i + 2] = board[i];
						board[i] = 0;
					}
				}
				board[2] = 1;
			}
			if (result == 3) {
				for (int i = 3; i >= 1; i--) {
					if (board[i] != 0) {
						score++;
						board[i] = 0;
					}
				}
				board[3] = 1;
			}
			if (result == 4) {
				for (int i = 3; i >= 1; i--) {
					if (board[i] != 0) {
						score++;
						board[i] = 0;
					}
				}
				score++;
			}
		}
	}
	MAX = max(MAX, score);
}

void permutation(int m) {
	if (m > 9) {
		game_start();
	}
	for (int i = 1; i <= 9; i++) {
		if (check[i] == 0) {
			check[i] = m;
			permutation(m + 1);
			check[i] = 0;
		}
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= 9; j++) {
			cin >> star[i][j];
		}
	}
	check[4] = 1;
	permutation(2);
	cout << MAX << endl;
	return 0;
}