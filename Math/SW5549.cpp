/*SW 5549 Ȧ���ϱ� ¦���ϱ�
���̰� 100���� �����ϱ⶧����
long long�� �����ʰ�, ���ڿ��� �Է¹޾ƾ��Ѵ�.
strlen �� ���� ���ڿ� ���� ����*/
#include <iostream>
#include <cstring>

char arr[105];
int main() {
	int t;
	int num;
	scanf("%d", &t);
	for (int i = 1; i <= t; i++) {
		scanf("%s", arr);
		num = strlen(arr);
		if (arr[num - 1] % 2 == 0) printf("#%d Even\n", i);
		else printf("#%d Odd\n", i);
		memset(arr, 0, sizeof(arr));
	}
	return 0;
}