/*BOJ2743 단어길이재기
입력받은 단어의 길이를 출력하는 문제
C++에서 C라이브러리를 쓸때는 .h를 없애고 c를 붙히면된다.
ex) #include <stdio.h> -> #include <cstdio>
#include <string.h> -> #include <cstring>
*/

#include <iostream>
#include <cstring>
using namespace std;

char str[105];
int main() {
	int num = 0;
	scanf("%s", str);
	num = strlen(str);
	printf("%d\n", num);
	return 0;
}
