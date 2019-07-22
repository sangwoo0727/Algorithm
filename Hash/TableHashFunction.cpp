#include <iostream>
using namespace std;

typedef struct {
	int empNum;
	int age;
}EmpInfo;

int GetHashValue(int empNum) {
	return empNum % 100;
}

int main() {
	EmpInfo empInfoArr[100];
	EmpInfo emp1 = { 20120003,42 };
	EmpInfo emp2 = { 20130012,33 };
	EmpInfo emp3 = { 20170049,27 };

	EmpInfo r1, r2, r3;

	empInfoArr[GetHashValue(emp1.empNum)] = emp1;
	empInfoArr[GetHashValue(emp2.empNum)] = emp2;
	empInfoArr[GetHashValue(emp3.empNum)] = emp3;

	r1 = empInfoArr[GetHashValue(20120003)];
	r2 = empInfoArr[GetHashValue(20130012)];
	r3 = empInfoArr[GetHashValue(20170049)];

	cout << "��� " << r1.empNum << " ���� " << r1.age <<endl;
	cout << "��� " << r2.empNum << " ���� " << r2.age << endl;
	cout << "��� " << r3.empNum << " ���� " << r3.age << endl;
	return 0;
}

