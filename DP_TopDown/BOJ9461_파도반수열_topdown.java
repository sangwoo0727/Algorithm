import java.io.*;

public class BOJ9461_파도반수열_topdown {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        dp = new long[101];
        wave(100);
        StringBuilder output = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(input.readLine());
            output.append(dp[n-1]).append("\n");
        }
        System.out.println(output);
    }
    static long wave(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return dp[n] = 1;
        }
        if (n == 3 || n == 4) {
            return dp[n] = 2;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = wave(n - 1) + wave(n - 5);
    }
}
