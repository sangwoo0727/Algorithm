/*SW 6730 ��ֹ� ���� ���̵�
���� ����� ���ٸ� downup����
���� ����� ���ٸ� updown���� �����ؼ�
�� ������ ���� ū ���� �����ؼ� ����ϸ�ȴ�.*/
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int t, n;
	int arr[105];
	int updown=0, downup=0;
	scanf("%d", &t);
	for (int i = 1; i <= t; i++) {
		scanf("%d", &n);
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[j]);
		}
		for (int j = 0; j < n-1; j++) {
			if (arr[j] > arr[j + 1]) updown=max(updown , arr[j] - arr[j + 1]);
			else if (arr[j] <= arr[j + 1]) downup = max(downup,arr[j + 1] - arr[j]);
		}
		printf("#%d %d %d\n", i, downup, updown);
		downup = 0; updown = 0;
	}
	return 0;
}