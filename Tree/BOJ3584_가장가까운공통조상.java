import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3584_가장가까운공통조상 {
    private static StringBuilder output = new StringBuilder();
    private static int T, N;
    private static boolean[] visit;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(output);
    }

    private static void solve(int n, int m) {
        findAnces(n);
        findAnces(m);
    }

    private static void findAnces(int n) {
        if (visit[n]) {
            output.append(n).append("\n");
            return;
        }
        visit[n] = true;
        if (n == 0) return;
        int nn = parent[n];
        findAnces(nn);
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(input.readLine());
            parent = new int[N + 1];
            visit = new boolean[N + 1];
            for (int i = 1; i < N; i++) {
                StringTokenizer st = new StringTokenizer(input.readLine());
                int p = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                parent[s] = p;
            }
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            solve(n, m);
        }
    }
}
