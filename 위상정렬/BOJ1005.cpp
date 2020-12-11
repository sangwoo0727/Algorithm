#include <cstdio>
#include <vector>
#include <cstring>
#include <algorithm>
#include <queue>
using namespace std;

vector <vector <int>> adj;
vector <vector <int>> from_vert;
queue <int> q;
int check[1005];
int vert[1005];
int ind[1005];
int topological[1005];
int dp[1005];
int idx;

void bfs() {
	while (!q.empty()) {
		int now = q.front();
		check[now] = 1;
		topological[idx++] = now;
		q.pop();
		int size = adj[now].size();
		for (int i = 0; i < size; i++) {
			int next = adj[now][i];
			ind[next]--;
			if (ind[next] == 0) q.push(next);
		}
	}
}
int main() {
	int T, N, K,w;
	scanf("%d", &T);
	while (T--) {
		idx = 0;
		scanf("%d%d", &N, &K);
		adj.resize(N + 1);
		from_vert.resize(N + 1);
		for (int i = 1; i <= N; i++) {
			int weight;
			scanf("%d", &weight);
			vert[i] = weight;
		}
		for (int i = 0; i < K; i++) {
			int a, b;
			scanf("%d%d", &a, &b);
			adj[a].push_back(b);
			from_vert[b].push_back(a);
			ind[b]++;
		}
		for (int i = 1; i <= N; i++) {
			int size = from_vert[i].size();
			if (size == 0) q.push(i);
		}
		bfs();
		for (int i = 0; i < N; i++) {
			int size = from_vert[topological[i]].size();
			if (size == 0) {
				dp[topological[i]] = vert[topological[i]];
			}
			else {
				dp[topological[i]] = vert[topological[i]];
				for (int j = 0; j < size; j++) {
					dp[topological[i]] = max(dp[topological[i]], dp[from_vert[topological[i]][j]] + vert[topological[i]]);
				}
			}
		}
		scanf("%d", &w);
		printf("%d\n", dp[w]);
		adj.clear();
		from_vert.clear();
		memset(ind, 0, sizeof(ind));
		memset(check, 0, sizeof(check));
		memset(topological, 0, sizeof(topological));
		memset(dp, 0, sizeof(dp));
		memset(vert, 0, sizeof(vert));
	}
	return 0;
}