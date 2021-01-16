import java.io.*;

public class BOJ15988_123더하기3 {
    static final int MOD = 1000000009;
    static long[] dp = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        StringBuilder output = new StringBuilder();
        pp();
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(input.readLine());
            output.append(dp[n]).append("\n");
        }
        System.out.println(output);
    }

    static void pp() {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }
    }
}
