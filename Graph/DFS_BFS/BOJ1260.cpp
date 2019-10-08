/*1260�� dfs�� bfs
dfs bfs ����� �����ϸ鼭 �⺻���� Ʋ �����ϴ�
����.*/

#include <iostream>
#include <algorithm> //������ �ϱ����� ���
#include <vector> //�׷����� ��������� ���
#include <queue> //bfs���� queue�� �������� ���
#include <cstring> //memset�� ���� ���
using namespace std;

vector <vector <int>> adj(1005); //��������Ʈ ��������� vector
queue <int> q; //bfs���� ����ϱ� ���� ť
int n, m, v, a, b;
int visit[1005]; //�湮������ 1�� üũ �ٲ�

void dfs(int now) {
	visit[now] = 1; //1�� �湮��� üũ
	printf("%d ", now);
	for (int i = 0; i < adj[now].size(); i++) { //now�� ��������Ʈ���� �湮�Ұǵ�, 
		int next = adj[now][i];  //dfs�̹Ƿ� ��͸� ���� ���̸��� ����.
		if (visit[next] == 0) dfs(next); //�湮 ���� ���� ���� ��� ����
	}
}
void bfs(int start) { 
	visit[start] = 1; //�湮 ��� 1�� üũ
	q.push(start); // �湮�� �� ť�� �ִ´�.
	while (q.empty() == 0) { //ť�� ������� ���� ���� �ݺ�
		int now = q.front(); // ���� �湮���� ���� ť�� �Ǿպκ�,
		q.pop(); //ť���� �湮���� ���� ���� ��
		printf("%d ", now); //���
		for (int i = 0; i < adj[now].size(); i++) { //�湮 ���� �� ��������, ��������Ʈ���� �湮
			int next = adj[now][i]; //���� �湮�� ���� ���������� ����.
			if (visit[next] == 0) { //�ѹ��� �湮��������
				visit[next] = 1; //1�� �湮 ��� �ְ�
				q.push(next); // ť�� ���� �湮�� ���� ����ִ´�.
			}
		}
	}
}
int main() {
	scanf("%d %d %d", &n, &m, &v);
	for (int i = 1; i <= m; i++) {
		scanf("%d %d", &a, &b);
		adj[a].push_back(b); //������ �׷����̱� ������ ���� �������ش�.
		adj[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		sort(adj[i].begin(), adj[i].end()); //�Է°������� �������� �� �����Ƿ� ������ ���� ���� �������� ������ �� �ְ� �ٲ۴�.
	}
	dfs(v);
	printf("\n");
	memset(visit, 0, sizeof(visit)); // dfsȰ���� ������ bfs ������ �޸𸮼����� �ʱ�ȭ�����ش�.
	bfs(v);
	printf("\n");
	return 0;
}