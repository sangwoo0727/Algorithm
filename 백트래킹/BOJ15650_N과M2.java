import java.io.*;
import java.util.*;

public class BOJ15650_N과M2 {
    static int N, M;
    static boolean[] visit;
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        getAns(1, 0);
        System.out.println(output);
    }

    static void getAns(int idx, int cnt) {
        if (M == cnt) {
            for (int i = 1; i <= N; i++) {
                if (visit[i]) output.append(i).append(" ");
            }
            output.append("\n");
            return;
        }
        if (N < idx) return;
        visit[idx] = true;
        getAns(idx + 1, cnt + 1);
        visit[idx] = false;
        getAns(idx + 1, cnt);
    }
}
