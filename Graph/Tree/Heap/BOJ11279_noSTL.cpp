#include <iostream>
#include <algorithm>
using namespace std;

long tree[100005];

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N , cnt = 0;
	cin >> N;
	while (N--) {
		int n;
		cin >> n;
		if (n == 0) { // delete
			cout << tree[1] << '\n';
			if (tree[1] == 0) continue;
			tree[1] = tree[cnt];
			tree[cnt--] = 0;
			int idx = 1;
			while (idx < cnt) {
				int leftsub = idx * 2;
				int rightsub = idx * 2 + 1;
				if (rightsub <= cnt) {
					if (tree[idx] <= tree[leftsub] && tree[idx] <= tree[rightsub]) {
						if (tree[leftsub] >= tree[rightsub]) {
							swap(tree[idx], tree[leftsub]);
							idx=leftsub;
							continue;
						}
						else {
							swap(tree[idx], tree[rightsub]);
							idx = rightsub;
							continue;
						}
					}
					if (tree[idx] <= tree[leftsub] && tree[idx] >= tree[rightsub]) {
						swap(tree[idx], tree[leftsub]);
						idx = leftsub;
						continue;
					}
					if (tree[idx] >= tree[leftsub] && tree[idx] <= tree[rightsub]) {
						swap(tree[idx], tree[rightsub]);
						idx = rightsub;
						continue;
					}
					if (tree[idx] >= tree[leftsub] && tree[idx] >= tree[rightsub]) break;
				}
				if (leftsub <= cnt && rightsub > cnt) {
					if (tree[leftsub] > tree[idx]) {
						swap(tree[idx], tree[leftsub]);
						idx = leftsub;
						continue;
					}
					else break;
				}
				if (leftsub > cnt) {
					break;
				}
			}
		}
		else { // insert
			tree[++cnt] = n;
			int idx = cnt;
			if (cnt == 1) {
				continue;
			}
			while (idx > 1) {
				if (tree[idx / 2] < tree[idx]) {
					swap(tree[idx], tree[idx / 2]);
					idx /= 2;
				}
				else break;
			}
		}
	}
	return 0;
}