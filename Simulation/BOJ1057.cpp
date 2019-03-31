/* BOJ 1057 토너먼트*/

#include <iostream>
using namespace std;

int main() {
	int N, kim, lim;
	cin >> N >> kim >> lim;
	int cnt = 0;
	while (kim != lim) {
		kim = kim / 2 + kim % 2;
		lim = lim / 2 + lim % 2;
		cnt++;
	}
	cout << cnt << endl;
	return 0;
}
