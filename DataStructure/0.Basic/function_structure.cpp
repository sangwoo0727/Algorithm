/*�Լ����� ����ü ���� ���ް� ��ȯ ��Ʈ
�Լ��� ���ڷ� ����ü ������ ���޵� �� ������, �̷��� ���ڸ� ���� ���� �� �ֵ��� ����ü ������
�Ű������� �������� �� �� �ִ�. ���޵Ǵ� ����ü ������ ���� �Ű������� ��°�� ���簡 �ȴ�.*/
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
}//��ȯ���� struct point


/*����ü �� �����̳� ������ ��� �Ұ����ϴ�. ����ü �ȿ��� �迭�� ������ ���� �ְ�, �����ͺ����� 
������ �� �ֱ� ������,, �׷��� ����ü ���� ������� �����̳� ������ �Ϸ���, �Լ��� �����ؾ� �Ѵ�.*/
Point AddPoint(Point pos3, Point pos4) {
	Point pos = { pos3.xpos + pos4.xpos,pos3.ypos + pos4.ypos };
	return pos;
} // ����ü���� ������ ���ֱ� ���� �Լ� 

int main() {
	Point curPos = GetCurrentPosition();
	ShowPosition(curPos);
	
	Point pos2 = curPos; //curPos�� ��� �� pos2�� ����� ���簡 ����ȴ�.
	printf("����� ��: %d , %d\n", pos2.xpos, pos2.ypos);
	printf("����ü ũ��Ȯ�� : %d\n", sizeof(curPos)); //int�� ���� 2�� �������Ƿ�, 8�� ���� ��.
	Point result = AddPoint(curPos, pos2);
	printf("�����Լ��� �̿��� ����: %d , %d\n", result.xpos, result.ypos);
	return 0;
}