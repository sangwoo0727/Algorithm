/* BOJ 15685 µå·¡°ï Ä¿ºê*/

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

typedef struct {
	int x;
	int y;
	int d;
	int g;
}dragon_infor;

dragon_infor arr[22][1100];
int check[105][105];
int x, y, d, g;
int dc[4] = {0,-1,0,1};
int dr[4] = {1,0,-1,0};

void dragon_check(int idx, int level, int size) {
	for (level; level <= size; level++) {
		int tmp = (int)pow(2, level - 1);
		int num = 1;
		for (int i = (int)pow(2, level - 1); i <= (int)pow(2, level); i++) {
			if (num > tmp) {
				arr[idx][i].x = arr[idx][i - 1].x + dc[arr[idx][i - 1].d];
				arr[idx][i].y = arr[idx][i - 1].y + dr[arr[idx][i - 1].d];
				check[arr[idx][i].x][arr[idx][i].y] = 1;
				break;
			}
			arr[idx][i].x = arr[idx][i - 1].x + dc[arr[idx][i - 1].d];
			arr[idx][i].y = arr[idx][i - 1].y + dr[arr[idx][i - 1].d];
			check[arr[idx][i].x][arr[idx][i].y] = 1;
			if (arr[idx][(int)pow(2,level-1) - num].d == 3) arr[idx][i].d = 0;
			else {
				arr[idx][i].d = arr[idx][(int)pow(2,level-1) - num].d + 1;
			}
			num++;
		}
	}
}


int main() {
	int N;
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		scanf("%d%d%d%d", &arr[i][0].y, &arr[i][0].x, &arr[i][0].d, &arr[i][0].g);
		check[arr[i][0].x][arr[i][0].y] = 1;
		arr[i][1].x = arr[i][0].x + dc[arr[i][0].d];
		arr[i][1].y = arr[i][0].y + dr[arr[i][0].d];
		check[arr[i][1].x][arr[i][1].y] = 1;
		if (arr[i][0].d == 3) arr[i][1].d = 0;
		else arr[i][1].d = arr[i][0].d + 1;
	}
	for (int i = 1; i <= N; i++) {
		dragon_check(i,1, arr[i][0].g);
	}
	int ans = 0;
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (check[i][j] == 1) {
				if (check[i][j + 1] == 1 && check[i + 1][j + 1] == 1 && check[i + 1][j] == 1) ans++;
			}
		}
	}
	printf("%d", ans);
	return 0;
}