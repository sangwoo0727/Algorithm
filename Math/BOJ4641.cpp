/*4641�� 2���������� �ܼ��� Ž���� �ϸ鼭, 
ã���ָ� ������ ����*/
#include <iostream>
#include <cstring>
using namespace std;

int arr[17];

int main() {
	int cnt = 0;
	int k = 0;
	while (1) {
		while (1) {
			scanf("%d", &arr[k]);
			if (arr[k] == 0 || arr[k] == -1) break;
			k++;
		}
		if (arr[k] == -1) break;
		for (int i = 0; arr[i] != 0; i++) {
			for (int j = 0; arr[j] != 0; j++) {				
				if (arr[j] == arr[i] * 2) {
					cnt++;
					break;
				}
			}
		}
		printf("%d\n", cnt);
		cnt = 0;
		k = 0;
		memset(arr, 0, sizeof(arr));
	}
	return 0;
}