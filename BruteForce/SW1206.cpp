/* SW1206 view ����
���� ���������� �������� 2�̻� �ִ� ������� ���� ����ϴ� ����
���� ������ vert[i] �������� vert[i]�� vert[i-1] [i-2] [i+1] [i+2] ���� Ŭ���
vert[i]-vert[i-1] , -[i-2] , -[i+1] ,-[i+2] �� �� ����ؼ� 
���� ���� ���� ���� �����ִ� ������ ������ Ǯ����.*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int horiz = 0;
	int vert[1000] = {};

	for (int T = 1; T <= 10; T++) {
		int cnt = 0;
		scanf("%d", &horiz);
		for (int i = 0; i < horiz; i++) {
			scanf("%d", &vert[i]);
		}
		for (int i = 2; i < horiz-1; i++) {
			if (vert[i] == 0)
				continue;
			else if (vert[i] > vert[i - 1] && vert[i] > vert[i - 2] && vert[i] > vert[i + 1] && vert[i] > vert[i + 2])
				cnt += min(min(min(vert[i] - vert[i - 1], vert[i] - vert[i - 2]), vert[i] - vert[i + 1]), vert[i] - vert[i + 2]);
			else
				continue;
		}
		printf("#%d %d\n", T, cnt);
	}
	return 0;
}