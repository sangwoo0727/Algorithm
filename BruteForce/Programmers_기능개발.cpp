#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
	vector<int> answer;
	int deadLine = 0, idx = -1;

	for (int i = 0; i< progresses.size(); i++) {
		int cnt = 0;
		int leftDev = 100 - progresses[i];
		leftDev % speeds[i] == 0 ? cnt = leftDev / speeds[i] : cnt = leftDev / speeds[i] + 1;
		if (deadLine < cnt) {
			deadLine = cnt;
			idx++;
			answer.push_back(1);
		}
		else {
			answer[idx]++;
		}
	}
	return answer;
}