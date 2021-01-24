import java.io.*;
import java.util.*;

public class BOJ16397_탈출 {
    static int N, T, G;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        int ans = bfs();
        System.out.println(ans == -1? "ANG" : ans);
    }
    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[100000];
        q.add(N);
        int cnt = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt += 1;
            if (cnt > T) return -1;
            for (int i = 0; i < size; i++) {
                int n = q.poll();
                if (n == G) {
                    return cnt;
                }
                visit[n] = true;
                int nn = n + 1;
                if (nn <= 99999 && !visit[nn]) {
                    visit[nn] = true;
                    q.add(nn);
                }
                if (n != 0 && n * 2 <= 99999) {
                    StringBuilder s = new StringBuilder(Integer.toString(n * 2));
                    s.replace(0, 1, Integer.toString(s.charAt(0) - '0' - 1));
                    nn = Integer.parseInt(s.toString());
                    if (!visit[nn]) {
                        visit[nn] = true;
                        q.add(nn);
                    }
                }
            }
        }
        return -1;
    }
}
