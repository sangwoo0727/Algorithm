#include <iostream>
#include <cstring>
#define STACK_LEN 100
using namespace std;

typedef struct{
	int stackArr[STACK_LEN];
	int topIndex;
}Stack;

void StackInit(Stack * pstack) { //스택 초기화
	pstack->topIndex = -1;
}
int SIsEmpty(Stack * pstack) {
	if (pstack->topIndex == -1) return 1;
	else return 0;
}
void SPush(Stack * pstack, int data) {
	pstack->topIndex += 1;
	pstack->stackArr[pstack->topIndex] = data;
}
int SPop(Stack * pstack) {
	int rIdx;
	if (SIsEmpty(pstack)) {
		printf("Stack Memory Error!");
		exit(-1);
	}
	rIdx = pstack->topIndex;
	pstack->topIndex -= 1;
	return pstack->stackArr[rIdx];
}
int SPeek(Stack * pstack) {
	if (SIsEmpty(pstack)) {
		printf("Stack Memory Error!");
		exit(-1);
	}
	return pstack->stackArr[pstack->topIndex];
}

int main() {
	Stack stack;
	StackInit(&stack);
	SPush(&stack, 1);
	SPush(&stack, 2);
	SPush(&stack, 3);
	SPush(&stack, 4);
	SPush(&stack, 5);
	while (!SIsEmpty(&stack)) printf("%d ", SPop(&stack));
	return 0;
}