#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int check[20005];

int bfs(int v, vector <vector <int>> &g) {
	queue <int> q;
	int n = 1;
	check[v] = n;
	q.push(v);
	while (!q.empty()) {
		int now = q.front();
		n = check[now];
		q.pop();
		int size = g[now].size();
		for (int i = 0; i < size; i++) {
			int next = g[now][i];
			if (check[next] == 0) {
				if (n == 1) {
					check[next] = 2;
					q.push(next);
				}
				if (n == 2) {
					check[next] = 1;
					q.push(next);
				}
			}
			else if(check[next]!=0){
				if (check[now] == check[next]) return 0;
				else if (check[now] != check[next]) continue;
			}
		}
	}
	return 1;
}

int main() {
	int k, V, E;
	scanf("%d", &k);
	for (int i = 0; i < k; i++) {
		scanf("%d%d", &V, &E);
		vector <vector <int>> g(20005);
		for (int j = 0; j < E; j++) {
			int a, b;
			scanf("%d%d", &a, &b);
			g[a].push_back(b);
			g[b].push_back(a);
		}
		int result = 0;
		for (int k = 1; k <= V; k++) {
			if (check[k] != 0) continue;
			result = bfs(k, g);
			if (result == 0) break;
		}
		if (result == 1) printf("YES\n");
		if (result == 0) printf("NO\n");
		memset(check, 0, sizeof(check));
	}
	return 0;
}