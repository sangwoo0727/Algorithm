#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
#include <cstring>

#define endl '\n'
using namespace std;

typedef struct {
	int r;
	int c;
	int speed;
	int dir;
	int size;
}shark;

vector <shark> sv;
int R, C, M;
int dr[5] = { 0,-1,1,0,0 };
int dc[5] = { 0,0,0,1,-1 };
shark check[105][105];
bool flag[105][105];
int ans;

bool cmp(const shark &p1, const shark &p2) {
	if (p1.c < p2.c) {
		return true;
	}
	else if (p1.c == p2.c) {
		return p1.r < p2.r;
	}
	else {
		return false;
	}
}

void fishing() {
	int tmp = 0;
	while (tmp <= C) {
		tmp++;
		memset(flag, false, sizeof(flag));
		memset(check, 0, sizeof(check));
		for (int n = 0; n < sv.size(); n++) {
			if (tmp == sv[n].c) {
				ans += sv[n].size;
				sv.erase(sv.begin() + n);
				break;
			}
		}
		for (int i = 0; i < sv.size(); i++) {
			if (sv[i].dir == 1 || sv[i].dir == 2) {
				int dist = sv[i].speed;
				dist %= ((R-1)*2);
				for (int move = 0; move < dist; move++) {
					if (sv[i].r == 1 || sv[i].r == R) {
						if (sv[i].r == 1) sv[i].dir = 2;
						else if (sv[i].r == R) sv[i].dir = 1;
					}
					sv[i].r = sv[i].r + dr[sv[i].dir];
				}
			}
			if (sv[i].dir == 3 || sv[i].dir == 4) {
				int dist = sv[i].speed;
				dist %= ((C-1)*2);
				for (int move = 0; move < dist; move++) {
					if (sv[i].c == 1 || sv[i].c == C) {
						if (sv[i].c == 1) sv[i].dir = 3;
						else if (sv[i].c == C) sv[i].dir = 4;
					}
					sv[i].c = sv[i].c + dc[sv[i].dir];
				}
			}
			if (flag[sv[i].r][sv[i].c]) {
				if (check[sv[i].r][sv[i].c].size < sv[i].size) {
					shark tmp = { sv[i].r,sv[i].c,sv[i].speed,sv[i].dir,sv[i].size };
					check[sv[i].r][sv[i].c] = tmp;
				}
			}
			if (!flag[sv[i].r][sv[i].c]) {
				shark tmp = { sv[i].r,sv[i].c,sv[i].speed,sv[i].dir,sv[i].size };
				check[sv[i].r][sv[i].c] = tmp;
			}
			flag[sv[i].r][sv[i].c] = true;
		}
		sv.clear(); sv.resize(0);
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (flag[i][j]) {
					shark tmp = { check[i][j].r,check[i][j].c,check[i][j].speed,check[i][j].dir,check[i][j].size };
					sv.push_back(tmp);
				}
			}
		}
		if (sv.size() == 0) break;
		sort(sv.begin(), sv.end(), cmp);
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> R >> C >> M;
	for (int i = 1; i <= M; i++) {
		int r, c, s, d, z;
		cin >> r >> c >> s >> d >> z;
		shark tmp = { r,c,s,d,z };
		sv.push_back(tmp);
	}
	if (M == 0) {
		cout << "0" << endl;
		return 0;
	}
	sort(sv.begin(), sv.end(),cmp);
	fishing();
	cout << ans << endl;
	return 0;
}