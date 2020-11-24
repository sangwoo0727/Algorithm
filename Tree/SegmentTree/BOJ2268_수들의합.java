import java.io.*;
import java.util.*;

public class BOJ2268_수들의합 {
    static int[] arr;
    static long[] tree;
    static int N, M, flag, i, j;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder output = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new long[N * 4];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            flag = Integer.parseInt(st.nextToken());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            if (flag == 0) { // sum
                if (j < i) swap(i,j);
                output.append(find(1, N, i, j, 1));
                output.append("\n");
            } else { // modify
                int diff = j - arr[i];
                arr[i] = j;
                update(1, N, i, diff, 1);
            }
        }
        System.out.print(output);
    }
    static void update(int start, int end, int modifyIdx, int diff, int node) {
        if (start <= modifyIdx && modifyIdx <= end) {
            tree[node] += diff;
        }else return;
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, modifyIdx, diff, node * 2);
        update(mid + 1, end, modifyIdx, diff, node * 2 + 1);
    }
    static long find(int start, int end,int left, int right,  int node) {
        // left, right 가 찾고자하는 구간.
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return find(start, mid, left, right, node * 2) + find(mid + 1, end, left, right, node * 2 + 1);
    }
    static void swap(int n, int m) {
        i = m; j = n;
    }
}
