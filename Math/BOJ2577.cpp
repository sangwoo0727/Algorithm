/*2577 ������ ���� ����
���� ����� ���� ���� ���ڸ����� ���ڸ� ���� ����ϸ� �Ǵ� ��������. */
#include <iostream>
using namespace std;

int result;
int a, b, c;
int cnt[11];

int main() {
	scanf("%d%d%d", &a, &b, &c);
	result = a * b * c;
	for (int i = 1; result>=0; i++) {
		cnt[result % 10]++;
		result = result / 10;
		if (result == 0) break;
	}
	for (int i = 0; i < 10; i++) {
		printf("%d\n", cnt[i]);
	}
	return 0;
}