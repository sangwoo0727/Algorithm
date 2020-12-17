import java.io.*;
import java.util.*;

/**
 *  @author Eden
 *  BOJ 2160 DFS와 BFS
 */
public class BOJ1260_DFS와BFS {
    static StringBuilder output = new StringBuilder();
    static int N, M, V;
    static List<Integer>[] lists;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        lists = new List[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        while (--M >= 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }
        dfs(V);
        visit = new boolean[N + 1];
        output.append("\n");
        bfs(V);
        System.out.println(output);
    }

    static void dfs(int now) {
        visit[now] = true;
        output.append(now).append(" ");
        for (int next : lists[now]) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            visit[now] = true;
            output.append(now).append(" ");
            for (int next : lists[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
