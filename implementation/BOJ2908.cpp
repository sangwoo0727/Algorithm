/*���� 2908 ���
3�ڸ� �� �ΰ��� �Է¹ް� �� ���� ����� �� ū ���ڸ� ����ϴ� ����*/

#include <iostream>
#include <algorithm>
using namespace std;

int arra[3];
int arrb[3];
int main() {
	int a, b;
	scanf("%d%d", &a, &b);
	for (int i = 0; i < 3 ; i++) {
		arra[i] = a % 10;
		arrb[i] = b % 10;
		a = a / 10;
		b = b / 10;
	}
	for (int i = 0; i < 3; i++) {
		if (arra[i] > arrb[i]) {
			for (int j = 0; j < 3; j++) {
				printf("%d", arra[j]);
			}
			break;
		}
		else if (arra[i] < arrb[i]) {
			for (int j = 0; j < 3; j++) {
				printf("%d", arrb[j]);
			}
			break;
		}
		else continue;
	}
	return 0;
}