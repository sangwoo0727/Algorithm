/*
10797�� 10���� �����ѹ���
������ ���� �ڵ� */
#include <iostream>
using namespace std;

int arr[5];
int num;
int cnt;

int main() {
	scanf("%d", &num);
	for (int i = 0; i<5; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i<5; i++) {
		if (arr[i] == num) cnt++;
	}
	printf("%d\n", cnt);
	return 0;
}