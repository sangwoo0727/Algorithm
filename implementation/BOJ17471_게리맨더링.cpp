#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>
#include <cmath>

#define endl '\n'
#define INF 999999999
using namespace std;


int N, Min = INF;
int sum, asum, bsum;
int person_num[11];
bool connection[11][11]; 
bool selected[11];
bool check[11];

bool bfs(vector <int> v, bool flag) {
	memset(check, false, sizeof(check));
	queue <int> q;
	q.push(v[0]);
	check[v[0]] = true;
	int cnt = 1;
	while (!q.empty()) {
		int now = q.front();
		if (!check[now]) {
			check[now] = true;
			cnt++;
		}
		q.pop();
		for (int i = 1; i <= N; i++) {
			if (connection[now][i] && selected[i] == flag && !check[i]) {
				q.push(i);
			}
		}
	}
	if (cnt == v.size()) return true;
	else return false;
}

void comb(int m, int idx) {
	if (m >= 1 && m < N) {
		vector <int> av;
		vector <int> bv;
		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				av.push_back(i);
				asum += person_num[i];
			}
			else {
				bv.push_back(i);
				bsum += person_num[i];
			}
		}
		if (bfs(av,true) && bfs(bv,false)) {
			Min = min(Min, abs(asum - bsum));
		}
		asum = bsum = 0;
		av.resize(0); bv.resize(0);
	}
	if (idx > N) return;
	selected[idx] = true;
	comb(m + 1, idx + 1);
	selected[idx] = false;
	comb(m, idx + 1);
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> person_num[i];
		sum += person_num[i];
	}
	for (int i = 1; i <= N; i++) {
		int ad_cnt = 0;
		cin >> ad_cnt;
		for (int j = 0; j < ad_cnt; j++) {
			int adj = 0;
			cin >> adj;
			connection[i][adj] = true;
			connection[adj][i] = true;
		}
	}
	comb(0, 1);
	if (Min == INF) cout << "-1" << endl;
	else cout << Min << endl;
	return 0;
}
