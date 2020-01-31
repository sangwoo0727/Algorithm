/*2146번 다리만들기
간척사업을 구현하기위한 첫 문제
다른분들이 어떻게 했는지는 모르겠지만 
이코드에선 comp가 가장 중요한 것 같다.
크게 보면 
1. 영역들 단지 붙이기
2. 간척사업을 위한 영역들의 테두리 선택
3. 간척을 해나가면서, 계층별로 값을 저장
4. 다른영역에서 온 간척지들이 만났을때, 거리를 더해서 저장
5. 저장된 거리를 최소값으로 갱신해나가기
https://www.acmicpc.net/problem/2146
*/

#include <iostream>
#include <queue>
#include <utility>
#include <cstring>
#include <algorithm>
using namespace std;

int N;
int Min = 1000000;
int result;
int board[105][105];
int check[105][105];
int part_num = 1; //단지번호 붙이기위한 변수
int dr[4] = { 0,0,1,-1 };
int dc[4] = { 1,-1,0,0 };
queue <pair<int, int>> q; 

void pre_bfs(int n, int m) { //단지번호 붙이기 위한 사전 그래프탐색

	queue <pair <int, int>> pre_q;
	check[n][m] = 1;
	pre_q.push({ n,m });
	while (pre_q.empty() == 0) {
		int rn = pre_q.front().first;
		int cm = pre_q.front().second;
		board[rn][cm] = part_num;
		pre_q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = rn + dr[k];
			int mnext = cm + dc[k];
			if (nnext >= 0 && nnext < N&&mnext >= 0 && mnext < N&&check[nnext][mnext] == 0 && board[nnext][mnext] !=0) {
				check[nnext][mnext] = 1;
				pre_q.push({ nnext,mnext });
			}
		}
	}
}
void bfs() { //최소거리를 구하기 위한 탐색
	int cnt = 0;
	int comp = check[q.front().first][q.front().second];
	while (q.empty() == 0) {
		int n = q.front().first;
		int m = q.front().second;
		if (check[n][m] > comp) { //한 레벨이 끝났을때, 다음레벨의 값을 한칸 올려주기 위한 코드
			cnt++;
			comp++;
		}
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if(check[nnext][mnext]!=0&&board[nnext][mnext]!=0&&board[nnext][mnext]!=board[n][m]){ 
				//다른 영역에서 온 간척지들이 만났을때
				result = check[nnext][mnext] + check[n][m]; //거리를 구하기
				Min = min(Min, result); //최소값 갱신
			}	
			if (nnext >= 0 && nnext < N && mnext >= 0 && mnext < N && check[nnext][mnext] == 0 && board[nnext][mnext] == 0) { 
				//간척 계층마다 check 배열에 계층입력과 board배열엔 어디영역에서 간척되어 온건지를 구현.
				check[nnext][mnext] = cnt+1;
				board[nnext][mnext] = board[n][m];
				q.push({ nnext,mnext });
			}
		}

	}
}
int main() {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	for (int i = 0; i < N; i++) {  //영역별로 숫자를 다르게 매겨서, 섬을 종류별로 나눔
		for (int j = 0; j < N; j++) {
			if (board[i][j] == 1 && check[i][j] == 0) {
				pre_bfs(i, j);
				part_num++;
			}
		}
	} 
	memset(check, 0, sizeof(check));
	for (int i = 0; i < N; i++) { //테두리들을 처음 큐에다가 전부 넣는다.
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < 4; k++) {
				int simx = i + dr[k];
				int simy = j + dc[k];
				if (board[i][j]!=0 && board[simx][simy] == 0) {
					q.push({ i,j });
					break;
				}
			}
		}
	}
	bfs();
	printf("%d", Min);
	return 0;
}