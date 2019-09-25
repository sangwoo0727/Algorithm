#include <iostream>
#include <string>

using namespace std;

string solution(string s) {
	int n = s.length() / 2;
	if (s.length() % 2) return s.substr(n, 1);
	else return s.substr(n-1,2);
}
