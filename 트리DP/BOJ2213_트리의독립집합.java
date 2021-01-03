import java.io.*;
import java.util.*;

public class BOJ2213_트리의독립집합 {
    static int[] weight;
    static int[][] dp;
    static List<Integer>[] adj;
    static List<Integer> tracker;

    public static void main(String[] args) throws IOException {
        tracker = new ArrayList<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        weight = new int[n + 1];
        dp = new int[n + 1][2];
        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        getAnswer(0,1, 0);
        getAnswer(0,1, 1);
        StringBuilder output = new StringBuilder();

        if (dp[1][0] <= dp[1][1]) { // selected
            output.append(dp[1][1]).append("\n");
            trace(0,1,1);
        } else {
            output.append(dp[1][0]).append("\n");
            trace(0,1,0);
        }
        tracker.sort((o1, o2) -> o1 - o2);
        for (int i = 0; i < tracker.size(); i++) {
            output.append(tracker.get(i)).append(" ");
        }
        System.out.println(output);
    }

    static void trace(int prev, int n, int flag) {
        if (flag == 1) {
            tracker.add(n);
            for (int i = 0; i < adj[n].size(); i++) {
                int nn = adj[n].get(i);
                if (nn == prev) continue;
                trace(n, nn, 0);
            }
        } else {
            for (int i = 0; i < adj[n].size(); i++) {
                int nn = adj[n].get(i);
                if (nn == prev) continue;
                if (dp[nn][0] <= dp[nn][1]) {
                    trace(n, nn, 1);
                } else {
                    trace(n, nn, 0);
                }
            }
        }
    }
    static int getAnswer(int prev, int n, int flag) {
        if (dp[n][flag] != -1) return dp[n][flag];
        if (flag == 0) { // not selected
            int sum = 0;
            for (int i = 0; i < adj[n].size(); i++) {
                int nn = adj[n].get(i);
                if (nn == prev) continue;
                int w = Math.max(getAnswer(n, nn, 0), getAnswer(n, nn, 1));
                sum += w;
            }
            return dp[n][flag] = sum;
        } else { // selected
            int sum = weight[n];
            for (int i = 0; i < adj[n].size(); i++) {
                int nn = adj[n].get(i);
                if (nn == prev) continue;
                int w = getAnswer(n, nn, 0);
                sum += w;
            }
            return dp[n][flag] = sum;
        }
    }
}
