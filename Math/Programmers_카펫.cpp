#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int red) {
	int x = 0, y = 0;
	for (int i = 1; i <= brown / 2; i++) {
		y = i - 2;
		x = brown / 2 - i;
		if (x*y == red) {
			return { x + 2, i };
		}
	}
}