import java.io.*;
import java.util.*;

public class BOJ2660_회장뽑기 {
    static int N, score = Integer.MAX_VALUE;
    static boolean[] visit;
    static List<Integer>[] adj;
    static List<Integer> candi;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            adj[a].add(b);
            adj[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            int level = bfs(i);
            if (level < score) {
                candi = new ArrayList<>();
                candi.add(i);
                score = level;
            } else if (level == score) {
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

    static int bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int s = 0; s < size; s++) {
                int now = queue.poll();
                visit[now] = true;
                for (int k = 0; k < adj[now].size(); k++) {
                    int nn = adj[now].get(k);
                    if (!visit[nn]) {
                        visit[nn] = true;
                        queue.add(nn);
                    }
                }
            }
        }
        return level;
    }
}
