public class LEV1_정수제곱근판별 {
    public long solution(long n) {
        return Math.sqrt(n) == (int) Math.sqrt(n) ?
                (long) Math.pow(Math.sqrt(n) + 1, 2) :
                -1;
    }
}
