import java.io.*;
import java.util.*;

public class BOJ1932_정수삼각형_topdown {
    static int N;
    static int[][] dp;
    static int[][] score;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        dp = new int[N + 1][N + 1];
        score = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int j = 1; j <= i; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(getScore(1, 1));
    }

    static int getScore(int n, int idx) {
        if (n == N) {
            return dp[n][idx] = score[n][idx];
        }
        if (dp[n][idx] != 0) return dp[n][idx];
        return dp[n][idx] = Math.max(getScore(n + 1, idx), getScore(n + 1, idx + 1)) + score[n][idx];
    }
}
