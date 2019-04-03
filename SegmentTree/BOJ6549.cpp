/*��ǻ���������к� 201221315 �� �� ��*/
#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
using namespace std;

void make_seg(vector<int> &stick, vector<int> &segtree, int node, int start, int end) {
	if (start == end) {//start�� end �� ������ ������ �ٲ�� ������忡 �ִ� �� ��ü �ε����� �ȴ�.
		segtree[node] = start;
		return;
	}
	// start�� end�� �ٸ� ���(������尡 �ƴ� ���)
	make_seg(stick, segtree, node * 2, start, (start + end) / 2);
	make_seg(stick, segtree, node * 2 + 1, (start + end) / 2 + 1, end);
	// �� �������� ���� ���̰� ���� ���簢���� �ε����� ��忡 �־��ش�.
	if (stick[segtree[node * 2]] <= stick[segtree[node * 2 + 1]])
		segtree[node] = segtree[node * 2]; //�� ���̰� ���� ��ƽ�� idx ���� ���׸�ƮƮ���� �ִ´�
	else segtree[node] = segtree[node * 2 + 1];
}

int repeat_func(vector<int> &stick, vector<int> &segtree, int node, int start, int end, int left, int right) { //�����۾�
	//���ϰ��� �ϴ� ������ left~right , start�� end�� ���� ����
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
	int min_idx = repeat_func(stick, segtree, 1, 0, stick.size() - 1, left, right); // ������ ���� �� ������ ���� �ּ� ���� ���� �ε��� ������
	long long area = (long long)(right - left + 1)*(long long)stick[min_idx];
	if (left <= min_idx - 1) { //�ּҳ��� ã�� ����� �ε��� ���ʿ� ���� ��ƽ���� �����ϸ� ��������
		long long left_area = Max_Rectangle(stick, segtree, left, min_idx - 1);
		area = max(area, left_area);
	}
	if (right >= min_idx + 1) {//�ּҳ��� ã�� ����� �ε��� �����ʿ� ���� ��ƽ���� �����ϸ� ��������
		long long right_area = Max_Rectangle(stick, segtree, min_idx + 1, right);
		area = max(area, right_area);
	}
	return area; // �ִ� ���� ��ȯ
}

int main() {
	while (1) {
		int n;
		scanf("%d", &n);
		if (n == 0) break;
		int h = 0;
		if (log2(n) == (int)log2(n)) h = (int)log2(n);
		else h = (int)log2(n) + 1;
		vector<int> stick(n);  //������׷��� ���̰� ����� �迭
		for (int i = 0; i < n; i++) scanf("%d", &stick[i]);
		int tree_size = pow(2, h + 1); //���׸�Ʈ Ʈ�� �ִ� ������
		vector<int> segtree(tree_size); //���׸�Ʈ Ʈ���� ����� ���� �迭 -> �����δ� arr�� �ε�����ȣ�� ��
		make_seg(stick, segtree, 1, 0, n - 1); // ���׸�Ʈ Ʈ�� ����
		long long result = Max_Rectangle(stick, segtree, 0, n - 1);
		printf("%lld\n", result);
	}
	return 0;
}
