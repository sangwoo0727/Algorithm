/*SW 1926 간단한 369 게임*/
#include <iostream>
using namespace std;

int main() {
	int N;
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		int cnt = 0;
		int n = 0;
		n = i;
		while (1) {
			int digit = n % 10;
			if (digit == 3 || digit == 6 || digit == 9) cnt++;
			n /= 10;
			if (n == 0) break;
		}
		if (cnt == 0) printf("%d ", i);
		else {
			for (int j = 0; j < cnt; j++) {
				printf("-");
			}
			printf(" ");
		}
	}
	return 0;
}