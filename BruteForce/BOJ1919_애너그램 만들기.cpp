#include <iostream>
#include <string>
using namespace std;

string str1;
string str2;
int check1[1000];
int check2[1000];

int main() {
	cin >> str1 >> str2;
	int common_char = 0;
	for (int i = 0; i < str1.length(); i++) {
		for (int j = 0; j < str2.length(); j++) {
			if (str1[i] == str2[j] && !check1[i] && !check2[j]) {
				common_char++;
				check1[i] = 1;
				check2[j] = 1;
			}
		}
	}
	int result = 0;
	result = str1.length() - common_char + str2.length() - common_char;
	cout << result;
	return 0;
}