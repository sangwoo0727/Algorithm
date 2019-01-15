/* 1182 �κ������� ���� S�� �Ǵ� ��� �κ������� ������ ����ϴ� ����
ó���� �κ������� ���� ���ϱ� ���� 2�� for������ ���̴� ����� �ߴµ�
������ �ذ�å�� �ȳ��ͼ� ó������ �ٽ� �����ؼ�,
�ܼ��ϰ� ��͸� ����, i��° �迭 ���� �����ϴ� �� ���ϴ��� �� ������ 
��͸� ������ �ذ��ߴ�.*/

#include <iostream>
using namespace std;

int N;
int S;
int arr[20];
int cnt;

void go(int i, int sum) {
	sum += arr[i];
	if (i >= N) //�������� i�� N�� ���ų� �� Ŀ����, ����
		return;
	if (sum == S) { // sum�� S�� �������� cnt�� ����
		cnt++;
	}
	go(i + 1, sum - arr[i]); // arr[i]�� ���ԵǴ� ���
	go(i + 1, sum); //���Ե��� �ʴ� ���
	return;
}

int main() {
		
	scanf("%d %d", &N, &S);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	go(0, 0); //0��° �ε���, ���� 0�� ������ ����
	printf("%d\n", cnt);
	return 0;
}