/*백준 2631 줄세우기 문제
이 문제는 LIS알고리즘을 쓰면 쉽게 풀린다.
7명이 있다 쳤을때 LIS를 구하면 그 인원 만큼은 정렬이 되있는 것이므로
나머지 인원만 옮기면 되니깐,
n-LIS(n)을 구하면 답이다.*/
#include <iostream>
#include <algorithm>
using namespace std;

int arr[200];
int dp[200];
int MAX;

int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);
	dp[0] = 1;
	for (int i = 1; i < n; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
				dp[i] = dp[j] + 1;
			}
		}
		MAX = max(MAX, dp[i]);
	}
	printf("%d\n", n - MAX);
	return 0;
}