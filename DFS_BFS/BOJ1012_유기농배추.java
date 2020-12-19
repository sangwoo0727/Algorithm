import java.io.*;
import java.util.*;

public class BOJ1012_유기농배추 {
    static int[][] board;
    static boolean[][] visit;
    static int N, M;
    static int[][] dir = {{0, 0, -1, 1}, {1, -1, 0, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            visit = new boolean[N][M];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                board[n][m] = 1;
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1 && !visit[i][j]) {
                        getArea(i, j);
                        cnt++;
                    }
                }
            }
            output.append(cnt).append("\n");
        }
        System.out.println(output);
    }

    static void getArea(int n, int m) {
        visit[n][m] = true;
        for (int k = 0; k < 4; k++) {
            int nn = n + dir[0][k];
            int nm = m + dir[1][k];
            if (inner(nn, nm)) {
                visit[nn][nm] = true;
                getArea(nn, nm);
            }
        }
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M && board[n][m] == 1 && !visit[n][m];
    }
}
