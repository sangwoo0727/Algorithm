/*SW2971 평균값 구하기
10개 수 의 평균을 1의자리에서 반올림한 값으로 구하는 문제
나머지가 5보다 크거나 같은 경우는
답의 +1을 더해서 출력*/
#include <iostream>
using namespace std;

int arr[10];
int T;
int result;
int ans;
int main() {
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		for (int i = 0; i < 10; i++) {
			scanf("%d", &arr[i]);
			result += arr[i];
		}
		ans = double(result / 10);
		if (result % 10 >= 5) ans++;
		printf("#%d %d\n", t, ans);
		result = 0;
		ans = 0;
	}

	return 0;
}