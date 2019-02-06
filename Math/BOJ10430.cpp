/*10430 나머지 문제
연산을 한 후 나머지를 적용하는 값이나
연산 전 각 변수를 나머지 적용한 후 연산 한 후 다시 나머지를 적용한 값이나
같다는 것을 알 수 있다.*/
#include <iostream>
using namespace std;

int main() {
	int A, B, C;
	scanf("%d%d%d", &A, &B, &C);
	printf("%d\n", (A + B) % C);
	printf("%d\n", (A%C+B%C) % C);
	printf("%d\n", (A * B) % C);
	printf("%d\n", (A%C * B%C) % C);
	return 0;
}