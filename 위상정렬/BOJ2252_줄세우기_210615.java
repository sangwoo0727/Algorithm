import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solve {
    private int N, M;
    private int indegree[];
    private List<List<Integer>> adj;
    private StringBuilder output;
    private static Solve solve;

    public static Solve getInstance() {
        if (solve == null) {
            solve = new Solve();
        }
        return solve;
    }
    public void process() throws IOException {
        this.setInput()
                .doSimul()
                .printAns();
    }

    private void printAns() {
        System.out.println(output);
    }

    private Solve doSimul() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            output.append(now).append(" ");
            for (int nn : adj.get(now)) {
                indegree[nn]--;
                if (indegree[nn] == 0) {
                    q.add(nn);
                }
            }
        }
        return this;
    }

    private Solve setInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            indegree[b]++;
        }
        output = new StringBuilder();
        return this;
    }
}

public class BOJ2252_줄세우기_210615 {
    public static void main(String[] args) throws IOException {
        Solve solve = Solve.getInstance();
        solve.process();
    }
}
