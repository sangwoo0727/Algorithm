/*1152�� �ܾ��� ����
���Ⱑ ���Ե� ������ �Է¹ް�, 
���⸦ �������� �ܾ��� ������ ���� �����̴�.
�Ǿտ� ������ ���� �� �ְ�, �� �ڿ��� ������ ���� �� �ִ�.
scanf�� ���� %s�� �Է��� ������ ���⸦ �ϰԵǸ�, �� ���Ĵ� �迭�� �Է��� ����
�ʴ´�.
fgets�� ���� �Է��� �޾Ҵ�.
gets��� �Լ��� �ִµ�, gets�� ���� �����÷ο츦 �˻����� �ʾƼ�, ġ������ ������ �߻��Ѵ�.
fgets�� scanf�� �Է��� �޴´ٰ� �Ҷ�, scanf�� ���⸦ �ν� ���Ѵ�.
���� fgets�� �ڵ������� ���๮�ڰ� ������ �ȴ�.*/
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