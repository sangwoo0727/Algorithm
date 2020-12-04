import java.io.*;
import java.util.*;

public class BOJ2042_구간합구하기_펜윅 {
    static int N, M, K;
    static long[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder output = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = Long.parseLong(br.readLine());
        }
        FenwickTree fenwickTree = new FenwickTree(N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                fenwickTree.update(b, c - input[b]);
                input[b] = c;
            } else {
                long sum = fenwickTree.sum((int) c) - fenwickTree.sum(b - 1);
                output.append(sum).append("\n");
            }
        }
        System.out.println(output);
    }
    static class FenwickTree {
        long[] tree;
        int n;
        FenwickTree(int n) {
            this.n = n;
            this.tree = new long[n + 1];
            makeTree(n);
        }
        private void makeTree(int n) {
            for (int i = 1; i <= n; i++) {
                update(i, input[i]);
            }
        }
        public long sum(int bit) {
            long sum = 0;
            while (bit > 0) {
                sum += this.tree[bit];
                bit -= (bit & -bit);
            }
            return sum;
        }
        public void update(int bit, long val) {
            while (bit <= this.n) {
                this.tree[bit] += val;
                bit += (bit & -bit);
            }
        }
    }
}
