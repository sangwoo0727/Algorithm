/*2146�� �ٸ������
��ô����� �����ϱ����� ù ����
�ٸ��е��� ��� �ߴ����� �𸣰����� 
���ڵ忡�� comp�� ���� �߿��� �� ����.
ũ�� ���� 
1. ������ ���� ���̱�
2. ��ô����� ���� �������� �׵θ� ����
3. ��ô�� �س����鼭, �������� ���� ����
4. �ٸ��������� �� ��ô������ ��������, �Ÿ��� ���ؼ� ����
5. ����� �Ÿ��� �ּҰ����� �����س�����
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
int part_num = 1; //������ȣ ���̱����� ����
int dr[4] = { 0,0,1,-1 };
int dc[4] = { 1,-1,0,0 };
queue <pair<int, int>> q; 

void pre_bfs(int n, int m) { //������ȣ ���̱� ���� ���� �׷���Ž��

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
void bfs() { //�ּҰŸ��� ���ϱ� ���� Ž��
	int cnt = 0;
	int comp = check[q.front().first][q.front().second];
	while (q.empty() == 0) {
		int n = q.front().first;
		int m = q.front().second;
		if (check[n][m] > comp) { //�� ������ ��������, ���������� ���� ��ĭ �÷��ֱ� ���� �ڵ�
			cnt++;
			comp++;
		}
		q.pop();
		for (int k = 0; k < 4; k++) {
			int nnext = n + dr[k];
			int mnext = m + dc[k];
			if(check[nnext][mnext]!=0&&board[nnext][mnext]!=0&&board[nnext][mnext]!=board[n][m]){ 
				//�ٸ� �������� �� ��ô������ ��������
				result = check[nnext][mnext] + check[n][m]; //�Ÿ��� ���ϱ�
				Min = min(Min, result); //�ּҰ� ����
			}	
			if (nnext >= 0 && nnext < N && mnext >= 0 && mnext < N && check[nnext][mnext] == 0 && board[nnext][mnext] == 0) { 
				//��ô �������� check �迭�� �����Է°� board�迭�� ��𿵿����� ��ô�Ǿ� �°����� ����.
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
	for (int i = 0; i < N; i++) {  //�������� ���ڸ� �ٸ��� �Űܼ�, ���� �������� ����
		for (int j = 0; j < N; j++) {
			if (board[i][j] == 1 && check[i][j] == 0) {
				pre_bfs(i, j);
				part_num++;
			}
		}
	} 
	memset(check, 0, sizeof(check));
	for (int i = 0; i < N; i++) { //�׵θ����� ó�� ť���ٰ� ���� �ִ´�.
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