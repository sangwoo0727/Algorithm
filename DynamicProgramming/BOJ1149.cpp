/*1149 RGB 거리
N번째까지의 최소값을 구하기 위해 N-1번째까지 최소값을 저장해두는
재귀를 생각했다가, 해결이 안되서, 아예 다시 생각하던 중
몇번을 그려보다가, dp[i][j]=최소 dp[i-1][다른 j]+ arr[i][j] 식을 발견했다
여기서 i는 몇번째 집인지이고 j는 0,1,2로 구분하여(빨강,초록,파랑)
0이 선택된 경우는 1 이나 2만 보는 식으로 했다.
3개의 수를 비교하기위해 min을 두번사용했다 맞는 방식인진 모르겠다..
경우의 수를 보다보면, 위의 점화식에 조건이 들어가는데, 
처음부터 최소를 선택해 나가면, 답이 틀린 경우가 있다. (여기서 좀 고생함)
그래서 처음 시작을 0, 1, 2 모든 가지에서 출발하여
나온 답 3개중 최소를 출력하는 식으로 풀었다.*/
#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000][3];
int dp[1000][3];
int N;
int result;

int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 3; j++) {
			scanf("%d", &arr[i][j]);
		}
	}

	dp[0][0] = arr[0][0];
	dp[0][1] = arr[0][1];
	dp[0][2] = arr[0][2];

	for (int i = 1; i < N; i++) {
		for (int j = 0; j < 3; j++) {
			if (j == 0)	dp[i][j] = min(dp[i - 1][1], dp[i - 1][2]) + arr[i][j];
			if (j == 1)	dp[i][j] = min(dp[i - 1][0], dp[i - 1][2]) + arr[i][j];			
			if (j == 2) dp[i][j] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][j];			
		}
	}
	result = min(min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
	printf("%d", result);
	return 0;
}
