/*10815�� ����Ž�������ε�,
0�� 1�� ���ڰ��ִ��� ������ ��ȯ�ϴ°Ŷ�
�׳� ����Ž�� stl�� �ذ��ߴ�.*/

#include <iostream>
#include <algorithm>
using namespace std;

int arr[500001];  //���������� ���� �޸𸮰� ���ÿ����� ���̰�,
//���������� ���� �޸𸮰� �������� ���δ�. �迭�� ũ�Լ����� ���
//���������� ���� ���ÿ����� ����� ������.. �����÷�..
int arr2[500001];
int main() {	
	int N, M;
	
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		scanf("%d", &arr2[i]);
	}
	sort(arr, arr + N);

	for (int i = 0; i < M; i++) {
		printf("%d ", binary_search(arr, arr + N, arr2[i]));
	}
	printf("\n");
	return 0;
}