/*����ü
�����ͺ����� ����ü�� ����� �����ϱ� ����*/
#include <cstdio>

struct point { //��ǥ�� ��Ÿ���� ����ü
	int xpos;
	int ypos;
};

struct circle { //���� �߽����� �������� �������ִ� ����ü(�߽����� point����ü���� �����´�)
	double radius;
	struct point *center;
};

int main() {
	struct point cen = { 2, 7 }; //point����ü�� cen������ 2,7�� �ʱ�ȭ��Ų��.
	double rad = 5.5; //rad �̶� ���� ����
	struct circle ring = { rad,&cen }; //circle ����ü�� ring������ ���������� rad �������� ��������, �߽����� cen����ü������ �����´�
	printf("���� ������: %f\n", ring.radius);
	printf("���� �߽�: %d ,%d\n", (ring.center)->xpos, (ring.center)->ypos);  //ring�� center�� ����Ű�� cen������ xpos���� ypos���� ����Ѵ�.
	return 0;
}