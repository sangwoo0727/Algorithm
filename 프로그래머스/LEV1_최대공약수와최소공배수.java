public class LEV1_최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[]{gcd, n * m / gcd};
    }
    static int gcd(int n, int m) {
        while (m != 0) {
            int t = n % m;
            n = m;
            m = t;
        }
        return n;
    }
}
