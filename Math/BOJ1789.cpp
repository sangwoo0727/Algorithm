/*BOJ1789 ������ ��*/

#include <iostream>
using namespace std;

int main() {
	long long S;
	scanf("%lld", &S);
	for (long long i = 1; i < S; i++) {
		S = S - i;
		if (S < 0) {
			printf("%lld", i-1);
			break;
		}
	}
	return 0;
}