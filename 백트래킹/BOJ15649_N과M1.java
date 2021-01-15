import java.io.*;
import java.util.*;

public class BOJ15649_N과M1 {
    static int N, M;
    static int[] line;
    static boolean[] visit;
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        line = new int[M];
        getAns(0);
        System.out.println(output);
    }
    static void getAns(int k) {
        if (M == k) {
            for (int i = 0; i < M; i++) {
                output.append(line[i]).append(" ");
            }
            output.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                line[k] = i;
                getAns(k + 1);
                visit[i] = false;
            }
        }
    }
}
