import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solve {
    private static Solve solve;
    private int R, C, T;
    private int sr, sc, ans = 0;
    private char[][] board;
    int[][] d = {{-1, 1, 0, 0, 0}, {0, 0, -1, 1, 0}};
    public static Solve getInstance() {
        if (solve == null) {
            solve = new Solve();
        }
        return solve;
    }

    public void setInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        this.R = Integer.parseInt(st.nextToken());
        this.C = Integer.parseInt(st.nextToken());
        this.T = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = input.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'G') {
                    this.sr = i;
                    this.sc = j;
                }
            }
        }
    }

    public void searchMap() {
        dfs(sr, sc, 0, 0);
    }

    private void dfs(int n, int m, int w, int cnt) {
        if (w == T) {
            ans = Math.max(ans, cnt);
            return;
        }
        for (int k = 0; k < 5; k++) {
            int nn = n + d[0][k];
            int nm = m + d[1][k];
            if (!inner(nn, nm)) {
                continue;
            }
            if (board[nn][nm] == 'S') {
                board[nn][nm] = '.';
                dfs(nn, nm, w + 1, cnt + 1);
                board[nn][nm] = 'S';
            } else {
                dfs(nn, nm, w + 1, cnt);
            }
        }
    }
    public int getAnswer() {
        return this.ans;
    }

    private boolean inner(int n, int m) {
        return 0 <= n && n < R && 0 <= m && m < C && board[n][m] != '#';
    }
}

public class BOJ21772_가희의고구마먹방 {
    public static void main(String[] args) throws IOException {
        Solve solve = Solve.getInstance();
        solve.setInput();
        solve.searchMap();
        System.out.println(solve.getAnswer());
    }
}
