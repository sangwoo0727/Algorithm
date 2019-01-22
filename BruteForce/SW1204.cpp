/* SW문제해결기본 1일차-최빈수 구하기
정말 쉬운 문제였다. 그냥 pair하나써서
0부터 100점까지 많이나온 순서대로 입력하고
정렬시킨다음에 제일 많이나온 숫자의 first 번호를 출력하면 된다.*/

#include <iostream>
#include <utility>
#include <algorithm>
using namespace std;

int arr[1000];
pair<int, int> num[101];

int main() {
	int T;
	int n = 1000;
	scanf("%d", &T);
	for (int t = 1; t <= T; t++) {
		scanf("%d", &t);
		for (int i = 0; i < n; i++) {
			scanf("%d", &arr[i]);
		}
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[j] == i)
					num[i].first++;
			}
		}
		for (int i = 0; i <= 100; i++) {
			num[i].second = i;
		}
		sort(num, num + 101);
		printf("#%d %d\n", t, num[100].second);		
		for (int i = 0; i <= 100; i++) {
			num[i].first = 0;
			num[i].second = 0;
		}
	}
	return 0;
}