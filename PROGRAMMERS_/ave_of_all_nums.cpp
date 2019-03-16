//배열에 입력받은 값들의 평균을 구하는 문제
#include <string>
#include <vector>
#include <numeric>

using namespace std;

double solution(vector<int> arr) {
	double answer = accumulate(arr.begin(), arr.end(), 0);
	int size = arr.size();
	return answer / size;
}

/*accumulate 함수는 first ~ last 구간에 속한 값들의 총합을 구해주는 함수
세번째 인수는 초기값을 나타낸다.*/