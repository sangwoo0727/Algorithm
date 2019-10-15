#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector <int> v;
vector <int> ans;

void rep_combination(int n, int m) {
	if (m == M) {
		for (int i = 0; i < M; i++) cout << ans[i] << ' ';
		cout << '\n';
		return;
	}
	if (n >= N) return;
	ans.push_back(v[n]);
	rep_combination(n , m + 1);
	ans.pop_back();
	rep_combination(n + 1, m);
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
	rep_combination(0, 0);
	return 0;
}