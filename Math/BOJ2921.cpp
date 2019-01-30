/*2921 도미노 문제
점화식을 세워서 해결했다.*/
#include <iostream>
using namespace std;

int main() {
	int N;
	int result = 0;
	scanf("%d",&N);
	result = N * (N + 1)*(N + 2) / 2;
	printf("%d", result);
	return 0;
}