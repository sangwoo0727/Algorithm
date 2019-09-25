#include <iostream>
#include <string>

using namespace std;

string solution(string s) {
	return s.length() % 2 ? s.substr(s.length()*0.5, 1) : s.substr(s.length()*0.5 - 1, 2);
}

