import java.io.*;
import java.util.*;

public class BOJ16197_두동전 {
    static int N, M;
    static char[][] map;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        boolean flag = false;
        int n1, m1, n2, m2;
        n1 = m1 = n2 = m2 = 0;
        for (int i = 0; i < N; i++) {
            map[i] = input.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'o') {
                    if (!flag) {
                        flag = true;
                        n1 = i; m1 = j;
                    } else {
                        n2 = i; m2 = j;
                    }
                }
            }
        }
        dfs(n1, m1, n2, m2, 0);
        System.out.println(ans == Integer.MAX_VALUE? -1 : ans);
    }
    static void dfs(int n1, int m1, int n2, int m2, int cnt) {
        if (cnt > 10 || (!inner(n1, m1) && !inner(n2, m2))) {
            return;
        }
        if ((inner(n1, m1) && !inner(n2, m2)) || (!inner(n1, m1) && inner(n2, m2))) {
            ans = Math.min(ans, cnt);
        }
        for (int k = 0; k < 4; k++) {
            int nn1 = n1 + d[0][k], nm1 = m1 + d[1][k];
            int nn2 = n2 + d[0][k], nm2 = m2 + d[1][k];
            if (inner(nn1, nm1) && map[nn1][nm1] == '#') {
                nn1 = n1; nm1 = m1;
            }
            if (inner(nn2, nm2) && map[nn2][nm2] == '#') {
                nn2 = n2; nm2 = m2;
            }
            dfs(nn1, nm1, nn2, nm2, cnt + 1);
        }
    }

    static boolean inner(int n, int m) {
        return 0 <= n && n < N && 0 <= m && m < M;
    }
}
