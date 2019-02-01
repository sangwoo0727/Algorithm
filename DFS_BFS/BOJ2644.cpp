/*2644번 촌수계산 문제
BFS인 것 까지는 쉽게 파악했는데,
cnt를 증가시키는 부분에서 원래방법이 틀렸다고 나온다
아직 반례는 못찾았지만, 다른 방법을 도움받아 풀었다 일단.
반례를 찾게되면 그 코드도 올리겠다.*/

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

int bfs(int start) { //bfs 시작
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
	return -1; //이 경우는 탐색이 완료되었는데 못찾은 경우니깐 -1을 리턴한다.
}

int main() {
	scanf("%d", &n);
	scanf("%d%d", &target1, &target2);
	scanf("%d", &m);
	for (int i = 1; i <= m; i++) {
		scanf("%d%d", &a, &b);
		adj[a].push_back(b);
		adj[b].push_back(a);
	}  // 그래프 만듬
	for (int i = 1; i <= n; i++) {
		sort(adj[i].begin(), adj[i].end());
	} //정렬 후

	printf("%d", bfs(target1));
	return 0;
}