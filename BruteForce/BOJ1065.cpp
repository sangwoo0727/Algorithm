/*1065 한수 갯수 출력하는 문제
한수는 각자리수가 등차수열을 이루는 수를 의미한다
1000미만의 수를 입력받아서, 그 수보다 작은 자연수중 한수의 개수를 출력하는 문제
2자리수 , 즉 99까지는 전부 한수이다.
100부터 999까지는 수를 배열에 쪼개서,
세번째 자리수 - 두번째자리수와
두번째 자리수- 첫번째 자리수의 값이 같은 경우에 카운트를 세주는 단순한 문제*/

#include <iostream>
using namespace std;

int main() {
	int num = 0;
	int arr[3] = {};
	int cnt = 0;
	scanf("%d", &num);
	for (int i = 1; i <= num; i++) {
		if (i <= 99)
			cnt++;
		if (i >=100) {
			arr[2] = i % 10;
			arr[1] = (i / 10) % 10;
			arr[0] = i / 100;
			if (arr[0] - arr[1] == arr[1] - arr[2])
				cnt++;
		}
	}
	printf("%d\n", cnt);
	return 0;
}