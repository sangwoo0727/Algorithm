/* ���ݷ� �ɰ��� ���� 2163��
�� ������ Ǯ�� ���� ó�� �����س� ���(���� Ǭ �ڵ�)�� 
N�� M�� 300�ۿ� ���� ������
�ڸ� ���ݸ� �������� ��ͷ� �ٽ� �Լ��� ���� ���� ���س��� ����̾���.
������ �� Ǯ���� ������ ���� �ٽ��� 1*1 ũ���� ���ݸ����� �ɰ��� ���̶�
��� �ɰ��� ���� �Ȱ��� ���´�.
�׷��Ƿ�, N�� M�� �̿��ؼ� �ɰ��� Ƚ���� ������ �ٲٸ�,
M-1 + M(N-1) = M*N-1�� �ȴ�.
�Լ��� �����ʰ� �׳� �� ���� ����� ���Ը� �ϸ� �Ǵ� �ڵ忴��*/

#include <iostream>
using namespace std;
int N, M;
int cnt;
int result;

int go(int N, int M) {
	cnt = 0;
	if (N == 1 && M == 1) {
		return 0;
	}
	else if (N == 1 || M == 1) {
		if (N == 1) {
			cnt += M-1;
			result = cnt;
			return result;
		}
		else if (M == 1) {
			cnt += N-1;
			result = cnt;
			return result;
		}
	}
	else {
		result = 1 + go(N, 1) + go(N, M - 1);
		return result;
	}
}
int main() {
	scanf("%d %d", &N, &M);
	printf("%d\n", go(N, M));
	return 0;
}