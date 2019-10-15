#include <iostream>
using namespace std;

int N, M;
bool check[9];

void comb(int m, int idx) {
	if (m == M) {
		for (int i = 1; i <= N; i++) {
			if (check[i]) cout << i <<' ';
		}
		cout << '\n';
		return;
	}
	if (idx > N) return;
	check[idx] = true;
	comb(m + 1, idx + 1);
	check[idx] = false;
	comb(m, idx + 1);
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	comb(0, 1);
	return 0;
}