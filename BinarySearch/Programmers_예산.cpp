#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int answer;
int MAX;

void findMax(int start, int end, vector<int>& v, int M) {
	if (start > end) {
		return;
	}
	int mid = (start + end) / 2;
	int result = 0;
	for (int i = 0; i < v.size(); i++) {
		if (v[i] >= mid) result += mid;
		else result += v[i];
	}
	if (result == M) {
		if (MAX <= result) {
			MAX = result;
			answer = mid;
		}
	}
	else if (result > M) {
		findMax(start, mid - 1, v, M);
	}
	else {
		if (MAX <= result) {
			MAX = result;
			answer = mid;
		}
		findMax(mid + 1, end, v, M);
	}
}
int solution(vector<int> budgets, int M) {
	int maxBudget = *max_element(budgets.begin(), budgets.end());
	int minBudget = 0;
	findMax(minBudget, maxBudget, budgets, M);
	return answer;
}
