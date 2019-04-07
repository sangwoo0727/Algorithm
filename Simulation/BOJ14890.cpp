/*BOJ 14890 경사로*/
#include <iostream>
using namespace std;

int N, L;
int board[105][105];

int main() {
	int ans = 0;
	scanf("%d%d", &N, &L);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	for (int i = 0; i < N; i++) {
		int start = board[i][0];
		int cnt = 1;
		for (int j = 0; j < N; j++) {
			if (j == N - 1) {
				ans++;
				break;
			}
			if (start == board[i][j + 1]) { //다음 블록이랑 같은 경우
				start = board[i][j + 1];
				cnt++;
				continue;
			}
			if (start > board[i][j + 1]) { //다음 블록이 더 작은 경우
				if (start - 1 > board[i][j + 1]) break;
				int cnt2 = 0;
				for (int k = j + 1; board[i][k] == board[i][j + 1]; k++) {
					cnt2++;
				}
				if (cnt2 >= L) {
					start = board[i][j + cnt2];
					j = j + cnt2 - 1;
					cnt = cnt2-L;
					continue;
				}
				else if(cnt2<L) break;
			}
			if (start < board[i][j + 1]) { //다음 블록이 더 큰경우
				if (start + 1 < board[i][j + 1]) break;
				else if(start + 1 == board[i][j + 1]) {
					if (cnt >= L) {
						start = board[i][j + 1];
						cnt = 1;
						continue;
					}
					else if (cnt < L) break;
				}
			}
		}
	}
	for (int j = 0; j < N; j++) {
		int start = board[0][j];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				ans++;
				break;
			}
			if (start == board[i+1][j]) { //다음 블록이랑 같은 경우
				start = board[i+1][j];
				cnt++;
				continue;
			}
			if (start > board[i+1][j]) { //다음 블록이 더 작은 경우
				if (start - 1 > board[i+1][j]) break;
				int cnt2 = 0;
				for (int k = i + 1; board[k][j] == board[i+1][j]; k++) {
					cnt2++;
				}
				if (cnt2 >= L) {
					start = board[i+cnt2][j];
					i = i + cnt2 - 1;
					cnt = cnt2-L;
					continue;
				}
				else if (cnt2 < L) break;
			}
			if (start < board[i+1][j]) { //다음 블록이 더 큰경우
				if (start + 1 < board[i+1][j]) break;
				else if (start + 1 == board[i+1][j]) {
					if (cnt >= L) {
						start = board[i+1][j];
						cnt = 1;
						continue;
					}
					else if (cnt < L) break;
				}
			}
		}
	}
	printf("%d", ans);
	return 0;
}