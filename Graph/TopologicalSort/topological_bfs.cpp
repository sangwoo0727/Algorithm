#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int V, E;
int check[500];
int indegree[500];
int ans[500];
vector <vector <int>> adj(500);
queue <int> q;

void bfs() {
	int idx = 0;
	while (!q.empty()) {
		int now = q.front();
		check[now] = 1;
		ans[idx++] = now;
		q.pop();
		int size = adj[now].size();
		for (int i = 0; i < size; i++) {
			int next = adj[now][i];
			indegree[next]--;
			if (indegree[next] == 0) q.push(next);
		}
	}
}

int main() {
	int a, b;
	printf("접점의 개수: ");
	scanf("%d", &V);
	printf("간선의 개수: ");
	scanf("%d", &E);
	for (int i = 0; i < E; i++) {
		scanf("%d %d", &a, &b); //a -> b로 이어지게 방향그래프 만듬
		adj[a].push_back(b);
		indegree[b]++;
	}
	for (int i = 1; i <= V; i++) {
		if (indegree[i] == 0) {
			q.push(i);
		}
	}
	bfs();
	if (ans[V - 1] == 0) {
		printf("사이클이 있는 방향그래프\n");
		return 0;
	}
	for (int i = 0; i < V; i++) {
		printf("%d ", ans[i]);
	}
	return 0;
}
	