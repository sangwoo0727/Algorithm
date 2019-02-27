/*10569 ¥Ÿ∏È√º*/
#include <iostream>
using namespace std;

int main() {
	int T;
	int V, E;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d %d", &V, &E);
		printf("%d\n", 2 + E - V);
	}
	return 0;
}