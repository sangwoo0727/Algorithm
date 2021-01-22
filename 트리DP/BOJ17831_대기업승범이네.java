import java.io.*;
import java.util.*;

public class BOJ17831_대기업승범이네 {
    static int N;
    static List<Integer>[] adj;
    static int[] score;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        adj = new List[N + 1];
        score = new int[N + 1];
        dp = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 2; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            adj[n].add(i);
        }
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        func(1, 0);
        System.out.println(dp[1][0]);

    }

    static int func(int n, int status) {
        if (dp[n][status] != -1) {
            return dp[n][status];
        }
        dp[n][status] = 0;
        if (status == 1) { // 부모랑 관계 있을 때
            for (int i = 0; i < adj[n].size(); i++) {
                int nn = adj[n].get(i);
                dp[n][status] += func(nn, 0);
            }
        }else if (status == 0) { // 부모랑 관계 없을때
            int presum = 0;
            for (int i = 0; i < adj[n].size(); i++) {
                int nn = adj[n].get(i);
                presum += func(nn, 0);
            }
            dp[n][status] = presum;
            for (int i = 0; i < adj[n].size(); i++) {
                int nn = adj[n].get(i);
                dp[n][status] = Math.max(dp[n][status],
                        presum - func(nn, 0) + func(nn, 1) + (score[n] * score[nn]));
            }
        }
        return dp[n][status];
    }
}
