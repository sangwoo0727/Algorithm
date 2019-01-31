/*4811번 알약문제
진짜 처음엔 w는 항상 맨앞에 나와야하고, h는 맨뒤에 항상 한개 나와야되는
생각을 하면서, n이 작아지면서 도는 재귀를 생각했는데
도저히 안나와서 아예 다른 식으로 전환했다
함수를 들어갈때 w엔 처음 n개의 온전한 알약 , h는 0개니깐
go(n,0)으로 들어가서 한알짜리 약을 반으로쪼갤때의 경우와 반알짜리 약을 그대로 꺼내
먹을때의 경우의 수로 나눠서 재귀를 들어갔다. */

#include <iostream>
#include <cstring>
using namespace std;

int n;
long long dp[1005][1005];

long long go(int w, int h) {	
	long long &ret = dp[w][h];
	if (ret != 0) return ret;
	if (w == 0 && h == 0) return 1;
	if (w != 0) ret += go(w - 1, h + 1);
	if (h != 0) ret += go(w, h - 1);
	return ret;
}
int main() {
	while (1) {
		scanf("%d", &n);
		if (n == 0) break;
		printf("%lld\n", go(n, 0));
		memset(dp, 0, sizeof(dp));
	}
	return 0;
}