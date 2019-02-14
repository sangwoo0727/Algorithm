/*1152번 단어의 개수
띄어쓰기가 포함된 문장을 입력받고, 
띄어쓰기를 기준으로 단어의 개수를 세는 문제이다.
맨앞에 공백이 나올 수 있고, 맨 뒤에도 공백이 나올 수 있다.
scanf를 통한 %s로 입력을 받으면 띄어쓰기를 하게되면, 그 이후는 배열에 입력이 들어가지
않는다.
fgets를 통해 입력을 받았다.
gets라는 함수도 있는데, gets는 버퍼 오버플로우를 검사하지 않아서, 치명적인 문제가 발생한다.
fgets와 scanf로 입력을 받는다고 할때, scanf는 띄어쓰기를 인식 못한다.
또한 fgets는 자동적으로 개행문자가 삽입이 된다.*/
#include <iostream>
#include <cstring>
using namespace std;

char str[1000050];

int main() {
	fgets(str, 1000050, stdin);
	int str_len = strlen(str);
	int cnt = 1;

	for (int i = 0; i < str_len; i++) {
		if (str[i] == ' ' && str[i - 1] == ' ') continue;
		else if (str[i] == ' ') cnt++;
	}
	if (str[0] == ' ') cnt--;
	if (str[str_len - 2] == ' ') cnt--;
	printf("%d",cnt);
	return 0;
}