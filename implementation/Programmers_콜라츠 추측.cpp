#include <string>
#include <vector>

using namespace std;

int solution(int num) {
	int answer = 0;
	long long ans = num;
	while (ans > 1) {
		if (answer == 500) return -1;
		if (ans % 2) ans = (ans * 3) + 1;
		else ans /= 2;
		answer++;
	}
	return answer;
}