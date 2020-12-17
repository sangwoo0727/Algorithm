import java.io.*;
import java.util.*;

public class BOJ2606_바이러스 {
    static int N, M, output;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            merge(n, m);
        }
        for (int i = 1; i <= N; i++) {
            find(i);
            if (i != 1 && p[i] == p[1]) {
                output++;
            }
        }
        System.out.println(output);
    }
    static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        p[n] = m;
    }

    static int find(int n) {
        if (n == p[n]) {
            return n;
        }
        return p[n] = find(p[n]);
    }
}
