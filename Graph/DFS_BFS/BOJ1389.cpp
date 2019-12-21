#include <iostream>
#include <queue>
#include <vector>
#include <utility>
#include <cstring>
#include <algorithm>

#define endl '\n'
using namespace std;

int N, M;
int Min = 10000000;
vector <vector <int>> v;
bool check[101];

int bfs(int start) {
	int result = 0;
	queue <pair<int,int>> q;
	q.push(make_pair(start,0));
	while (!q.empty()) {
		int now = q.front().first;
		int cnt = q.front().second;
		q.pop();
		check[now] = true;
		result += cnt;
		int size = v[now].size();
		for (int k = 0; k < size; k++) {
			int next = v[now][k];
			if (!check[next]) {
				check[next] = true;
				q.push(make_pair(next, cnt + 1));
			}
		}
	}
	return result;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int pNum = 0;
	cin >> N >> M;
	v.resize(N + 1);
	for (int m = 0; m < M; m++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for (int n = 1; n <= N; n++) {
		int result = bfs(n);
		if (Min > result) {
			Min = result;
			pNum = n;
		}
		memset(check, false, sizeof(check));
	}
	cout << pNum << endl;
	return 0;
}
