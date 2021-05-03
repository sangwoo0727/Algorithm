import java.util.LinkedList;
import java.util.Queue;

public class Kakao_2020인턴십_4_경주로건설 {
    private static int[][] d = {
            {0, 0, -1, 1},
            {1, -1, 0, 0}
    };
    private static int[][] visit;
    private static int N;

    public int solution(int[][] board) {
        N = board.length;
        visit = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(board);
        return visit[N - 1][N - 1];
    }

    private void bfs(int[][] board) {
        Queue<Node> pq = new LinkedList<>();
        pq.add(new Node(0, 0, 100, -1));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int k = 0; k < 4; k++) {
                int nn = node.n + d[0][k];
                int nm = node.m + d[1][k];
                if (inner(nn, nm, board)) {
                    int nw = 0;
                    if (node.d == -1 || node.d == k) {
                        nw = node.w + 100;
                    } else {
                        nw = node.w + 600;
                    }
                    if (nw <= visit[nn][nm]) {
                        visit[nn][nm] = nw;
                        pq.add(new Node(nn, nm, nw, k));
                    }
                }
            }
        }
    }

    private boolean inner(int n, int m, int[][] board) {
        return 0 <= n && n < N && 0 <= m && m < N && board[n][m] == 0;
    }
    private static class Node {
        int n,m, w, d;
        Node(int n, int m, int w, int d) {
            this.n = n;
            this.m = m;
            this.w = w;
            this.d = d;
        }
    }
}
