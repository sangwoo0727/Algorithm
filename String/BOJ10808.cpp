/*10808 알파벳 개수
문자열을 주어주고 , 그 문자열에 있는 알파벳 각각의 개수를
출력하는 문제이다.
아이디어가 굉장히 독특했다.*/
#include <iostream>
#include <cstring>
using namespace std;

char str[105];
int arr[26];

int main() {
	scanf("%s", str);
	for (int i = 0; i < strlen(str); i++) {
		arr[str[i] - 'a']++;
	}
	for (int i = 0; i < 26; i++) {
		printf("%d ", arr[i]);
	}
	return 0;
}