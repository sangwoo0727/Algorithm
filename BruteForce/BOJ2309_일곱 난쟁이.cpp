/*�ϰ������� ����
9���� �ϰ��������� ���� Ű�� 100�� 7���� ã�� ������������ �����ϴ� ����
������ ��Ų ��, ��� ���� ���� �ݺ����� ���� 2���� ���� ���� 100�̵Ǹ�
�� �θ��� ���ܽ�Ų �� ������� ����ߴ�.*/
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int arr[9] = {};
	int result = 0;
	int a, b = 0;
	for (int i = 0; i < 9; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr, arr + 9);
	for (int i = 0; i < 9; i++) {
		result += arr[i];
	}
	
	for (int i = 0; i < 8; i++) {
		for (int j = i+1; j < 9; j++) {
			if (result - arr[i] - arr[j] == 100) {
				a = i;
				b = j;
				break;
			}
		}
	}
	for (int i = 0; i < 9; i++) {
		if (i == a || i == b)
			continue;
		printf("%d\n", arr[i]);
	}
	return 0;
}