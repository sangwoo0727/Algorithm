#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>

#define endl '\n';
using namespace std;

bool check[50];

void comb(int r, int idx, vector <int>& v, int k) {
	if (r == 6) {
		for (int i = 0; i < k; i++) {
			if (check[v[i]]) {
				cout << v[i] << ' ';
			}
		}
		cout << endl;
		return;
	}
	if (idx >= k) return;
	check[v[idx]] = true;
	comb(r + 1, idx + 1, v, k);
	check[v[idx]] = false;
	comb(r, idx + 1, v, k);
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	while (1) {
		int k;
		vector <int> v;
		cin >> k;
		if (k == 0) break;
		for (int i = 0; i < k; i++) {
			int a;
			cin >> a;
			v.push_back(a);
		}
		sort(v.begin(), v.end());
		comb(0, 0, v , k);
		cout << endl;
	}
	return 0;
}