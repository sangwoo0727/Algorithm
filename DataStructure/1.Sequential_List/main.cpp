#include <cstdio>
#include "ArrayList.h"

int main() {
	//ArrayList ���� �� �ʱ�ȭ
	List list;
	int data;
	ListInit(&list);

	LInsert(&list, 11);
	LInsert(&list, 11);
	LInsert(&list, 22);
	LInsert(&list, 22);
	LInsert(&list, 33);

	// ����� ������ ��ü ���
	printf("���� ������ �� : %d \n", LCount(&list));

	if (LFirst(&list, &data)) {
		printf("%d ", data);
		while (LNext(&list, &data)) printf("%d ", data);
	}
	printf("\n\n");

	// �����Ͱ� 22�� �͵� ��� ����
	if (LFirst(&list, &data)) {
		if (data == 22) {
			LRemove(&list);
			
		}
		while (LNext(&list, &data)) {
			if (data == 22) LRemove(&list);
		}
	}

	// ���� �� ���� ������ ��ü ���
	printf("���� ������ �� : %d\n", LCount(&list));
	if (LFirst(&list, &data)) {
		printf("%d ", data);
		while (LNext(&list, &data)) printf("%d ", data);
	}
	printf("\n\n");
	return 0;
}