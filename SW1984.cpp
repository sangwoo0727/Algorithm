//10개 입력받고, 최소값과 최대값을 빼고 나머지값들의 평균을 구하는 코드. 


#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

int main() {
	int T = 0;
	int arr[10] = {};
	double sum = 0;
	int result;
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		for (int j = 0; j < 10; j++) {
			scanf("%d", &arr[j]);
		}
		sort(arr, arr + 10);
		for (int j = 1; j < 9; j++) {
			sum += arr[j];
		}
		result = floor((sum / 8) + 0.5); //반올림 하는 코드..
		printf("#%d %d\n", i + 1, result);
		sum = 0;
		result = 0;
	}
	return 0;
}
