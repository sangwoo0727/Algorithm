import java.io.*;
import java.util.*;

public class BOJ2630_색종이만들기 {
    private static int N;
    private static int[][] board;
    private static int blue, white;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int n, int m, int size) {
        int color = board[n][m];
        label: for (int i = n; i < n + size; i++) {
            for (int j = m; j < m + size; j++) {
                if (color != board[i][j]) {
                    color = 2;
                    break label;
                }
            }
        }
        if (color == 0) {
            white++;
        } else if (color == 1) {
            blue++;
        } else {
            divide(n, m, size / 2);
            divide(n + size / 2, m, size / 2);
            divide(n, m + size / 2, size / 2);
            divide(n + size / 2, m + size / 2, size / 2);
        }
    }
}
