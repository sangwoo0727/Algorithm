/*����ü
�ϳ��̻��� ����(�����ͺ����� �迭 ����)�� ��� ���ο� �ڷ����� �����ϴ� ����
����ü�� �̸��� �ڷ����� �̸��� �ȴ�.*/
#include <cstdio>
#include <cstring>
struct person {
	char name[20];
	char phoneNum[20];
	int age;
};
struct point {
	int xpos;
	int ypos;
};
/*����ü ���� ������
	struct point {
		int xpos;
		int ypos;
	} pos1, pos2, pos3;   �̷������� ������ ���� �ִ�. 
*/
int main() {
	struct point pos1, pos2; //����ü ���� ����
	scanf("%d %d", &pos1.xpos, &pos1.ypos);
	scanf("%d %d", &pos2.xpos, &pos2.ypos);

	struct person man1,man2;
	struct person man3 = { "ȫ�浿","010-1234-5678",22 }; //����ü ���� ����� ���ÿ� �ʱ�ȭ
	strcpy(man1.name, "�����"); //����� ���ÿ� �ʱ�ȭ�����ʰ�, �����س��� �ʱ�ȭ ��ų�� ���ڿ��� strcpy����Ѵ�.
	strcpy(man1.phoneNum, "010-1234-5678");
	man1.age = 28;
	scanf("%s", man2.name);
	scanf("%s", man2.phoneNum);
	scanf("%d", &man2.age);
	
	struct point arr[3]; //����ü �迭 ����
	for (int i = 0; i < 3; i++) {
		scanf("%d %d", &arr[i].xpos, &arr[i].ypos);
	}

	struct person arr2[3] = {
		{"��","1234-1234",20},
		{"��","1233-1233",23},
		{"��","0000-0000",27},
	}; //����ü �迭 ����� ���ÿ� �ʱ�ȭ ���

	struct point pos5;
	struct point *pptr = &pos5; //����ü ������ ����(�����ͺ����� �ڷ����� ���ƾ��Ѵ�)

	(*pptr).xpos = 10;
	(*pptr).ypos = 20;  //pos5�� xpos�� ypos ���� �ٲ��.

	pptr->xpos = 5;
	pptr->ypos = 1; //���� �ι���� �Ȱ��� �ǹ�

	printf("%d %d", pos5.xpos, pos5.ypos);

	return 0;
}