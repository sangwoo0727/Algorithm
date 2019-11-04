#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
	int cnt1 = 0, cnt2 = 0;
	for (const auto &c : s) {
		if (c == 'p' || c == 'P') cnt1++;
		if (c == 'y' || c == 'Y') cnt2++;
	}
	return cnt1 == cnt2;
}