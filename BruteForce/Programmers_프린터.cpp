#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <functional>
using namespace std;

int solution(vector<int> priorities, int location) {
	int answer = 0;
	priority_queue <int, vector<int>, less<int>> pq;
	for (int i = 0; i < priorities.size(); i++) {
		pq.push(priorities[i]);
	}
	while (priorities.size()) {
		if (priorities[0] < pq.top()) {
			int num = priorities[0];
			priorities.push_back(num);
			priorities.erase(priorities.begin());
			if (location == 0) {
				location = priorities.size() - 1;
			}
			else location--;
		}
		else if (priorities[0] == pq.top()) {
			if (location == 0) {
				priorities.erase(priorities.begin());
				answer++;
				break;
			}
			answer++;
			location--;
			priorities.erase(priorities.begin());
			pq.pop();
		}
	}
	return answer;
}