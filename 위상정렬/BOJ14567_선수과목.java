import java.util.*;
import java.io.*;

public class BOJ14567_선수과목 {
    static int N, M;
    static int[] ind;
    static List<Integer>[] adj;
    static int[] visit;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder output = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ind = new int[N + 1];
        visit = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            ind[b]++;
        }
        for (int i = 1; i <= N; i++) {
            if (ind[i]==0) q.add(new Node(i, 1));
        }
        bfs();
        for (int i = 1; i <= N; i++) {
            output.append(visit[i]).append(" ");
        }
        System.out.println(output);
    }
    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            visit[now.n] = now.l;
            for (int i = 0; i < adj[now.n].size(); i++) {
                int nn = adj[now.n].get(i);
                if (visit[nn] == 0) {
                    ind[nn]--;
                    if (ind[nn] == 0) {
                        visit[nn] = now.l + 1;
                        q.add(new Node(nn, now.l + 1));
                    }
                }
            }
        }
    }
    static class Node{
        int n, l;
        Node(int n, int l) {
            this.n = n;
            this.l = l;
        }
    }
}
