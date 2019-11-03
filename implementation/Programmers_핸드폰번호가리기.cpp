#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
	string answer = "";
	int cnt = 0;
	for (int i = 0; phone_number[i] != NULL; i++) cnt++;
	for (int i = 0; i<cnt - 4; i++) {
		phone_number[i] = '*';
	}
	return phone_number;
}