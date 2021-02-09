import java.io.*;
import java.util.*;

public class BOJ6497_전력난 {
    static int N, M;
    static int[] p;
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            N = Integer.parseInt(st.nextToken()); // house
            M = Integer.parseInt(st.nextToken()); // road
            if (N == 0 && M == 0) break;
            pq = new PriorityQueue<>((o1, o2) -> o1.w-o2.w);
            p = new int[N + 1];
            for (int i = 0; i < N; i++) {
                p[i] = i;
            }
            int sum = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(input.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.add(new Edge(u, v, w));
                sum += w;
            }
            int cost = 0;
            int cnt = 0;
            while (!pq.isEmpty()) {
                if (cnt == N - 1) {
                    break;
                }
                Edge edge = pq.poll();
                if (find(edge.u) == find(edge.v)) {
                    continue;
                }
                cost += edge.w;
                merge(edge.u, edge.v);
                cnt += 1;
            }
            output.append(sum - cost).append("\n");
        }
        System.out.println(output);
    }

    static int find(int n) {
        if (n == p[n]) return n;
        return p[n] = find(p[n]);
    }

    static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        p[m] = n;
    }
    static class Edge{
        int u,v,w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
