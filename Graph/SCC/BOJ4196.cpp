#include <cstdio>
#include <vector>
#include <stack>
#include <algorithm>
#include <cstring>
using namespace std;

vector <vector <int>> adj;
vector <int> scc_num;
stack <int> discover_stack;
int discover_time[100005];
int finish_time[100005];
int low_level[100005];
int color_check[100005];
int ind[100005];
int scc_group;
int time;

void scc_dfs(int v) { 
	color_check[v] = 1;
	discover_time[v] = ++time;
	discover_stack.push(v);
	low_level[v] = discover_time[v];
	int size = adj[v].size();
	for (int i = 0; i < size; i++) {
		int w = adj[v][i];
		if (color_check[w] == 0) {
			scc_dfs(w);
			low_level[v] = min(low_level[v], low_level[w]);
		}
		else if (color_check[w] == 1) {
			low_level[v] = min(low_level[v], discover_time[w]);
		}
		else if (color_check[w] == 2) {
			if (discover_time[v] < discover_time[w]) continue;
			else if (discover_time[v] > finish_time[w]) {
				if (scc_num[w] != 0) continue;
				else {
					low_level[v] = min(low_level[v], low_level[w]);
				}
			}
		}
	}
	color_check[v] = 2;
	finish_time[v] = ++time;
	if (discover_time[v] == low_level[v]) {
		scc_group++;
		while (1) {
			int top_v = discover_stack.top();
			scc_num[top_v] = scc_group;
			discover_stack.pop();
			if (top_v == v) break;
		}
	}
}


int main() {
	int N, M, t;
	int ans=0;
	scanf("%d", &t);
	while (t--) {
		memset(discover_time, 0, sizeof(discover_time));
		memset(finish_time, 0, sizeof(finish_time));
		memset(low_level, 0, sizeof(low_level));
		memset(color_check, 0, sizeof(color_check));
		memset(ind, 0, sizeof(ind));
		ans = time = scc_group = 0;
		scc_num.clear();
		adj.clear();
		scanf("%d%d", &N, &M);
		scc_num.resize(N + 1);
		adj.resize(N + 1);
		for (int i = 0; i<M; i++) {
			int a, b;
			scanf("%d%d", &a, &b);
			adj[a].push_back(b);
		}
		for (int i = 1; i <= N; i++) {
			if (color_check[i] == 0) scc_dfs(i);
		}
		for (int i = 1; i <= N; i++) {
			int size = adj[i].size();
			for (int j = 0; j < size; j++) {
				int w = adj[i][j];
				if (scc_num[i] != scc_num[w]) ind[scc_num[w]]++;
			}
		}
		for (int i = 1; i <= scc_group; i++) if (ind[i] == 0) ans++;
		printf("%d\n", ans);
	}
	return 0;
}