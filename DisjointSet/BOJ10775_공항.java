import java.io.*;

public class BOJ10775_공항 {
    static int G, P;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(input.readLine());
        P = Integer.parseInt(input.readLine());
        p = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            p[i] = i;
        }
        int ans = P;
        for (int i = 1; i <= P; i++) {
            int n = Integer.parseInt(input.readLine());
            if (find(n) == 0) {
                ans = i - 1;
                break;
            } else {
                int tmp = find(n);
                merge(tmp, tmp - 1);
            }
        }
        System.out.println(ans);
    }

    static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }

    static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        if (n < m) {
            p[m] = n;
        } else {
            p[n] = m;
        }
    }
}
