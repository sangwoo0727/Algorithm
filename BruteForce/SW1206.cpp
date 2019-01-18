/* SW1206 view 문제
왼쪽 오른쪽으로 조망권이 2이상 있는 세대수의 개수 출력하는 문제
나는 조건을 vert[i] 기준으로 vert[i]가 vert[i-1] [i-2] [i+1] [i+2] 보다 클경우
vert[i]-vert[i-1] , -[i-2] , -[i+1] ,-[i+2] 를 다 계산해서 
그중 가장 작은 값을 더해주는 식으로 문제를 풀었다.*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int horiz = 0;
	int vert[1000] = {};

	for (int T = 1; T <= 10; T++) {
		int cnt = 0;
		scanf("%d", &horiz);
		for (int i = 0; i < horiz; i++) {
			scanf("%d", &vert[i]);
		}
		for (int i = 2; i < horiz-1; i++) {
			if (vert[i] == 0)
				continue;
			else if (vert[i] > vert[i - 1] && vert[i] > vert[i - 2] && vert[i] > vert[i + 1] && vert[i] > vert[i + 2])
				cnt += min(min(min(vert[i] - vert[i - 1], vert[i] - vert[i - 2]), vert[i] - vert[i + 1]), vert[i] - vert[i + 2]);
			else
				continue;
		}
		printf("#%d %d\n", T, cnt);
	}
	return 0;
}