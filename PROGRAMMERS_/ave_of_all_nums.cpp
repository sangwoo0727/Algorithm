//�迭�� �Է¹��� ������ ����� ���ϴ� ����
#include <string>
#include <vector>
#include <numeric>

using namespace std;

double solution(vector<int> arr) {
	double answer = accumulate(arr.begin(), arr.end(), 0);
	int size = arr.size();
	return answer / size;
}

/*accumulate �Լ��� first ~ last ������ ���� ������ ������ �����ִ� �Լ�
����° �μ��� �ʱⰪ�� ��Ÿ����.*/