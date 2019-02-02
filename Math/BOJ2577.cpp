/*2577 숫자의 개수 문제
딱히 어려운 것은 없이 각자리마다 숫자를 세서 출력하면 되는 문제였다. */
#include <iostream>
using namespace std;

int result;
int a, b, c;
int cnt[11];

int main() {
	scanf("%d%d%d", &a, &b, &c);
	result = a * b * c;
	for (int i = 1; result>=0; i++) {
		cnt[result % 10]++;
		result = result / 10;
		if (result == 0) break;
	}
	for (int i = 0; i < 10; i++) {
		printf("%d\n", cnt[i]);
	}
	return 0;
}