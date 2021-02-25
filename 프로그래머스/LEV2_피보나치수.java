public class LEV2_피보나치수 {
    static final int MOD = 1234567;
    public int solution(int n) {
        int answer = 0;
        int f = 0, s = 1;
        for (int i = 2; i <= n; i++) {
            answer = (f + s) % MOD;
            f = s; s = answer;
        }
        return answer % MOD;
    }
}
