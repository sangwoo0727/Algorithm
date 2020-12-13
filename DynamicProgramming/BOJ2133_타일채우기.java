import java.io.*;

public class BOJ2133_타일채우기 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[31];
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            if (i % 2 == 0) {
                for (int j = 2; j < i; j += 2) {
                    int now = j == 2 ? 3 : 2;
                    dp[i] += now * dp[i - j];
                }
                dp[i] += 2;
            }
        }
        System.out.println(dp[N]);
    }
}
