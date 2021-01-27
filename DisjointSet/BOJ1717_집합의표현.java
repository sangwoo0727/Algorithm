import java.io.*;
import java.util.*;

public class BOJ1717_집합의표현 {
    static int n, m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (o == 1) {
                if (find(a) == find(b)) output.append("YES").append("\n");
                else output.append("NO").append("\n");
            } else {
                merge(a, b);
            }
        }
        System.out.println(output);
    }

    static void merge(int n, int m) {
        n = find(n); m = find(m);
        if (n < m) {
            p[m] = n;
        } else {
            p[n] = m;
        }
    }
    static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }
}
