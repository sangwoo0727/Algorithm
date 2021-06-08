import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1240_두노드사이의거리 {
    private static int N, M, score, commonScore;
    private static int[][] dist;
    private static boolean flag;
    private static boolean[] visit;
    private static List<List<Integer>> adj;
    private static int[] tree;
    private static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];
        tree = new int[N + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
            dist[a][b] = w;
            dist[b][a] = w;
        }
        visit = new boolean[N + 1];
        makeTree(1);
        for (int i = 0; i < M; i++) {
            visit = new boolean[N + 1];
            flag = false;
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            find(n, 0, 0);
            int nw = score;
            find(m, 0, 0);
            int mw = score;
            if (flag) {
                nw -= commonScore;
                mw -= commonScore;
            }
            output.append(nw + mw).append("\n");
        }
        System.out.println(output);
    }
    private static void makeTree(int node) {
        visit[node] = true;
        for (int nn : adj.get(node)) {
            if (!visit[nn]) {
                tree[nn] = node;
                visit[nn] = true;
                makeTree(nn);
            }
        }
    }
    private static void find(int n, int total, int commonTotal) {
        if (visit[n]) {
            flag = true;
        }
        visit[n] = true;
        if (tree[n] == 0) {
            commonScore = commonTotal;
            score = total;
            return;
        }
        int nn = tree[n];
        if (flag) {
            find(nn, total + dist[nn][n], commonTotal + dist[nn][n]);
        } else {
            find(nn, total + dist[nn][n], commonTotal);
        }

    }
}
