import java.io.*;
public class BOJ1463_1로만들기_topdown {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        System.out.println(makeOne(n));
    }
    static int makeOne(int n) {
        if (n==1) return 0;
        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }
        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], makeOne(n / 3) + 1);
        }
        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], makeOne(n / 2) + 1);
        }
        if (n - 1 >= 1) {
            dp[n] = Math.min(dp[n], makeOne(n - 1) + 1);
        }
        return dp[n];
    }
}
