public class LEV1_수박수박수박수박수박수 {
    public String solution(int n) {
        String answer = "수박".repeat(n / 2);
        return n % 2 == 1 ?
                answer + "수" :
                answer;
    }
}
