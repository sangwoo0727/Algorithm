#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

typedef struct {
	int r;
	int c;
	int s;
}spinning;

vector <spinning> v;
int arr[7] = { 0,1,2,3,4,5,6 };
int N, M, K;
int board[53][53];
int copyboard[53][53];

void spin(int r, int c, int s) {
	if (s == 0) return;
	else {
		int tmp = 0;
		int tmp2 = 0;
		for (int i = c + s; i >= c-s; i--) {
			if (i == c + s) tmp = copyboard[r-s][i];
			else copyboard[r-s][i + 1] = copyboard[r-s][i];
		}
		for (int i = r + s; i > r - s; i--) {
			if (i == r + s) {
				tmp2 = copyboard[i][c + s];
				copyboard[i][c + s] = copyboard[i - 1][c + s];
			}
			else if (i == r - s + 1) {
				copyboard[i][c + s] = tmp;
				tmp = 0;
			}
			else copyboard[i][c + s] = copyboard[i-1][c + s];
		}
		for (int i = c - s; i < c + s; i++) {
			if (i == c - s) {
				tmp = copyboard[r + s][i];
				copyboard[r + s][i] = copyboard[r + s][i + 1];
			}
			else if (i == c + s - 1) {
				copyboard[r + s][i] = tmp2;
				tmp2 = 0;
			}
			else copyboard[r + s][i] = copyboard[r + s][i + 1];
		}
		for (int i = r - s; i < r + s; i++) {
			if (i == r + s - 1) copyboard[i][c - s] = tmp;
			else copyboard[i][c - s] = copyboard[i + 1][c - s];
		}
		spin(r, c, s - 1);
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M >> K;
	int Min = 0;
	int ans = 100000000;
	for (int n = 1; n <= N; n++) {
		for (int m = 1; m <= M; m++) {
			cin >> board[n][m];
		}
	}
	int range = K;
	while (range--) {
		int r, c, s;
		cin >> r >> c >> s;
		v.push_back({ r,c,s });
	}
	do {
		for (int n = 1; n <= N; n++) {
			for (int m = 1; m <= M; m++) {
				copyboard[n][m] = board[n][m];
			}
		}
		for (int i = 0; i < K; i++) {
			spin(v[arr[i]].r,v[arr[i]].c,v[arr[i]].s);
		}
		for (int n = 1; n <= N; n++) {
			for (int m = 1; m <= M; m++) {
				Min += copyboard[n][m];
			}
			ans = min(ans, Min);
			Min = 0;
		}
	} while (next_permutation(arr,arr + K));
	cout << ans << '\n';
	return 0;
}