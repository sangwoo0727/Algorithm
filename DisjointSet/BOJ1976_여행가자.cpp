#include <iostream>
#include <vector>
using namespace std;

int N, M;

void init(vector <int>& refRoot, vector <int>&refRank) {
	for (int i = 0; i < N ; i++) {
		refRoot.push_back(i);
		refRank.push_back(1);
	}
}

int find(int u, vector <int>& v) {
	if (u == v[u]) return u;
	return v[u] = find(v[u], v);
}

void merge(int u, int v, vector<int>& refRoot, vector<int>& refRank) {
	u = find(u, refRoot);
	v = find(v, refRoot);
	refRank[u] > refRank[v] ? refRoot[v] = u : refRoot[u] = v;
	if (refRank[u] == refRank[v]) {
		refRank[v]++;
	}
}

int main() {
	vector <int> root, rank;
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	init(root, rank);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			bool n;
			cin >> n;
			if (n) {
				merge(i, j, root, rank);
			}
		}
	}
	int tmp = 0;
	cin >> tmp;
	tmp = find(tmp - 1, root);
	for (int i = 1; i < M; i++) {
		int n;
		cin >> n;
		n = find(n - 1, root);
		n != tmp ? tmp = -1 : tmp = n;
	}
	tmp == -1 ? cout << "NO" : cout << "YES";
	return 0;
}