#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <utility>
using namespace std;

int person[11];
map <string, int> m;

vector<int> solution(int n, vector<string> words) {
	vector<int> answer;
	for (int i = 0; i<words.size(); i++) {
		m.insert(make_pair(words[i], 0));
	}
	int tmp = 1;
	char fc, ec;
	for (int i = 0; i < words.size(); i++) {
		if (i == 0) {
			ec = words[i][words[i].length() - 1];
			person[tmp]++;
			m[words[i]]++;
		}
		else {
			fc = words[i][0];
			if (ec == fc) {
				ec = words[i][words[i].length() - 1];
				if (m[words[i]] == 1) {
					person[tmp]++;
					answer.push_back(tmp);
					answer.push_back(person[tmp]);
					break;
				}
				else if (m[words[i]] == 0) {
					m[words[i]]++;
					person[tmp]++;
				}
			}
			else {
				person[tmp]++;
				answer.push_back(tmp);
				answer.push_back(person[tmp]);
				break;
			}
		}
		if (tmp == n) tmp = 1;
		else tmp++;
	}
	if (answer.empty()) {
		answer.push_back(0);
		answer.push_back(0);
	}
	return answer;
}