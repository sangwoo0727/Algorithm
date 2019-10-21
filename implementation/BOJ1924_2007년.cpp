#include <iostream>
#include <string>

using namespace std;

string arr[7] = { "SUN","MON","TUE","WED","THU","FRI","SAT" };

int main() {
	int month, day;
	cin >> month >> day;
	int cnt = 0;
	for (int m = 1; m < month; m++) {
		if (m==1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
			cnt += 31;
		}
		else if (m == 2) {
			cnt += 28;
		}
		else {
			cnt += 30;
		}
	}
	cnt += day;
	cnt %= 7;
	cout << arr[cnt] << endl;
	return 0;
}

