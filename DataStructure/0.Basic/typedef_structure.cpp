/*구조체 typedef와 합쳐진 선언
typedef는 변수의 또다른 이름을 지어주는 것과 같다*/
#include <cstdio>

struct point {
	int xpos;
	int ypos;
};
typedef struct point Point;

typedef struct person {
	char name[20];
	char phoneNum[20];
	int age;
} Person;

typedef struct {
	char name[30];
	char phoneNum[10];
	int num;
} Student; //이 경우는 구조체 이름을 생략하고 typedef에 의해 새로 정의된 이름만 사용한 경우
//어차피 typedef로 새로 지어진 이름을쓸거라 굳이 이름을 안써도된다. 많이쓰이는 방식.

int main() {
	Point pos = { 10,20 };
	Person man = { "강상우","0101234-5667",24 };

	return 0;
}