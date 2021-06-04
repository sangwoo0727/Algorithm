import java.io.*;
import java.util.*;

public class BOJ3055_탈출 {
    private static int R, C;
    private static char[][] board;
    private static int[][] waterVisit;
    private static int[][] animalVisit;
    private static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve() {
        waterMove();
        animalMove();
        printAnswer();
    }
    private static void printAnswer() {
        label: for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'D') {
                    System.out.println(animalVisit[i][j] == -1 ? "KAKTUS" : animalVisit[i][j]);
                    break label;
                }
            }
        }
    }
    private static void animalMove() {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'S') {
                    q.add(new Pair(i, j));
                    animalVisit[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm)) {
                    if (waterVisit[nn][nm] != -1 && waterVisit[nn][nm] <= animalVisit[now.n][now.m] + 1) continue;
                    if (animalVisit[nn][nm] != -1 && animalVisit[nn][nm] <= animalVisit[now.n][now.m] + 1) continue;
                    if (board[nn][nm] == '*') continue;
                    animalVisit[nn][nm] = animalVisit[now.n][now.m] + 1;
                    q.add(new Pair(nn, nm));
                }
            }
        }
    }

    private static void waterMove() {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '*') {
                    q.add(new Pair(i, j));
                    waterVisit[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nn = now.n + d[0][k];
                int nm = now.m + d[1][k];
                if (inner(nn, nm)) {
                    if (waterVisit[nn][nm] != -1 && waterVisit[nn][nm] <= waterVisit[now.n][now.m] + 1) {
                        continue;
                    }
                    if (board[nn][nm] != '.') continue;
                    waterVisit[nn][nm] = waterVisit[now.n][now.m] + 1;
                    q.add(new Pair(nn, nm));
                }
            }
        }
    }

    private static boolean inner(int n, int m) {
        return 0 <= n && n < R && 0 <= m && m < C && board[n][m] != 'X';
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
        StringTokenizer st = new StringTokenizer(input.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        waterVisit = new int[R][C];
        animalVisit = new int[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = input.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                waterVisit[i][j] = -1;
                animalVisit[i][j] = -1;
            }
        }
    }

}
