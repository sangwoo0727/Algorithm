/* 2864번, 5와 6을 바꾸기 
 숫자 2개를 입력받아서, 5인경우는 6이나 5일 수도있고,
 6인 경우는 5나 6일 수도있다
 두 수를 더해서 최대값과 최소값을 구하는 문제*/

#include <iostream>
#include <math.h>
using namespace std;

int arr[7];
int arr2[7];

int main() {
	int num1, num2 = 0;
	int max_result = 0;
	int min_result = 0;
	scanf("%d %d", &num1, &num2);

	for (int i = 6; i >= 0; i--) {  //배열에 숫자를 자리수별로 찢어서 저장한다
		arr[i] = num1 % 10;
		num1 = num1 / 10;
		arr2[i] = num2 % 10;
		num2 = num2 / 10;  
	}
	for (int i = 6; i >= 0; i--) {  //max를 구하기 위해 5인경우 6으로 둘다 바꾸고 더한다
		if (arr[i] == 5)
			arr[i] = 6;
		if (arr2[i] == 5)
			arr2[i] = 6;
		max_result += arr[i] * pow(10, 6-i) + arr2[i] * pow(10, 6-i);
	}
	for (int i = 6; i >= 0; i--) { //min을 구하기 위해 6인경우는 5로 바꾼다 
		if (arr[i] == 6)
			arr[i] = 5;
		if (arr2[i] == 6)
			arr2[i] = 5;
		min_result += arr[i] * pow(10, 6 - i) + arr2[i] * pow(10, 6 - i);
	}
	printf("%d %d", min_result, max_result);
	return 0;
	
}