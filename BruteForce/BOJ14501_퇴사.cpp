#include <iostream>
#include <algorithm>
#define endl '\n'
using namespace std;

int N;
int MAX;
int arrT[16];
int arrP[16];

void comb(int idx,int result) {
	if (idx == N) {
		MAX = max(MAX, result);
		return;
	}
	if (idx + arrT[idx] <= N) {
		comb(idx + arrT[idx], result+arrP[idx]);
	}
	comb(idx + 1,result);
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arrT[i] >> arrP[i];
	}
	comb(0,0);
	cout << MAX << endl;
	return 0;
}