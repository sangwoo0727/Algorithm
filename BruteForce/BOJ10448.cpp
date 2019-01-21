/* 10448번 유레카 이론
T수열은 45정도까지밖에 안돌고
k값또한 1000이하기때문에
3중포문으로 해결할수 있다.
어렵게 풀려고하다가 못풀어서,, 3중포문으로 다시 해결*/

#include <iostream>
using namespace std;
int T[50];
int go(int sum) {
	for (int j = 1; T[j] < sum; j++) {
		for (int j2 = 1; T[j2] < sum; j2++) {
			for (int j3 = 1; T[j3] < sum; j3++) {
				if (T[j] + T[j2] + T[j3] == sum) {
					return 1;

				}
			}
		}
	}
	return 0;
}

int main() {
	int k,t;
	scanf("%d", &t);
	for (int i = 1; T[i] <= 1000; i++) {
		T[i] = (i*(i + 1)) / 2;
	}
	
	for (int i = 0; i < t; i++) {
		scanf("%d", &k);
		printf("%d\n", go(k));
	}
	return 0;
}
