/*9506 ������� ��
���ٸ� �˰����� ����
n������ ������� ���ϰ� �� ���� n�� ���� ��쿡
������� ������ָ� �ȴ�.
�׸��� ���ѷ����� �ѹ� ������ ��� �迭�� ī��Ʈ�آZ�� ���� �ʱ�ȭ�����ش� 
*/

#include <iostream>
using namespace std;
int arr[100];
int main() {
	int n;
	int cnt = 0;
	int result = 0;
	while (1) {
		scanf("%d", &n);
		if (n == -1)
			break;	
		for (int i = 1; i < n; i++) {
			if (n%i == 0) {
				arr[cnt] = i;
				cnt++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) break;
			result += arr[i];
		}
		if (n == result) {
			printf("%d = ", n);
			for (int i = 0; i < n; i++) {
				if (arr[i] == 0) break;
				if (arr[i + 1] == 0)
					printf("%d", arr[i]);
				else
					printf("%d + ", arr[i]);
			}
			printf("\n");
		}
		if (n != result)
			printf("%d is NOT perfect.\n", n);
		for (int i = 0; arr[i] != 0; i++)
			arr[i] = 0;
		result = 0;
		cnt = 0;
	}
	return 0;
}