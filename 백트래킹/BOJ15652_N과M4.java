import java.io.*;
import java.util.*;

public class BOJ15652_N과M4 {
    static int N, M;
    static int[] line;
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        line = new int[M + 1];
        getAns(1, 0);
        System.out.println(output);
    }

    static void getAns(int idx, int k) {
        if (M == k) {
            for (int i = 0; i < M; i++) {
                output.append(line[i]).append(" ");
            }
            output.append("\n");
            return;
        }
        if (N < idx) {
            return;
        }
        line[k] = idx;
        getAns(idx, k + 1);
        getAns(idx + 1, k);
    }
}
