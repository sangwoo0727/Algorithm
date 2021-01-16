import java.io.*;
import java.util.*;

public class BOJ15654_N과M5 {
    static int N, M;
    static int[] arr;
    static int[] line;
    static boolean[] visit;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new boolean[N];
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
        if (M == k) {
            for (int i = 0; i < M; i++) {
                output.append(line[i]).append(" ");
            }
            output.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            line[k] = arr[i];
            getAns(k + 1);
            visit[i] = false;
        }
    }
}
