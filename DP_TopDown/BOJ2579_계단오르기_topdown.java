import java.io.*;
public class BOJ2579_계단오르기_topdown {
    static int[][] dp;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];
        score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 2; i++) {
            getScore(n, i);
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
    static int getScore(int n, int cnt) {
        if (n < 0) return 0;
        if (n == 0) return dp[0][cnt] = 0;
        if (dp[n][cnt] != 0) {
            return dp[n][cnt];
        }
        if (cnt == 1) {
            dp[n][cnt] = getScore(n - 1, cnt - 1) + score[n];
        }
        if (cnt == 0) {
            int tmp = Math.max(getScore(n - 2, 0), getScore(n - 2, 1));
            dp[n][cnt] = Math.max(dp[n][cnt], tmp) + score[n];
        }
        return dp[n][cnt];
    }
}
