/*���� 2631 �ټ���� ����
�� ������ LIS�˰����� ���� ���� Ǯ����.
7���� �ִ� ������ LIS�� ���ϸ� �� �ο� ��ŭ�� ������ ���ִ� ���̹Ƿ�
������ �ο��� �ű�� �Ǵϱ�,
n-LIS(n)�� ���ϸ� ���̴�.*/
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