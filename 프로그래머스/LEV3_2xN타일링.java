public class LEV3_2xN타일링 {
    static int[] dp;
    static final int MOD = 1000000007;
    public int solution(int n) {
        dp = new int[n + 1];
        return func(n);
    }
    static int func(int n) {
        if (n==1) return dp[1] = 1;
        if (n==2) return dp[2] = 2;
        if (dp[n]!=0) return dp[n];
        return dp[n] = (func(n - 1) % MOD + func(n - 2) % MOD) % MOD;
    }
}
