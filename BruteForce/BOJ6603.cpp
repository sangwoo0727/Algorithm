#include <iostream>
using namespace std;
int k;
int arr[15];
int ans[6];

void lotto(int start, int idx) {
	int i;
	if (idx == 6) {
		for (i = 0; i < 6; i++) {
			printf("%d ", ans[i]);
		}
		printf("\n");
		return;
	}
	for (i = start; i < k; i++) {
		ans[idx] = arr[i];
		lotto(i + 1, idx + 1);
	}
}
int main() {
	while (1) {
		scanf("%d", &k);
		if (k == 0) break;
		for (int i = 0; i < k; i++) {
			scanf("%d", &arr[i]);
		}
		lotto(0, 0);
		printf("\n");
	}
	return 0;
}