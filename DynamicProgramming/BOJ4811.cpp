/*4811�� �˾๮��
��¥ ó���� w�� �׻� �Ǿտ� ���;��ϰ�, h�� �ǵڿ� �׻� �Ѱ� ���;ߵǴ�
������ �ϸ鼭, n�� �۾����鼭 ���� ��͸� �����ߴµ�
������ �ȳ��ͼ� �ƿ� �ٸ� ������ ��ȯ�ߴ�
�Լ��� ���� w�� ó�� n���� ������ �˾� , h�� 0���ϱ�
go(n,0)���� ���� �Ѿ�¥�� ���� �������ɰ����� ���� �ݾ�¥�� ���� �״�� ����
�������� ����� ���� ������ ��͸� ����. */

#include <iostream>
#include <cstring>
using namespace std;

int n;
long long dp[1005][1005];

long long go(int w, int h) {	
	long long &ret = dp[w][h];
	if (ret != 0) return ret;
	if (w == 0 && h == 0) return 1;
	if (w != 0) ret += go(w - 1, h + 1);
	if (h != 0) ret += go(w, h - 1);
	return ret;
}
int main() {
	while (1) {
		scanf("%d", &n);
		if (n == 0) break;
		printf("%lld\n", go(n, 0));
		memset(dp, 0, sizeof(dp));
	}
	return 0;
}