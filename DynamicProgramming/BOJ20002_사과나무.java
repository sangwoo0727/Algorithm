import java.io.*;
import java.util.*;

public class BOJ20002_사과나무 {
    static int N, output = Integer.MIN_VALUE;
    static int[][] input;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + input[i][j];
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k < N; k++) {
                    if (i + k <= N && j + k <= N) {
                        int weight = dp[i + k][j + k] - dp[i + k][j - 1] - dp[i - 1][j + k] + dp[i - 1][j - 1];
                        output = Math.max(output, weight);
                    }
                }
            }
        }
        System.out.println(output);
    }
}
