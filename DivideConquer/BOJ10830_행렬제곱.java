import java.io.*;
import java.util.*;

public class BOJ10830_행렬제곱 {
    static int N;
    static long B;
    static final int MOD = 1000;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] answer = go(B);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer[i][j] %= MOD;
                output.append(answer[i][j]).append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    static int[][] go(long n) {
        if (n == 1) {
            return matrix;
        }
        int[][] tmp = go(n / 2);
        tmp = getCalculate(tmp, tmp);
        if (n % 2 == 0) {
            return tmp;
        } else {
            return getCalculate(tmp, matrix);
        }
    }

    static int[][] getCalculate(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += (a[i][k] * b[k][j]) % MOD;
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
