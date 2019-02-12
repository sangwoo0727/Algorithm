/*
백준 11654
아스키코드 값을 출력하는 문제인데,
char로 입력받고 int로 출력하면 되는 기본문제
잊지만 말자*/
#include <iostream>
using namespace std;

int main() {
	char word;
	scanf("%c", &word);
	printf("%d", word);
	return 0;
}