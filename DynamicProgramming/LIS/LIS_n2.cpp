/*LIS �˰��� -> Longest Increasing Subsequence (���������κм���)
O(n^2)�� O(nlogn) �� ���� ����� �����Ѵ�. 
���� {10, 20, 10, 30, 20, 50}�� �ִٸ� LIS�� 10,20,30,50 �� �ȴ�. 
LIS�� DP�� �̿��� Ǫ�� ��� */

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
				//���� ����
				dp[i] = dp[j] + 1;
			}
		}
		if (max < dp[i]) {
			max = dp[i];
		}
	}
	printf("%d\n", max);
}