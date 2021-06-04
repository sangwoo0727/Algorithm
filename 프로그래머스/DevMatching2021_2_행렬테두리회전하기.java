import java.util.ArrayDeque;
import java.util.Deque;

public class DevMatching2021_2_행렬테두리회전하기 {
    private static int[][] board;
    private static int[] answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        board = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = num++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            board = spin(i, queries[i]);
        }

        return answer;
    }

    private static int[][] spin(int idx, int[] query) {
        int sn = query[0] - 1;
        int sm = query[1] - 1;
        int en = query[2] - 1;
        int em = query[3] - 1;
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;
        for (int j = sm; j < em; j++) {
            dq.addLast(board[sn][j]);
            ans = Math.min(ans, board[sn][j]);
        }
        for (int i = sn; i < en; i++) {
            dq.addLast(board[i][em]);
            ans = Math.min(ans, board[i][em]);
        }
        for (int j = em; j > sm; j--) {
            dq.addLast(board[en][j]);
            ans = Math.min(ans, board[en][j]);
        }
        for (int i = en; i > sn; i--) {
            dq.addLast(board[i][sm]);
            ans = Math.min(ans, board[i][sm]);
        }
        dq.addFirst(dq.pollLast());
        for (int j = sm; j < em; j++) {
            board[sn][j] = dq.pollFirst();
        }
        for (int i = sn; i < en; i++) {
            board[i][em] = dq.pollFirst();
        }
        for (int j = em; j > sm; j--) {
            board[en][j] = dq.pollFirst();
        }
        for (int i = en; i > sn; i--) {
            board[i][sm] = dq.pollFirst();
        }
        answer[idx] = ans;
        return board;
    }
}
