/*LIS 알고리즘 -> Longest Increasing Subsequence (최장증가부분순열)
O(n^2)과 O(nlogn) 두 가지 방식이 존재한다. 
가령 {10, 20, 10, 30, 20, 50}이 있다면 LIS는 10,20,30,50 이 된다. 
LIS를 DP를 이용해 푸는 방식 */

#include <iostream>
using namespace std;

int arr[50];
int dp[50];

int main() {
	int N;
	scanf("%d", &N);
	int max = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	dp[0] = 1;
	for (int i = 1; i < N; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
				//증가 수열
				dp[i] = dp[j] + 1;
			}
		}
		if (max < dp[i]) {
			max = dp[i];
		}
	}
	printf("%d\n", max);
}
