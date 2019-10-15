#include <iostream>
using namespace std;

int N, M;
int arr[9];

void rep_combination(int m, int n) {
	if (m == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
		return;
	}
	if (n > N) return;
	arr[m] = n;
	rep_combination(m + 1, n);
	rep_combination(m , n + 1);
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	rep_combination(0, 1);
	return 0;
}