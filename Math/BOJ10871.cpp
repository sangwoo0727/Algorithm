/*10871�� x���� ���� ��
������ ��ǥ ���� x�� �־�����
x���� ���� ���鸸 �Է¹޴� ������� ����ϴ� �ܼ��� ����*/

#include <iostream>
using namespace std;

int arr[10002];
int n,x;
int main() {
	scanf("%d%d", &n, &x);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < n; i++) {
		if (arr[i] >= x) continue;
		printf("%d ", arr[i]);
	}
	printf("\n");
	return 0;
}