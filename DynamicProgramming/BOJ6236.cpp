#include <iostream>
#include <algorithm>
using namespace std;

int dp_1[1005][1005]; //위->아래
int dp_2[1005][1005]; //왼쪽 -> 오른쪽
int dp_3[1005][1005]; //오른쪽 ->왼쪽
int board[1005][1005];
int N, M;

int main() {
	cin >> N >> M;
	for (int n = 1; n <= N; n++) {
		for (int m = 1; m <= M; m++) {
			cin >> board[n][m];
		}
	}
	dp_1[1][1] = board[1][1];
	dp_2[1][1] = board[1][1];
	for (int m = 2; m <= M; m++) {
		dp_1[1][m] = -1000000000;
	}
	for (int m = 2; m <= M; m++) {
		dp_2[1][m] = dp_2[1][m - 1] + board[1][m];
	}
	for (int m = 1; m <= M; m++) {
		dp_3[1][m] = -1000000000;
	}
	for (int n = 2; n <= N; n++) {
		for (int m = 1; m <= M; m++) {
			dp_1[n][m] = max(dp_1[n - 1][m],max(dp_2[n - 1][m], dp_3[n - 1][m]));
			dp_1[n][m] += board[n][m];
		}
		for (int m = 1; m <= M; m++) {
			if (m == 1) {
				dp_2[n][m] = -1000000000;
			}
			else {
				dp_2[n][m] = max(dp_1[n][m - 1], dp_2[n][m - 1]);
				dp_2[n][m] += board[n][m];
			}
		}
		for (int m = M; m >= 1; m--) {
			if (m == M) {
				dp_3[n][m] = -1000000000;
			}
			else {
				dp_3[n][m] = max(dp_1[n][m + 1], dp_3[n][m + 1]);
				dp_3[n][m] += board[n][m];
			}
		}
	}
	cout << max(dp_1[N][M], max(dp_2[N][M], dp_3[N][M]));
	return 0;
}