import java.io.*;
import java.util.*;

public class BOJ1697_숨바꼭질 {
    static int[] d = {-1, 1, 2};
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[200100];
        System.out.println(bfs(n, m));
    }
    static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int dist = 0;
        label: while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int n = q.poll();
                visit[n] = true;
                if (n == end) break label;
                for (int k = 0; k < 3; k++) {
                    int nn = k == 2 ? n * d[k] : n + d[k];
                    if (200000 >= nn && nn >= 0 && !visit[nn]) {
                        visit[nn] = true;
                        q.add(nn);
                    }
                }
            }
            dist += 1;
        }
        return dist;
    }
}
