import java.io.*;
import java.util.*;

public class BOJ1937_욕심쟁이판다 {
    static int N, output;
    static int[][] matrix;
    static int[][] ret;
    static int[][] dir = {{0,0,-1,1},{1,-1,0,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        ret = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                ret[i][j] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ret[i][j] == 1) {
                    ret[i][j] = dfs(i, j);
                }
            }
        }
        System.out.println(output);
    }
    static int dfs(int n, int m) {
        for (int k = 0; k < 4; k++) {
            int nn = n + dir[0][k];
            int nm = m + dir[1][k];
            if (inner(nn, nm, matrix[n][m])) {
                if (ret[nn][nm]!=1) {
                    ret[n][m] = Math.max(ret[n][m], ret[nn][nm] + 1);
                }else {
                    ret[n][m] = Math.max(ret[n][m], dfs(nn,nm) + 1);
                }
            }
        }
        output = Math.max(output, ret[n][m]);
        return ret[n][m];
    }

    static boolean inner(int n, int m, int value) {
        return n >= 0 && n < N && m >= 0 && m < N && matrix[n][m] > value;
    }
}
