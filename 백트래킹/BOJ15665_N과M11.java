import java.io.*;
import java.util.*;

public class BOJ15665_N과M11 {
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
        line = new int[N];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        getAns(0);
        System.out.println(output);
    }

    static void getAns(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                output.append(line[i]).append(" ");
            }
            output.append("\n");
            return;
        }
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (prev != arr[i]) {
                prev = arr[i];
                line[k] = arr[i];
                getAns(k + 1);
            }
        }
    }
}
