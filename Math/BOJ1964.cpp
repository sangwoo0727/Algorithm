#include <cstdio>
#define MOD 45678
using namespace std;

int main() {
	int N;
	int result;
	scanf("%d", &N);
	result = 5;
	for (int i = 2; i <= N; i++) {
		int mid = (i + 1) * 3 - 2;
		result = (result + mid) % MOD;
	}
	printf("%d", result);
}
