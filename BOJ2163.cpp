/* 초콜렛 쪼개기 백준 2163번
이 문제를 풀기 위해 처음 생각해낸 방식(내가 푼 코드)는 
N과 M이 300밖에 되지 않으니
자른 초콜릿 조각들을 재귀로 다시 함수로 들어가서 합을 구해내는 방식이었다.
하지만 다 풀고나서 깨닳은 것이 핵심은 1*1 크기의 초콜릿으로 쪼개는 것이라
어떻게 쪼개든 값은 똑같이 나온다.
그러므로, N과 M을 이용해서 쪼개는 횟수를 식으로 바꾸면,
M-1 + M(N-1) = M*N-1이 된다.
함수를 쓰지않고 그냥 저 식을 만들어 대입만 하면 되는 코드였다*/

#include <iostream>
using namespace std;
int N, M;
int cnt;
int result;

int go(int N, int M) {
	cnt = 0;
	if (N == 1 && M == 1) {
		return 0;
	}
	else if (N == 1 || M == 1) {
		if (N == 1) {
			cnt += M-1;
			result = cnt;
			return result;
		}
		else if (M == 1) {
			cnt += N-1;
			result = cnt;
			return result;
		}
	}
	else {
		result = 1 + go(N, 1) + go(N, M - 1);
		return result;
	}
}
int main() {
	scanf("%d %d", &N, &M);
	printf("%d\n", go(N, M));
	return 0;
}