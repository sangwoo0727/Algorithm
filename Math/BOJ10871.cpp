/*10871번 x보다 작은 수
수열과 목표 값인 x가 주어지고
x보다 작은 값들만 입력받는 순서대로 출력하는 단순한 문제*/

#include <iostream>
using namespace std;

int arr[10002];
int n,x;
int main() {
	scanf("%d%d", &n, &x);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < n; i++) {
		if (arr[i] >= x) continue;
		printf("%d ", arr[i]);
	}
	printf("\n");
	return 0;
}