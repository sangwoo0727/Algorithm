/* BOJ 3049 다각형의 대각선 */
#include <iostream>
using namespace std;

int comb(int n, int k) {
	if (k == 1) return n;
	if (n == k) return 1;
	return comb(n - 1, k) + comb(n - 1, k - 1);
}
int main() {
	int N;
	cin >> N;
	cout << comb(N, 4);
	return 0;
}