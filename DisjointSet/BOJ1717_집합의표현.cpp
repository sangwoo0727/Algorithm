#include <iostream>
#include <vector>
using namespace std;

int N, M;

void init(vector<int>& r, vector<int>& lev) {
	for (int i = 0; i < N + 1; i++) {
		r.push_back(i);
		lev.push_back(1);
	}
}

int find(int u, vector <int>& r) {
	if (u == r[u]) return u;
	return r[u] = find(r[u], r);
}

void merge(int u, int v, vector<int>& r, vector<int>& lev) {
	int uRoot = find(u, r);
	int vRoot = find(v, r);
	if (uRoot == vRoot) return;
	lev[uRoot] > lev[vRoot] ? r[vRoot] = uRoot : r[uRoot] = vRoot;
	if (lev[uRoot] == lev[vRoot]) lev[vRoot]++;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	vector <int> root, rank;
	cin >> N >> M;
	init(root, rank);
	for (int i = 0; i < M; i++) {
		int m = 0, a = 0, b = 0;
		cin >> m >> a >> b;
		if (m == 0) {
			merge(a, b, root, rank);
		}
		else {
			int aRoot = find(a, root);
			int bRoot = find(b, root);
			if (aRoot == bRoot) {
				cout << "YES" << '\n';
			}
			else {
				cout << "NO" << '\n';
			}
		}
	}
	return 0;
}