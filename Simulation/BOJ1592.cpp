/*1592�� �����̿� ģ����
https://www.acmicpc.net/problem/1592
��ȭ������ �ذ��ߴ�*/
#include <iostream>
using namespace std;

int N, M, L;
int arr[1005];
int cnt;

int main() {
	scanf("%d%d%d", &N, &M, &L);
	int i=0;
	while (1) {
		arr[i]++;
		if (arr[i] == M) break;
		if (arr[i] % 2 == 1) {
			i = (i + N - L) % N;
			cnt++;
		}
		else {
			i = (i + L) % N;
			cnt++;
		}
	}
	printf("%d", cnt);
	return 0;
}