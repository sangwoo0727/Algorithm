#include <iostream>
using namespace std;

int N, c, s;
int A[1000002];

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int a = 1; a <= N; a++) {
		cin >> A[a];
	}
	cin >> c >> s;
	long long cnt = N;
	for (int a = 1; a <= N; a++) {
		int tmp = 0;
		A[a] -= c;
		if (A[a] > 0) {
			if (A[a] % s == 0) tmp = A[a] / s;
			else tmp = A[a] / s + 1;
			cnt += tmp;
		}
	}
	cout << cnt << '\n';
	return 0;
}