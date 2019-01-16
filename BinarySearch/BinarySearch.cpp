/*����Ž��*/

#include <iostream>
using namespace std;

int BSearch(int arr[], int len, int target) { //arr[] == *arr
	int first = 0; // Ž�� ����� ���� �ε��� ��
	int last = len - 1; //Ž�� ����� ������ �ε��� ��
	int mid;

	while (first <= last) {
		mid = (first + last) / 2;
		if (target == arr[mid]) return mid;
		else {
			if (target < arr[mid]) last = mid - 1;
			else first = mid + 1;
		}
	}
	return -1; // Ž�� �������� ��� ��ȯ�Ǵ� ��
}

int main() {
	int arr[] = { 1,3,5,7,9 };
	int idx;

	idx = BSearch(arr, sizeof(arr) / sizeof(int), 7);  //7 ã������ ����Ž��
	if (idx == -1) printf("Ž������\n");
	else printf("Ÿ�� ���� �ε���: %d\n", idx);

	idx = BSearch(arr, sizeof(arr) / sizeof(int), 4); //4 ã������ ����Ž��
	if (idx == -1) printf("Ž������\n");
	else printf("Ÿ�� ���� �ε���: %d\n", idx);

	return 0;
}
