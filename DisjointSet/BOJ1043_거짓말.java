import java.io.*;
import java.util.*;

public class BOJ1043_거짓말 {
    static int N, M, K;
    static int[] p;
    static int[] human;


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        K = Integer.parseInt(st.nextToken());
        human = new int[K];
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        for (int k = 0; k < K; k++) {
            human[k] = Integer.parseInt(st.nextToken());
        }
        List<Integer>[] list = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pre = 0;
            if (n != 0) {
                pre = Integer.parseInt(st.nextToken());
                list[i].add(pre);
            }
            for (int j = 2; j <= n; j++) {
                int m = Integer.parseInt(st.nextToken());
                list[i].add(m);
                merge(pre, m);
                pre = m;
            }
        }
        int cnt = 0;
        for (int i = 1; i <= M; i++) {
            boolean flag = false;
            label: for (int n = 0; n < list[i].size(); n++) {
                int now = list[i].get(n);
                for (int k = 0; k < K; k++) {
                    if (find(now) == find(human[k])) {
                        flag = true;
                        break label;
                    }
                }
            }
            if (!flag) cnt++;
        }
        System.out.println(cnt);
    }

    static void merge(int n, int m) {
        n = find(n);
        m = find(m);
        p[m] = n;
    }

    static int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }
}
