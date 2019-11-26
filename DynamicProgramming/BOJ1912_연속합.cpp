/* 1912�� ������ 
������ �����ϰ�, ���ӵ� ���ڵ��߿� ���� ���� ū �κ��� ã�� ���̴�.
�ݺ����� �̿��� dp�迭�� ���� ���� �� �����ϰ�
���� ū ���� ����ϸ� �Ǵ� ����
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
		if (dp[i - 1] + arr[i] >= arr[i]) // �����ǿ��� �� ����ߴ�. ������ ���� �ٸ��� �����ؼ�
			// dp�� �� �����ϰ�, �ִ밪�� �Ʒ��ʿ��� ����ϴ� �������� Ǯ���
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