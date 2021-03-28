import java.io.*;
import java.util.*;

public class BOJ1912_연속합 {
    private static int N;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        dp[0] = -1001;
        int ans = -1001;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(num, dp[i - 1] + num);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
