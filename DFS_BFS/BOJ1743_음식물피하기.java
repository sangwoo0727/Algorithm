import java.io.*;
import java.util.*;

public class BOJ1743_음식물피하기 {
    static int N, M, K, cnt;
    static boolean[][] map;
    static boolean[][] visit;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(input.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] && !visit[i][j]) {
                    cnt = 0;
                    ff(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);
    }
    static void ff(int n, int m) {
        visit[n][m] = true;
        cnt++;
        for (int k = 0; k < 4; k++) {
            int nn = n + d[0][k];
            int nm = m + d[1][k];
            if (inner(nn, nm)) {
                visit[nn][nm] = true;
                ff(nn, nm);
            }
        }
    }

    static boolean inner(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M && !visit[i][j] && map[i][j];
    }
}
