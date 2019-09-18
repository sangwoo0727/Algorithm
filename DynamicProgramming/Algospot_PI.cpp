#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int dp[10005];
char str[10005];


int findlev3(int pos) {
	int n1 = str[pos] - '0', n2 = str[pos - 1] - '0', n3 = str[pos - 2] - '0';
	if (n1 == n2 && n2 == n3) return 1;
	else if (n1 + 1 == n2 && n2 + 1 == n3) return 2;
	else if (n1 - 1 == n2 && n2 - 1 == n3) return 2;
	else if (n1 == n3 && n1 != n2) return 4;
	else if ((n1 - n2) == (n2 - n3)) return 5;
	else return 10;
}

int findlev4(int pos) {
	int n1 = str[pos] - '0', n2 = str[pos - 1] - '0';
	int n3 = str[pos - 2] - '0', n4 = str[pos - 3] - '0';
	if (n1 == n2 && n2 == n3 && n3 == n4) return 1;
	else if (n1 + 1 == n2 && n2 + 1 == n3 && n3 + 1 == n4) return 2;
	else if (n1 - 1 == n2 && n2 - 1 == n3 && n3 - 1 == n4) return 2;
	else if (n1 == n3 && n2 == n4 && n1!=n2) return 4;
	else if (n1 - n2 == n2 - n3 && n2 - n3 == n3 - n4) return 5;
	else return 10;
}

int findlev5(int pos) {
	int n1 = str[pos] - '0', n2 = str[pos - 1] - '0';
	int n3 = str[pos - 2] - '0', n4 = str[pos - 3] - '0' , n5 = str[pos-4]-'0';
	if (n1 == n2 && n2 == n3 && n3 == n4 && n4 == n5) return 1;
	else if (n1 + 1 == n2 && n2 + 1 == n3 && n3 + 1 == n4 && n4 + 1 == n5) return 2;
	else if (n1 - 1 == n2 && n2 - 1 == n3 && n3 - 1 == n4 && n4 - 1 == n5) return 2;
	else if (n1 == n3 && n3 == n5 && n2 == n4 && n1 != n2) return 4;
	else if (n1 - n2 == n2 - n3 && n2 - n3 == n3 - n4 && n3 - n4 == n4 - n5) return 5;
	else return 10;
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int C;
	cin >> C;
	while (C--) {
		memset(dp, 0, sizeof(dp));
		memset(str, 0, sizeof(str));
		cin >> str;
		int cnt = 0;
		dp[0] = 0; dp[1] = 0;
		dp[2] = findlev3(2);
		dp[3] = findlev4(3);
		dp[4] = findlev5(4);
		dp[5] = dp[2] + findlev3(5);
		dp[6] = min(dp[3] + findlev3(6), dp[2] + findlev4(6));
		for (int i = 7; i < strlen(str); i++) {
			dp[i] = min(dp[i - 3] + findlev3(i), min(dp[i - 4] + findlev4(i), dp[i - 5] + findlev5(i)));
		}
		cout << dp[strlen(str)-1] << '\n';
		memset(dp, 0, sizeof(dp));
	}
	return 0;
}