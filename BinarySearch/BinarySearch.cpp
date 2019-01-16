/*이진탐색*/

#include <iostream>
using namespace std;

int BSearch(int arr[], int len, int target) { //arr[] == *arr
	int first = 0; // 탐색 대상의 시작 인덱스 값
	int last = len - 1; //탐색 대상의 마지막 인덱스 값
	int mid;

	while (first <= last) {
		mid = (first + last) / 2;
		if (target == arr[mid]) return mid;
		else {
			if (target < arr[mid]) last = mid - 1;
			else first = mid + 1;
		}
	}
	return -1; // 탐색 실패했을 경우 반환되는 값
}

int main() {
	int arr[] = { 1,3,5,7,9 };
	int idx;

	idx = BSearch(arr, sizeof(arr) / sizeof(int), 7);  //7 찾기위한 이진탐색
	if (idx == -1) printf("탐색실패\n");
	else printf("타겟 저장 인덱스: %d\n", idx);

	idx = BSearch(arr, sizeof(arr) / sizeof(int), 4); //4 찾기위한 이진탐색
	if (idx == -1) printf("탐색실패\n");
	else printf("타겟 저장 인덱스: %d\n", idx);

	return 0;
}
