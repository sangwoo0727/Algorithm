public class LEV1_두정수사이의합 {
    public long solution(int a, int b) {
        if (a > b) {
            int t = a; a = b; b = t;
        }
        return calc(a, b);
    }
    private static long calc(long a, long b) {
        return (a + b) * (b - a + 1) / 2;
    }
}
