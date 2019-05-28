#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
	vector<int> answer;
	int min = arr[0];
	int idx = 0;
	int size = arr.size();
	if (size == 1) {
		answer.push_back(-1);
		return answer;
	}
	for (int i = 1; i<size; i++) {
		if (min<arr[i]) continue;
		else {
			min = arr[i];
			idx = i;
		}
	}
	for (int i = 0; i<size; i++) {
		if (i != idx) {
			answer.push_back(arr[i]);
		}
	}
	return answer;
}