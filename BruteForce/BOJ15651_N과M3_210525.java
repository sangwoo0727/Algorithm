import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651_N과M3_210525 {
    static int N, M;
    static int[] selected;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(output);
    }
    static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
    }

    static void recFunc(int k) {
        if (k == M + 1) {
            for (int m = 1; m <= M; m++) {
                output.append(selected[m]).append(" ");
            }
            output.append("\n");
        } else {
            for (int n = 1; n <= N; n++) {
                selected[k] = n;
                recFunc(k + 1);
            }
        }
    }
}
