/*11055번 가장 큰 증가 부분 수열 문제
가장 길이가 긴 증가 부분 수열 문제 에서 +1대신
arr[i]값을 넣으면 된다.*/

#include <iostream>
#include <algorithm>
using namespace std;

int N;
int arr[1050];
int dp[1050];
int MAX;

int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) 
		scanf("%d", &arr[i]);
	if (N == 1) {
		printf("%d\n", arr[0]);
		return 0;
	}
	
	for (int i = 0; i < N; i++) {
		dp[i] = arr[i];
		for (int j = 0; j < N; j++) {
			if (arr[i] > arr[j] && dp[j] + arr[i] > dp[i]) {
				dp[i] = dp[j] + arr[i];
			}
		}
		MAX = max(MAX, dp[i]);
	}
	printf("%d\n", MAX);
	return 0;
}