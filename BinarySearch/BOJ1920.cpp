#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int bs(vector <int>& v, int num, int left, int right) {
	int mid = (left + right) / 2;
	if (right == left) {
		if (v[left] == num) return 1;
		else return 0;
	}
	else {
		if (v[mid] == num) return 1;
		else if (v[mid] < num) return bs(v, num, mid + 1, right);
		else return bs(v, num, left, mid);
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;
	vector <int> v;
	for (int n = 0; n < N; n++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());
	int M;
	cin >> M;
	for (int m = 0; m < M; m++) {
		int n;
		cin >> n;
		int ans = bs(v, n, 0, N - 1);
		cout << ans << "\n";
	}
	return 0;
}