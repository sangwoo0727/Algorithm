import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725_트리의부모찾기_210607 {
    private static int N;
    private static List<ArrayList<Integer>> adj;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve() {
        makeTree();
        print();
    }
    private static void print() {
        StringBuilder output = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            output.append(parent[i]).append("\n");
        }
        System.out.println(output);
    }
    private static void makeTree() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < adj.get(now).size(); i++) {
                int nn = adj.get(now).get(i);
                if (!visit[nn]) {
                    q.add(nn);
                    parent[nn] = now;
                    visit[nn] = true;
                }
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        init();
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
    }
    private static void init() {
        adj = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
    }
}
