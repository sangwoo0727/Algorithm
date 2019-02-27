/*시험점수 5596 */
#include <iostream>
using namespace std;

int main() {
	int inf1, math1, sci1, eng1;
	int inf2, math2, sci2, eng2;
	int S, T;
	scanf("%d %d %d %d", &inf1, &math1, &sci1, &eng1);
	scanf("%d %d %d %d", &inf2, &math2, &sci2, &eng2);
	S = inf1 + math1 + sci1 + eng1;
	T = inf2 + math2 + sci2 + eng2;
	if (S >= T) printf("%d", S);
	if (T > S) printf("%d", T);
	return 0;
}