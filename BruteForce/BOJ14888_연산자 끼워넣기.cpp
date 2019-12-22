#include <iostream>
#include <vector>
#include <algorithm>
#define endl '\n'
using namespace std;

int N;
int MAX = -1000000000;
int Min = 1000000000;
vector <int> v;
vector <int> op;
int cnt[4];

void rep_permu(int r, int R) {
	if (r == R) {
		int result = v[0];
		for (int i = 0; i < R; i++) {
			if (op[i] == 0) {
				result += v[i + 1];
			}
			else if (op[i] == 1) {
				result -= v[i + 1];
			}
			else if (op[i] == 2) {
				result *= v[i + 1];
			}
			else if (op[i] == 3) {
				result /= v[i + 1];
			}
		}
		MAX = max(MAX, result);
		Min = min(Min, result);
		return;
	}
	for (int k = 0; k < 4; k++) {
		if (cnt[k] > 0) {
			op.push_back(k);
			cnt[k]--;
			rep_permu(r + 1, R);
			op.pop_back();
			cnt[k]++;
		}
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int n = 0; n < N; n++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	for (int n = 0; n < 4; n++) {
		cin >> cnt[n];
	}
	rep_permu(0, N - 1);
	cout << MAX << endl;
	cout << Min << endl;
	return 0;
}