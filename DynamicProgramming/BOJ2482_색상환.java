import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BOJ2482_색상환 {
    private final static int MOD = 1000000003;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int K = Integer.parseInt(input.readLine());
        dp = new int[N + 1][N + 1];
        IntStream.range(0, N).forEach(i -> {
            Arrays.fill(dp[i], -1);
            dp[i][1] = i;
            dp[i][0] = 1;
        });
        System.out.println((func(N - 3, K - 1) + func(N - 1, K)) % MOD);
    }

    private static int func(int n, int k) {
        if (dp[n][k] != -1) return dp[n][k];
        if (n == k) return dp[n][k] = 0;
        return dp[n][k] = (func(n - 2, k - 1) % MOD + func(n - 1, k) % MOD) % MOD;
    }
}
