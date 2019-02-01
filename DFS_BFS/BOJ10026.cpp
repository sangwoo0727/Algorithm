/*적록색약 문제 10026번
dfs든 bfs로 풀면되는데, 벡터로 입력받은 그래프가 아닌
배열이기때문에 위,아래,좌,우를 보면서 dfs 탐색이 한번 끝나면
카운트를 1증가시키면된다.
모든걸 초기화시킨후 적록색약인 사람은 r을 g로 바꿔서 풀면 된다.*/

#include <iostream>
#include <cstring>
using namespace std;

int n;
char board[105][105];
int check[105][105];
int dr[4] = { 0,0,-1,1 };
int dc[4] = { -1,1,0,0 };
int cnt = 0;

void dfs(int i, int j) {
	check[i][j] = 1;
	for (int m = 0; m < 4; m++) {
		int ri = i + dr[m];
		int cj = j + dc[m];
		if (check[ri][cj] == 0 && ri>=0 && cj>=0 && ri<n && cj<n && board[ri][cj]==board[i][j]) {
			check[ri][cj] = 1;
			dfs(ri, cj);
		}
	}
}
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%s", &board[i]);
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] != 0) continue;
			dfs(i, j);
			cnt++;
		}
	}
	printf("%d ", cnt);
	cnt = 0;
	memset(check, 0, sizeof(check));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (board[i][j] == 'R')
				board[i][j] = 'G';
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] != 0) continue;
			dfs(i, j);
			cnt++;
		}
	}
	printf("%d ", cnt);
	return 0;
}