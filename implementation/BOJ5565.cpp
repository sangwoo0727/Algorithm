#include <iostream>
using namespace std;

int main() {
	int N;
	int result = 0;
	scanf("%d", &N);
	for (int i = 0; i < 9; i++) {
		int n;
		scanf("%d", &n);
		result += n;
	}
	printf("%d", N - result);
	return 0;
}