/* BOJ 15686 치킨배달*/

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;

int N, M;
int board[55][55];
int check[55][55];
int dp[120][15];
int sum = 0;
int Min = 10000000;
vector <pair <int, int>> home;
vector < pair <int, int>> kfc_home;
vector <int> v;

void dfs(int idx, int M_cnt) {
	if (M_cnt == M) {
		for (int i = 0; i < home.size(); i++) {
			int ans = 1000000;
			for (int j = 0; j < M ; j++) {
				ans=min(ans, dp[i][v[j]]);
			}
			sum += ans;
		}
		Min = min(Min, sum);
		sum = 0;
		return;
	}
	if (idx == kfc_home.size()) {
		return;
	}
	v.push_back(idx);
	dfs(idx + 1, M_cnt + 1);
	v.pop_back();
	dfs(idx+1, M_cnt);
}

int main() {
	scanf("%d%d", &N, &M);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%d", &board[i][j]);
			if (board[i][j] == 1) home.push_back({ i, j });
			if (board[i][j] == 2) kfc_home.push_back({ i,j });
		}
	}
	int h_size = home.size();
	int c_size = kfc_home.size();
	for (int i = 0; i < h_size; i++) {
		for (int j = 0; j < c_size; j++) {
			int distx = abs(home[i].first - kfc_home[j].first);
			int disty = abs(home[i].second - kfc_home[j].second);
			dp[i][j] = distx + disty;
		}
	}
	dfs(0, 0);
	printf("%d", Min);
	return 0;
}