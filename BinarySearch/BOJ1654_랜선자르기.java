import java.io.*;
import java.util.*;

public class BOJ1654_랜선자르기 {
    static int K, N;
    static int[] wires;
    static int max;
    static long output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        wires = new int[K];
        for (int k = 0; k < K; k++) {
            wires[k] = Integer.parseInt(br.readLine());
            max = Math.max(max, wires[k]);
        }
        search(1, max);
        System.out.println(output);
    }
    static void search(long left, long right) {
        if (left > right) return;
        long mid = (left + right) / 2;
        long cnt = 0;
        for (int k = 0; k < K; k++) {
            cnt += wires[k] / mid;
        }
        if (cnt >= N) {
            output = mid;
            search(mid+1, right);
        } else {
            search(left, mid - 1);
        }
    }
}
