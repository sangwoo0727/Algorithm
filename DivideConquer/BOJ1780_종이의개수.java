import java.io.*;
import java.util.*;

public class BOJ1780_종이의개수 {
    private static int N;
    private static int[][] board;
    private static int[] ans = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }
        getAnswer(N, 0, 0);
        String output = ans[0] + "\n"
                + ans[1] + "\n"
                + ans[2] + "\n";
        System.out.println(output);
    }

    private static void getAnswer(int size, int n, int m) {
        int check = board[n][m];
        boolean flag = false;
        label:for (int i = n; i < n + size; i++) {
            for (int j = m; j < m + size; j++) {
                if (check != board[i][j]) {
                    flag = true;
                    break label;
                }
            }
        }
        if (flag) {
            int divideSize = size / 3;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    getAnswer(divideSize, n + divideSize * i, m + divideSize * j);
                }
            }
            return;
        }
        ans[check]++;
    }
}
