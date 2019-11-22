#include <iostream>
#include <queue>
#include <vector>
#include <functional>
using namespace std;

priority_queue <int, vector<int>, greater<int>> pq;

void pqInsert(vector <int>& v) {
	for (int i = 0; i < v.size(); i++) {
		pq.push(v[i]);
	}
}

int pqPop() {
	int minData = pq.top();
	pq.pop();
	return minData;
}

int mixFood(int f, int s) {
	return f + 2 * s;
}

int solution(vector<int> scoville, int K) {
	int answer = 0;	
	pqInsert(scoville);
	while (1) {
		if (pq.size() < 1) {
			answer = -1;
			break;
		}
		int minScov = pqPop();
		if (minScov >= K) {
			break;
		}
		if (pq.size() < 1) {
			answer = -1;
			break;
		}
		answer++;
		int minSecondScov = pqPop();
		int mixScov = mixFood(minScov, minSecondScov);
		pq.push(mixScov);
	}
	return answer;
}