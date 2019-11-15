#include <iostream>
#include <vector>
using namespace std;

int G, P;

void init(vector <int>& r) {
	for (int i = 0; i <= G; i++) {
		r.push_back(i);
	}
}

int find(int n, vector <int>& r) {
	if (n == r[n]) return n;
	return r[n] = find(r[n], r);
}

void merge(int u, int v, vector <int>& r) {
	r[u] = v;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	vector <int> root;
	int ans = 0;
	cin >> G >> P;
	init(root);

	for (int i = 0; i < P; i++) {
		int n;
		cin >> n;
		int ceo = find(n, root);
		if (ceo == 0) break;
		merge(n, ceo - 1, root);
		ans++;
	}
	cout << ans << "\n";
	return 0;
}