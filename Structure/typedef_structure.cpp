/*����ü typedef�� ������ ����
typedef�� ������ �Ǵٸ� �̸��� �����ִ� �Ͱ� ����*/
#include <cstdio>

struct point {
	int xpos;
	int ypos;
};
typedef struct point Point;

typedef struct person {
	char name[20];
	char phoneNum[20];
	int age;
} Person;

typedef struct {
	char name[30];
	char phoneNum[10];
	int num;
} Student; //�� ���� ����ü �̸��� �����ϰ� typedef�� ���� ���� ���ǵ� �̸��� ����� ���
//������ typedef�� ���� ������ �̸������Ŷ� ���� �̸��� �Ƚᵵ�ȴ�. ���̾��̴� ���.

int main() {
	Point pos = { 10,20 };
	Person man = { "�����","0101234-5667",24 };

	return 0;
}