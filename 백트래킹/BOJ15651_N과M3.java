import java.io.*;
import java.util.*;

public class BOJ15651_N과M3 {
    static int N, M;
    static int[] line;
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        line = new int[M];
        getAns(0);
        System.out.println(output);
    }

    /**
     * 중복 순열
     * @param k 현재까지 뽑은
     */
    static void getAns(int k) {
        if (M == k) {
            for (int i = 0; i < M; i++) {
                output.append(line[i]).append(" ");
            }
            output.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            line[k] = i;
            getAns(k + 1);
        }
    }
}
