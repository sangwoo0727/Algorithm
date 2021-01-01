import java.io.*;
import java.util.*;

public class BOJ2533_사회망서비스 {
    static int N;
    static int[][] dp;
    static boolean[] visit;
    static List<Integer>[] child;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        adj = new List[N + 1];
        child = new List[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }
        dp = new int[N + 1][2];
        for (int n = 0; n < N - 1; n++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        make_tree(1);
        for (int i = 0; i < 2; i++) {
            getAdapter(1, i);
        }
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void make_tree(int now) {
        visit[now] = true;
        for (int i = 0; i < adj[now].size(); i++) {
            int next = adj[now].get(i);
            if (!visit[next]) {
                child[now].add(next);
                make_tree(next);
            }
        }
    }
    static int getAdapter(int n, int flag) {
        if (dp[n][flag] != 0) return dp[n][flag];
        if (flag == 0) {
            for (int i = 0; i < child[n].size(); i++) {
                int nn = child[n].get(i);
                dp[n][flag] += getAdapter(nn, 1);
            }
            return dp[n][flag];
        } else {
            for (int i = 0; i < child[n].size(); i++) {
                int nn = child[n].get(i);
                dp[n][flag] += Math.min(getAdapter(nn, 0), getAdapter(nn, 1));
            }
            dp[n][flag] += 1;
            return dp[n][flag];
        }
    }
}
