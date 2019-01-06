/* 대상이 알려주기 위한 문제
5명의 평균을 구하는 문제
조건은 40점 미만인 학생은 40점으로 환산
*/

#include <iostream>
using namespace std;

int arr[5];
int main() {
	int result = 0;

	for (int i = 0; i < 5; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < 5; i++) {
		if (arr[i] <= 40)
			arr[i] = 40;
		result += arr[i];
	}
	printf("%d\n", result / 5);
	return 0;
}