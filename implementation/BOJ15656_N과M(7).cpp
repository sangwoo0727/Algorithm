#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector <int> v;
vector <int> ans;

void rep_permutation(int m) {
	if (m == M) {
		for (int i = 0; i < M; i++) {
			cout << ans[i] << ' ';
		}
		cout << '\n';
		return;
	}
	for (int i = 0; i < N; i++) {
		ans.push_back(v[i]);
		rep_permutation(m + 1);
		ans.pop_back();
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		int tmp = 0;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	rep_permutation(0);
	return 0;
}