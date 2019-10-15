#include <iostream>
using namespace std;

int arr[10];
bool check[10];
int r, cnt , N;

void rep_combination(int i,int n) {
	if (i == r) { 
		cnt++;
		for (int k = 0; k < r; k++) {
			cout << arr[k] << ' ';
		}
		cout << endl;
		return;
	}
	if (n >= N) return;
	arr[i] = n;
	rep_combination(i + 1, n);
	arr[i] = n + 1;
	rep_combination(i, n + 1);
}
int main() {
	cin >> N >> r;
	rep_combination(0,0);
	cout << cnt << endl;
	return 0;
}