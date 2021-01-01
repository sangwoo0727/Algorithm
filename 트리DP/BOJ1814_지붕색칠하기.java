import java.io.*;
import java.util.*;

public class BOJ1814_지붕색칠하기 {
    static int N, M, size;
    static int[][] dp;
    static int[] colors;
    static boolean[] visit;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        M = Integer.parseInt(input.readLine());

        StringTokenizer st = new StringTokenizer(input.readLine());
        colors = new int[M];
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(colors);
        size = Math.min(getSize(N), M);
        dp = new int[N + 1][size];
        int ans = dfs(1, 0);
        for (int i = 1; i < size; i++) {
            dp[1][i] = dfs(1, i);
            ans = Math.min(ans, dp[1][i]);
        }
        System.out.println(ans);
    }

    static int getSize(int n) {
        return (int) (Math.log10(n) / Math.log10(2) + 1);
    }
    static int dfs(int n, int idx) {
        if (dp[n][idx]!=0) return dp[n][idx];
        dp[n][idx] = colors[idx];
        visit[n] = true;
        for (int i = 0; i < adj[n].size(); i++) {
            int nn = adj[n].get(i);
            if (visit[nn]) continue;
            int sum = Integer.MAX_VALUE;
            for (int c = 0; c < size; c++) {
                if (c != idx) {
                    sum = Math.min(sum, dfs(nn, c));
                }
            }
            dp[n][idx] += sum;
        }
        visit[n] = false;
        return dp[n][idx];
    }
}
