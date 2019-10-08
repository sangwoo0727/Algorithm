/*1260번 dfs와 bfs
dfs bfs 방식을 이해하면서 기본적인 틀 구현하는
문제.*/

#include <iostream>
#include <algorithm> //정렬을 하기위한 헤더
#include <vector> //그래프를 만들기위한 헤더
#include <queue> //bfs에서 queue를 쓰기위한 헤더
#include <cstring> //memset을 위한 헤더
using namespace std;

vector <vector <int>> adj(1005); //인접리스트 만들기위한 vector
queue <int> q; //bfs에서 사용하기 위한 큐
int n, m, v, a, b;
int visit[1005]; //방문했으면 1로 체크 바꿔

void dfs(int now) {
	visit[now] = 1; //1로 방문기록 체크
	printf("%d ", now);
	for (int i = 0; i < adj[now].size(); i++) { //now에 인접리스트들을 방문할건데, 
		int next = adj[now][i];  //dfs이므로 재귀를 통해 깊이먼저 들어간다.
		if (visit[next] == 0) dfs(next); //방문 안한 곳에 대해 재귀 시작
	}
}
void bfs(int start) { 
	visit[start] = 1; //방문 기록 1로 체크
	q.push(start); // 방문한 곳 큐에 넣는다.
	while (q.empty() == 0) { //큐가 비어있지 않은 동안 반복
		int now = q.front(); // 현재 방문중인 곳은 큐의 맨앞부분,
		q.pop(); //큐에서 방문중인 곳을 빼낸 후
		printf("%d ", now); //출력
		for (int i = 0; i < adj[now].size(); i++) { //방문 중인 곳 기준으로, 인접리스트들을 방문
			int next = adj[now][i]; //다음 방문할 곳을 순차적으로 들어간다.
			if (visit[next] == 0) { //한번도 방문안했으면
				visit[next] = 1; //1로 방문 기록 넣고
				q.push(next); // 큐에 지금 방문한 곳을 집어넣는다.
			}
		}
	}
}
int main() {
	scanf("%d %d %d", &n, &m, &v);
	for (int i = 1; i <= m; i++) {
		scanf("%d %d", &a, &b);
		adj[a].push_back(b); //무방향 그래프이기 때문에 서로 연결해준다.
		adj[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		sort(adj[i].begin(), adj[i].end()); //입력값순서가 제각각일 수 있으므로 정렬을 해줘 작은 순서부터 참조할 수 있게 바꾼다.
	}
	dfs(v);
	printf("\n");
	memset(visit, 0, sizeof(visit)); // dfs활동이 끝나고 bfs 들어가기전 메모리셋으로 초기화시켜준다.
	bfs(v);
	printf("\n");
	return 0;
}