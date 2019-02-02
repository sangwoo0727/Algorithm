/*2010 플러그 문제
처음에 1개의 콘센트에 멀티탭을 연결해나간다. 같은 레벨에서 멀티탭을 여러개 사용하진 않고
단계별로 하나의 멀티탭을 연결하되 멀티탭의 플러그 개수는 임의로 나열한다.
멀티탭을 다 연결 후 꽂을 수 있는 플러그의 개수를 출력하는 문제이다.
이 문제는 단순히 첫 멀티탭부터 마지막 멀티탭전까지는 구멍갯수의 -1을 더해나가고
마지막 멀티탭에선 구멍개수를 그냥 더해서 출력하면 끝나는 문제이다.*/

#include <iostream>
using namespace std;

int n;
int ans[500005];
int result;

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &ans[i]);
	}
	for (int i = 0; ans[i] != 0; i++) {
		if (ans[i + 1] == 0) {
			result += ans[i];
			break;
		}
		result += ans[i] - 1;
	}
	printf("%d", result);
	return 0;
}