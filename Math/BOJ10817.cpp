/* ����� ���� 
�Է¹��� 3���� ���߿� 2��°�� ū �� ���
������θ� 6������ �������� if�� ���� ������, 
�� �� 2��°�� ���� ���.
�� �ڵ�� sort�� ����� �Է¹��� 3���� ���� �����ϰ�
�� �� 2��°�� ����Ѵ�.*/

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int arr[3] = {};
	for (int i = 0; i < 3; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr, arr + 3);
	printf("%d\n", arr[1]);
	return 0;
}