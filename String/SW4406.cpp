/*SW4406 모음이 보이지 않는 사람
문자열을 입력받고, 모음을 빼고 출력하는 문제이다.*/

#include <iostream>
#include <cstring>
using namespace std;

char str[55];

int main() {
	int t;
	scanf("%d", &t);
	for (int i = 1; i <= t; i++) {
		scanf("%s", str);
		int num = strlen(str);
		printf("#%d ", i);
		for (int j = 0; j < num; j++) {
			if (str[j] == 'a' || str[j] == 'e' || str[j] == 'i' || str[j] == 'o' || str[j] == 'u') continue;
			printf("%c", str[j]);
		}
		printf("\n");
		memset(str, 0, sizeof(str));
	}
	return 0;
}