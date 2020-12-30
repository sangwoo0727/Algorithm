import java.io.*;

public class BOJ9095_123더하기_topdown {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        dp = new int[12];
        getCnt(11);
        StringBuilder output = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(input.readLine());
            output.append(dp[n]).append("\n");
        }
        System.out.println(output);
    }

    static int getCnt(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (dp[n] != 0) {
            return dp[n];
        }
        for (int i = 1; i <= 3; i++) {
            dp[n] += getCnt(n - i);
        }
        return dp[n];
    }
}
