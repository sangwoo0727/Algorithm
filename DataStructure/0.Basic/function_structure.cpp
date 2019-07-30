/*함수로의 구조체 변수 전달과 반환 파트
함수의 인자로 구조체 변수가 전달될 수 있으며, 이러한 인자를 전달 받을 수 있도록 구조체 변수가
매개변수의 선언으로 올 수 있다. 전달되는 구조체 변수의 값은 매개변수에 통째로 복사가 된다.*/
#include <cstdio>

typedef struct point {
	int xpos;
	int ypos;
} Point;

void ShowPosition(Point pos) {
	printf("%d,%d\n", pos.xpos, pos.ypos);
}

Point GetCurrentPosition(void) {
	Point cen;
	printf("Input current pos: ");
	scanf("%d %d", &cen.xpos, &cen.ypos);
	return cen;
}//반환형이 struct point


/*구조체 간 덧셈이나 뺄셈은 사실 불가능하다. 구조체 안에는 배열이 존재할 수도 있고, 포인터변수도 
존재할 수 있기 때문에,, 그래서 구조체 변수 대상으로 덧셈이나 뺄셈을 하려면, 함수를 정의해야 한다.*/
Point AddPoint(Point pos3, Point pos4) {
	Point pos = { pos3.xpos + pos4.xpos,pos3.ypos + pos4.ypos };
	return pos;
} // 구조체끼리 덧셈을 해주기 위한 함수 

int main() {
	Point curPos = GetCurrentPosition();
	ShowPosition(curPos);
	
	Point pos2 = curPos; //curPos의 멤버 대 pos2의 멤버간 복사가 진행된다.
	printf("복사된 값: %d , %d\n", pos2.xpos, pos2.ypos);
	printf("구조체 크기확인 : %d\n", sizeof(curPos)); //int형 변수 2개 들어가있으므로, 8이 나올 것.
	Point result = AddPoint(curPos, pos2);
	printf("덧셈함수를 이용한 덧셈: %d , %d\n", result.xpos, result.ypos);
	return 0;
}