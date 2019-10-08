#include <iostream>
#include <queue>
#include <vector>
#include <utility>
#include <functional>
#include <algorithm>
using namespace std;

vector <pair<int,int>> v[1001];
priority_queue <pair<int,int>, vector <pair<int,int>>, greater<pair<int,int>>> pq;
int N, M;
bool visit[1001];

int prim(int start) {
	int ans = 0;
	int edge_max = N - 1;
	int edge_cnt = 0;
	for (int i = 0; i < v[start].size(); i++) {
		pq.push(make_pair(v[start][i].second, v[start][i].first));
	}
	visit[start] = true;
	while (!pq.empty() && edge_cnt <= edge_max) {
		if (visit[pq.top().second]) {
			pq.pop();
			continue;
		}
		int now = pq.top().second;
		ans += pq.top().first;
		edge_cnt++;
		pq.pop();
		visit[now] = true;
		for (int i = 0; i < v[now].size(); i++) {
			if (visit[v[now][i].first]) continue;
			else pq.push(make_pair(v[now][i].second, v[now][i].first));
		}
	}
	return ans;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	cin >> M;
	for (int m = 1; m <= M; m++) {
		int a, b, w;
		cin >> a >> b >> w;
		v[a].push_back(make_pair(b, w));
		v[b].push_back(make_pair(a, w));
	}
	cout << prim(1) << '\n';
	return 0;
}