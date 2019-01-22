/*구조체
포인터변수를 구조체의 멤버로 선언하기 예제*/
#include <cstdio>

struct point { //좌표를 나타내는 구조체
	int xpos;
	int ypos;
};

struct circle { //원의 중심점과 반지름을 가지고있는 구조체(중심점은 point구조체에서 가져온다)
	double radius;
	struct point *center;
};

int main() {
	struct point cen = { 2, 7 }; //point구조체의 cen변수를 2,7로 초기화시킨다.
	double rad = 5.5; //rad 이란 변수 선언
	struct circle ring = { rad,&cen }; //circle 구조체의 ring변수의 반지름값은 rad 변수값을 가져오고, 중심점은 cen구조체변수를 가져온다
	printf("원의 반지름: %f\n", ring.radius);
	printf("원의 중심: %d ,%d\n", (ring.center)->xpos, (ring.center)->ypos);  //ring의 center가 가리키는 cen변수의 xpos값과 ypos값을 출력한다.
	return 0;
}