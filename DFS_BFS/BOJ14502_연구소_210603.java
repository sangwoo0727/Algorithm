import java.io.*;
import java.util.*;

public class BOJ14502_연구소_210603 {
    private static int N, M;
    private static int[][] board;
    private static boolean[][] visit;
    private static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve() {
        recFunc(1);
        System.out.println(ans);
    }

    private static class Pair {
        int n, m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
    private static void bfs() {
        visit = new boolean[N][M];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2) {
                    q.add(new Pair(i, j));
                    visit[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair now = q.poll();
            int[][] d = {{0, 0, -1, 1}, {-1, 1, 0, 0}};
            for (int k = 0; k < 4; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm)) {
                    visit[nn][nm] = true;
                    q.add(new Pair(nn, nm));
                }
            }
        }
    }

    private static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M && board[n][m] == 0 && !visit[n][m];
    }

    private static void checkAns() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && board[i][j] == 0) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }
    private static void recFunc(int k) {
        if (k > 3) {
            bfs();
            checkAns();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 3;
                    recFunc(k + 1);
                    board[i][j] = 0;
                }
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
