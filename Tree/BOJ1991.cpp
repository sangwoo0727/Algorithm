#include <iostream>
#include <cstdlib>
using namespace std;

typedef struct _treenode{
	char c;
	_treenode *left;
	_treenode *right;
	_treenode *next;
}treenode;

typedef struct {
	treenode *root;
	treenode *cur;
}Tree;

void preorder(treenode * plist) {
	cout << plist->c;
	if(plist->left != NULL) preorder(plist->left);
	if(plist->right != NULL) preorder(plist->right);	
}
void inorder(treenode * plist) {
	if (plist->left != NULL) inorder(plist->left);
	cout << plist->c;
	if (plist->right != NULL) inorder(plist->right);
}
void postorder(treenode * plist) {
	if (plist->left != NULL) postorder(plist->left);
	if (plist->right != NULL) postorder(plist->right);
	cout << plist->c;
	free(plist);
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;
	Tree *tree = (Tree*)malloc(sizeof(Tree));
	tree->root = NULL; tree->cur = NULL;
	for (int n = 0; n < N; n++) {
		if (n == 0) {
			treenode *newnode = (treenode*)malloc(sizeof(treenode));
			tree->root = newnode;
			tree->cur = newnode;
			newnode->c = 'A';
		}
		else {
			treenode *newnode = (treenode*)malloc(sizeof(treenode));
			tree->cur->next = newnode;
			tree->cur = newnode;
			newnode->c = 'A' + n;
		}
	}
	tree->cur->next = NULL;
	for (int n = 0; n < N; n++) {
		tree->cur = tree->root;
		char ctmp, ltmp, rtmp;
		cin >> ctmp >> ltmp >> rtmp;
		while(1) {
			if (tree->cur->c == ctmp) {
				break;
			}
			tree->cur = tree->cur->next;
		}
		treenode *tmp = tree->cur;
		tree->cur = tree->root;
		if (ltmp != '.' && rtmp != '.') {
			while (tree->cur != NULL) {
				if (tree->cur->c == ltmp) {
					tmp->left = tree->cur;
					break;
				}
				tree->cur = tree->cur->next;
			}
			tree->cur = tree->root;
			while (tree->cur != NULL) {
				if (tree->cur->c == rtmp) {
					tmp->right = tree->cur;
					break;
				}
				tree->cur = tree->cur->next;
			}
		}
		else if (ltmp == '.' && rtmp != '.') {
			tmp->left = NULL;
			while (tree->cur != NULL) {
				if (tree->cur->c == rtmp) {
					tmp->right = tree->cur;
					break;
				}
				tree->cur = tree->cur->next;
			}
		}
		else if (ltmp != '.' && rtmp == '.') {
			tmp->right = NULL;
			while (tree->cur != NULL) {
				if (tree->cur->c == ltmp) {
					tmp->left = tree->cur;
					break;
				}
				tree->cur = tree->cur->next;
			}
		}
		else {
			tmp->left = NULL;
			tmp->right = NULL;
		}
	}
	preorder(tree->root);
	cout << "\n";
	inorder(tree->root);
	cout << "\n";
	postorder(tree->root);
	cout << "\n";
	free(tree);
	return 0;
}