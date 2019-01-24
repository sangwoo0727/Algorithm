/*9506 약수들의 합
별다른 알고리즘은 없이
n까지중 약수들을 구하고 그 합이 n과 같은 경우에
약수들을 출력해주면 된다.
그리고 무한루프가 한번 끝나면 모든 배열과 카운트해줫던 값을 초기화시켜준다 
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