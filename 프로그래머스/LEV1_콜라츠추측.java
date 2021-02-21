public class LEV1_콜라츠추측 {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        while (n > 1) {
            n = n % 2 == 0 ?
                    n / 2 :
                    n * 3 + 1;
            answer++;
            if (answer == 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}
