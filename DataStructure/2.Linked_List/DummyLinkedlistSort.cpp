#include <cstdio>
#include <cstdlib>

#define TRUE 1
#define FALSE 0

typedef struct _node {
	int data;
	struct _node *next;
}Node;

typedef struct {
	Node * head;
	Node * cur;
	Node * before;
	int numOfData;
	int(*comp)(int d1, int d2);
}List;

void ListInit(List * plist) {
	plist->head = (Node*)malloc(sizeof(Node));
	plist->head->next = NULL;
	plist->comp = NULL;
	plist->numOfData = 0;
}

void LInsert(List * plist, int data) {
	Node * newNode = (Node*)malloc(sizeof(Node));
	Node * pred = plist->head;
	newNode->data = data;
	while (pred->next != NULL && plist->comp(data, pred->next->data) != 0)
		pred = pred->next;
	newNode->next = pred->next;
	pred->next = newNode;
	(plist->numOfData)++;
}

int LFirst(List *plist, int *pdata) {
	if (plist->head->next == NULL) return FALSE;
	plist->before = plist->head;
	plist->cur = plist->head->next;
	*pdata = plist->cur->data;
	return TRUE;
}

int LNext(List *plist, int *pdata) {
	if (plist->cur->next == NULL) return FALSE;
	plist->before = plist->cur;
	plist->cur = plist->cur->next;

	*pdata = plist->cur->data;
	return TRUE;
}

int LRemove(List *plist) {
	Node * rpos = plist->cur;
	int rdata = rpos->data;
	plist->before->next = plist->cur->next;
	plist->cur = plist->before;
	free(rpos);
	(plist->numOfData)--;
	return rdata;
}

int LCount(List *plist) {
	return plist->numOfData;
}

int WhoIsPrecede(int d1, int d2) {
	if (d1 < d2) return 0;
	else return 1;
}

int main() {
	List list;
	int data;
	int num;
	ListInit(&list);

	List * plist = &list;
	plist->comp = WhoIsPrecede;

	printf("입력받을 데이터 개수:");
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		int a;
		scanf("%d", &a);
		LInsert(&list, a);
	}
	printf("현재 데이터 개수: %d\n", LCount(&list));
	if (LFirst(&list, &data)) {
		printf("%d ", data);
		while (LNext(&list, &data)) printf("%d ", data);
	}
	printf("\n\n");

	if (LFirst(&list, &data)) {
		int a;
		printf("삭제하고 싶은 데이터 값입력:");
		scanf("%d", &a);
		if (data == a) LRemove(&list);
		while (LNext(&list, &data)) {
			if (data == a) LRemove(&list);
		}
	}
	printf("현재 데이터 개수: %d\n", LCount(&list));
	if (LFirst(&list, &data)) {
		printf("%d ", data);
		while (LNext(&list, &data)) printf("%d ", data);
	}
	printf("\n\n");

	return 0;
}
