/*9372�� ������� ����
�� ������ bfs�� �����ϰ� Ǯ���ٰ� �ذ��� ���� ���ϰ�,
�˾ƺ��� �� �ּ� ���д� Ʈ����� ���� �˰ԵǾ��� 
�ܼ��� ������ ���� -1�� ���̶�� �ܼ��� �ڵ忴��..
�ּҽ��д� Ʈ���� ���ؼ��� ���Ŀ� �����ؼ� �ø��ڴ�.*/
#include <iostream>
using namespace std;

int T;
int N, M;
int a, b;
int main() {
	scanf("%d", &T);
	for (int t = 0; t < T; t++) {
		scanf("%d%d", &N, &M);
		for (int i = 0; i < M; i++) {
			scanf("%d%d", &a, &b);
		}
		printf("%d\n", N - 1);
	}
	return 0;
}