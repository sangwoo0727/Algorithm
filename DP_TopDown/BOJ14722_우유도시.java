import java.io.*;
import java.util.*;

public class BOJ14722_우유도시 {
    static int N;
    static int[][] city;
    static int[][][] dp;
    static int[][] d = {{0, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        city = new int[N][N];
        dp = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }
        if (city[0][0] == 1) {
            dp[0][0][city[0][0]] = Math.max(milkCount(0, 0, city[0][0]) + 1, milkCount(0, 0, 0));
        } else {
            dp[0][0][0] = milkCount(0, 0, 0);
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans = Math.max(ans,dp[0][0][i]);
        }
        System.out.println(ans);
    }

    static int milkCount(int n, int m, int now) {
        if (dp[n][m][now] != 0) {
            return dp[n][m][now];
        }
        for (int k = 0; k < 2; k++) {
            int nn = n + d[0][k];
            int nm = m + d[1][k];
            if (inner(nn, nm)) {
                if (canEat(now, city[nn][nm])) {
                    dp[n][m][now] = Math.max(dp[n][m][now], milkCount(nn, nm, city[nn][nm]) + 1);
                }
                dp[n][m][now] = Math.max(dp[n][m][now], milkCount(nn, nm, now));
            }
        }
        return dp[n][m][now];
    }

    static boolean canEat(int nowState, int nextState) {
        if (nowState < 3) {
            return nowState + 1 == nextState;
        } else {
            return nextState == 1;
        }
    }
    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N;
    }
}