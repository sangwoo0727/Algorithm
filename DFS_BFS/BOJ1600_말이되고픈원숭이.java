import java.io.*;
import java.util.*;

public class BOJ1600_말이되고픈원숭이 {
    static int K,N, M;
    static int ans = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] d = {{-1, -2, -2, -1, 1, 2, 2, 1, -1, 1, 0, 0}, {-2, -1, 1, 2, 2, 1, -1, -2, 0, 0, -1, 1}};
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            visit[now.n][now.m][now.k] = true;
            if (now.n == N - 1 && now.m == M - 1) {
                ans = now.l;
                break;
            }
            for (int k = 0; k < 12; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm)) {
                    if (k < 8) {
                        if (now.k + 1 <= K && !visit[nn][nm][now.k + 1]) {
                            visit[nn][nm][now.k + 1] = true;
                            q.add(new Node(nn, nm, now.l + 1, now.k + 1));
                        }
                    } else {
                        if (!visit[nn][nm][now.k]) {
                            visit[nn][nm][now.k] = true;
                            q.add(new Node(nn, nm, now.l + 1, now.k));
                        }
                    }
                }
            }
        }
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M && map[n][m] == 0;
    }

    static class Node{
        int n, m, l, k;
        Node(int n, int m, int l, int k) {
            this.n = n;
            this.m = m;
            this.l = l;
            this.k = k;
        }
    }
}
