#include <iostream>
#include <string>
#include <deque>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	deque <char> store;
	string s, bs;
	cin >> s;
	cin >> bs;
	for (const auto& c : s) {
		store.push_back(c);
		if (c == bs[bs.length() - 1]) {
			stack <char> tmp;
			for (int i = bs.length() - 1; i >= 0; i--) {
				if (!store.empty() && store.back() == bs[i]) {
					tmp.push(store.back());
					store.pop_back();
				}
				if (i == 0 && tmp.size() != bs.length()) {
					while (!tmp.empty()) {
						store.push_back(tmp.top());
						tmp.pop();
					}
				}
			}
		}
	}
	if (store.empty()) cout << "FRULA\n";
	else {
		while (!store.empty()) {
			cout << store.front();
			store.pop_front();
		}
		cout << "\n";
	}
	return 0;
}
