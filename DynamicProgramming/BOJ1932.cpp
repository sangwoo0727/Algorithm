/*1932 정수 삼각형 문제
삼각형모양으로 입력을 받아서, 아래까지 내려갔을때
최대 합을 구하는 문제이다.
dp를 이용하면 간단히 구현 가능*/
#include <iostream>
#include <algorithm>
using namespace std;

int n;
int arr[505][505];
int dp[505][505];

int go(int i, int j) {
	if (i == n - 1) return arr[i][j];
	int &ret = dp[i][j];
	if (ret != 0) return ret;
	ret = arr[i][j] + max(go(i + 1,j), go(i + 1,j + 1));
	return ret;
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i + 1; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	printf("%d\n", go(0, 0));
	return 0;
}