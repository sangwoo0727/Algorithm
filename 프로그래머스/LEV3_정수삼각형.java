public class LEV3_정수삼각형 {
    private int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];
        return dp(triangle, 0, 0);
    }

    private int dp(int[][] tri, int n, int m) {
        if (n == tri.length - 1) {
            return dp[n][m] = tri[n][m];
        }
        if (dp[n][m] != 0) {
            return dp[n][m];
        }
        return dp[n][m] = tri[n][m] +
                Math.max(dp(tri, n + 1, m), dp(tri, n + 1, m + 1));
    }
}
