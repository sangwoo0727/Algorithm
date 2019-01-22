/*구조체
하나이상의 변수(포인터변수와 배열 포함)을 묶어서 새로운 자료형을 정의하는 도구
구조체의 이름은 자료형의 이름이 된다.*/
#include <cstdio>
#include <cstring>
struct person {
	char name[20];
	char phoneNum[20];
	int age;
};
struct point {
	int xpos;
	int ypos;
};
/*구조체 변수 선언은
	struct point {
		int xpos;
		int ypos;
	} pos1, pos2, pos3;   이런식으로 선언할 수도 있다. 
*/
int main() {
	struct point pos1, pos2; //구조체 변수 선언
	scanf("%d %d", &pos1.xpos, &pos1.ypos);
	scanf("%d %d", &pos2.xpos, &pos2.ypos);

	struct person man1,man2;
	struct person man3 = { "홍길동","010-1234-5678",22 }; //구조체 변수 선언과 동시에 초기화
	strcpy(man1.name, "강상우"); //선언과 동시에 초기화하지않고, 선언해놓고 초기화 시킬때 문자열은 strcpy써야한다.
	strcpy(man1.phoneNum, "010-1234-5678");
	man1.age = 28;
	scanf("%s", man2.name);
	scanf("%s", man2.phoneNum);
	scanf("%d", &man2.age);
	
	struct point arr[3]; //구조체 배열 선언
	for (int i = 0; i < 3; i++) {
		scanf("%d %d", &arr[i].xpos, &arr[i].ypos);
	}

	struct person arr2[3] = {
		{"강","1234-1234",20},
		{"유","1233-1233",23},
		{"한","0000-0000",27},
	}; //구조체 배열 선언과 동시에 초기화 방법

	struct point pos5;
	struct point *pptr = &pos5; //구조체 포인터 변수(포인터변수는 자료형이 같아야한다)

	(*pptr).xpos = 10;
	(*pptr).ypos = 20;  //pos5의 xpos와 ypos 값이 바뀐다.

	pptr->xpos = 5;
	pptr->ypos = 1; //위의 두문장과 똑같은 의미

	printf("%d %d", pos5.xpos, pos5.ypos);

	return 0;
}