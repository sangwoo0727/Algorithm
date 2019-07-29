#include <iostream>
#include <cstdlib>
#include <cstdio>
using namespace std;

typedef struct _tree {
	_tree *parent;
	_tree *lnext;
	_tree *rnext;
	int data;
}Tree;

typedef struct {
	Tree * root;
	Tree * cur;
}Treepoint;

void postorder(Tree * tmp) {
	if (tmp == NULL) return;
	postorder(tmp->lnext);
	postorder(tmp->rnext);
	printf("%d\n", tmp->data);
	free(tmp);
}

int main() {
	int tmp;
	Treepoint * newtree = (Treepoint*)malloc(sizeof(Treepoint));
	newtree->cur = NULL; newtree->root = NULL; 
	while (scanf("%d", &tmp) != EOF) {
		Tree * newnode = (Tree*)malloc(sizeof(Tree));
		if (newtree->root == NULL) { //·çÆ®
			newnode->data = tmp;
			newnode->lnext = NULL;
			newnode->rnext = NULL;
			newnode->parent = NULL;
			newtree->root = newnode;
			newtree->cur = newnode;
		}
		else if (newtree->root != NULL) {
			Tree * ppos = NULL;
			while (1) {
				if (tmp < newtree->cur->data) {
					if (newtree->cur->lnext == NULL) {
						newnode->data = tmp;
						newnode->lnext = NULL;
						newnode->rnext = NULL;
						ppos = newtree->cur;
						ppos->lnext = newnode;
						break;
					}
					newtree->cur = newtree->cur->lnext;
				}
				else if (tmp > newtree->cur->data) {
					if (newtree->cur->rnext == NULL) {
						newnode->data = tmp;
						newnode->lnext = NULL;
						newnode->rnext = NULL;
						ppos = newtree->cur;
						ppos->rnext = newnode;
						newnode->parent = ppos;
						break;
					}
					newtree->cur = newtree->cur->rnext;
				}
			}
			newtree->cur = newtree->root;
		}
	}
	//newtree->cur = newtree->root;
	postorder(newtree->root);
	return 0;
}