import java.io.*;
import java.util.*;

public class BOJ15666_N과M12 {
    static int N, M;
    static int[] arr;
    static int[] line;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        line = new int[M];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        getAns(0, 0, -1);
        System.out.println(output);
    }

    static void getAns(int idx, int k, int prev) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                output.append(line[i]).append(" ");
            }
            output.append("\n");
            return;
        }
        if (idx >= N) {
            return;
        }
        line[k] = arr[idx];
        int now = arr[idx];
        if (now != prev) {
            getAns(idx, k + 1, prev);
        }
        getAns(idx + 1, k, now);
    }
}
