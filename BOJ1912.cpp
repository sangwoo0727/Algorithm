/* 1912번 연속합 
수열을 나열하고, 연속된 숫자들중에 합이 가장 큰 부분을 찾는 것이다.
반복문을 이용한 dp배열을 통해 값을 다 저장하고
가장 큰 수를 출력하면 되는 문제
*/
#include <iostream>
using namespace std;

int main() {
	int dp[100010] = {};
	int arr[100010] = {};
	int n, max = 0;
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	dp[0] = arr[0];
	for (int i = 1; i < n; i++) {
		if (dp[i - 1] + arr[i] >= arr[i]) // 이조건에서 좀 고생했다. 관점을 조금 다르게 생각해서
			// dp를 다 저장하고, 최대값을 아래쪽에서 출력하는 방향으로 풀면됨
			dp[i] = dp[i - 1] + arr[i];
		else
			dp[i] = arr[i];
	}
	max = dp[0];
	for (int i = 1; i < n; i++) {
		if (max <= dp[i])
			max = dp[i];
	}

	printf("%d\n", max);
	return 0;
}