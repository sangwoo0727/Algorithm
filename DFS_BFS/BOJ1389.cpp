/*1389 �ɺ� �������� 6�ܰ� ��Ģ
���� �ϳ��� ��������, �ٸ���������� ���� ī��Ʈ�� �������Ѽ� ���� ���� �ɺ� ������ ��
��� �������߿� �ɺ� ������ ���� ���� ���� ���� ����ϴ� ����
�̼����� ����� ������ bfs�� ���� Ǯ����.*/
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
#include <utility>
using namespace std;

queue <pair <int, int>> q;
vector <vector<int>> adj(105);
int ans[105];
int check[105];
int a, b;
int n, m;
int result;
int Min=105;

int bfs(int start) {
	check[start] = 1;
	q.push({ start,0 });
	while (q.empty() == 0) {
		int now = q.front().first;
		int cnt = q.front().second;
		result += cnt;
		q.pop();
		for (int i = 0; i < adj[now].size(); i++) {
			int next = adj[now][i];
			if (check[next] == 0) {
				check[next] = 1;
				q.push({ next,cnt + 1 });
			}
		}
	}
	return result;
}
int main() {
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= m; i++) {
		scanf("%d%d", &a, &b);
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		sort(adj[i].begin(), adj[i].end());
	}
	for (int i = 1; i <= n; i++) {
		ans[i] = bfs(i);
		Min = min(Min, ans[i]);
		result = 0;
		memset(check, 0, sizeof(check));
	}
	for (int i = 1; i <= n; i++) {
		if (Min == ans[i]) {
			printf("%d\n", i);
			break;
		}
	}
	return 0;
}