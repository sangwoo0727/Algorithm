import java.io.*;
import java.util.*;

public class BOJ14438_수열과쿼리17 {
    static int N, M;
    static int[] input;
    static int[] tree;
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N + 1];
        tree = new int[4 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        init(1, N, 1);
        M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (flag == 1) {
                update(1, N, a, b, 1);
            } else {
                output.append(find(1, N, a, b, 1));
                output.append("\n");
            }
        }
        System.out.print(output);
    }

    static int update(int start, int end, int idx, int val, int node) {
        if (start > idx || end < idx) return tree[node];
        if (start == end) {
            return tree[node] = val;
        }
        int mid = (start + end) / 2;
        return tree[node] = Math.min(update(start, mid, idx, val, node * 2), update(mid + 1, end, idx, val, node * 2 + 1));
    }
    static int find(int start, int end, int left, int right, int node) {
        if (start > right || end < left) return MAX;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return Math.min(find(start, mid, left, right, node * 2), find(mid + 1, end, left, right, node * 2 + 1));
    }
    static int init(int left, int right, int node) {
        if (left == right) return tree[node] = input[left];
        int mid = (left + right) / 2;
        return tree[node] = Math.min(init(left, mid, node * 2), init(mid + 1, right, node * 2 + 1));
    }
}
