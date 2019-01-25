/*Dynamic Memory Allocation
�����Ҵ��̶�� �θ��� ������ �Ҵ�Ǵ� �޸��� ũ�⸦ �����Ϸ��� �������� �ʰ�
���α׷��� ���� �߰��� ȣ��Ǵ� malloc�Լ��� �����ϱ� ����*/
#include <cstdio>
#include <cstdlib>

int main() {
	int *ptr1 = (int *)malloc(sizeof(int));
	int *ptr2 = (int *)malloc(sizeof(int) * 7);
	/*����� malloc�Լ��� �޸� ������ �Ҵ翡 ������ ��� NULL�� ��ȯ
	�޸� �Ҵ��� �������θ� Ȯ���ϰ��� �Ҷ� 
	if(ptr==NULL){
		�޸� �Ҵ� ���п� ���� ������ ó��
	}
	�κ��� �߰��ؾ��Ѵ�.*/
	int i;
	*ptr1 = 20;
	for (i = 0; i < 7; i++)
		ptr2[i] = i + 1;
	printf("%d\n", *ptr1);
	for (i = 0; i < 7; i++)
		printf("%d ", ptr2[i]);
	free(ptr1);
	free(ptr2);
	return 0;
}