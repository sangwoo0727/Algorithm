/* 1110�� ���ϱ� ����Ŭ 
�ڸ����� 2���� ������ ó�� n�� a�� b�� �����صΰ�,
�ڸ����� �̵��ϴ� ��Ŀ� ���� a ,b�� ���ؼ� ���� ��� 
������ Ż���ϴ� ������ �������
//
�������� �迭���� �����ؼ� ���������� �ʹ� �����ߴ�.
�ٸ� ��� Ǯ�� ���ϱ� a,b,c�� �����ؼ� ��������
a=b b=c�� ���ָ� ������ ����..*/

#include <iostream>
using namespace std;

int n;
int a,b;
int arr[2],arr2[2];
int result;
int cnt;

int main() {
	scanf("%d", &n);
	a = n / 10;
	b = n % 10;
	arr[1] = a;
	arr[0] = b;

	while (1) {
		result = arr[1] + arr[0];
		arr2[1] = result / 10;
		arr2[0] = result % 10;
		arr[1] = arr[0];
		arr[0] = arr2[0];
		cnt++;
		if (a == arr[1] && b == arr[0])
			break;
	}
	printf("%d\n", cnt);
	return 0;
}