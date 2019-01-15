/* 1182 부분집합의 합이 S가 되는 모든 부분집합의 개수를 출력하는 문제
처음에 부분집합의 합을 구하기 위해 2중 for문으로 줄이는 고민을 했는데
도무지 해결책이 안나와서 처음부터 다시 생각해서,
단순하게 재귀를 통해, i번째 배열 값을 포함하는 지 안하는지 로 나눠서 
재귀를 돌려서 해결했다.*/

#include <iostream>
using namespace std;

int N;
int S;
int arr[20];
int cnt;

void go(int i, int sum) {
	sum += arr[i];
	if (i >= N) //기저조건 i가 N과 같거나 더 커지면, 리턴
		return;
	if (sum == S) { // sum이 S와 같아지면 cnt를 증가
		cnt++;
	}
	go(i + 1, sum - arr[i]); // arr[i]가 포함되는 경우
	go(i + 1, sum); //포함되지 않는 경우
	return;
}

int main() {
		
	scanf("%d %d", &N, &S);
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	go(0, 0); //0번째 인덱스, 합이 0인 경우부터 시작
	printf("%d\n", cnt);
	return 0;
}