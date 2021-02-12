import java.io.*;
import java.util.*;

public class BOJ2463_비용 {
    static final int MOD = 1000000000;
    static long total;
    static int N, M;
    static int[] p;
    static long[] lev;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> -(o1.w - o2.w));
    public static void main(String[] args) throws IOException {
        input();
        long sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.u;
            int v = node.v;
            int w = node.w;
            if (find(u) != find(v)) {
                sum += ((lev[find(u)] * lev[find(v)] % MOD) * total) % MOD;
                sum %= MOD;
                merge(u, v);
            }
            total -= w;
        }
        System.out.println(sum);
    }

    static int find(int n) {
        if (n == p[n]) return n;
        return p[n] = find(p[n]);
    }

    static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        lev[n] += lev[m];
        lev[m] = 1;
        p[m] = n;
    }
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N + 1];
        lev = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
            lev[i] = 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(u, v, w));
            total += w;
        }
    }
    static class Node{
        int u,v, w;
        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
