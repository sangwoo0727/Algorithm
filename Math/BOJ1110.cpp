/* 1110번 더하기 사이클 
자리수를 2개로 나눠서 처음 n은 a와 b에 저장해두고,
자리수가 이동하는 방식에 따라서 a ,b와 비교해서 같을 경우 
루프를 탈출하는 식으로 만들었다
//
쓸데없이 배열까지 동원해서 변수선언을 너무 많이했다.
다른 사람 풀이 보니깐 a,b,c만 선언해서 마지막에
a=b b=c만 해주면 끝나는 문제..*/

#include <iostream>
using namespace std;

int n;
int a,b;
int arr[2],arr2[2];
int result;
int cnt;

int main() {
	scanf("%d", &n);
	a = n / 10;
	b = n % 10;
	arr[1] = a;
	arr[0] = b;

	while (1) {
		result = arr[1] + arr[0];
		arr2[1] = result / 10;
		arr2[0] = result % 10;
		arr[1] = arr[0];
		arr[0] = arr2[0];
		cnt++;
		if (a == arr[1] && b == arr[0])
			break;
	}
	printf("%d\n", cnt);
	return 0;
}