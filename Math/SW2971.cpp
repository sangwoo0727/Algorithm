/*SW2971 ��հ� ���ϱ�
10�� �� �� ����� 1���ڸ����� �ݿø��� ������ ���ϴ� ����
�������� 5���� ũ�ų� ���� ����
���� +1�� ���ؼ� ���*/
#include <iostream>
using namespace std;

int arr[10];
int T;
int result;
int ans;
int main() {
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		for (int i = 0; i < 10; i++) {
			scanf("%d", &arr[i]);
			result += arr[i];
		}
		ans = double(result / 10);
		if (result % 10 >= 5) ans++;
		printf("#%d %d\n", t, ans);
		result = 0;
		ans = 0;
	}

	return 0;
}