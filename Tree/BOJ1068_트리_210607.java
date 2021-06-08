import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1068_트리_210607 {
    private static int N;
    private static boolean[] visit;
    private static int root, deleteNode;
    private static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve() {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visit[root] = true;
        if (root == deleteNode) {
            System.out.println(ans);
            return;
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            int count = 0;
            for (int nn : adj.get(now)) {
                if (nn != deleteNode) count++;
                if (!visit[nn] && nn != deleteNode) {
                    visit[nn] = true;
                    q.add(nn);
                }
            }
            if (count == 0) ans++;
        }
        System.out.println(ans);
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        init();
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) {
                root = i;
                continue;
            }
            adj.get(n).add(i);
        }
        deleteNode = Integer.parseInt(input.readLine());
    }
    private static void init() {
        adj = new ArrayList<>();
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
    }
}
