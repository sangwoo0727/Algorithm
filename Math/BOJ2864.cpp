/* 2864��, 5�� 6�� �ٲٱ� 
 ���� 2���� �Է¹޾Ƽ�, 5�ΰ��� 6�̳� 5�� �����ְ�,
 6�� ���� 5�� 6�� �����ִ�
 �� ���� ���ؼ� �ִ밪�� �ּҰ��� ���ϴ� ����*/

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

	for (int i = 6; i >= 0; i--) {  //�迭�� ���ڸ� �ڸ������� ��� �����Ѵ�
		arr[i] = num1 % 10;
		num1 = num1 / 10;
		arr2[i] = num2 % 10;
		num2 = num2 / 10;  
	}
	for (int i = 6; i >= 0; i--) {  //max�� ���ϱ� ���� 5�ΰ�� 6���� �Ѵ� �ٲٰ� ���Ѵ�
		if (arr[i] == 5)
			arr[i] = 6;
		if (arr2[i] == 5)
			arr2[i] = 6;
		max_result += arr[i] * pow(10, 6-i) + arr2[i] * pow(10, 6-i);
	}
	for (int i = 6; i >= 0; i--) { //min�� ���ϱ� ���� 6�ΰ��� 5�� �ٲ۴� 
		if (arr[i] == 6)
			arr[i] = 5;
		if (arr2[i] == 6)
			arr2[i] = 5;
		min_result += arr[i] * pow(10, 6 - i) + arr2[i] * pow(10, 6 - i);
	}
	printf("%d %d", min_result, max_result);
	return 0;
	
}