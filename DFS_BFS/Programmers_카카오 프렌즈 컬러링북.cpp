#include <vector>
#include <cstring>
#include <queue>
#include <algorithm>
using namespace std;

bool check[101][101];
int dc[4] = { 0,0,-1,1 };
int dr[4] = { 1,-1,0,0 };

int bfs(int m, int n, int N, int M, vector <vector <int>>& board, int cnt) {
	queue <pair <int, int>> q;
	q.push({ m,n });
	while (!q.empty()) {
		int mnow = q.front().first;
		int nnow = q.front().second;
		check[mnow][nnow] = true;
		cnt++;
		q.pop();
		for (int k = 0; k < 4; k++) {
			int mnext = mnow + dc[k];
			int nnext = nnow + dr[k];
			if (mnext < 0 || mnext >= M || nnext < 0 || nnext >= N) continue;
			if (check[mnext][nnext] || board[mnow][nnow] != board[mnext][nnext]) continue;
			q.push({ mnext,nnext });
			check[mnext][nnext] = true;
		}
	}
	return cnt;
}

vector<int> solution(int m, int n, vector<vector<int>> picture) {
	int n_area = 0;
	int max_area = 0;
	memset(check, 0, sizeof(check));
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (picture[i][j] == 0) continue;
			if (!check[i][j]) {
				max_area = max(max_area, bfs(i, j, n, m, picture, 0));
				n_area++;
			}
		}
	}
	return vector <int> { n_area, max_area };
}