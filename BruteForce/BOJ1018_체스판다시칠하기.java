import java.io.*;
import java.util.*;

public class BOJ1018_체스판다시칠하기 {
    static int N, M, output = Integer.MAX_VALUE;
    static char[][] board;
    static char[][] whiteStart = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };
    static char[][] blackStart = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (inner(i, j)) {
                    output = Math.min(output, getFixCount(i, j));
                }
            }
        }
        System.out.println(output);
    }

    static int getFixCount(int n, int m) {
        int wcnt = 0, bcnt = 0;
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (whiteStart[i-n][j-m] != board[i][j]) wcnt++;
                if (blackStart[i-n][j-m] != board[i][j]) bcnt++;
            }
        }
        return Math.min(wcnt, bcnt);
    }
    static boolean inner(int i, int j) {
        return i + 7 < N && j + 7 < M;
    }
}
