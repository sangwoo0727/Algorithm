/*11053 ���� �� �����ϴ� �κм��� ����
LIS �����̴�. 2�������� DP�� �̿��ؼ� Ǯ �� �ִ� ������*/
#include <iostream>
#include <algorithm>
using namespace std;

int arr[1050];
int dp[1050];
int N;
int MAX;

int main() {	
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	if (N == 1) { //���� �ȳ����� MAX=0�� ��ȯ�ȴ�
		printf("1\n");
		return 0;
	}
	dp[0] = 1;
	for (int i = 1; i < N; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
				dp[i] = dp[j] + 1;
			}
		}
		MAX = max(dp[i], MAX);
	}
	printf("%d\n", MAX);
	return 0;
}