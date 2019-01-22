/*SW4466 최대성적표 만들기
어제 푼 퇴사문제랑 유형이같다고 생각하고
디피로 풀라고 난리를 치다가
정렬시켜서 뒤에 k개만큼 뽑으면 끝난다는 생각이 나서
바로 풀었다.*/
#include <iostream>
#include <algorithm>
using namespace std;

int arr[100]; 
int T;
int N, K;
int result;

int main() {	
	scanf("%d", &T);
	for (int i = 1; i <= T; i++) {
		scanf("%d %d", &N, &K);
		for (int j = 0; j < N; j++) {
			scanf("%d", &arr[j]);
		}
		sort(arr, arr + N);
		for (int j = 0; j < K;j++) {
			result += arr[N - 1 - j];
		}
		printf("#%d %d\n", i, result);
		result = 0;
	}

	return 0;
}