/*10987 �����ǰ���
�ܼ��� �ܾ� �Է¹ް� ������ ���� ����ϴ� ����
fgets�� �޴� ����*/
#include <iostream>
#include <cstring>
using namespace std;

char str[105];

int main() {
	int cnt=0;
	fgets(str, 105, stdin);
	for (int i = 0; i < strlen(str); i++) {
		if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u')
			cnt++;
	}
	printf("%d\n", cnt);
	return 0;
}