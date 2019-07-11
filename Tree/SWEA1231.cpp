#include <iostream>
#include <cstdlib>
using namespace std;

typedef struct Node {
	Node *left;
	Node *right;
	Node *next;
	int num;
	char data;
}node;

typedef struct{
	node * head;
	node * cur;
}tree;

int N;

void Inorder(node * bt) {
	if (bt == NULL) return;
	Inorder(bt->left);
	cout << bt->data;
	Inorder(bt->right);
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (int t = 1; t <= 10; t++) {
		cin >> N;
		tree tl;
		tl.head = NULL;
		tl.cur = NULL;
		for (int i = 1; i <= N; i++) {
			node *newnode = (node*)malloc(sizeof(node));
			if (tl.head == NULL && tl.cur == NULL) {
				tl.head = newnode;
				tl.cur = newnode;
			}
			tl.cur->next = newnode;
			tl.cur = newnode;
		}
		tl.cur = tl.head;
		for (int i = 1; i <= N; i++) {
			int left, right;
			cin >> tl.cur->num;
			cin >> tl.cur->data;
			if (tl.cur->num * 2 < N) {
				cin >> left >> right;
				node * temp = tl.cur;
				for (int j = i; j < left; j++) {
					temp = temp->next;
				}
				tl.cur->left = temp;
				temp->num = left;
				temp = tl.cur;
				for (int j = i; j < right; j++) {
					temp = temp->next;
				}
				tl.cur->right = temp;
				temp->num = right;
			}
			else if (tl.cur->num * 2 == N) {
				cin >> left;
				node * temp = tl.cur;
				for (int j = i; j < left; j++) {
					temp = temp->next;
				}
				tl.cur->left = temp;
				temp->num = left;
				tl.cur->right = NULL;
			}
			else {
				tl.cur->left = NULL;
				tl.cur->right = NULL;
			}
			tl.cur = tl.cur->next;
		}
		tl.cur = tl.head;
		cout << '#' << t << ' ';
		Inorder(tl.cur);
		cout << '\n';
		tl.cur = tl.head;
		for (int i = 1; i < N; i++) {
			node * rpos = tl.cur->next;
			free(tl.cur);
			tl.cur = rpos;
		}
	}
}