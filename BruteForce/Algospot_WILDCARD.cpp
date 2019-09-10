#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

bool checking(string& file, string& str, int f_idx, int s_idx) {
	if ((str[s_idx] == '?' || str[s_idx] == file[f_idx]) && s_idx < str.length() && f_idx < file.length()) {
		return checking(file, str, f_idx + 1, s_idx + 1);
	}
	if (s_idx == str.length() && f_idx == file.length()) {
		return true;
	}
	if (str[s_idx] == '*') {
		for (int idx = f_idx; idx  <= file.length(); idx++) {
			if (checking(file, str, idx , s_idx + 1)) {
				return true;
			}
		}
	}
	return false;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int C;
	cin >> C;
	while (C--) {
		string str;
		string result[50];
		cin >> str;
		int N;
		cin >> N;
		for (int n = 0; n < N; n++) {
			string file;
			cin >> file;
			bool check = checking(file, str, 0, 0);
			if (check == true) {
				result[n] = file;
			}
		}
		sort(result, result + N);
		for (int n = 0; n < N; n++) {
			if (result[n].empty()) continue;
			cout << result[n] <<'\n';
		}
	}
	return 0;
}