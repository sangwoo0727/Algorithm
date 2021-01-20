import java.io.*;
import java.util.*;

public class BOJ2410_2의멱수의합 {
    static final int MOD = 1000000000;
    static int N;
    static int[][] dp;
    static int[] pow = new int[20];
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        int num = 1;
        for (int i = 0; i < 20; i++) {
            pow[i] = num;
            num *= 2;
        }
        dp = new int[N + 1][20];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 20; j++) {
                if (pow[j] > i) break;
                for (int k = j; k < 20; k++) {
                    if (pow[k] > i) break;
                    dp[i][j] = (dp[i][j] + dp[i - pow[j]][k]) % MOD;
                }
                dp[i][j] %= MOD;
            }
        }
        int ans = 0;
        for (int i = 0; i < 20; i++) {
            ans = (ans + dp[N][i]) % MOD;
        }
        System.out.println(ans);
    }
}
