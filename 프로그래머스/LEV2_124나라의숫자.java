public class LEV2_124나라의숫자 {
    public String solution(int n) {
        int[] digit = {4, 1, 2};
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            int temp = n % 3;
            n /= 3;
            if (temp == 0) {
                n -= 1;
            }
            answer.append(digit[temp]);
        }
        return answer.reverse().toString();
    }
}
