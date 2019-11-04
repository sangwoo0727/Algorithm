#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
	int digitsum = 0;
	int tmp = x;
	while (tmp) {
		digitsum += tmp % 10;
		tmp /= 10;
	}
	return x % digitsum == 0 ? true : false;
}