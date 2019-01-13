/* N개의 수에 대해 소수가 몇개인지 찾는 프로그램
N의 갯수가 100이하이기 때문에 2중포문으로 가능하다고 생각
N을 arr배열에 넣은 후 반복문을 돌면서, 1부터 나눠서 나머지가 0일때 카운트를 증가시킨다
카운트가 2인 경우에만(소수인 경우) cnt2를 증가시켜 소수의 개수를 찾아냈다
다른 사람 풀이 중에서도 2중포문보다 시간이 절약되는 코드는 못찾았다.*/

#include <iostream>
using namespace std;

int arr[105];
int cnt1, cnt2;

int main() {
	int N;
	scanf("%d", &N); //100이하의 개수
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}

	for (int i = 0; i < N; i++) {
		for (int j = 1; j <= arr[i]; j++) {
			if (arr[i] % j == 0)
				cnt1++;
		}
		if (cnt1 == 2)
			cnt2++;
		cnt1 = 0;
	}
	printf("%d\n", cnt2);
	return 0;
}