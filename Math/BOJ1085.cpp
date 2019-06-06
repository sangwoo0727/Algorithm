#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
	int x, y, w, h;
	x = y = w = h = 0;
	scanf("%d%d%d%d", &x, &y, &w, &h);
	printf("%d", min(x, min(y, min(h - y, w - x))));
	return 0;
}