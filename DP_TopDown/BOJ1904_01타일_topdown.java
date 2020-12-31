import java.io.*;

public class BOJ1904_01타일_topdown {
    static final int MOD = 15746;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        dp = new long[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = -1;
        System.out.println(getCount(n));
    }
    static long getCount(int n) {
        if (n==0) return dp[n] = 1;
        if (n==1) return dp[n] = 1;
        if (dp[n]!=-1) return dp[n];
        return dp[n] = (getCount(n - 1) % MOD + getCount(n - 2) % MOD) % MOD;
    }
}
