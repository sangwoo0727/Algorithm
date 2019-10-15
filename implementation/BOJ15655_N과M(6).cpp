#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
bool check[10];
vector <int> v;

void combination(int m, int n) {
	if (m == M) {
		for (int i = 0; i < N; i++) {
			if (check[i]) cout << v[i] << ' ';
		}
		cout << '\n';
		return;
	}
	if (n >= N) return;
	check[n] = true;
	combination(m + 1, n + 1);
	check[n] = false;
	combination(m, n + 1);
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
	combination(0, 0);
	return 0;
}