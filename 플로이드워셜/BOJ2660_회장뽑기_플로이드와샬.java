import java.io.*;
import java.util.*;

public class BOJ2660_회장뽑기_플로이드와샬 {
    static final int INF = 98765432;
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i==j) dp[i][j] = 0;
                else dp[i][j] = INF;
            }
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a==-1 && b==-1) break;
            dp[a][b] = 1;
            dp[b][a] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        int score = Integer.MAX_VALUE;
        List<Integer> candi = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int tmpScore = 0;
            for (int j = 1; j <= N; j++) {
                if (dp[i][j] != INF) {
                    tmpScore = Math.max(tmpScore, dp[i][j]);
                }
            }
            if (tmpScore < score) {
                candi = new ArrayList<>();
                candi.add(i);
                score = tmpScore;
            } else if (tmpScore == score) {
                candi.add(i);
            }
        }
        StringBuilder output = new StringBuilder();
        output.append(score).append(" ").append(candi.size()).append("\n");
        for (int c : candi) {
            output.append(c).append(" ");
        }
        System.out.println(output);
    }
}
