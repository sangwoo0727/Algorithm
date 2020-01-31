/*11403�� ���ã�� ����
��������� ���� ����׷����� ���ͷ� ��Ÿ���ְ� i���� j�� ���� ����� �ִ��� 
ã�� ������. 
bfs�� ���������� Ÿ�ٱ��� Ž���ϴ� ������ �ߴµ�, ��� Ʋ�ȴٰ� ���ͼ� ���� �ظ̴�..
������ Ž���� �� ��, ť�� ���� ���Ӱ� �ٽ� ���ߵǴµ� ť�� ������� ���� ��찡 �����ߴ�.
*/

#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;

int n;
vector <vector <int>> adj(100);
queue <int> q;
int arr[100][100];
int ans[100][100];
int check[100];

void clear(queue<int> &q) {
	queue <int> empty;
	swap(q, empty);
}
int bfs(int start, int target) {
	check[start] = 1;
	q.push(start);
	while (q.empty() == 0) {
		int now = q.front();
		q.pop();
		for (int i = 0; i < adj[now].size(); i++) {
			int next = adj[now][i];
			if (next == target) return 1;
			if (check[next] == 0) {
				check[next] = 1;
				q.push(next);
			}
		}
	}
	return 0;
}
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 1)	adj[i].push_back(j);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d ", bfs(i, j));
			memset(check, 0, sizeof(check));
			clear(q);
		}
		printf("\n");
	}
	return 0;
}