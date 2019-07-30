#include <iostream>
#include <malloc.h>
#include <cstring>
using namespace std;

typedef struct _node{
	_node *next;
	_node *parent;
	int data;
}Node;

typedef struct {
	Node *head;
	Node *cur;
	Node *temp;
}dummy;

int queuesize = 0;

void push(dummy * plist,int data) {
	Node *newnode = (Node*)malloc(sizeof(Node));
	newnode->data = data;
	if (plist->head == NULL) {
		plist->head = newnode;
		plist->cur = newnode;
		newnode->parent = NULL;
		newnode->next = NULL;
		queuesize++;
	}
	else {
		newnode->parent = plist->cur;
		plist->cur->next = newnode;
		plist->cur = newnode;
		newnode->next = NULL;
		queuesize++;
	}
}

int pop(dummy *plist) {
	if (plist->head == NULL) {
		return -1;
	}
	else {
		int temp = plist->head->data;
		plist->temp = plist->head;
		plist->head = plist->head->next;
		free(plist->temp);
		queuesize--;
		return temp;
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int T;
	cin >> T;
	dummy *newqueue = (dummy*)malloc(sizeof(dummy));
	newqueue->cur = NULL; newqueue->head = NULL;
	for (int t = 0; t < T; t++) {
		char str[10];
		int num;
		cin >> str;
		if (strcmp(str, "push") == 0) {
			cin >> num;
			push(newqueue,num);
		}
		else if (strcmp(str, "pop") == 0) {
			cout << pop(newqueue) << '\n';
		}
		else if (strcmp(str, "size") == 0) {
			cout << queuesize << '\n';
		}
		else if (strcmp(str, "empty") == 0) {
			if (queuesize > 0) cout << "0" << '\n';
			else cout << "1" << '\n';
		}
		else if (strcmp(str, "front") == 0) {
			if (newqueue->head == NULL) cout << "-1" << '\n';
			else cout << newqueue->head->data << '\n';
		}
		else if (strcmp(str, "back") == 0) {
			if (newqueue->head == NULL) cout << "-1" << '\n';
			else cout << newqueue->cur->data << '\n';
		}
	}
	return 0;
}