/*2644�� �̼���� ����
BFS�� �� ������ ���� �ľ��ߴµ�,
cnt�� ������Ű�� �κп��� ��������� Ʋ�ȴٰ� ���´�
���� �ݷʴ� ��ã������, �ٸ� ����� ����޾� Ǯ���� �ϴ�.
�ݷʸ� ã�ԵǸ� �� �ڵ嵵 �ø��ڴ�.*/

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

vector <vector <int>> adj(105);
queue <pair<int, int>> q;
int check[105];
int n, m;
int cnt;
int target1, target2;
int a, b;

int bfs(int start) { //bfs ����
	check[start] = 1;
	q.push({ start,0 });
	while (q.empty() == 0) {
		int now = q.front().first;
		int val = q.front().second;
		q.pop();
		if (now == target2) return val;
		for (int i = 0; i <adj[now].size(); i++) {
			int next = adj[now][i];
			if (check[next] == 0) {
				check[next] = 1;
				q.push({ next,val + 1 });
			}
		}
	}
	return -1; //�� ���� Ž���� �Ϸ�Ǿ��µ� ��ã�� ���ϱ� -1�� �����Ѵ�.
}

int main() {
	scanf("%d", &n);
	scanf("%d%d", &target1, &target2);
	scanf("%d", &m);
	for (int i = 1; i <= m; i++) {
		scanf("%d%d", &a, &b);
		adj[a].push_back(b);
		adj[b].push_back(a);
	}  // �׷��� ����
	for (int i = 1; i <= n; i++) {
		sort(adj[i].begin(), adj[i].end());
	} //���� ��

	printf("%d", bfs(target1));
	return 0;
}