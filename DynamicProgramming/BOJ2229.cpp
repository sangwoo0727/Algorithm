/* 2229번 조짜기 문제
dp 점화식은 세웠는데, 구현을 어렵게 했다...
다른 분들은 max,min도 배열로 안만들고,
dp도 1차원으로 하셨다.
일단 이문제에 아이디어를 떠올리고 혼자 해결한것에 만족하고
실력을 조금 더 올려서 풀어보기로한다.
*/
#include <iostream>
#include <algorithm>
using namespace std;

int N;
int dp[1005][1005];
int arr[1005];
int MAX[1005][1005];
int Min[1005][1005];
int first;
int result;
int main() {
	for (int i = 0; i <= 1005; i++) {
		for (int j = 0; j <= 1005; j++) {
			Min[i][j] = 10005;
		}
	}
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 1; i <= N; i++) {
		for (int j = i; j <= N; j++) {
			MAX[i][j] = max(MAX[i][j-1], arr[j]);
			Min[i][j] = min(Min[i][j-1], arr[j]);
		}
	}
	dp[0][0] = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j < i; j++) {
			first = max(first, dp[j][i-1]);
		}
		for (int j = i; j <= N; j++) {
			dp[i][j] = first + (MAX[i][j] - Min[i][j]);
		}
		first = 0;
	}
	for (int i = 1; i <= N; i++) {
		result = max(result, dp[i][N]);
	}
	printf("%d", result);
	return 0;
}