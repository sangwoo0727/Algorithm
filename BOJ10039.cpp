#include <stdio.h>

int main(void)
{
	int i = 0;
	int sum = 0;
	int grade[5];

	for (i = 0; i <= 5; i++)
	{

		scanf("%d", &grade[i]);


		if (grade[i] >= 40)
		{
			sum += grade[i];
		}
		else
		{
			sum += 40;
		}
	}
	printf("%d\n", sum / (i + 1));

	return 0;
}