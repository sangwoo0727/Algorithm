import java.io.*;
import java.util.*;

public class BOJ2230_수고르기 {
    static int N, M;
    static int output = Integer.MAX_VALUE;
    static long[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new long[N];
        for (int i = 0; i < N; i++) {
            input[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(input);
        for (int i = 0; i < N; i++) {
            long nextNum = input[i] + M;
            int idx = lowerBound(0, N, nextNum);
            if (idx != N) {
                output = (int) Math.min(output, input[idx] - input[i]);
            }
        }
        System.out.println(output);
    }

    static int lowerBound(int left, int right, long key) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (input[mid] < key) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
