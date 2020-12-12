import java.io.*;
import java.util.*;

public class BOJ2225_합분해 {
    static int N, K;
    static final int MOD = 1000000000;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1][N+1];
        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }
        for (int k = 1; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int l = 0; l <= n; l++) {
                    dp[k][n] = (dp[k][n] % MOD + dp[k - 1][n - l] % MOD) % MOD;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
