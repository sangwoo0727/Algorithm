#include <iostream>
#include <vector>
using namespace std;

char color[100];
int time;
int discover_time[100];
int finish_time[100];
int V, E;
int ans[100];
int idx;
bool cycle_exist=false;
vector <vector <int>> adj(100);

void DFS(int v) {
	color[v] = 'g'; //gray
	discover_time[v] = ++time;
	int size = adj[v].size();
	for (int i = 0; i < size; i++) {
		int w = adj[v][i];
		if (color[w] == 'w') {//white 만날때
			color[w] = 'g';
			DFS(w);
		}
		if (color[w] == 'g') {//gray 만날때
			cycle_exist = true;
			return;
		}
		if (color[w] == 'b') {//black
			continue;
		}
	}
	finish_time[v] = ++time;
	color[v] = 'b';
	ans[idx++] = v;
}
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> V >> E;
	int a, b;
	for (int i = 0; i < E; i++) {
		cin >> a >> b;
		adj[a].push_back(b); //a->b로 
	}
	for (int i = 1; i <= V; i++) {
		color[i] = 'w';//white
	}
	for (int i = 1; i <= V; i++) {
		if (color[i] == 'w') {
			DFS(i);
		}
	}
	if (cycle_exist) cout << "위상정렬 실패(사이클 존재)\n";
	else {
		for (int i = V - 1; i >= 0; i--) cout << ans[i] << " ";
		cout << "\n";
	}
	return 0;
}

