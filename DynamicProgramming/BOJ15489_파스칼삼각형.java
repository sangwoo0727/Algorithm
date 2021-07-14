import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15489_파스칼삼각형 {
    private static int R, C, W;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        long[][] dp = new long[31][31];
        for (int i = 1; i <= 30; i++) {
            dp[i][1] = 1;
            dp[i][i] = 1;
        }
        for (int i = 1; i <= 30; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        int num = 1;
        long total = 0;
        for (int i = R; i < R + W; i++) {
            for (int j = C; j < C + num; j++) {
                total += dp[i][j];
            }
            num++;
        }
        System.out.println(total);
    }
}
