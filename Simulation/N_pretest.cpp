#include <iostream>
#include <string>
#include <queue>
using namespace std;

string str[100][100];
queue <string> q[50];
int N, W;

void dir_list(int *start, int *end) {
	for (int i = *start; i <= *end; i++) {
		q[*start].push(str[i][*start]);
	}
	for (int i = *start + 1; i <= *end; i++) {
		q[*start].push(str[*end][i]);
	}
	for (int i = *end - 1; i >= *start; i--) {
		q[*start].push(str[i][*end]);
	}
	for (int i = *end - 1; i > *start; i--) {
		q[*start].push(str[*start][i]);
	}
}
void redir_list(int *start, int *end) {
	for (int i = *start; i <= *end; i++) {
		q[*start].push(str[*start][i]);
	}
	for (int i = *start + 1; i <= *end; i++) {
		q[*start].push(str[i][*end]);
	}
	for (int i = *end - 1; i >= *start; i--) {
		q[*start].push(str[*end][i]);
	}
	for (int i = *end - 1; i > *start; i--) {
		q[*start].push(str[i][*start]);
	}
}
void make_dir(int *start, int *end) {
	for (int i = *start; i <= *end; i++) {
		str[i][*start] = q[*start].front();
		q[*start].pop(); 
	}
	for (int i = *start + 1; i <= *end; i++) {
		str[*end][i] = q[*start].front();
		q[*start].pop();
	}
	for (int i = *end - 1; i >= *start; i--) {
		str[i][*end] = q[*start].front();
		q[*start].pop();
	}
	for (int i = *end - 1; i > *start; i--) {
		str[*start][i] = q[*start].front();
		q[*start].pop();
	}
}
void make_redir(int *start, int *end) {
	for (int i = *start; i <= *end; i++) {
		str[*start][i] = q[*start].front();
		q[*start].pop();
	}
	for (int i = *start + 1; i <= *end; i++) {
		str[i][*end] = q[*start].front();
		q[*start].pop();
	}
	for (int i = *end - 1; i >= *start; i--) {
		str[*end][i] = q[*start].front();
		q[*start].pop();
	}
	for (int i = *end - 1; i > *start; i--) {
		str[i][*start] = q[*start].front();
		q[*start].pop();
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> W;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> str[i][j];
		}
	}
	int dir = W, start_tmp = 0, end_tmp = N - 1;
	while (start_tmp <= (N - 1) / 2) {
		if (dir < 0) {
			redir_list(&start_tmp, &end_tmp);
			dir *= -1;
		}
		else if (dir > 0) {
			dir_list(&start_tmp, &end_tmp);
			dir *= -1;
		}
		start_tmp++; end_tmp--;
	}
	end_tmp = N - 1;
	dir = W;
	for (int i = 0; i <= (N - 1) / 2; i++) {
		if (dir < 0) {
			int spin = 0;
			if (end_tmp != i) spin = (dir*-1) % (2 * (end_tmp - i + 1) + 2 * (end_tmp - i -1 ));
			else if (end_tmp == i) spin = 1;
			while (spin--) {
				string tmp = q[i].front();
				q[i].pop();
				q[i].push(tmp);
			}
			start_tmp = i;
			make_redir(&start_tmp, &end_tmp);
		}
		else if (dir > 0) {
			int spin = 0;
			if (end_tmp != i) spin = dir % (2 * (end_tmp - i + 1) + 2 * (end_tmp - i - 1));
			else if (end_tmp == i) spin = 1;
			while (spin--) {
				string tmp = q[i].front();
				q[i].pop();
				q[i].push(tmp);
			}
			start_tmp = i;
			make_dir(&start_tmp, &end_tmp);
		}
		dir *= -1;
		end_tmp--;
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (j != N - 1) cout << str[i][j] << " ";
			else if (j == N - 1) cout << str[i][j] << "\n";
		}
	}
	return 0;
}