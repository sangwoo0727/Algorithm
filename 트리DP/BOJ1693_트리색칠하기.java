import java.util.*;
import java.io.*;

public class BOJ1693_트리색칠하기 {
    static long[][] dp;
    static boolean[] visit;
    static List<Integer>[] adj;
    static List<Integer>[] child;
    static int color;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        color = getColor(n) + 1;
        dp = new long[n + 1][color + 1];
        visit = new boolean[n + 1];
        adj = new List[n + 1];
        child = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        make_tree(1);
        for (int i = 1; i <= color; i++) {
            dp[1][i] = getColor(1, i);
        }
        long output = dp[1][1];
        for (int i = 2; i <= color; i++) {
            output = Math.min(output, dp[1][i]);
        }
        System.out.println(output);

    }

    static long getColor(int n, int c) {
        if (dp[n][c]!=0) return dp[n][c];
        dp[n][c] = c;
        for (int i = 0; i < child[n].size(); i++) {
            int nn = child[n].get(i);
            long cost = Integer.MAX_VALUE;
            for (int j = 1; j <= color; j++) {
                if (j != c) {
                    cost = Math.min(cost, getColor(nn, j));
                }
            }
            dp[n][c] += cost;
        }
        return dp[n][c];
    }
    static void make_tree(int n) {
        visit[n] = true;
        for (int i = 0; i < adj[n].size(); i++) {
            int nn = adj[n].get(i);
            if (!visit[nn]) {
                child[n].add(nn);
                make_tree(nn);

            }
        }
    }
    static int getColor(int n) {
        return (int) (Math.log10(n) / Math.log10(2));
    }
}
