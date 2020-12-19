import java.io.*;
import java.util.*;

public class BOJ2667_단지번호붙이기 {
    static int N;
    static int[][] board;
    static boolean[][] visit;
    static int[][] dir = {{0, 0, -1, 1}, {1, -1, 0, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        StringBuilder output = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    list.add(getArea(i, j));
                }
            }
        }
        list.sort(null);
        output.append(list.size()).append("\n");
        for (int cnt : list) {
            output.append(cnt).append("\n");
        }
        System.out.println(output);
    }
    static int getArea(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        int cnt = 0;
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            visit[now.n][now.m] = true;
            cnt++;
            for (int k = 0; k < 4; k++) {
                int nn = now.n + dir[0][k];
                int nm = now.m + dir[1][k];
                if (inner(nn, nm)) {
                    visit[nn][nm] = true;
                    queue.add(new Pair(nn, nm));
                }
            }
        }
        return cnt;
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < N && !visit[n][m] && board[n][m] == 1;
    }
    static class Pair {
        int n, m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
