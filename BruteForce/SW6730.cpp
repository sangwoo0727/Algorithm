/*SW 6730 장애물 경주 난이도
다음 계단이 높다면 downup으로
다음 계단이 낮다면 updown으로 저장해서
두 변수에 가장 큰 값을 저장해서 출력하면된다.*/
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int t, n;
	int arr[105];
	int updown=0, downup=0;
	scanf("%d", &t);
	for (int i = 1; i <= t; i++) {
		scanf("%d", &n);
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[j]);
		}
		for (int j = 0; j < n-1; j++) {
			if (arr[j] > arr[j + 1]) updown=max(updown , arr[j] - arr[j + 1]);
			else if (arr[j] <= arr[j + 1]) downup = max(downup,arr[j + 1] - arr[j]);
		}
		printf("#%d %d %d\n", i, downup, updown);
		downup = 0; updown = 0;
	}
	return 0;
}