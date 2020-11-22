import java.io.*;
import java.util.*;

public class BOJ20152_GameAddiction {
    static int N, H;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int length = Math.abs(H - N);
        dp = new long[length + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                if (i > j) continue;
                if (i==0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[length][length]);
    }

}
