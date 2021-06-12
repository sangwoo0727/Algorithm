import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15681_트리와쿼리 {
    private static int N, R, Q;
    private static List<List<Integer>> adj;
    private static int[] subtree;
    private static boolean[] visit;

    private static void makeTree() {
        subtree = new int[N + 1];
        visit = new boolean[N + 1];
        dfs(R);
    }

    private static int dfs(int now) {
        visit[now] = true;
        for (int nn : adj.get(now)) {
            if (!visit[nn]) {
                subtree[now] += dfs(nn);
            }
        }
        return ++subtree[now];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        makeTree();
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= Q; i++) {
            int q = Integer.parseInt(input.readLine());
            output.append(subtree[q]).append("\n");
        }
        System.out.println(output);
    }
}
