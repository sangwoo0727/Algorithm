/* 대상이 숙제 
입력받은 3개의 수중에 2번째로 큰 수 출력
원래대로면 6가지의 가지수를 if를 통해 나누고, 
그 중 2번째인 값을 출력.
이 코드는 sort를 사용해 입력받은 3개의 수를 정렬하고
그 중 2번째를 출력한다.*/

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int arr[3] = {};
	for (int i = 0; i < 3; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr, arr + 3);
	printf("%d\n", arr[1]);
	return 0;
}