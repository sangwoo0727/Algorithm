#include <iostream>
using namespace std;

int main() {
	int a, b, v;
	cin >> a >> b >> v;
	(v - a) % (a - b) == 0 ? cout << 1 + (v - a) / (a - b) : cout << 2 + (v - a) / (a - b);
	return 0;
}
