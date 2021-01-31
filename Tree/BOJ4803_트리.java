import java.io.*;
import java.util.*;

public class BOJ4803_트리 {
    static List<Integer>[] adj;
    static int[] visit;
    static int n, m;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int tc = 0;
        while (true) {
            tc++;
            StringTokenizer st = new StringTokenizer(input.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            adj = new ArrayList[n + 1];
            visit = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                flag = false;
                if (visit[i] == 0) {
                    visit[i] = 1;
                    dfs(i, -1);
                    if (!flag) {
                        ans++;
                    }
                }
            }
            output.append("Case ").append(tc).append(": ");
            if (ans == 0) {
                output.append("No trees.");
            } else if (ans == 1) {
                output.append("There is one tree.");
            } else {
                output.append("A forest of ").append(ans).append(" trees.");
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    static void dfs(int n, int p) {
        for (int i = 0; i < adj[n].size(); i++) {
            int nn = adj[n].get(i);
            if (nn != p) {
                if (visit[nn] == 0) {
                    visit[nn] = visit[n] + 1;
                    dfs(nn, n);
                } else {
                    flag = true;
                }
            }
        }
    }
}
