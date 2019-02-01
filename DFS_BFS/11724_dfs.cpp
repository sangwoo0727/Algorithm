/*11724�� �������� ���� ����
bfs�� Ǭ ���ó�� dfs�� Ǭ ���*/

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector <vector <int>> adj(1002);
int check[1002];
int n, m;
int u, v;
int cnt;

void dfs(int now) {
	check[now] = 1;
	for (int i = 0; i < adj[now].size(); i++) {
		int next = adj[now][i];
		if (check[next] == 0) dfs(next);
	}
}
int main() {
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= m; i++) {
		scanf("%d %d", &u, &v);
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	for (int i = 1; i <= n; i++) {
		if (check[i] == 1) continue;
		dfs(i);
		cnt++;
	}
	printf("%d", cnt);
	return 0;
}