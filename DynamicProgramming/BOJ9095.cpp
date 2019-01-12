/* 9095�� 1,2,3 ���ϱ� ����
11������ ���ڿ� ���� 1,2,3�� ������ ��Ÿ���� �ִ� ��������
����ϴ� ����,
���ڸ� ������ �־����� ��������, dp�� �̿��� �̸� ���� �����ص� �� �ְ�
�Ͽ���, 
N�� �־����� ��, 1�� �� N-1�� ǥ���� �� �ִ� ������
2�� �� N-2�� ��Ÿ���� �ִ� ������
3�� �� N-3�� ��Ÿ���� �ִ� �������� ���Ͽ��� ����Ͽ���.
N�� 1���� 11������, N�� 3�� ��쿡�� 1�϶� ������, 2�϶� ������
3�϶� ���������� 3�϶� �������� go(0)�� ����Ƿ�, N==0 ������ �־���.*/

#include <iostream>
using namespace std;

int dp[11];
int check[11];
int arr[11];
int go(int N) {
	if (N == 0) return 1;
	if (N == 1) return 1;
	if (N == 2) return 2;
	if (check[N] !=0)
		return dp[N];
	check[N] = 1;
	for (int i = 1; i <= 3; i++) {
		dp[N] += go(N - i);
	}
	return dp[N];
}


int main() {
	int T;
	
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < T; i++) {
		printf("%d\n", go(arr[i]));
	}
	return 0;
}