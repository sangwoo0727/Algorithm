/*1389 케빈 베이컨의 6단계 법칙
정점 하나를 기준으로, 다른정점들까지 가는 카운트를 누적시켜서 나온 값이 케빈 베이컨 값
모든 정점들중에 케빈 베이컨 수가 가장 작은 수를 출력하는 문제
촌수계산과 비슷한 문제로 bfs를 통해 풀었다.*/
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