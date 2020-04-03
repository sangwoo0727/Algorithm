/*1965 ���ڳֱ� ����
�� ������ LIS ������ �͸� �ľ��ϸ�
������ �����̴�. */

#include <iostream>
#include <algorithm>
using namespace std;

int arr[1005];
int dp[1005];

int main() {
	int n;
	int MAX=0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	dp[0] = 1;
	for (int i = 1; i < n; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && dp[j] + 1 > dp[i])
				dp[i] = dp[j] + 1;
		}
		MAX = max(MAX, dp[i]);
	}
	printf("%d", MAX);
	return 0;
}