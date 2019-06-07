#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

vector <vector <int>> adj;
queue <int> q;
int weight[505];
int ind[505];
int dp[505];
int check[505];

void bfs() {
	while (!q.empty()) {
		int now = q.front();
		check[now] = 1;
		q.pop();
		int size = adj[now].size();
		for (int i = 0; i < size; i++) {
			int next = adj[now][i];
			ind[next]--;
			dp[next] = max(dp[next], dp[now] + weight[next]);
			if (check[next] == 0 && ind[next] == 0)
				q.push(next);
		}
	}
}

int main() {
	int N;
	scanf("%d", &N);
	adj.resize(N + 1);
	for (int i = 1; i <= N; i++) {
		int w;
		scanf("%d", &w);
		weight[i] = w;
		dp[i] = w;
		while (1) {
			int a;
			scanf("%d", &a);
			if (a == -1) break;
			adj[a].push_back(i);
			ind[i]++;
		}
	}
	for (int i = 1; i <= N; i++) {
		if (ind[i] == 0) q.push(i);
	}
	bfs();
	for (int i = 1; i <= N; i++) {
		printf("%d\n", dp[i]);
	}
	return 0;
}
