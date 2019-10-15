#include <iostream>
using namespace std;

int N, M;
int arr[8];

void rep_permutation(int m) {
	if (m == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
		return;
	}
	for (int i = 1; i <= N; i++) {
		arr[m] = i;
		rep_permutation(m + 1);
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	rep_permutation(0);
	return 0;
}