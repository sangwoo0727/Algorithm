import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14267_회사문화1 {
    private static int N, M;
    private static int[] weight;
    private static int[] ansWeight;
    private static List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve() {
        dfs(1, weight[1]);
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            output.append(ansWeight[i]).append(" ");
        }
        output.append("\n");
        System.out.println(output);
    }

    private static void dfs(int n, int w) {
        ansWeight[n] = w;
        for (int nn : adj.get(n)) {
            dfs(nn, w + weight[nn]);
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        weight = new int[N + 1];
        ansWeight = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                continue;
            }
            adj.get(parent).add(i);
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(input.readLine());
            int node = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            weight[node] += w;
        }
    }
}
