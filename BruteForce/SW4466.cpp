/*SW4466 �ִ뼺��ǥ �����
���� Ǭ ��繮���� �����̰��ٰ� �����ϰ�
���Ƿ� Ǯ��� ������ ġ�ٰ�
���Ľ��Ѽ� �ڿ� k����ŭ ������ �����ٴ� ������ ����
�ٷ� Ǯ����.*/
#include <iostream>
#include <algorithm>
using namespace std;

int arr[100]; 
int T;
int N, K;
int result;

int main() {	
	scanf("%d", &T);
	for (int i = 1; i <= T; i++) {
		scanf("%d %d", &N, &K);
		for (int j = 0; j < N; j++) {
			scanf("%d", &arr[j]);
		}
		sort(arr, arr + N);
		for (int j = 0; j < K;j++) {
			result += arr[N - 1 - j];
		}
		printf("#%d %d\n", i, result);
		result = 0;
	}

	return 0;
}