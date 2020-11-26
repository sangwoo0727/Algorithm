import java.util.*;
import java.io.*;

public class BOJ16975_수열과쿼리21 {
    static int N, M;
    static int[] input;
    static long[] tree;
    static long[] lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        input = new int[N + 1];
        tree = new long[4 * N];
        lazy = new long[4 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            input[n] = Integer.parseInt(st.nextToken());
        }
        init(1, N, 1);
        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            int flag, i, j, k;
            st = new StringTokenizer(br.readLine());
            flag = Integer.parseInt(st.nextToken());
            if (flag == 1) {
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());
                update(1, N, i, j, k, 1);
            } else {
                i = Integer.parseInt(st.nextToken());
                output.append(find(i, 1, N, 1));
                output.append("\n");
            }
        }
        System.out.print(output);
    }
    static void lazy_update(int start, int end, int node) {
        if (lazy[node] == 0) return;
        tree[node] += (end - start + 1) * lazy[node];
        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }

    static long find(int idx, int start, int end, int node) {
        lazy_update(start, end, node);
        if (end < idx || start > idx) {
            return 0;
        }
        if (start == end) return tree[node];
        int mid = (start + end) / 2;
        return find(idx, start, mid, node * 2) + find(idx, mid + 1, end, node * 2 + 1);
    }
    static long update(int start, int end, int left, int right, int val, int node) {
        lazy_update(start, end, node);
        if (start > right || end < left) return tree[node];
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * val;
            if (start != end) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }
            return tree[node];
        }
        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, left, right, val, node * 2) + update(mid + 1, end, left, right, val, node * 2 + 1);
    }
    static long init(int start, int end, int node) {
        if (start == end) return tree[node] = input[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }
}
