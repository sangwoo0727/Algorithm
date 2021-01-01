import java.io.*;
import java.util.*;

public class BOJ1949_우수마을 {
    static int N;
    static int[][] dp;
    static int[] citizens;
    static boolean[] visit;
    static List<Integer>[] adj;
    static List<Integer>[] child;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        citizens = new int[N + 1];
        visit = new boolean[N + 1];
        dp = new int[N + 1][2];
        adj = new List[N + 1];
        child = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            citizens[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        make_tree(1);
        System.out.println(Math.max(getCity(1, 0), getCity(1, 1)));
    }

    static int getCity(int n, int flag) {
        if (dp[n][flag]!=0) return dp[n][flag];
        if (flag == 0) { // not selected
            for (int i = 0; i < child[n].size(); i++) {
                int nn = child[n].get(i);
                dp[n][flag] += Math.max(getCity(nn, 0), getCity(nn, 1));
            }
            return dp[n][flag];
        } else {
            for (int i = 0; i < child[n].size(); i++) {
                int nn = child[n].get(i);
                dp[n][flag] += getCity(nn, 0);
            }
            dp[n][flag] += citizens[n];
            return dp[n][flag];
        }
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
}
