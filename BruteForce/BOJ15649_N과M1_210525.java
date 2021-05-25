import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649_N과M1_210525 {
    private static int N, M;
    private static int[] selected;
    private static boolean[] used;
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(output);
    }

    private static void recFunc(int k) {
        if (k == M + 1) {
            for (int m = 1; m <= M; m++) {
                output.append(selected[m]).append(" ");
            }
            output.append("\n");
            return;
        }
        for (int n = 1; n <= N; n++) {
            if (used[n]) continue;
            used[n] = true;
            selected[k] = n;
            recFunc(k + 1);
            used[n] = false;
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        used = new boolean[N + 1];
    }
}
