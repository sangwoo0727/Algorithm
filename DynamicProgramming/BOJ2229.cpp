/* 2229�� ��¥�� ����
dp ��ȭ���� �����µ�, ������ ��ư� �ߴ�...
�ٸ� �е��� max,min�� �迭�� �ȸ����,
dp�� 1�������� �ϼ̴�.
�ϴ� �̹����� ���̵� ���ø��� ȥ�� �ذ��ѰͿ� �����ϰ�
�Ƿ��� ���� �� �÷��� Ǯ�����Ѵ�.
*/
#include <iostream>
#include <algorithm>
using namespace std;

int N;
int dp[1005][1005];
int arr[1005];
int MAX[1005][1005];
int Min[1005][1005];
int first;
int result;
int main() {
	for (int i = 0; i <= 1005; i++) {
		for (int j = 0; j <= 1005; j++) {
			Min[i][j] = 10005;
		}
	}
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 1; i <= N; i++) {
		for (int j = i; j <= N; j++) {
			MAX[i][j] = max(MAX[i][j-1], arr[j]);
			Min[i][j] = min(Min[i][j-1], arr[j]);
		}
	}
	dp[0][0] = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j < i; j++) {
			first = max(first, dp[j][i-1]);
		}
		for (int j = i; j <= N; j++) {
			dp[i][j] = first + (MAX[i][j] - Min[i][j]);
		}
		first = 0;
	}
	for (int i = 1; i <= N; i++) {
		result = max(result, dp[i][N]);
	}
	printf("%d", result);
	return 0;
}