/*14501��. ��繮��
�� ���� ���Ͽ�, �׳��� �ִ� ���� �����ϸ� ��ĥ�����ϴ����� �׿����� ���� ���޵ȴ�.
�� ���� ���� ����, �����ؼ� ���޵Ǵ� �Ѿ��� �ִ븦 ���ϴ� ����,
N�� 15�����̹Ƿ�, �ܼ��� �� ���� �������� �������� ���� ��ͷ� ���� Ǯ����.*/
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
