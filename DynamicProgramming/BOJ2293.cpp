/* 2293 동전 문제
이 문제는 주어진 동전 값어치를 가지고 k원을 만들수 있는
가지수를 출력하는 문제인데, 순서가 다른 경우도 같은 경우로 친다
재귀는 불가능할 듯 해서, 반복문을 이용해 처음엔 dp 2차원 배열을 채워나갔다.
i는 코인을 몇개쓸건지, j는 j원을 만들 수 있는 가지수, 
점화식을 j가 coin[i]보다 작은 경우와, 크거나 같은 경우로 나눠서 세워서 풀었는데
메모리 초과가 나서
dp배열을 1차원으로 다시 만들어서 풀었다. 조건은 아래 코드를 보면됨*/

#include <iostream>
using namespace std;

int n;
int k;
int dp[10001];
int coin[100];

int main() {
	scanf("%d%d", &n, &k);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &coin[i]);
	}
	dp[0] = 1;
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= k; j++) {
			if (j >= coin[i]) dp[j] += dp[j - coin[i]];
			else dp[j] = dp[j];
		}
	}
	printf("%d\n", dp[k]);
	return 0;
}
