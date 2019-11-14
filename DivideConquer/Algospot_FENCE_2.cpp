#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dq(vector <int> &fence, int left, int right) {
	if (left == right) return fence[left];
	int mid = (left + right) / 2;
	int ret = max(dq(fence, left, mid), dq(fence, mid + 1, right));
	int ml = mid, mr = mid + 1;
	int height = min(fence[ml], fence[mr]);
	ret = max(ret, height * 2);
	while (left < ml || mr < right) {
		if (mr < right && (ml == left || fence[ml - 1] < fence[mr + 1])) {
			height = min(height, fence[++mr]);
		}
		else {
			height = min(height, fence[--ml]);
		}
		ret = max(ret, height*(mr - ml + 1));
	}
	return ret;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int C;
	cin >> C;
	for (int c = 1; c <= C; c++) {
		int N;
		cin >> N;
		vector <int> fence;
		int Min = 100000;
		int idx = 0;
		for (int n = 0; n < N; n++) {
			int h;
			cin >> h;
			fence.push_back(h);
		}
		int ans = dq(fence,0, N - 1);
		cout << ans << '\n';
	}
	return 0;
}