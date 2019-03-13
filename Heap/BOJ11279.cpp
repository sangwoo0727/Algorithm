/*11279 최대힙 */
#include <iostream>
#include <queue>
#include <functional>
using namespace std;
priority_queue <int, vector<int>, less<int>> pq;

int main() {
	int N;
	scanf("%d", &N);
	while (N > 0) {
		int num;
		scanf("%d", &num);
		if (num == 0) {
			if (pq.empty()) printf("0\n");
			else {
				printf("%d\n", pq.top());
				pq.pop();
			}
		}
		else pq.push(num);
		N--;
	}
	return 0;
}
