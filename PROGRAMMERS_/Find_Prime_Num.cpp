/*Programmers 소수 개수 문제
n은 1000000 이하로 주어지고 1부터 n까지 중 소수 개수를 찾아서 출력하는 문제이다
단순히 소수의 정의대로 풀면 최악의 경우 n*(n-2) = o(n^2)이 나와서
시간이 엄청나게 커진다
에라토스테네스의 체를 이용하여 풀어야 한다.
에라토스테네스의 체는 말그대로 체로 미리 걸르는 과정을 통하여 소수를 빠르게 찾는 방법으로
2부터 시작하여 2를 제외한 2의 배수들을 전부 지우고, 이어서 3을 제외한 3의 배수또한 모두 지우는 과정을
반복하여, 시간을 줄이는 방법이다.*/

#include <string>
#include <vector>

using namespace std;

int solution(int n) {
	int answer = 0;
	int arr[1000005];
	for (int i = 1; i <= n; i++) arr[i] = i;
	for (int i = 2; i*i <= n; i++) {
		if (arr[i] == 0) continue;
		for (int j = i + i; j <= n; j += i) arr[j] = 0;
	}
	for (int i = 2; i <= n; i++) {
		if (arr[i] != 0) answer++;
	}
	return answer;
}