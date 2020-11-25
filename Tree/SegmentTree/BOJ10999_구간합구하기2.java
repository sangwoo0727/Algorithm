import java.io.*;
import java.util.*;

public class BOJ10999_구간합구하기2 {
    static long[] input;
    static long[] tree;
    static long[] lazy;
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new long[N + 1];
        tree = new long[4 * N];
        lazy = new long[4 * N];
        for (int n = 1; n <= N; n++) {
            input[n] = Long.parseLong(br.readLine());
        }
        init(1, N, 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                modify(1, N, b, c, d, 1);
            } else {
                output.append(sum(1, N, b, c, 1));
                output.append("\n");
            }
        }
        System.out.println(output);
    }

    static void lazyPropagate(int node, int start, int end) {
        if (lazy[node] == 0) return;
        tree[node] += (end - start + 1) * lazy[node];
        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
    static void modify(int start, int end, int left, int right, long diff, int node) {
        lazyPropagate(node, start, end);
        if (start > right || end < left) return;
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * diff;
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }
        int mid = (start + end) / 2;
        modify(start, mid, left, right, diff, node * 2);
        modify(mid + 1, end, left, right, diff, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
    static long sum(int start, int end, int left, int right, int node) {
        lazyPropagate(node, start, end);
        if (start > right || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, left, right, node * 2) + sum(mid + 1, end, left, right, node * 2 + 1);
    }
    static long init(int left, int right, int node) {
        if (left==right){
            return  tree[node] = input[left];
        }
        int mid = (left + right) / 2;
        return tree[node] = init(left, mid, node * 2) + init(mid + 1, right, node * 2 + 1);
    }
}
