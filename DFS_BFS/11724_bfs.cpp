/*11724�� �������� ���� ã�� ����
�־��� ������ ������ ���� �׷����� ��������µ�
�� �׷����� �������϶� ����� ���� ����� ã�¹���
bfs�� dfs�� �������.*/
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector <vector <int>> adj(1002);
queue <int> q;
int check[1002];
int n, m;
int u, v;
int cnt;

void bfs(int start) {
	check[start] = 1;
	q.push(start);
	while (q.empty() == 0) {
		int now = q.front();
		q.pop();
		for (int i = 0; i < adj[now].size(); i++) {
			int next = adj[now][i];
			if (check[next] == 0) {
				check[next] = 1;
				q.push(next);
			}
		}
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
		bfs(i);
		cnt++;
	}
	printf("%d", cnt);
	return 0;
}