/*SW 5549 홀수일까 짝수일까
길이가 100까지 가능하기때문에
long long도 되지않고, 문자열로 입력받아야한다.
strlen 을 통해 문자열 길이 측정*/
#include <iostream>
#include <cstring>

char arr[105];
int main() {
	int t;
	int num;
	scanf("%d", &t);
	for (int i = 1; i <= t; i++) {
		scanf("%s", arr);
		num = strlen(arr);
		if (arr[num - 1] % 2 == 0) printf("#%d Even\n", i);
		else printf("#%d Odd\n", i);
		memset(arr, 0, sizeof(arr));
	}
	return 0;
}