/*Dynamic Memory Allocation
동적할당이라고 부르는 이유는 할당되는 메모리의 크기를 컴파일러가 결정하지 않고
프로그램의 실행 중간에 호출되는 malloc함수가 결정하기 때문*/
#include <cstdio>
#include <cstdlib>

int main() {
	int *ptr1 = (int *)malloc(sizeof(int));
	int *ptr2 = (int *)malloc(sizeof(int) * 7);
	/*참고로 malloc함수는 메모리 공간의 할당에 실패할 경우 NULL을 반환
	메모리 할당의 성공여부를 확인하고자 할땐 
	if(ptr==NULL){
		메모리 할당 실패에 따른 오류의 처리
	}
	부분을 추가해야한다.*/
	int i;
	*ptr1 = 20;
	for (i = 0; i < 7; i++)
		ptr2[i] = i + 1;
	printf("%d\n", *ptr1);
	for (i = 0; i < 7; i++)
		printf("%d ", ptr2[i]);
	free(ptr1);
	free(ptr2);
	return 0;
}