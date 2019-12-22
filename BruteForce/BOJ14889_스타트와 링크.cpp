#include <iostream>
#include <algorithm>
#include <cmath>
#define endl '\n'
using namespace std;

int N;
int Min = 1000000000;
int board[21][21];
bool check[21];

void comb(int r, int idx) {
	if (r == N / 2) {
		int ssum = 0, lsum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (check[i] && check[j]) 
					ssum += (board[i][j]+board[j][i]);
				if (!check[i] && !check[j]) 
					lsum += (board[i][j]+board[j][i]);
			}
		}
		Min = min(Min, abs(ssum - lsum));
	}
	if (idx >= N) return;
	check[idx] = true;
	comb(r + 1, idx + 1);
	check[idx] = false;
	comb(r, idx + 1);
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> board[i][j];
		}
	}
	comb(0, 0);
	cout << Min << endl;
	return 0;
}