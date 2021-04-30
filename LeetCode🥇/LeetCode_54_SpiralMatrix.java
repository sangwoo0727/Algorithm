import java.util.ArrayList;
import java.util.List;

public class LeetCode_54_SpiralMatrix {
    private static int[][] d = {{0, 1, 0, -1}, {1, 0, -1, 0}};
    private static int N, M;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        N = matrix.length;
        M = matrix[0].length;
        boolean[][] visit = new boolean[N][M];
        int n = 0, m = 0, k = 0;
        for (int cnt = 0; cnt < N * M; cnt++) {
            visit[n][m] = true;
            ans.add(matrix[n][m]);
            int nn = n + d[0][k];
            int nm = m + d[1][k];
            if (!inner(nn,nm) || visit[nn][nm]) {
                k = k == 3 ? 0 : k + 1;
                nn = n + d[0][k];
                nm = m + d[1][k];
            }
            n = nn;
            m = nm;
        }
        return ans;
    }

    private static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }
}
