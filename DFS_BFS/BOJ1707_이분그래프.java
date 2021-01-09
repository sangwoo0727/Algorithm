import java.io.*;
import java.util.*;

public class BOJ1707_이분그래프 {
    static int V, E;
    static int[] color;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int tc = Integer.parseInt(input.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adj = new ArrayList[V + 1];
            color = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }
            boolean flag = false;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        flag = true;
                        break;
                    }
                }
            }
            output.append(flag ? "NO" : "YES").append("\n");
        }
        System.out.println(output);
    }

    static boolean bfs(int n) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, 1));
        boolean flag = true;
        label:while (!q.isEmpty()) {
            Pair now = q.poll();
            color[now.n] = now.c;
            for (int i = 0; i < adj[now.n].size(); i++) {
                int nn = adj[now.n].get(i);
                int nc = now.c == 1 ? 2 : 1;
                if (color[nn] == 0) {
                    color[nn] = nc;
                    q.add(new Pair(nn, nc));
                } else {
                    if (color[nn] == nc) continue;
                    else {
                        flag = false;
                        break label;
                    }
                }
            }
        }
        return flag;
    }
    static class Pair{
        int n, c;
        Pair(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }
}
