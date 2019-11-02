#include <string>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

int solution(string s) {
	int answer = 1000000;
	if (s.length() == 1) return 1;
	for (int cut_num = 1; cut_num <= s.length() / 2; cut_num++) {
		string str, ans;
		stack <string> st;
		int cnt = 0;
		int tmp = 0;
		for (int i = 0; i*cut_num < s.length(); i++) {
			tmp = i;
			str = s.substr(i*cut_num, cut_num);
			if (st.empty()) {
				st.push(str);
			}
			else {
				if (st.top() == str) {
					st.push(str);
				}
				else {
					if (st.size() != 1) {
						int size = st.size();
						while (size) {
							size /= 10;
							ans += '1';
						}
					}
					ans += st.top();
					while (!st.empty()) st.pop();
					st.push(str);
				}
			}
		}
		if (!st.empty()) {
			if (st.size() != 1) {
				int size = st.size();
				while (size) {
					size /= 10;
					ans += '1';
				}
			}
			ans += st.top();
			while (!st.empty()) st.pop();
		}
		int size = ans.length();
		answer = min(answer, size);
	}
	return answer;
}