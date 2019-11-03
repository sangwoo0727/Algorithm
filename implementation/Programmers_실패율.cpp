#include <string>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

bool comp(const pair <double, int>& a, const pair <double, int>& b) {
	if (a.first > b.first) return true;
	else if (a.first == b.first) return b.second > a.second;
	else return false;
}
vector<int> solution(int N, vector<int> stages) {
	int board[501];
	int sum = stages.size();
	vector <pair <double, int>> fp;
	vector<int> answer;
	memset(board, 0, sizeof(board));
	for (int i = 0; i<sum; i++) {
		board[stages[i]]++;
	}
	for (int i = 1; i <= N; i++) {
		if (board[i] == 0) {
			fp.push_back({ 0,i });
			sum -= board[i];
		}
		else {
			double fail_per = (double)board[i] / sum;
			fp.push_back({ fail_per,i });
			sum -= board[i];
		}
	}
	sort(fp.begin(), fp.end(), comp);
	for (int i = 0; i < fp.size(); i++) {
		answer.push_back(fp[i].second);
	}
	return answer;
}
