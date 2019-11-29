/*일곱난쟁이 문제
9명의 일곱난쟁이중 도합 키가 100인 7명을 찾아 오름차순으로 나열하는 문제
정렬을 시킨 후, 모두 더한 다음 반복문을 통해 2명을 빼서 합이 100이되면
그 두명을 제외시킨 후 결과값을 출력했다.*/
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int arr[9] = {};
	int result = 0;
	int a, b = 0;
	for (int i = 0; i < 9; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr, arr + 9);
	for (int i = 0; i < 9; i++) {
		result += arr[i];
	}
	
	for (int i = 0; i < 8; i++) {
		for (int j = i+1; j < 9; j++) {
			if (result - arr[i] - arr[j] == 100) {
				a = i;
				b = j;
				break;
			}
		}
	}
	for (int i = 0; i < 9; i++) {
		if (i == a || i == b)
			continue;
		printf("%d\n", arr[i]);
	}
	return 0;
}