import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solve {
    private int tc, N, K, W;
    private List<List<Integer>> adj;
    private int[] time;
    private int[] indegree;
    private int[] weight;
    private static Solve solve;
    private StringBuilder output;
    private BufferedReader input;

    public static Solve getInstance() {
        if (solve == null) {
            solve = new Solve();
        }
        return solve;
    }

    public void process() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();
        tc = Integer.parseInt(input.readLine());
        for (int t = 1; t <= tc; t++) {
            this.setInput()
                    .playGame();
        }
        this.printAns();
    }

    private void printAns() {
        System.out.println(this.output);
    }

    private void playGame() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            weight[now] += time[now];
            if (now == W) {
                output.append(weight[now]).append("\n");
                break;
            }
            for (int nn : adj.get(now)) {
                indegree[nn]--;
                weight[nn] = Math.max(weight[nn], weight[now]);
                if (indegree[nn] == 0) {
                    q.add(nn);
                }
            }
        }
    }


    private Solve setInput() throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[N + 1];
        indegree = new int[N + 1];
        weight = new int[N + 1];
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            indegree[b]++;
        }
        W = Integer.parseInt(input.readLine());
        return this;
    }
}

public class BOJ1005_ACMCraft_210615 {
    public static void main(String[] args) throws IOException {
        Solve solve = Solve.getInstance();
        solve.process();
    }
}
