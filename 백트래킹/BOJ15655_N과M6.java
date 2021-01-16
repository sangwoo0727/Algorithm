import java.io.*;
import java.util.*;

public class BOJ15655_N과M6 {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        getAns(0, 0);
        System.out.println(output);
    }

    static void getAns(int idx, int k) {
        if (M == k) {
            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    output.append(arr[i]).append(" ");
                }
            }
            output.append("\n");
            return;
        }
        if (N <= idx) {
            return;
        }
        visit[idx] = true;
        getAns(idx + 1, k + 1);
        visit[idx] = false;
        getAns(idx + 1, k);
    }
}
