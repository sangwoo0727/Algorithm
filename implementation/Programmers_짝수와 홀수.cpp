/*프로그래머스 짝수와 홀수 문제
메인없이 쓰는 첫 코딩*/
#include <string>
#include <vector>

using namespace std;

string solution(int num) {
	return num & 1 ? "Odd" : "Even"; //비트연산자 
}