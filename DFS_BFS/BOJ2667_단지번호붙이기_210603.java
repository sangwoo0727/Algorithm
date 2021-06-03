import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667_단지번호붙이기_210603 {
    private static int N, total;
    private static List<Integer> countArr = new ArrayList<>();
    private static int[][] board;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        StringBuilder output = new StringBuilder();
        output.append(total).append("\n");
        countArr.sort((o1, o2) -> o1 - o2);
        for (int c : countArr) {
            output.append(c).append("\n");
        }
        System.out.println(output);
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    total += 1;
                    countArr.add(bfs(i, j));
                }
            }
        }
    }

    private static int bfs(int i, int j) {
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visit[i][j] = true;
        while (!q.isEmpty()) {
            Pair now = q.poll();
            count++;
            int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
            for (int k = 0; k < 4; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm)) {
                    visit[nn][nm] = true;
                    q.add(new Pair(nn, nm));
                }
            }
        }
        return count;
    }

    private static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N && !visit[n][m] && board[n][m] == 1;
    }
    
    private static class Pair {
        int n, m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        board = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = input.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
    }
}
