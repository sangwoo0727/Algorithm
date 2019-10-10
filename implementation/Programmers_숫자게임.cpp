#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
	int answer = 0;
	sort(A.begin(), A.end());
	sort(B.begin(), B.end());
	int j = B.size()-1;
	for (int i = A.size() - 1; i >= 0; i--) {
		if (A[i] < B[j]) {
			answer++; j--;
		}
	}
	return answer;
}