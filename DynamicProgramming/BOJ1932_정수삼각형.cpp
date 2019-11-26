/*1932 ���� �ﰢ�� ����
�ﰢ��������� �Է��� �޾Ƽ�, �Ʒ����� ����������
�ִ� ���� ���ϴ� �����̴�.
dp�� �̿��ϸ� ������ ���� ����*/
#include <iostream>
#include <algorithm>
using namespace std;

int n;
int arr[505][505];
int dp[505][505];

int go(int i, int j) {
	if (i == n - 1) return arr[i][j];
	int &ret = dp[i][j];
	if (ret != 0) return ret;
	ret = arr[i][j] + max(go(i + 1,j), go(i + 1,j + 1));
	return ret;
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i + 1; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	printf("%d\n", go(0, 0));
	return 0;
}