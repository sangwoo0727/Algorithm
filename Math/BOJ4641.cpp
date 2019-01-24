/*4641번 2중포문으로 단순히 탐색을 하면서, 
찾아주면 끝나는 문제*/
#include <iostream>
#include <cstring>
using namespace std;

int arr[17];

int main() {
	int cnt = 0;
	int k = 0;
	while (1) {
		while (1) {
			scanf("%d", &arr[k]);
			if (arr[k] == 0 || arr[k] == -1) break;
			k++;
		}
		if (arr[k] == -1) break;
		for (int i = 0; arr[i] != 0; i++) {
			for (int j = 0; arr[j] != 0; j++) {				
				if (arr[j] == arr[i] * 2) {
					cnt++;
					break;
				}
			}
		}
		printf("%d\n", cnt);
		cnt = 0;
		k = 0;
		memset(arr, 0, sizeof(arr));
	}
	return 0;
}