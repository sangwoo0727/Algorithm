public class LEV1_자릿수더하기 {
    public int solution(int n) {
        return String.valueOf(n)
                .chars()
                .map(c -> c - '0')
                .sum();
    }
}
