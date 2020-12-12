import java.io.*;
import java.util.*;

public class BOJ1766_문제집 {
    static StringBuilder output = new StringBuilder();
    static int N, M;
    static List<Integer>[] adj;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] ind;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        ind = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());
            adj[prev].add(now);
            ind[now]++;
        }
        for (int i = 1; i <= N; i++) {
            if (ind[i] == 0) {
                pq.add(i);
            }
        }
        topologicalSort();
        System.out.println(output);
    }
    static void topologicalSort() {
        while (!pq.isEmpty()) {
            int now = pq.poll();
            output.append(now).append(" ");
            for (int next : adj[now]) {
                if (--ind[next] == 0) {
                    pq.add(next);
                }
            }
        }
    }
}
