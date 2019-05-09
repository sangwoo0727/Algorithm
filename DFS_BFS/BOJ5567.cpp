#include <iostream>
#include <vector>
#include <queue>
#include <utility>
#define p pair<int,int>
using namespace std;

int n, m;
int cnt;
vector <vector<int>> v(505);
queue <p> q;
int check[505];

int bfs(int n, int level) {
	q.push(make_pair(n, level));
	check[n] = 1;
	while (!q.empty()) {
		if (q.front().second == 3) break;
		int now = q.front().first;
		int now_lev = q.front().second;
		if (now != 1) cnt++;
		check[now] = 1;
		q.pop();
		int size = v[now].size();
		for (int i = 0; i < size; i++) {
			int next = v[now][i];
			if (check[next] == 0) {
				q.push(make_pair(next, now_lev + 1));
				check[next] = 1;
			}
		}
	}
	return cnt;
}
int main() {
	int a, b;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &a, &b);
		v[a].push_back(b);
		v[b].push_back(a);
	}
	printf("%d", bfs(1,0));
	return 0;
}