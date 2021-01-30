import java.io.*;
import java.util.*;

public class BOJ1976_여행가자 {
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int j = 1; j <= N; j++) {
                int flag = Integer.parseInt(st.nextToken());
                if (flag == 1) {
                    merge(i, j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(input.readLine());
        int prev = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for (int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (find(prev) == find(now)) continue;
            else {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }

    static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        if (n < m) p[m] = n;
        else p[n] = m;
    }

    static int find(int n) {
        if (n==p[n]) return n;
        return p[n] = find(p[n]);
    }
}
