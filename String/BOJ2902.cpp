#include <iostream>
#include <cstring>
using namespace std;

char str[105];
int main() {
	scanf("%s", str);
	for (int i = 0; i < strlen(str); i++) {
		if (i == 0) printf("%c", str[i]);
		if (str[i] == '-') printf("%c", str[i + 1]);
	}
	printf("\n");
	return 0;
}