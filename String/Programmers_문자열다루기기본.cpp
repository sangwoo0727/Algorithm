#include <string>
#include <iostream>
using namespace std;

bool solution(string s) {
	bool answer = true;
	if (s.length() == 4 || s.length() == 6) {
		for (auto c:s) {
			if (c - '0' >= 0 && c - '9' <= 0) continue;
			else {
				answer = false;
				break;
			}
		}
	}
	else answer = false;
	return answer;
}

int main() {
	string s;
	cin >> s;
	bool ans = solution(s);
	cout << ans;
	return 0;
}