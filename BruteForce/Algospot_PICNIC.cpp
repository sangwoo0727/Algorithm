#include <iostream>
#include <cstring>
using namespace std;

int board[11][11];
int check[11];
int N, M;
int result;

void dfs(int first, int second, int n){
	check[first] = 1;
	check[second] = 1;
	if (n == N) {
		result += 1;
		return;
	}
	for (int i = 0; i < N; i++) {
		for (int j = i; j < N; j++) {
			if (check[i] == 0 && check[j] == 0 && board[i][j] == 1 && i>first) {
				dfs(i, j, n + 2);
				check[i] = 0; check[j] = 0;
			}
		}
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int C;
	cin >> C;
	for (int c = 1; c <= C; c++) {
		cin >> N >> M;
		for (int i = 0; i < M; i++) {
			int a, b;
			cin >> a >> b;
			board[a][b] = 1;
			board[b][a] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (board[i][j] == 1) {
					dfs(i, j, 2);
					check[i] = 0; check[j] = 0;
				}
			}
		}
		cout << result << '\n';
		result = 0;
		memset(board, 0, sizeof(board));
	}
	return 0;
}