#include <iostream>
#include <algorithm>
using namespace std;

int arr[1005];
int N;

int MaxCrossingSubArr(int low, int mid, int high) {
	int leftsum = -1000000;
	int rightsum = -1000000;
	int sum = 0;
	for (int i = mid; i >= 0; i--) {
		sum += arr[i];
		if (sum > leftsum) leftsum = sum;
	}
	sum = 0;
	for (int i = mid + 1; i <= high; i++) {
		sum += arr[i];
		if (sum > rightsum) rightsum = sum;
	}
	return leftsum + rightsum;
}
int MaxSubArray(int low, int high) {
	if (low == high) return arr[low];
	int mid = (low + high) / 2;
	int lresult = MaxSubArray(low, mid);
	int rresult = MaxSubArray(mid + 1, high);
	int cresult = MaxCrossingSubArr(low, mid, high);
	return max(lresult, max(rresult, cresult));
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int T;
	cin >> T;
	for (int t = 1; t <= T; t++) {
		cin >> N;
		for (int i = 0; i < N; i++) {
			cin >> arr[i];
		}
		int result = MaxSubArray(0, N-1);
		cout << result << '\n';
	}
	return 0;
}