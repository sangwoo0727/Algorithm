/*11403번 경로찾기 문제
인접행렬을 통해 방향그래프를 벡터로 나타내주고 i에서 j로 가는 방법이 있는지 
찾는 문제다. 
bfs로 시작점에서 타겟까지 탐색하는 식으로 했는데, 계속 틀렸다고 나와서 한참 해맸다..
이유는 탐색을 한 후, 큐를 비우고 새롭게 다시 들어가야되는데 큐가 비워있지 않은 경우가 존재했다.
*/

#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;

int n;
vector <vector <int>> adj(100);
queue <int> q;
int arr[100][100];
int ans[100][100];
int check[100];

void clear(queue<int> &q) {
	queue <int> empty;
	swap(q, empty);
}
int bfs(int start, int target) {
	check[start] = 1;
	q.push(start);
	while (q.empty() == 0) {
		int now = q.front();
		q.pop();
		for (int i = 0; i < adj[now].size(); i++) {
			int next = adj[now][i];
			if (next == target) return 1;
			if (check[next] == 0) {
				check[next] = 1;
				q.push(next);
			}
		}
	}
	return 0;
}
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 1)	adj[i].push_back(j);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d ", bfs(i, j));
			memset(check, 0, sizeof(check));
			clear(q);
		}
		printf("\n");
	}
	return 0;
}