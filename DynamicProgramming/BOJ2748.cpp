/*2748 �Ǻ���ġ2
�Ǻ���ġ 1������ n�� 45�������� �̴� int��ȯ�� �������� �ذ��� �� �ִ� ���� ũ�⿴�µ�
�� ������ ��ȯ���� �÷��ߵǴ°� ����Ʈ�� ������ �Ͱ���. 
long long�� ���� �ذ�*/
#include <iostream>
using namespace std;

long long dp[100];
int n;

long long go(int num) {
	if (num == 0) return 0;
	if (num == 1) return 1;
	long long &ret = dp[num];
	if (ret != 0) return ret;
	ret = go(num - 1) + go(num - 2);
	return ret;
}
int main() {
	scanf("%d", &n);
	printf("%lld", go(n));
	return 0;
}