/*10808 ���ĺ� ����
���ڿ��� �־��ְ� , �� ���ڿ��� �ִ� ���ĺ� ������ ������
����ϴ� �����̴�.
���̵� ������ ��Ư�ߴ�.*/
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