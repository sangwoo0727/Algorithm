import java.io.*;
import java.util.*;

public class BOJ11505_구간곱구하기 {
    static final int MOD = 1000000007;
    static int N, M, K;
    static long[] input;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder output = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new long[N + 1];
        tree = new long[4 * N];
        for (int n = 1; n <= N; n++) {
            input[n] = Integer.parseInt(br.readLine());
        }
        init(1, N, 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                update(c, 1, N, b, 1);
            } else {
                output.append(mul(1, N, b, c, 1));
                output.append("\n");
            }
        }
        System.out.print(output);
    }

    static long mul(int start, int end, int left, int right, int node) {
        if (start > right || left > end) {
            return 1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return ((mul(start, mid, left, right, node * 2) % MOD ) * (mul(mid + 1, end, left, right, node * 2 + 1) % MOD)) % MOD;
    }
    static long update(int val, int start, int end, int idx, int node) {
        if (start > idx || end < idx) return tree[node];
        if (start == end) return tree[node] = val;
        int mid = (start + end) / 2;
        return tree[node] = ((update(val, start, mid, idx, node * 2) % MOD) * (update(val, mid + 1, end, idx, node * 2 + 1) % MOD)) % MOD;
    }
    static long init(int left, int right, int node) {
        if (left == right) {
            return tree[node] = input[left];
        }
        int mid = (left + right) / 2;
        return tree[node] = ((init(left, mid, node * 2) % MOD) * (init(mid+1, right, node * 2 + 1) % MOD)) % MOD;
    }
}
