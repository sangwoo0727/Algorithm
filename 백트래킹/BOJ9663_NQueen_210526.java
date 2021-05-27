import java.io.*;
import java.util.Arrays;

public class BOJ9663_NQueen_210526 {
    private static int N;
    private static int[] row;
    private static int ans;
    public static void main(String[] args) throws IOException {
        input();
        recFunc(1);
        System.out.println(ans);
    }

    private static boolean attackable(int c1, int r1, int c2, int r2) {
        if (r1 == r2) return true;
        else if (c1 + r1 == c2 + r2) return true;
        else if (c1 - r1 == c2 - r2) return true;
        return false;
    }
    private static void recFunc(int k) {
        if (k == N + 1) {
            ans++;
            return;
        }
        for (int c = 1; c <= N; c++) {
            boolean flag = true;
            for (int i = 1; i < k; i++) {
                if (attackable(i, row[i], k, c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                row[k] = c;
                recFunc(k + 1);
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        row = new int[N + 1];
    }
}
