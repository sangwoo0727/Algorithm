#include <iostream>
using namespace std;

int main() {
	int a, b, v;
	cin >> a >> b >> v;
	int ans = (v - a) % (a - b) == 0 ? ans = 1 + (v - a) / (a - b) : ans = 2 + (v - a) / (a - b);
	cout << ans;
	return 0;
}
