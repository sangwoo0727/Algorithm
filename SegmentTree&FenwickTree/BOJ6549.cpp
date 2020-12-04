
#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
using namespace std;

void make_seg(vector<int> &stick, vector<int> &segtree, int node, int start, int end) {
	if (start == end) {//start와 end 즉 구간이 점으로 바뀌면 리프노드에 있는 그 자체 인덱스가 된다.
		segtree[node] = start;
		return;
	}
	// start와 end가 다른 경우(리프노드가 아닌 경우)
	make_seg(stick, segtree, node * 2, start, (start + end) / 2);
	make_seg(stick, segtree, node * 2 + 1, (start + end) / 2 + 1, end);
	// 각 구간에서 가장 높이가 낮은 직사각형의 인덱스를 노드에 넣어준다.
	if (stick[segtree[node * 2]] <= stick[segtree[node * 2 + 1]])
		segtree[node] = segtree[node * 2]; //더 높이가 작은 스틱의 idx 값을 세그먼트트리에 넣는다
	else segtree[node] = segtree[node * 2 + 1];
}

int repeat_func(vector<int> &stick, vector<int> &segtree, int node, int start, int end, int left, int right) { //쿼리작업
	//구하고자 하는 범위는 left~right , start와 end로 구간 나눔
	if (left > end || right < start)	return -1;
	if (left <= start && end <= right)	return segtree[node];
	int left_ans = repeat_func(stick, segtree, node * 2, start, (start+end)/2, left, right);
	int right_ans = repeat_func(stick, segtree, node * 2 + 1, (start + end)/2 + 1, end, left, right);
	if (left_ans == -1) return right_ans;
	if (right_ans == -1) return left_ans;
	if (stick[right_ans] >= stick[left_ans]) return left_ans;
	else return right_ans;
}

long long Max_Rectangle(vector<int> &stick, vector<int> &segtree, int left, int right) {
	int min_idx = repeat_func(stick, segtree, 1, 0, stick.size() - 1, left, right); // 쿼리를 통해 그 구간에 대한 최소 높이 막대 인덱스 가져옴
	long long area = (long long)(right - left + 1)*(long long)stick[min_idx];
	if (left <= min_idx - 1) { //최소높이 찾은 막대기 인덱스 왼쪽에 아직 스틱들이 존재하면 분할정복
		long long left_area = Max_Rectangle(stick, segtree, left, min_idx - 1);
		area = max(area, left_area);
	}
	if (right >= min_idx + 1) {//최소높이 찾은 막대기 인덱스 오른쪽에 아직 스틱들이 존재하면 분할정복
		long long right_area = Max_Rectangle(stick, segtree, min_idx + 1, right);
		area = max(area, right_area);
	}
	return area; // 최대 넓이 반환
}

int main() {
	while (1) {
		int n;
		scanf("%d", &n);
		if (n == 0) break;
		int h = 0;
		if (log2(n) == (int)log2(n)) h = (int)log2(n);
		else h = (int)log2(n) + 1;
		vector<int> stick(n);  //히스토그램의 높이가 저장된 배열
		for (int i = 0; i < n; i++) scanf("%d", &stick[i]);
		int tree_size = pow(2, h + 1); //세그먼트 트리 최대 사이즈
		vector<int> segtree(tree_size); //세그먼트 트리를 만들기 위한 배열 -> 값으로는 arr의 인덱스번호가 들어감
		make_seg(stick, segtree, 1, 0, n - 1); // 세그먼트 트리 형성
		long long result = Max_Rectangle(stick, segtree, 0, n - 1);
		printf("%lld\n", result);
	}
	return 0;
}
