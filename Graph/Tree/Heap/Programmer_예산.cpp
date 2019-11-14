#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int solution(vector<int> d, int budget) {
	priority_queue <int, vector<int>, less<int>> pq;
	int answer = d.size();
	int total = 0;
	for (const auto& n : d) {
		total += n;
		pq.push(n);
	}
	if (budget < total) {
		while (1) {
			int tmp = pq.top();
			if (total - tmp > budget) {
				pq.pop();
				total -= tmp;
				answer--;
			}
			else {
				answer--;
				break;
			}
		}
	}
	return answer;
}