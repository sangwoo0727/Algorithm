#include <cstdio>
#include <cstdlib>

#define TRUE 1
#define FALSE 0

typedef struct _node { //노드구조체
	int data;
	struct _node *next;
}Node;

typedef struct { //리스트를 의미하는 구조체
	Node * head;
	Node * cur;
	Node * before;
	int numOfData;
	int(*comp)(int d1, int d2); //함수 포인터 변수
}List;

void ListInit(List * plist) { //리스트 처음 만들때 초기화시켜서 공간 할당받는 역할
	plist->head = (Node*)malloc(sizeof(Node));
	plist->head->next = NULL;
	plist->comp = NULL;
	plist->numOfData = 0;
}

void LInsert(List * plist, int data) { //데이터 삽입시 정렬함수를 사용하여 정렬하며 리스트에 데이터 삽입
	Node * newNode = (Node*)malloc(sizeof(Node));
	Node * pred = plist->head;
	newNode->data = data;
	while (pred->next != NULL && plist->comp(data, pred->next->data) != 0)
		pred = pred->next;
	newNode->next = pred->next;
	pred->next = newNode;
	(plist->numOfData)++;
}

int LFirst(List *plist, int *pdata) { //리스트의 첫번째 노드의 데이터 값 저장 및 첫번째 노드 존재하는지에 대한 참/거짓반환
	if (plist->head->next == NULL) return FALSE;
	plist->before = plist->head;
	plist->cur = plist->head->next;
	*pdata = plist->cur->data;
	return TRUE;
}

int LNext(List *plist, int *pdata) { //리스트의 두번째 이후 노드부터 값 저장 및 반환
	if (plist->cur->next == NULL) return FALSE;
	plist->before = plist->cur;
	plist->cur = plist->cur->next;

	*pdata = plist->cur->data;
	return TRUE;
}

int LRemove(List *plist)  //노드 삭제
	Node * rpos = plist->cur;
	int rdata = rpos->data;
	plist->before->next = plist->cur->next;
	plist->cur = plist->before;
	free(rpos);
	(plist->numOfData)--;
	return rdata;
}

int LCount(List *plist) { //현재 리스트에 존재하는 노드 개수 반환
	return plist->numOfData;
}

int WhoIsPrecede(int d1, int d2) { //정렬하기 위해 사용한 함수
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
