#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int minheight(vector <int> &fence, int left, int right) {
	int Min = 100000;
	int idx = 0;
	for (int i = left; i <= right; i++) {
		if (Min > fence[i]) {
			Min = fence[i];
			idx = i;
		}
	}
	return idx;
}
int dq(vector <int> &fence, int idx, int left, int right) {
	if (left >= right) return fence[right];
	if (right <= left) return fence[left];
	int area = fence[idx] * (right - left+1);
	int leftidx = minheight(fence, left, idx-1);
	int rightidx = minheight(fence, idx + 1, right);
	int leftarea = dq(fence, leftidx, left, idx-1);
	int rightarea = dq(fence, rightidx, idx+1, right);
	return max(leftarea, max(rightarea, area));
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
			if (Min > h) {
				Min = h;
				idx = n;
			}
		}
		int ans = dq(fence, idx, 0, N - 1);
		cout << ans << '\n';
		fence.clear();
	}
	return 0;
}