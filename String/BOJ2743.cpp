/*BOJ2743 �ܾ�������
�Է¹��� �ܾ��� ���̸� ����ϴ� ����
C++���� C���̺귯���� ������ .h�� ���ְ� c�� ������ȴ�.
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
