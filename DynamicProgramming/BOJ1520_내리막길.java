import java.io.*;
import java.util.*;

public class BOJ1520_내리막길 {
    static int[][] dp;
    static int[][] map;
    static int N, M;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(dp[0][0] == -1 ? 0 : dp[0][0]);
    }

    static int dfs(int n, int m) {
        if (n == N - 1 && m == M - 1) {
            dp[n][m] = 1;
            return dp[n][m];
        }
        if (dp[n][m] != 0) return dp[n][m];
        boolean flag = false;
        int nowWeight = map[n][m];
        for (int k = 0; k < 4; k++) {
            int nn = n + d[0][k];
            int nm = m + d[1][k];
            if (isValid(nn, nm, nowWeight)) {
                int count = dfs(nn, nm);
                if (count > 0){
                    flag = true;
                    dp[n][m] += count;
                }
            }
        }
        if (!flag) dp[n][m] = -1;
        return dp[n][m];
    }

    static boolean isValid(int n, int m, int nowWeight) {
        return 0 <= n && n < N && 0 <= m && m < M && map[n][m] < nowWeight;
    }
}
