/*BOJ5532 ���м��� ����
�ùķ��̼��� Ǯ�����ؼ� ������ �����ε�, �������� �ʹ� �����
https://www.acmicpc.net/problem/5532
*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int L, A, B, C, D;
	int m_result;
	int k_result;
	int result;
	scanf("%d%d%d%d%d", &L, &A, &B, &C, &D);
	if (A%C > 0)	k_result = A / C + 1;
	if (A%C == 0) k_result = A / C;
	if (B%D > 0) m_result = B / D + 1;
	if (B%D == 0) m_result = B / D;
	result = L- max(k_result, m_result);
	printf("%d", result);
	return 0;
}