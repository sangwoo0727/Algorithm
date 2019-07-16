#include <iostream>
#include <cstdlib>
using namespace std;

typedef struct _node {
	int data;
	struct _node *next;
}Node;

typedef struct{
	Node *head;
}stack;

void  StackInit(stack * pstack) {
	pstack->head = NULL;
}

int SIsEmpty(stack *pstack) {
	if (pstack->head == NULL) return 1;
	else return 0;
}

void SPush(stack *pstack, int data) {
	Node * newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;
	newNode->next = pstack->head;
	pstack->head = newNode;
}

int SPop(stack *pstack) {
	int rdata;
	Node * rnode;
	if (SIsEmpty(pstack)) {
		cout << "Stack Memory Error!" << endl;
		exit(-1);
	}
	rdata = pstack->head->data;
	rnode = pstack->head;
	pstack->head = pstack->head->next;
	free(rnode);
	return rdata;
}

int SPeek(stack *pstack) {
	if (SIsEmpty(pstack)) {
		cout << "Stack Memory Error" << endl;
		exit(-1);
	}
	return pstack->head->data;
}
int main() {
	stack list;
	StackInit(&list);
	SPush(&list, 1);
	SPush(&list, 2);
	SPush(&list, 3);
	SPush(&list, 4);
	SPush(&list, 5);
	while (!SIsEmpty(&list)) cout << SPop(&list) << endl;
	return 0;
}