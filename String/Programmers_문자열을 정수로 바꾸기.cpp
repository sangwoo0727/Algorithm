#include <string>
#include <vector>

using namespace std;

int solution(string s) {
	int answer = 0;
	int digit = 1;
	for (int i = s.length() - 1; i >= 0; i--) {
		if (i == 0 && s[0] == '-') {
			answer *= -1;
			break;
		}
		if (i == 0 && s[0] == '+') break;
		answer += digit * (s[i] - '0');
		digit *= 10;
	}
	return answer;
}