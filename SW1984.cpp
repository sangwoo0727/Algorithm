/*SW 1984 ��հ� ���ϱ�
10���� ���� �Է¹޾Ƽ� �ּҰ��� �ִ��� �� �������� ����� ���ϴ�
�ܼ��� ����.
������ �̸����� �ݿø������ؼ� �� �ָ� �Ծ���...:( */

#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

int main() {
	int T=0;
	int arr[10] = {};
	double sum = 0;
	int result;
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		for (int j = 0; j < 10; j++) {
			scanf("%d", &arr[j]);
		}
		sort(arr, arr + 10);
		for (int j = 1; j < 9; j++) {
			sum += arr[j];
		}
		result = floor((sum / 8)+0.5);  //������ �Ҽ� ù°�ڸ����� �ݿø��� ���� ����� �Ǿ��ִ�.
		/* sum�� �Ǽ������� �޾Ƽ� 8�� ���������� �Ǽ����� �ǵ��� �Ѵ�. �� �� 0.5�� ���ؼ� floor �Լ��� ����, 
		(floor�Լ��� ���� �Լ�)
		�ݿø��� ���� ���´�. �װ��� int���� result�� ������, ���������� ���� ǥ���ȴ�.*/
		printf("#%d %d\n", i + 1, result);
		sum = 0;
		result = 0;
	}
	return 0;
}