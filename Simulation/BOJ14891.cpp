/*14891 ��Ϲ���
�ùķ��̼� �����ε�, ���ÿ� ���ư��� ������ �����ϱⰡ �������.
https://www.acmicpc.net/problem/14891
*/
#include <iostream>
#include <cstring>
using namespace std;

int arr[4][8];
int k;
int num, dir;
int dir_arr[4];
int main() {
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 8; j++) {
			scanf("%1d", &arr[i][j]);
		}
	}
	scanf("%d", &k);
	while (k--) {
		scanf("%d%d", &num, &dir);
		num = num - 1;
		dir_arr[num] = dir;
		for (int i = num - 1; i >= 0; i--) { //���ʹ���
			if (arr[i][2] != arr[i + 1][6]) dir_arr[i] = -dir_arr[i + 1];
			else break;
		}
		for (int i = num + 1; i < 4; i++) { //�����ʹ���
			if (arr[i][6] != arr[i - 1][2]) dir_arr[i] = -dir_arr[i - 1];
			else break;
		}
		for (int i = 0; i < 4; i++) {
			if (dir_arr[i] == 0) continue;
			if (dir_arr[i] == 1) { //�ð���� ȸ��
				int tmp = arr[i][7];
				for (int j = 7; j >= 1; j--) {
					arr[i][j] = arr[i][j - 1];
				}
				arr[i][0] = tmp;
			}
			else if (dir_arr[i] = -1) {//�ð� �ݴ����
				int tmp = arr[i][0];
				for (int j = 0; j < 7; j++) {
					arr[i][j] = arr[i][j + 1];
				}
				arr[i][7] = tmp;
			}
		}
		memset(dir_arr, 0, sizeof(dir_arr));
	}
	int result = 0;
	int sum = 1;
	for (int i = 0; i < 4; i++) {
		if (arr[i][0] == 1) result += sum;
		sum = sum * 2;
	}
	printf("%d", result);
	return 0;
}