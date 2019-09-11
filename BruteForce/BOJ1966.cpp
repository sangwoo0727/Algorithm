#include <iostream>
#include <deque>
using namespace std;


int N, M; //n은 문서의 수, m은 궁금한 문서가 어디있는지

int main() {
	int t;
	cin >> t;
	while (t--) {
		deque <pair <int, int>> d;
		cin >> N >> M;
		for (int i = 0; i < N; i++) {
			int imp = 0;
			cin >> imp;
			if (i == M) {
				d.push_back({ imp, 1 });
			}
			else {
				d.push_back({ imp,0 });
			}
		}
		int cnt = 1;
		while (1) {
			int op = d.front().first;
			int check = d.front().second;
			if (check == 0) {
				int tmp = 0;
				for (int i = 1; i < d.size(); i++) {
					if (op >= d[i].first) {
						continue;
					}
					else if (op < d[i].first) {
						d.pop_front();
						d.push_back({ op, check });
						tmp = 1;
						break;
					}
				}
				if (tmp == 0) {
					cnt++;
					d.pop_front();
				}
			}
			else {
				int tmp = 0;
				for (int i = 1; i < d.size(); i++) {
					if (op >= d[i].first) {
						continue;
					}
					else if (op < d[i].first) {
						d.pop_front();
						d.push_back({ op, check });
						tmp = 1;
						break;
					}
				}
				if (tmp == 0) {
					cout << cnt << endl;
					d.pop_front();
					break;
				}
			}
		}
	}
	return 0;
}