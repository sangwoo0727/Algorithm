/*10815번 이진탐색문제인데,
0과 1로 숫자가있는지 없는지 반환하는거라
그냥 이진탐색 stl로 해결했다.*/

#include <iostream>
#include <algorithm>
using namespace std;

int arr[500001];  //지역변수의 경우는 메모리가 스택영역에 쌓이고,
//전역변수의 경우는 메모리가 힙영역에 쌓인다. 배열을 크게선언할 경우
//지역변수로 쓰면 스택영역이 사이즈가 작은듯.. 오버플로..
int arr2[500001];
int main() {	
	int N, M;
	
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		scanf("%d", &arr2[i]);
	}
	sort(arr, arr + N);

	for (int i = 0; i < M; i++) {
		printf("%d ", binary_search(arr, arr + N, arr2[i]));
	}
	printf("\n");
	return 0;
}