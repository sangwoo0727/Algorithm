/*9372번 상근이의 여행
이 문제는 bfs로 생각하고 풀었다가 해결을 하지 못하고,
알아보던 중 최소 스패닝 트리라는 것을 알게되었고 
단순히 국가의 개수 -1이 답이라는 단순한 코드였다..
최소스패닝 트리에 대해서는 추후에 정리해서 올리겠다.*/
#include <iostream>
using namespace std;

int T;
int N, M;
int a, b;
int main() {
	scanf("%d", &T);
	for (int t = 0; t < T; t++) {
		scanf("%d%d", &N, &M);
		for (int i = 0; i < M; i++) {
			scanf("%d%d", &a, &b);
		}
		printf("%d\n", N - 1);
	}
	return 0;
}