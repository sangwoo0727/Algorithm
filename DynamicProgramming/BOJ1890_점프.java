import java.io.*;
import java.util.*;

public class BOJ1890_점프 {
    static int[][] map;
    static long[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0);
        System.out.println(dp[0][0]);
    }

    static long func(int n, int m) {
        if (n==N-1 && m==N-1) return 1;
        if (dp[n][m]!=0) return dp[n][m];
        int k = map[n][m];
        if (k==0) return dp[n][m] = 0;
        if (n + k < N) {
            dp[n][m] += func(n + k, m);
        }
        if (m + k < N) {
            dp[n][m] += func(n, m + k);
        }
        return dp[n][m];
    }
}
