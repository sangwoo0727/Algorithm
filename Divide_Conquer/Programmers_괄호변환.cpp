#include <string>
#include <vector>
using namespace std;

string solution(string p) {
	string answer = "";
	int left = 0, right = 0;
	bool check = false;
	if (p.length() == 0) return "";
	for (int i = 0; i < p.length(); i++) {
		if (p[i] == '(') left++;
		if (p[i] == ')') right++;
		if (right > left) check = true;
		if (left == right) {
			if (check == true) {
				answer += '(';
				answer += solution(p.substr(i + 1, p.length() - i - 1));
				answer += ')';
				for (int j = 1; j < i; j++) {
					if (p[j] == ')') answer += '(';
					if (p[j] == '(') answer += ')';
				}
				return answer;
			}
			else {
				answer += p.substr(0, i + 1);
				answer += solution(p.substr(i + 1, p.length() - i - 1));
				return answer;
			}
		}
	}
}