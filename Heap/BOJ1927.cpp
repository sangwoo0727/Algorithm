/*1927 �ּ���
�켱���� ť stl�� �ͼ������� ���ؼ� Ǭ ����*/
#include <iostream>
#include <queue>
#include <functional>
using namespace std;
/*
priority_queue <int,vector<int>,less<int>> q; ->�ִ���
priority_queue <int,vector<int>,greater<int>> q; ->�ּ���*/
priority_queue<int, vector<int>, greater<int>>q;

int main() {
	int N, num;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &num);
		if (num == 0) {
			if (q.empty() == 1) printf("0\n");
			else {
				printf("%d\n", q.top());
				q.pop();
			}
		}
		else q.push(num);
	}
	return 0;
}