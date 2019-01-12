/* 9095번 1,2,3 더하기 문제
11이하의 숫자에 대해 1,2,3의 합으로 나타낼수 있는 가지수를
출력하는 문제,
숫자를 여러개 주어지는 문제여서, dp를 이용해 미리 값을 저장해둘 수 있게
하였고, 
N이 주어졌을 때, 1을 뺀 N-1을 표현할 수 있는 가지수
2를 뺀 N-2를 나타낼수 있는 가지수
3을 뺀 N-3을 나타낼수 있는 가지수를 합하여서 출력하였다.
N은 1부터 11이지만, N이 3일 경우에는 1일때 가지수, 2일때 가지수
3일때 가지수에서 3일때 가지수는 go(0)이 생기므로, N==0 조건을 넣었다.*/

#include <iostream>
using namespace std;

int dp[11];
int check[11];
int arr[11];
int go(int N) {
	if (N == 0) return 1;
	if (N == 1) return 1;
	if (N == 2) return 2;
	if (check[N] !=0)
		return dp[N];
	check[N] = 1;
	for (int i = 1; i <= 3; i++) {
		dp[N] += go(N - i);
	}
	return dp[N];
}


int main() {
	int T;
	
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < T; i++) {
		printf("%d\n", go(arr[i]));
	}
	return 0;
}