#include <iostream>
using namespace std;

int arr[10];
bool check[10];
int r, cnt , N;

void permutation(int i) {
	if (i == r) { 
		cnt++;
		for (int k = 0; k < r; k++) {
			cout << arr[k] << ' ';
		}
		cout << endl;
		return;
	}
	for (int k = 0; k < N; k++) {
		if (!check[k]) {
			check[k] = true;
			arr[i] = k;
			permutation(i + 1);
			check[k] = false;
		}
	}
}
int main() {
	cin >> N >> r;
	permutation(0);
	cout << cnt << endl;
	return 0;
}