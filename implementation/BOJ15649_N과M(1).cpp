#include <iostream>
using namespace std;

int N, M;
int arr[9];
bool check[9];

void permutation(int m) {
	if (m == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
	}
	for (int i = 1; i <= N; i++) {
		if (!check[i]) {
			check[i] = true;
			arr[m] = i;
			permutation(m + 1);
			check[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	permutation(0);
	return 0;
}