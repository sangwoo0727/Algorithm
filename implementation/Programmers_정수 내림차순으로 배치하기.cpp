#include <string>
#include <algorithm>
#include <vector>

using namespace std;

long long solution(long long n) {
	int arr[10];
	long long ans = 0;
	int idx = 0;
	while (n != 0) {
		arr[idx] = n % 10;
		n = n / 10;
		idx++;
	}
	sort(arr, arr + idx);
	int cur = 1;
	for (int i = 0; i<idx; i++) {
		ans += (arr[i] * cur);
		cur = cur * 10;
	}
	return ans;
}