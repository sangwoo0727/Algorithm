import java.io.*;
import java.util.*;

public class BOJ7795_먹을것인가먹힐것인가 {
    private static int N, M;
    private static int[] numsA, numsB;
    private static StringBuilder output = new StringBuilder();

    private static void input(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numsA = new int[N + 1];
        numsB = new int[M + 1];
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            numsA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= M; i++) {
            numsB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numsB, 1, M + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        for (int t = 1; t <= tc; t++) {
            input(input);
            int total = 0;
            for (int i = 1; i <= N; i++) {
                int key = numsA[i];
                int result = lowerBound(1, M, key);
                total += result;
            }
            output.append(total).append("\n");
        }
        System.out.println(output);
    }

    private static int lowerBound(int l, int r, int key) {
        int result = l - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (key > numsB[m]) {
                result = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return result;
    }
}
