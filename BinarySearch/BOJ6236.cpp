#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int N, M;
vector <int> board;
int ans = 1000000000;

void bs(int left, int right) {
	if (left > right) return;
	int mid = (left + right) / 2;
	int cnt = 1, num = mid;
	for (int n = 0; n < N; n++) {
		if (board[n] > mid) break;
		else {
			if (board[n] <= num) {
				num -= board[n];
			}
			else {
				cnt++;
				num = mid;
				num -= board[n];
			}
		}
	}
	if (cnt <= M) {
		ans = min(ans, mid);
		bs(left, mid - 1);
	}
	else {
		bs(mid + 1, right);
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	int min_range = 0, max_range = 0;
	for (int n = 0; n < N; n++) {
		int num;
		cin >> num;
		board.push_back(num);
		max_range += num;
		if (min_range < num) min_range = num;
	}
	bs(min_range, max_range);
	cout << ans << "\n";
	return 0;
}