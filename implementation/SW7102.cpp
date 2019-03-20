/*SW 7102. 준홍이의 카드놀이*/
#include <iostream>
using namespace std;

int main() {
	int N, M;
	int T;
	cin >> T;
	for (int t = 1; t <= T; t++) {
		cin >> N >> M;
		cout << "#" << t << " ";
		if (N >= M) {
			int result = 1 + M;
			while (result <= N + 1) {
				cout << result << " ";
				result ++;
			}
		}
		else {
			int result = 1 + N;
			while (result <= M + 1) {
				cout << result << " ";
				result ++;
			}
		}
		cout << "\n";
	}
	return 0;
}