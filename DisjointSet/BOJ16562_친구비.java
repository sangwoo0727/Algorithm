import java.io.*;
import java.util.*;

public class BOJ16562_친구비 {
    static int N, M, K;
    static int[] p;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        p = new int[N + 1];
        cost = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        st = new StringTokenizer(input.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            merge(n, m);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int r = find(i);
            int c = cost[i];
            if (!map.containsKey(r)) {
                map.put(r, c);
            } else {
                map.put(r, Math.min(map.get(r), c));
            }
        }
        int sum = 0;
        for (int i : map.keySet()) {
            sum += map.get(i);
        }
        System.out.println(sum <= K ? sum : "Oh no");
    }

    static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        p[m] = n;
    }

    static int find(int n) {
        if (p[n] == n) {
            return n;
        }
        return p[n] = find(p[n]);
    }
}
