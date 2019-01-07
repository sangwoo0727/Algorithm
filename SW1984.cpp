/*SW 1984 평균값 구하기
10개의 수를 입력받아서 최소값과 최댓값을 뺀 나머지의 평균을 구하는
단순한 문제.
하지만 이마저도 반올림관련해서 좀 애를 먹었다...:( */

#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

int main() {
	int T=0;
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
		result = floor((sum / 8)+0.5);  //문제에 소수 첫째자리에서 반올림한 값을 쓰라고 되어있다.
		/* sum을 실수형으로 받아서 8로 나누었을때 실수값이 되도록 한다. 그 후 0.5를 더해서 floor 함수를 쓰면, 
		(floor함수는 버림 함수)
		반올림한 값이 나온다. 그것을 int형의 result에 넣으면, 정수형으로 답이 표현된다.*/
		printf("#%d %d\n", i + 1, result);
		sum = 0;
		result = 0;
	}
	return 0;
}