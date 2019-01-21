/*14501번. 퇴사문제
그 날에 대하여, 그날에 있는 일을 진행하면 며칠진행하는지와 그에대한 돈이 지급된다.
그 일을 할지 말지, 선택해서 지급되는 총액중 최대를 구하는 문제,
N이 15까지이므로, 단순히 그 일을 선택할지 안할지에 따라 재귀로 들어가서 풀었다.*/
#include <iostream>
#include <utility>
#include <algorithm>
using namespace std;
int N;
int result = 0;
int MAX = 0;
pair <int, int> p[20];
void go(int idx, int result) {
	MAX = max(MAX, result);
	if (idx == N + 1) return;
	if (idx + p[idx].first <= N + 1)
		go(idx + p[idx].first, result + p[idx].second);
	if (idx + 1 <= N + 1)
		go(idx + 1, result);
}

int main() {
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		scanf("%d%d", &p[i].first, &p[i].second); //p.first => Ti  p.second => Pi
	}
	go(1, 0);
	printf("%d\n", MAX);
	return 0;
}
