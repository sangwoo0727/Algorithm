/*1138 한줄로 서기 문제
체크배열을 만들어서, 카운트를 증가하면서
0의 개수를 세준다. 0의 개수가 자기보다 큰사람이 몇명있는지 말한 것보다
커지는 순간, 체크배열에 arr의 idx번호를 저장한다
마지막에 체크배열을 출력하면 된다.*/
#include <iostream>
using namespace std;

int n;
int arr[11];
int check[11];
int main() {
	int cnt = 0;
	int j = 1;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 1; i <= n; i++) {
		while(1){
			if (check[j] == 0) cnt++;
			if (cnt > arr[i]) {
				check[j] = i;
				break;
			}
			j++;
		}
		j = 1;
		cnt = 0;
	}
	for (int i = 1; i <= n; i++) {
		printf("%d ", check[i]);
	}
	return 0;
}