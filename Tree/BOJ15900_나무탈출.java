import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15900_나무탈출 {
    private static int N;
    private static List<List<Integer>> tree;
    private static boolean[] visit;
    private static int ans;
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve() {
        dfs(1, 0);
        System.out.println(ans % 2 == 0 ? "No" : "Yes");
    }

    private static void dfs(int node, int count) {
        visit[node] = true;
        if (node != 1 && tree.get(node).size() == 1) {
            ans += count;
            return;
        }
        for (int nn : tree.get(node)) {
            if (!visit[nn]) {
                visit[nn] = true;
                dfs(nn, count + 1);
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        tree = new ArrayList<>();
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }
}
