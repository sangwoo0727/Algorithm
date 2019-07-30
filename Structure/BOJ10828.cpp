#include <iostream>
#include <malloc.h>
#include <cstring>
using namespace std;

typedef struct _node {
	_node *next;
	_node *parent;
	int data;
}Node;

typedef struct {
	Node *head;
	Node *cur;
	Node *temp;
}dummy;

int stacksize = 0;

void push(dummy * plist, int data) {
	Node * newnode = (Node*)malloc(sizeof(Node));
	newnode->data = data;
	newnode->next = NULL;
	if (plist->head = NULL) {
		plist->head = newnode;
		plist->cur = newnode;
		newnode->parent = NULL;
		stacksize++;
	}
	else {
		newnode->parent = plist->cur;
		plist->cur = newnode;
		stacksize++;
	}
}

int pop(dummy *plist) {
	if (plist->cur == NULL) {
		return -1;
	}
	else {
		int temp = plist->cur->data;
		plist->temp = plist->cur;
		plist->cur = plist->cur->parent;
		if (plist->cur == NULL) {
			free(plist->temp);
			stacksize--;
			return temp;
		}
		else {
			plist->cur->next = NULL;
			free(plist->temp);
			stacksize--;
			return temp;
		}
	}
}

int top(dummy *plist) {
	if (stacksize == 0) return -1;
	else {
		return plist->cur->data;
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int T;
	cin >> T;
	dummy *newstack = (dummy*)malloc(sizeof(dummy));
	newstack->cur = NULL; newstack->head = NULL;
	for (int t = 0; t < T; t++) {
		char str[10];
		int num;
		cin >> str;
		if (strcmp(str, "push") == 0) {
			cin >> num;
			push(newstack, num);
		}
		else if (strcmp(str, "pop") == 0) {
			cout << pop(newstack) << '\n';
		}
		else if (strcmp(str, "size") == 0) {
			cout << stacksize << '\n';
		}
		else if (strcmp(str, "empty") == 0) {
			if (stacksize > 0) cout << "0" << '\n';
			else cout << "1" << '\n';
		}
		else if (strcmp(str, "top") == 0) {
			cout << top(newstack) << '\n';
		}
	}
	return 0;
}