/*BOJ 2858 ����� �ٴڹ��� 
�� ������ ��ȭ���� ������ Ǯ��ȴ�. 
Ǯ�̴� �پ��� �Ͱ���*/
#include <iostream>
using namespace std;

int main() {
	int R, B;
	int L, W;
	int sum = 0;
	scanf("%d %d", &R, &B);
	sum = R + B;
	for(int W = 3; W < 5000; W++) {
		L = (sum - B + 4 )/2 - W;
		if (W > L) break;
		if (L*W != sum) continue;
		if (L*W == sum) {
			printf("%d %d", L, W);
			break;
		}
	}
	return 0;
}