#include <iostream>
#include <cstring>
#include <stack>
#include <queue>
using namespace std;

char str[105];
queue <char> ans;
stack <char> s;

int operationLev(char op) {
	if (op == '*' || op == '/') return 3;
	else if (op == '+' || op == '-') return 1;
	else return -1;
}
int main() {
	cin >> str;
	int length = strlen(str);
	for (int i = 0; i < length; i++) {
		if (str[i] == '*' || str[i] == '/' || str[i] == '+' || str[i] == '-') { 
			while (!s.empty()) {
				if (operationLev(str[i]) <= operationLev(s.top())
					&& (s.top() == '+' || s.top() == '-' || s.top() == '*' || s.top() == '/')) {
					ans.push(s.top());
					s.pop();
				}
				else break;
			}
			s.push(str[i]);
		}
		else if (str[i] == '(') s.push(str[i]); 
		else if (str[i] == ')') { 
			while (s.top() != '(') {
				ans.push(s.top());
				s.pop();
			}
			s.pop();
		}
		else ans.push(str[i]);
	}
	while (!s.empty()) {
		ans.push(s.top());
		s.pop();
	}
	while (!ans.empty()) {
		cout << ans.front();
		ans.pop();
	}
	return 0;
}