/*4504 ���ã��
���ã�� �⺻����*/
#include <iostream>
using namespace std;

int main() {
	int n, k;
	scanf("%d", &n);
	while (1) {
		scanf("%d", &k);
		if (k == 0) return 0;
		if (k%n == 0)
			printf("%d is a multiple of %d.\n", k, n);
		if (k%n != 0)
			printf("%d is NOT a multiple of %d.\n", k, n);
	}
	return 0;
}