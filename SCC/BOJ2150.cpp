#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

vector <vector <int>> adj;
stack <int> discover_stack;
int discover_time[10005]; 
int finish_time[10005];
int lowlevel[10005]; //backedge , cross edge와의 비교를 통해 어디까지 올라가는지에 대한 정보
int color_check[10005];//0->white 1->gray 2->black
int scc[10005]; //scc 그룹으로 묶기위한
int time; //discover와 finish time을 재기위한 변수
int V, E;
int scc_group = 1; 

void scc_dfs(int v) {
	discover_stack.push(v);
	color_check[v] = 1;
	discover_time[v] = ++time;
	lowlevel[v] = discover_time[v];
	int size = adj[v].size();
	for (int i = 0; i < size; i++) {
		int w = adj[v][i];
		if (color_check[w] == 0) { //화이트일때 dfs 진행
			scc_dfs(w);
			lowlevel[v] = min(lowlevel[v], lowlevel[w]);
		}
		else if (color_check[w] == 1) {//backedge 일때
			lowlevel[v] = min(lowlevel[v], discover_time[w]);
		}
		else if (color_check[w] == 2) {//cross or forward
			if (discover_time[v] > finish_time[w]) { //cross
				if (scc[w]!=0) continue;
				else {
					lowlevel[v] = min(lowlevel[v], lowlevel[w]);
				}
			}
			else if (discover_time[v] < discover_time[w]) {//forward
				continue;
			}
		}
	}
	finish_time[v] = ++time;
	color_check[v] = 2;
	if (lowlevel[v] == discover_time[v]) { //리더
		while (1) {
			int idx = discover_stack.top();
			scc[idx] = scc_group;
			discover_stack.pop();
			if (idx == v) break;
		}
		scc_group++;
	}
}

int main() {
	scanf("%d%d", &V, &E);
	adj.resize(V + 1);
	for (int i = 0; i < E; i++) {
		int a, b;
		scanf("%d%d", &a, &b);
		adj[a].push_back(b);
	}
	for (int i = 1; i <= V; i++) {
		if (!color_check[i]) scc_dfs(i);
	}
	printf("%d\n", --scc_group);
	int group = 0;
	for (int i = 1; i <= V; i++) {
		if (scc[i] == -1) continue;
		group = scc[i];
		for (int j = i; j <= V; j++) {
			if (scc[j] == group) {
				printf("%d ", j);
				scc[j] = -1;
			}
		}
		printf("-1\n");
	}
	return 0;
}