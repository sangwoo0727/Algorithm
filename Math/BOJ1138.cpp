/*1138 ���ٷ� ���� ����
üũ�迭�� ����, ī��Ʈ�� �����ϸ鼭
0�� ������ ���ش�. 0�� ������ �ڱ⺸�� ū����� ����ִ��� ���� �ͺ���
Ŀ���� ����, üũ�迭�� arr�� idx��ȣ�� �����Ѵ�
�������� üũ�迭�� ����ϸ� �ȴ�.*/
#include <iostream>
using namespace std;

int n;
int arr[11];
int check[11];
int main() {
	int cnt = 0;
	int j = 1;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 1; i <= n; i++) {
		while(1){
			if (check[j] == 0) cnt++;
			if (cnt > arr[i]) {
				check[j] = i;
				break;
			}
			j++;
		}
		j = 1;
		cnt = 0;
	}
	for (int i = 1; i <= n; i++) {
		printf("%d ", check[i]);
	}
	return 0;
}